/*
 * RecuperaAtributosServicio.java
 *
 * Created on 17-oct-2007, 20:27:33
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
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
import javax.persistence.*;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author demian
 */
@WebService
@Stateless
public class RecuperaAtributosServicio {

    /* declara variable del paquete */
    StringReader stream;
    StreamSource source;
    TransformerFactory tf = TransformerFactory.newInstance();

    /**
     * Esta operación permite dada la configuración de recupèarción de atributos de un mensaje 
     * extraer el contenido del mismo, retornando en XML con el siguiente formato:
     *     <xsd:element name="atributos">
     *        <xsd:complexType>
     *            <xsd:sequence>
     *                <xsd:element name="atributo" maxOccurs="unbounded">
     *                    <xsd:complexType>
     *                        <xsd:sequence>
     *                            <xsd:element name="id" type="xsd:positiveInteger"/>
     *                            <xsd:element name="nombre" type="xsd:string"></xsd:element>
     *                            <xsd:element name="valor" type="xsd:string"/>
     *                        </xsd:sequence>
     *                    </xsd:complexType>
     *                </xsd:element>
     *            </xsd:sequence>
     *        </xsd:complexType>
     *    </xsd:element>
     * 
     * El cual representa la lista de los atributos recuperados del mensaje. Luego esta información es aplicada al
     * ,motor de configuración que determinará el comportamiento a seguir.
     */
    @WebMethod(operationName = "recuperaAtributos")
    @SuppressWarnings(value = "unchecked")
    public String recuperaAtributos(@WebParam(name = "codigo_servicio")
    String codigo_servicio, @WebParam(name = "mensaje")
    String mensaje) {

        try {

            /* declara variables locales */
            StringWriter xmlAttr; // Declara el string donde se almacenará el resultado del XML de los atributos
            Atributos atributos = new Atributos();
            List listaAtributos = atributos.getAtributo();
            JAXBContext jc = JAXBContext.newInstance(atributos.getClass());

            Marshaller mar = jc.createMarshaller();
            String valAttr = null;

            /* Declara el manejador de a la Base de datos y estructuras de datos*/
            EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
            EntityManager emPU = emfPU.createEntityManager();

            ServicioDistribuido servicioDistribuido;
            RecuperaAtributo recuperaAtributo = null;
            List<RecuperaAtributo> la;

            AtributosRol atributosRol;

            Query q;

            /* recupera el servicio distribuido */
            try {
                q = emPU.createNamedQuery("ServicioDistribuido.findByCodigoServicio");
                q.setParameter("codigoServicio", codigo_servicio);
                servicioDistribuido = (ServicioDistribuido) q.getSingleResult();
                Logger.getAnonymousLogger().log(Level.INFO, "El servicio con código: " + codigo_servicio + " y descripcioón: " + servicioDistribuido.getDescripcion() + " fue recuperado exitosamente");
            } catch (NoResultException ex) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el código de servicio: " + codigo_servicio, ex.getMessage());
                return null;
            } catch (NonUniqueResultException ex) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Recupera mas de un registro para el código de servicio: " + codigo_servicio, ex.getMessage());
                return null;
            }

