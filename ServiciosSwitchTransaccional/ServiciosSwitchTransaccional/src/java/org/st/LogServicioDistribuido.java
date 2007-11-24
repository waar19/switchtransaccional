/*
 * LogServicioDistribuido.java
 * 
 * Created on 27-oct-2007, 10:22:47
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author demian
 */
@Entity
@Table(name = "log_servicio_distribuido")
@NamedQueries({@NamedQuery(name = "LogServicioDistribuido.findByTicketId", query = "SELECT l FROM LogServicioDistribuido l WHERE l.ticketId = :ticketId"), @NamedQuery(name = "LogServicioDistribuido.findBySolicitado", query = "SELECT l FROM LogServicioDistribuido l WHERE l.solicitado = :solicitado"), @NamedQuery(name = "LogServicioDistribuido.findByTicketAsincronico", query = "SELECT l FROM LogServicioDistribuido l WHERE l.ticketAsincronico = :ticketAsincronico"), @NamedQuery(name = "LogServicioDistribuido.findByDespachaBpel", query = "SELECT l FROM LogServicioDistribuido l WHERE l.despachaBpel = :despachaBpel"), @NamedQuery(name = "LogServicioDistribuido.findByEnsamblaRespuesta", query = "SELECT l FROM LogServicioDistribuido l WHERE l.ensamblaRespuesta = :ensamblaRespuesta"), @NamedQuery(name = "LogServicioDistribuido.findByEntregaRespuesta", query = "SELECT l FROM LogServicioDistribuido l WHERE l.entregaRespuesta = :entregaRespuesta"), @NamedQuery(name = "LogServicioDistribuido.findByCantidadSolicitudesRespuesta", query = "SELECT l FROM LogServicioDistribuido l WHERE l.cantidadSolicitudesRespuesta = :cantidadSolicitudesRespuesta"), @NamedQuery(name = "LogServicioDistribuido.findByUltimaSolicitudRespuesta", query = "SELECT l FROM LogServicioDistribuido l WHERE l.ultimaSolicitudRespuesta = :ultimaSolicitudRespuesta")})
public class LogServicioDistribuido implements Serializable {
    @Id
    @Column(name = "ticket_id", nullable = false)
    private Integer ticketId;
    @Column(name = "servicio_distribuido_id", nullable = false)
    private Integer servicioDistribuidoId;
    @Column(name = "configuracion_servicio_id")
    private Integer configuracionServicio_id;
    @Column(name = "solicitado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solicitado;
    @Column(name = "ticket_asincronico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ticketAsincronico;
    @Column(name = "despacha_bpel")
    @Temporal(TemporalType.TIMESTAMP)
    private Date despachaBpel;
    @Column(name = "ensambla_respuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ensamblaRespuesta;
    @Column(name = "entrega_respuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entregaRespuesta;
    @Column(name = "cantidad_solicitudes_respuesta")
    private Integer cantidadSolicitudesRespuesta;
    @Column(name = "ultima_solicitud_respuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaSolicitudRespuesta;
    @Lob
    @Column(name = "mensaje")
    private String mensaje;
    @Lob
    @Column(name = "respuesta")
    private String respuesta;
    @Lob
    @Column(name = "atributos_recuperados")
    private String atributosRecuperados;
    @Lob
    @Column(name = "bpel_endpoint")
    private String bpelEndpoint;

    public LogServicioDistribuido() {
    }

    public LogServicioDistribuido(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public LogServicioDistribuido(Integer ticketId, Integer servicioDistribuidoId, String mensaje) {
        this.ticketId = ticketId;
        this.servicioDistribuidoId = servicioDistribuidoId;
        this.mensaje = mensaje;
        this.solicitado = new Date();
        this.cantidadSolicitudesRespuesta = 0;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Date getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(Date solicitado) {
        this.solicitado = solicitado;
    }

    public Date getTicketAsincronico() {
        return ticketAsincronico;
    }

    public void setTicketAsincronico(Date ticketAsincronico) {
        this.ticketAsincronico = ticketAsincronico;
    }

    public Date getDespachaBpel() {
        return despachaBpel;
    }

    public void setDespachaBpel(Date despachaBpel) {
        this.despachaBpel = despachaBpel;
    }

    public Date getEnsamblaRespuesta() {
        return ensamblaRespuesta;
    }

    public void setEnsamblaRespuesta(Date ensamblaRespuesta) {
        this.ensamblaRespuesta = ensamblaRespuesta;
    }

    public Date getEntregaRespuesta() {
        return entregaRespuesta;
    }

    public void setEntregaRespuesta(Date entregaRespuesta) {
        this.entregaRespuesta = entregaRespuesta;
    }

    public Integer getCantidadSolicitudesRespuesta() {
        return cantidadSolicitudesRespuesta;
    }

    public void setCantidadSolicitudesRespuesta(Integer cantidadSolicitudesRespuesta) {
        this.cantidadSolicitudesRespuesta = cantidadSolicitudesRespuesta;
    }

    public Date getUltimaSolicitudRespuesta() {
        return ultimaSolicitudRespuesta;
    }

    public void setUltimaSolicitudRespuesta(Date ultimaSolicitudRespuesta) {
        this.ultimaSolicitudRespuesta = ultimaSolicitudRespuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getAtributosRecuperados() {
        return atributosRecuperados;
    }

    public void setAtributosRecuperados(String atributosRecuperados) {
        this.atributosRecuperados = atributosRecuperados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogServicioDistribuido)) {
            return false;
        }
        LogServicioDistribuido other = (LogServicioDistribuido) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.LogServicioDistribuido[ticketId=" + ticketId + "]";
    }

    public Integer getServicioDistribuidoId() {
        return servicioDistribuidoId;
    }

    public void setServicioDistribuidoId(Integer servicioDistribuidoId) {
        this.servicioDistribuidoId = servicioDistribuidoId;
    }

    public Integer getConfiguracionServicio_id() {
        return configuracionServicio_id;
    }

    public void setConfiguracionServicio_id(Integer configuracionServicio_id) {
        this.configuracionServicio_id = configuracionServicio_id;
    }

    public String getBpelEndpoint() {
        return bpelEndpoint;
    }

    public void setBpelEndpoint(String bpelEndpoint) {
        this.bpelEndpoint = bpelEndpoint;
    }

}
