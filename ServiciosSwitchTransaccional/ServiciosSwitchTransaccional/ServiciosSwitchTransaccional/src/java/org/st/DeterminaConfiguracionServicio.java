/*
 * DeterminaConfiguracionServicio.java
 *
 * Created on 25-oct-2007, 16:26:33
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import org.st.Atributos.Atributo;

/**
 *
 * @author demian
 */
@WebService
@Stateless
public class DeterminaConfiguracionServicio {

/**
     * Determina la configuración según los atributos recuperados del mensaje
     */
    @WebMethod(operationName = "determinaConfiguracion")
    @SuppressWarnings(value = "unchecked")
    public int determinaConfiguracion(@WebParam(name = "atributos")
    String p_atributos) {

        try {

            /* declara variables locales */
            StringReader stream;
            stream = new StringReader(p_atributos);

            Atributo atributo;
            Atributos atributos = new Atributos();
            JAXBContext jc = JAXBContext.newInstance(atributos.getClass());
            Unmarshaller umar = jc.createUnmarshaller();
            atributos = (Atributos) umar.unmarshal(stream);
            List listaAtributos = atributos.getAtributo();

            List<Configuracion> listaConf;

            /* Declara el manejador de a la Base de datos y estructuras de datos*/
            EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
            EntityManager emPU = emfPU.createEntityManager();
            Query q;
            String sqlPositivo = " SELECT * FROM configuracion c WHERE c.configuracion_id IN" 
                                    + "     (SELECT configuracion_id" 
                                    + "       FROM atributos_configuracion as t1" 
                                    + "       WHERE (";
            String sqlNegativo = "AND NOT EXISTS (SELECT configuracion_id" 
                                      + "                           FROM atributos_configuracion as t2" 
                                      + "                           WHERE t2.configuracion_id = t1.configuracion_id" 
                                      + "                               AND (";
            String sql = "";
            Boolean primero = true;

            /* recorre la lista de atributos pasada como parámetro */
            @SuppressWarnings(value = "unchecked")
            Iterator<Atributo> iteraAtributos = listaAtributos.iterator();
            for (; iteraAtributos.hasNext();) {
                atributo = iteraAtributos.next();

                if (primero) {
                    primero = false;
                } else {
                    sqlPositivo = sqlPositivo + " OR ";
                    sqlNegativo = sqlNegativo + " OR ";
                }

                /* por cada atributo va armando el sql dinámico */
                sqlPositivo = sqlPositivo + "( atributo_id = " + atributo.getId().toString() + " AND valor  = \"" + atributo.getValor() + "\" )";
                sqlNegativo = sqlNegativo + "( atributo_id = " + atributo.getId().toString() + " AND valor != \"" + atributo.getValor() + "\" )";
            }

            /* arma el query definitivo*/
            sqlPositivo = sqlPositivo + ")";
            sqlNegativo = sqlNegativo + "))";
            sql = sqlPositivo + sqlNegativo + ") ORDER BY cardinalidad desc, prioridad desc";

            /* recupera las configuraciones que coinciden con los valores de los atributos */
            try {
                q = emPU.createNativeQuery(sql, Configuracion.class);
                listaConf = (List<Configuracion>) q.getResultList();
            } catch (IllegalStateException ex) {
                Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error recuperando lista de configuraciones" + ": " + ex.getMessage(), ex);
                return -1;
            }

            if (listaConf.isEmpty()) {
                Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "No se recuperó ninguna configuración válida para el conjunto de atributos, valores");
                return -1;
            }

            /* retorna el ID de la primera de las configuraciones recuperadas --> la de mayor cardinalidad, mayor prioridad */
            return listaConf.get(0).getConfiguracionId();
        } catch (JAXBException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando en contexto JAXB para el unmarshalling de atributos" + ": " + ex.getMessage(), ex);
            return -1;
        }
    }