            /* recupera la lista de atributos a recuparar del mensaje */
            try {
                q = emPU.createNamedQuery("RecuperaAtributo.findByServicioDistribuidoId");
                q.setParameter("servicioDistribuidoId", servicioDistribuido.getServicioDistribuidoId());
                la = (List<RecuperaAtributo>) q.getResultList();

                if (la.isEmpty()) {
                    Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "El servicio: " + codigo_servicio + " No tiene atributos definidos");
                    return null;
                }
            } catch (IllegalStateException ex) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error recuperando lista de atributos", ex);
                return null;
            }

            /* Itera sobre la lista de atributos recuperando cada valor y armando la lista de pares atributo, valor */
            Iterator<RecuperaAtributo> iteraAtributos = la.iterator();
            for (; iteraAtributos.hasNext();) {
                recuperaAtributo = iteraAtributos.next();

                /* reseteo el stream del mensaje cada vez, sino la segunda es EOF */
                stream = new StringReader(mensaje);
                source = new StreamSource(stream);

                /* Recupera el valor de atributo según el metodo de extracción */
                if (recuperaAtributo.getMetodoXml().equalsIgnoreCase("XSLT")) {
                    valAttr = recuperaValorAtributoXSLT(recuperaAtributo);
                } else if (recuperaAtributo.getMetodoXml().equalsIgnoreCase("XQUERY")) {
                    valAttr = recuperavalorAtributoXQuery(recuperaAtributo);
                    Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.INFO, "Recuperación de valores de Atributo mediante XQuery NO IMPLEMNATDO aún");
                }

                /* recupera los datos del atributo */
                try {
                    q = emPU.createNamedQuery("AtributosRol.findByAtributoId");
                    q.setParameter("atributoId", recuperaAtributo.getRecuperaAtributoPK().getAtributoId());
                    atributosRol = (AtributosRol) q.getSingleResult();
                    Logger.getAnonymousLogger().log(Level.INFO, "El atributo con ID: " + Integer.toString(recuperaAtributo.getRecuperaAtributoPK().getAtributoId()) + " y nombre: " + atributosRol.getNombre() + " fue recuperado exitosamente");
                } catch (NoResultException ex) {
                    Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe atributo: " + Integer.toString(recuperaAtributo.getRecuperaAtributoPK().getAtributoId()), ex.getMessage());
                    return null;
                } catch (NonUniqueResultException ex) {
                    Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Recupera mas de un atributo con ID: " + Integer.toString(recuperaAtributo.getRecuperaAtributoPK().getAtributoId()));
                    return null;
                }

                /* crea el nodo del xml de atributos y completa sus datos */
                Atributos.Atributo nuevoAtributo = new Atributos.Atributo();
                BigInteger idBig = new BigInteger(Integer.toString(recuperaAtributo.getRecuperaAtributoPK().getAtributoId()));
                nuevoAtributo.setId(idBig);
                nuevoAtributo.setNombre(atributosRol.getNombre()); //nuevoAtributo.setNombre(atributosRol.getNombre());
                nuevoAtributo.setValor(valAttr);
                listaAtributos.add(nuevoAtributo);

                /* libero los recursos del stream */
                stream.close();
            }

            /* realiza el marshaling del xml de atributos producido */
            xmlAttr = new StringWriter(); // crea un nuevo buffer de salida para que no sea acumulativo entre llamadas
            mar.marshal(atributos, xmlAttr);
            return xmlAttr.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error Creando el Marshaler de Atributos", ex);
            return null;
        }
    }

    private String recuperaValorAtributoXSLT(RecuperaAtributo attr) {

        StringWriter res = new StringWriter(); //Declara el strem de salida, resultado de la recuperación de cada atributo
        StreamResult resultado = new StreamResult(res); //asocia al strem de resultado con la salida posible del xslt engine
        String codigoXslt = attr.getCodigo();

        if (codigoXslt == null || codigoXslt.length() == 0) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "El atributo: " + Integer.toString(attr.getRecuperaAtributoPK().getAtributoId()) + "no tiene código xslt disponible");
            Logger.getAnonymousLogger().log(Level.SEVERE, "atributo NO Extraido ");
            return null;
        }

        StringReader xsltRecuperaAttr = new StringReader(codigoXslt); //Transforma al xslt para recuperar atributos en un stream
        StreamSource xslt = new StreamSource(xsltRecuperaAttr);

        try {
            Transformer transformer = tf.newTransformer(xslt);
            transformer.transform(source, resultado);
        } catch (TransformerException ex) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        Logger.getAnonymousLogger().log(Level.INFO, res.toString());
        return res.toString();
    }

    private String recuperavalorAtributoXQuery(RecuperaAtributo attr) {
        // TODO: implementar extracción de valores de atributos mediante XQuery
        return null;
    }
}