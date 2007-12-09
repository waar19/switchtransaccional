/*
 * AdministraLogSwitch.java
 *
 * Created on 27-oct-2007, 10:12:43
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.util.Date;
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

/**
 *
 * @author demian
 */
@WebService
@Stateless
public class AdministraLogSwitch {

/**
     * Obtiene un número único de operación denominado Ticket
     */
    @WebMethod(operationName = "ObtenerTIcketServicio")
    public int obtenerTIcketServicio(@WebParam(name = "p_codigo_servicio")
    String p_codigo_servicio, @WebParam(name = "p_mensaje")
    String p_mensaje) {

        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();
        Query q;

        /* declara las variables locales */
        ServicioDistribuido servicioDistribuido;
        Sequence sequence;
        LogServicioDistribuido logServicioDistribuido;
        int numero_ticket;

        /* recupera el servicio distribuido */
        try {
            emPU.clear();
            q = emPU.createNamedQuery("ServicioDistribuido.findByCodigoServicio");
            q.setParameter("codigoServicio", p_codigo_servicio);
            servicioDistribuido = (ServicioDistribuido) q.getSingleResult();
            Logger.getAnonymousLogger().log(Level.INFO, "El servicio con código: " + p_codigo_servicio + " y descripcioón: " + servicioDistribuido.getDescripcion() + " fue recuperado exitosamente");
        } catch (NoResultException ex) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el código de servicio: " + p_codigo_servicio, ex.getMessage());
            emPU.close();
            return -1;
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Recupera mas de un registro para el código de servicio: " + p_codigo_servicio, ex.getMessage());
            emPU.close();
            return -1;
        }

        /* recupera la secuencia (nro de ticket) y la actualiza */
        try {
            emPU.clear();
            emPU.getTransaction().begin();
            q = emPU.createNativeQuery("SELECT * FROM sequence WHERE seq_type = \"TICKETST\" FOR UPDATE", Sequence.class);
            sequence = (Sequence) q.getSingleResult();
            numero_ticket = sequence.getSeqId();
            sequence.setSeqId(numero_ticket + 1);
            emPU.getTransaction().commit();
        } catch (NoResultException ex) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el secuenciador para ticket TICKETST en la tabla sequence - " + ex.getMessage());
            emPU.close();
            return -1;
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Recupera mas de un registro para el secuenciador TICKETST - " + ex.getMessage());
            emPU.close();
            return -1;
        }

        /* inserta el ticket para este servicio */
        emPU.clear();
        emPU.getTransaction().begin();
        logServicioDistribuido = new LogServicioDistribuido(numero_ticket, servicioDistribuido.getServicioDistribuidoId(), p_mensaje);
        emPU.persist(logServicioDistribuido);
        emPU.getTransaction().commit();

        /* cierro el manejador de la base de datos */
        emPU.close();
        return numero_ticket;
    }