/**
     * Ejecuta dinámicamente el BPEL asociado a la configuración determinada
     */
    @WebMethod(operationName = "ejecutaBPELConfiguracion")
    public String ejecutaBPELConfiguracion(@WebParam(name = "codigo_servicio")
    String codigo_servicio, @WebParam(name = "p_configuracion_id")
    int p_configuracion_id, @WebParam(name = "p_mensaje")
    String p_mensaje) {

        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();

        ConfiguracionServicio configuracionServicio;
        ServicioDistribuido servicioDistribuido;
        Query q;

        /* recupera el servicio distribuido */
        try {
            q = emPU.createNamedQuery("ServicioDistribuido.findByCodigoServicio");
            q.setParameter("codigoServicio", codigo_servicio);
            servicioDistribuido = (ServicioDistribuido) q.getSingleResult();
            Logger.getAnonymousLogger().log(Level.INFO, "El servicio con código: " + codigo_servicio + " y descripcioón: " + servicioDistribuido.getDescripcion() + " fue recuperado exitosamente");
        } catch (NoResultException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "No existe el código de servicio: " + codigo_servicio + ": " + ex.getMessage(), ex);
            return null;
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Recupera mas de un registro para el código de servicio: " + codigo_servicio + ": " + ex.getMessage(), ex);
            return null;
        }

        /* recupera la configuración para la convinación configuración servicio */
        try {
            q = emPU.createNamedQuery("ConfiguracionServicio.findByConfiguracionyServicio");
            q.setParameter("configuracionId", p_configuracion_id);
            q.setParameter("servicioDistribuidoId", servicioDistribuido.getServicioDistribuidoId());
            configuracionServicio = (ConfiguracionServicio) q.getSingleResult();
            Logger.getAnonymousLogger().log(Level.INFO, "La configuración del servicio  con código: " + codigo_servicio + " y configuración: " + Integer.toString(p_configuracion_id) + " fue recuperado exitosamente");
        } catch (NoResultException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "No existe la combinación del código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Recupera mas de un registro para el código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        }

        /* declara e instancia las variables necesarias para el binding con el servicio BPEL */
        QName nombreServicio = new QName(configuracionServicio.getNameSpaceURI(), configuracionServicio.getNombreServicio());
        QName nombrePuerto = new QName(configuracionServicio.getNameSpaceURI(), configuracionServicio.getNombrePuerto());
        String endpointAddress = configuracionServicio.getEndpointAddress();

        /* crea el servicio */
        Service servicioBPEL;
        try {
            servicioBPEL = Service.create(new URL(endpointAddress), nombreServicio);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "URL del endpoint mal formada para el código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        } catch (WebServiceException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error crendo Servicio remoto con  código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        }

        /* agrega el puerto (operación) correspondiente al servicio BPEL */
        //servicioBPEL.addPort(nombrePuerto, SOAPBinding.SOAP12HTTP_BINDING, endpointAddress);
        /* crea una instancia para el despachante (llamador) del servicio BPEL */
        Dispatch<SOAPMessage> despachante = servicioBPEL.createDispatch(nombrePuerto, SOAPMessage.class, Service.Mode.MESSAGE);
        //BindingProvider bp = (BindingProvider) despachante;
        //Map<String, Object> rc = bp.getRequestContext();
        //rc.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
       // rc.put(BindingProvider.SOAPACTION_URI_PROPERTY, "requerimiento");
        //MessageFactory factory = ((SOAPBinding) bp.getBinding()).getMessageFactory();
        
        MessageFactory factory;
        try {
            factory = MessageFactory.newInstance();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando el MessageFactory para el código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        }

        /* crea el requerimiento SOAP y toda la estructura SOAP requerida */
        SOAPMessage requerimiento;
        SOAPMessage respuesta = null;
        SOAPBody body;
        SOAPBodyElement elResp;
        //SOAPElement payload;
        //SOAPElement mensaje;
        try {
            requerimiento = factory.createMessage();
            //body = requerimiento.getSOAPBody();
            
            /* compone al soap:body payload */
            //payload = body.addBodyElement(new QName(configuracionServicio.getNameSpaceURI(),"Requerimiento","tem"));
            //payload = body.addChildElement("requerimiento");
            //mensaje = payload.addChildElement("mensaje");
            //mensaje.addTextNode(p_mensaje);
            String msg = "<soapenv:Envelope xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/ http://schemas.xmlsoap.org/soap/envelope/\" "
                            + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
                            + "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                            + "xmlns:tem=\"http://xml.netbeans.org/schema/templateInvocaConfiguracion\"> "
                            + "     <soapenv:Body>"
                            + "         <tem:requerimiento>"
                            + "             <tem:mensaje>" + p_mensaje + "</tem:mensaje>"
                            + "         </tem:requerimiento>"
                            + "     </soapenv:Body>"
                            + "</soapenv:Envelope>";

          requerimiento.getSOAPPart().setContent((Source) new StreamSource(new StringReader(msg)));
          requerimiento.saveChanges();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando requerimiento SOAP para el código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        }
        
        /* Invoca la operación del BPEl en forma sincrónica */
        try {
            respuesta = despachante.invoke(requerimiento);
        } catch (WebServiceException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error invocando el BPEL dinámico para el código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        }

        /* procesa la respuesta del BPEL, decsendiendo dos niveles de elementos respuesta/return */
        try {
            body = respuesta.getSOAPBody();
            elResp = (SOAPBodyElement) ((SOAPBodyElement) body.getChildElements().next()).getChildElements().next();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando requerimiento SOAP para el código de servicio: " + codigo_servicio + " y id de configuración: " + Integer.toString(p_configuracion_id) + ": " + ex.getMessage(), ex);
            return null;
        }

        return elResp.getValue();
    }

/**
     * Web service operation
     */
    @WebMethod(operationName = "ejecutaWebServiceDinamico")
    public String ejecutaWebServiceDinamico(@WebParam(name = "pNameSpaceURI")
    String pNameSpaceURI, @WebParam(name = "pNombreServicio")
    String pNombreServicio, @WebParam(name = "pNombrePuerto")
    String pNombrePuerto, @WebParam(name = "pEndPoint")
    String pEndPoint, @WebParam(name = "pMensaje")
    String pMensaje) {

        //TODO write your implementation code here:
        /* declara e instancia las variables necesarias para el binding con el servicio BPEL */
        QName nombreServicio = new QName(pNameSpaceURI, pNombreServicio);
        QName nombrePuerto = new QName(pNameSpaceURI, pNombrePuerto);
        String endpointAddress = pEndPoint;

        /* crea el servicio */
        Service servicioBPEL;
        try {
            servicioBPEL = Service.create(new URL(endpointAddress), nombreServicio);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "URL del endpoint mal formada: " + ex.getMessage(), ex);
            return null;
        } catch (WebServiceException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error crendo Servicio remoto : " + ex.getMessage(), ex);
            return null;
        }

        /* agrega el puerto (operación) correspondiente al servicio BPEL */
        //servicioBPEL.addPort(nombrePuerto, SOAPBinding.SOAP12HTTP_BINDING, endpointAddress);
        /* crea una instancia para el despachante (llamador) del servicio BPEL */
        Dispatch<SOAPMessage> despachante = servicioBPEL.createDispatch(nombrePuerto, SOAPMessage.class, Service.Mode.MESSAGE);
        //BindingProvider bp = (BindingProvider) despachante;
        //Map<String, Object> rc = bp.getRequestContext();
        //rc.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
       // rc.put(BindingProvider.SOAPACTION_URI_PROPERTY, "requerimiento");
        //MessageFactory factory = ((SOAPBinding) bp.getBinding()).getMessageFactory();
        
        MessageFactory factory;
        try {
            factory = MessageFactory.newInstance();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando el MessageFactory: " + ex.getMessage(), ex);
            return null;
        }

        /* crea el requerimiento SOAP y toda la estructura SOAP requerida */
        SOAPMessage requerimiento;
        SOAPMessage respuesta = null;
        SOAPBody body;
        SOAPBodyElement elResp;
        //SOAPElement payload;
        //SOAPElement mensaje;
        try {
            requerimiento = factory.createMessage();
            //body = requerimiento.getSOAPBody();
            
            /* compone al soap:body payload */
            //payload = body.addBodyElement(new QName(configuracionServicio.getNameSpaceURI(),"Requerimiento","tem"));
            //payload = body.addChildElement("requerimiento");
            //mensaje = payload.addChildElement("mensaje");
            //mensaje.addTextNode(p_mensaje);
            String msg = "<soapenv:Envelope xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/ http://schemas.xmlsoap.org/soap/envelope/\" "
                            + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
                            + "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                            + "xmlns:tem=\"http://xml.netbeans.org/schema/templateInvocaConfiguracion\"> "
                            + "     <soapenv:Body>"
                            + "         <tem:requerimiento>"
                            + "             <tem:mensaje>" + pMensaje + "</tem:mensaje>"
                            + "         </tem:requerimiento>"
                            + "     </soapenv:Body>"
                            + "</soapenv:Envelope>";

          requerimiento.getSOAPPart().setContent((Source) new StreamSource(new StringReader(msg)));
          requerimiento.saveChanges();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando requerimiento SOAP: " + ex.getMessage(), ex);
            return null;
        }
        
        /* Invoca la operación del BPEl en forma sincrónica */
        try {
            respuesta = despachante.invoke(requerimiento);
        } catch (WebServiceException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error invocando el BPEL dinámico: " + ex.getMessage(), ex);
            return null;
        }

        /* procesa la respuesta del BPEL, decsendiendo dos niveles de elementos respuesta/return */
        try {
            body = respuesta.getSOAPBody();
            elResp = (SOAPBodyElement) ((SOAPBodyElement) body.getChildElements().next()).getChildElements().next();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando requerimiento SOAP: " + ex.getMessage(), ex);
            return null;
        }

        return elResp.getValue();
    }

/**
     * Web service operation
     */
    @WebMethod(operationName = "ejecutaSTDinamico")
    public String ejecutaSTDinamico(@WebParam(name = "pCodigoServicio")
    String pCodigoServicio,@WebParam(name = "pNameSpaceURI")
    String pNameSpaceURI, @WebParam(name = "pNombreServicio")
    String pNombreServicio, @WebParam(name = "pNombrePuerto")
    String pNombrePuerto, @WebParam(name = "pEndPoint")
    String pEndPoint, @WebParam(name = "pMensaje")
    String pMensaje) {

        //TODO write your implementation code here:
        /* declara e instancia las variables necesarias para el binding con el servicio BPEL */
        QName nombreServicio = new QName(pNameSpaceURI, pNombreServicio);
        QName nombrePuerto = new QName(pNameSpaceURI, pNombrePuerto);
        String endpointAddress = pEndPoint;

        /* crea el servicio */
        Service servicioBPEL;
        try {
            servicioBPEL = Service.create(new URL(endpointAddress), nombreServicio);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "URL del endpoint mal formada: " + ex.getMessage(), ex);
            return null;
        } catch (WebServiceException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error crendo Servicio remoto : " + ex.getMessage(), ex);
            return null;
        }

        /* agrega el puerto (operación) correspondiente al servicio BPEL */
        //servicioBPEL.addPort(nombrePuerto, SOAPBinding.SOAP12HTTP_BINDING, endpointAddress);
        /* crea una instancia para el despachante (llamador) del servicio BPEL */
        Dispatch<SOAPMessage> despachante = servicioBPEL.createDispatch(nombrePuerto, SOAPMessage.class, Service.Mode.MESSAGE);
        //BindingProvider bp = (BindingProvider) despachante;
        //Map<String, Object> rc = bp.getRequestContext();
        //rc.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
       // rc.put(BindingProvider.SOAPACTION_URI_PROPERTY, "requerimiento");
        //MessageFactory factory = ((SOAPBinding) bp.getBinding()).getMessageFactory();
        
        MessageFactory factory;
        try {
            factory = MessageFactory.newInstance();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando el MessageFactory: " + ex.getMessage(), ex);
            return null;
        }

        /* crea el requerimiento SOAP y toda la estructura SOAP requerida */
        SOAPMessage requerimiento;
        SOAPMessage respuesta = null;
        SOAPBody body;
        SOAPBodyElement elResp;
        //SOAPElement payload;
        //SOAPElement mensaje;
        try {
            requerimiento = factory.createMessage();
            //body = requerimiento.getSOAPBody();
            
            /* compone al soap:body payload */
            //payload = body.addBodyElement(new QName(configuracionServicio.getNameSpaceURI(),"Requerimiento","tem"));
            //payload = body.addChildElement("requerimiento");
            //mensaje = payload.addChildElement("mensaje");
            //mensaje.addTextNode(p_mensaje);
            String msg = "<soapenv:Envelope xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/ http://schemas.xmlsoap.org/soap/envelope/\" "
                            + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
                            + "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                            + "xmlns:st=\"http://xml.netbeans.org/schema/switchTransaccionalSincrónico\"> "
                            + "     <soapenv:Body>"
                            + "         <st:requerimiento>"
                            +"              <st:codigo_servicio>"+ pCodigoServicio + "</st:codigo_servicio>"
                            + "             <st:mensaje>" + pMensaje + "</st:mensaje>"
                            + "         </st:requerimiento>"
                            + "     </soapenv:Body>"
                            + "</soapenv:Envelope>";

          requerimiento.getSOAPPart().setContent((Source) new StreamSource(new StringReader(msg)));
          requerimiento.saveChanges();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando requerimiento SOAP: " + ex.getMessage(), ex);
            return null;
        }
        
        /* Invoca la operación del BPEl en forma sincrónica */
        try {
            respuesta = despachante.invoke(requerimiento);
        } catch (WebServiceException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error invocando el BPEL dinámico: " + ex.getMessage(), ex);
            return null;
        }

        /* procesa la respuesta del BPEL, decsendiendo dos niveles de elementos respuesta/return */
        try {
            body = respuesta.getSOAPBody();
            elResp = (SOAPBodyElement) ((SOAPBodyElement) body.getChildElements().next()).getChildElements().next();
        } catch (SOAPException ex) {
            Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Error creando requerimiento SOAP: " + ex.getMessage(), ex);
            return null;
        }

        return elResp.getValue();
    }
}