/**
     * Esta operación permite registrar distintos eventos en el log de transacciones para un ticket determinado.
     * Los eventos permitidos son:
     * solicitado --> timestamp de momento en que se solicitó el servicio
     * ticket asincronico --> para un mensaje asincrónico el timestamp en que se otorga el ticket
     * despacha bpel --> timestamp en el momento en que se despacha el bpel que atiende al comportamiento especófico del mensaje
     * ensambla respuesta --> timestamp en que termina el ensamblado de la respuesta
     * entrega respuesta --> timestamp en el monmeto en que se entrega la respuesta al solicitante del servicio
     * ultima solicitud respuesta --> timestamp en que un cliente de mensaje asincrónico solicitó quie se lñe entregue la respuesta
     */
    @WebMethod(operationName = "RegistrarEvento")
    public int registrarEvento(@WebParam(name = "p_ticket")
    int p_ticket, @WebParam(name = "p_evento")
    String p_evento) {
        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();

        LogServicioDistribuido logServicioDistribuido;

        /* recupera el log para setear el timeStamp del evento requerido */
        try {
            emPU.clear();
            emPU.getTransaction().begin();
            logServicioDistribuido = emPU.find(LogServicioDistribuido.class, p_ticket);
            if (logServicioDistribuido == null) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el ticket --> " + Integer.toString(p_ticket));
                emPU.close();
                return -1;
            }
            /* en función del evento actualiza el timestamp */
            if (p_evento.equalsIgnoreCase("solicitado")) {
                logServicioDistribuido.setSolicitado(new Date());
            } else if (p_evento.equalsIgnoreCase("ticket asincronico")) {
                logServicioDistribuido.setTicketAsincronico(new Date());
            } else if (p_evento.equalsIgnoreCase("despacha bpel")) {
                logServicioDistribuido.setDespachaBpel(new Date());
            } else if (p_evento.equalsIgnoreCase("ensambla respuesta")) {
                logServicioDistribuido.setEnsamblaRespuesta(new Date());
            } else if (p_evento.equalsIgnoreCase("entrega respuesta")) {
                logServicioDistribuido.setEntregaRespuesta(new Date());
                logServicioDistribuido.setUltimaSolicitudRespuesta(new Date());
                if (logServicioDistribuido.getCantidadSolicitudesRespuesta() != null) {
                    logServicioDistribuido.setCantidadSolicitudesRespuesta(logServicioDistribuido.getCantidadSolicitudesRespuesta() + 1);
                } else {
                    logServicioDistribuido.setCantidadSolicitudesRespuesta(1);
                }
            } else if (p_evento.equalsIgnoreCase("ultima solicitud respuesta")) {
                logServicioDistribuido.setUltimaSolicitudRespuesta(new Date());
                if (logServicioDistribuido.getCantidadSolicitudesRespuesta() != null) {
                    logServicioDistribuido.setCantidadSolicitudesRespuesta(logServicioDistribuido.getCantidadSolicitudesRespuesta() + 1);
                } else {
                    logServicioDistribuido.setCantidadSolicitudesRespuesta(1);
                }
            } else {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Evento Inexistente, pocesando el ticket --> " + Integer.toString(p_ticket) + " para el evento --> " + p_evento);
                emPU.close();
                return -1;
            }

            emPU.flush();
            emPU.getTransaction().commit();
            emPU.close();
            return 0; // EXITO
        } catch (Exception exception) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error fatal seteando evento en log de Servcio Distribuido --> " + exception.getMessage(), exception);
            emPU.close();
            return -1;
        }
    }

/**
     * Registra en el log de transacciones el mensaje (servicio) solicitado
     */
    @WebMethod(operationName = "registrarMensaje")
    public int registrarMensaje(@WebParam(name = "p_ticket")
    int p_ticket, @WebParam(name = "p_mensaje")
    String p_mensaje) {
        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();

        LogServicioDistribuido logServicioDistribuido;

        /* recupera el log para setear el timeStamp del evento requerido */
        try {
            emPU.clear();
            emPU.getTransaction().begin();
            logServicioDistribuido = emPU.find(LogServicioDistribuido.class, p_ticket);
            if (logServicioDistribuido == null) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el ticket --> " + Integer.toString(p_ticket));
                emPU.close();
                return -1;
            }

            logServicioDistribuido.setMensaje(p_mensaje);

            emPU.flush();
            emPU.getTransaction().commit();
            emPU.close();
            return 0; // EXITO
        } catch (Exception exception) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error fatal seteando mensaje en log de Servcio Distribuido --> " + exception.getMessage());
            emPU.close();
            return -1;
        }
    }

/**
     * Registra en el log de transacciones la respuesta ensamblada obtenida por parte de los proveedores
     */
    @WebMethod(operationName = "registrarRespuesta")
    public int registrarRespuesta(@WebParam(name = "p_ticket")
    int p_ticket, @WebParam(name = "p_respuesta")
    String p_respuesta) {
        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();

        LogServicioDistribuido logServicioDistribuido;

        /* recupera el log para setear el timeStamp del evento requerido */
        try {
            emPU.clear();
            emPU.getTransaction().begin();
            logServicioDistribuido = emPU.find(LogServicioDistribuido.class, p_ticket);
            if (logServicioDistribuido == null) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el ticket --> " + Integer.toString(p_ticket));
                emPU.close();
                return -1;
            }

            logServicioDistribuido.setRespuesta(p_respuesta);

            emPU.flush();
            emPU.getTransaction().commit();
            emPU.close();
            return 0; // EXITO
        } catch (Exception exception) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error fatal seteando respuesta en log de Servcio Distribuido --> " + exception.getMessage());
            emPU.close();
            return -1;
        }
    }

/**
     * Guarda en el log de transacciones e XML de los atributros recupeardos del mensaje
     */
    @WebMethod(operationName = "registrarAtributos")
    public int registrarAtributos(@WebParam(name = "p_ticket")
    int p_ticket, @WebParam(name = "p_atributos")
    String p_atributos) {
        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();

        LogServicioDistribuido logServicioDistribuido;

        /* recupera el log para setear el timeStamp del evento requerido */
        try {
            emPU.clear();
            emPU.getTransaction().begin();
            logServicioDistribuido = emPU.find(LogServicioDistribuido.class, p_ticket);
            if (logServicioDistribuido == null) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el ticket --> " + Integer.toString(p_ticket));
                emPU.close();
                return -1;
            }
            
            logServicioDistribuido.setAtributosRecuperados(p_atributos);

            emPU.flush();
            emPU.getTransaction().commit();
            emPU.close();
            return 0; // EXITO
        } catch (Exception exception) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error fatal seteando atributos en log de Servcio Distribuido --> " + exception.getMessage());
            emPU.close();
            return -1;
        }
    }

/**
     * Registra la configuración recuperada según los atributos del mensaje en el log de transacciones para este ticket
     */
    @WebMethod(operationName = "RegistrarConfiguracion")
    public int RegistrarConfiguracion(@WebParam(name = "p_ticket")
    int p_ticket, @WebParam(name = "p_configuracion")
    int p_configuracion) {
        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();

        LogServicioDistribuido logServicioDistribuido;
        ConfiguracionServicio configuracionServicio;
        Query q;

        /* recupera el log para setear el timeStamp del evento requerido */
        try {
            emPU.clear();
            emPU.getTransaction().begin();
            logServicioDistribuido = emPU.find(LogServicioDistribuido.class, p_ticket);
            if (logServicioDistribuido == null) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el ticket --> " + Integer.toString(p_ticket));
                emPU.close();
                return -1;
            }

            /* recupera la configuración para la convinación configuración servicio */
            try {
                q = emPU.createNamedQuery("ConfiguracionServicio.findByConfiguracionyServicio");
                q.setParameter("configuracionId", p_configuracion);
                q.setParameter("servicioDistribuidoId", logServicioDistribuido.getServicioDistribuidoId());
                configuracionServicio = (ConfiguracionServicio) q.getSingleResult();
            } catch (NoResultException ex) {
                Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "No existe la combinación servicio: " + Integer.toString(logServicioDistribuido.getServicioDistribuidoId()) + " y id de configuración: " + Integer.toString(p_configuracion) + ": " + ex.getMessage(), ex);
                return -1;
            } catch (NonUniqueResultException ex) {
                Logger.getLogger(DeterminaConfiguracionServicio.class.getName()).log(Level.SEVERE, "Recupera mas de un registro para el servicio: " + Integer.toString(logServicioDistribuido.getServicioDistribuidoId()) + " y id de configuración: " + Integer.toString(p_configuracion) + ": " + ex.getMessage(), ex);
                return -1;
            }

            logServicioDistribuido.setConfiguracionServicio_id(p_configuracion);
            logServicioDistribuido.setBpelEndpoint(configuracionServicio.getEndpointAddress());

            emPU.flush();
            emPU.getTransaction().commit();
            emPU.close();
            return 0; // EXITO
        } catch (Exception exception) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error fatal seteando respuesta en log de Servcio Distribuido --> " + exception.getMessage());
            emPU.close();
            return -1;
        }
    }

/**
     * Resgistra en el log de transacciones el endponint del BPEL que ejecutará según la configuración determinada
     */
    @WebMethod(operationName = "registrarBpelEndpoint")
    public int registrarBpelEndpoint(@WebParam(name = "p_ticket")
    int p_ticket, @WebParam(name = "p_bpelEndpoint")
    String p_bpelEndpoint) {
        /* Declara el manejador de a la Base de datos y estructuras de datos*/
        EntityManagerFactory emfPU = Persistence.createEntityManagerFactory("ServiciosSwitchTransaccionalPU");
        EntityManager emPU = emfPU.createEntityManager();

        LogServicioDistribuido logServicioDistribuido;

        /* recupera el log para setear el timeStamp del evento requerido */
        try {
            emPU.clear();
            emPU.getTransaction().begin();
            logServicioDistribuido = emPU.find(LogServicioDistribuido.class, p_ticket);
            if (logServicioDistribuido == null) {
                Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "No existe el ticket --> " + Integer.toString(p_ticket));
                emPU.close();
                return -1;
            }

            logServicioDistribuido.setBpelEndpoint(p_bpelEndpoint);

            emPU.flush();
            emPU.getTransaction().commit();
            emPU.close();
            return 0; // EXITO
        } catch (Exception exception) {
            Logger.getLogger(RecuperaAtributosServicio.class.getName()).log(Level.SEVERE, "Error fatal seteando respuesta en log de Servcio Distribuido --> " + exception.getMessage());
            emPU.close();
            return -1;
        }
    }
}