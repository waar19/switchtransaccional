/*
 * ConfiguracionServicio.java
 * 
 * Created on 26-oct-2007, 19:21:17
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author demian
 */
@Entity
@Table(name = "configuracion_servicio")
@NamedQueries({@NamedQuery(name = "ConfiguracionServicio.findByConfiguracionServicioId", query = "SELECT c FROM ConfiguracionServicio c WHERE c.configuracionServicioId = :configuracionServicioId"), @NamedQuery(name = "ConfiguracionServicio.findByConfiguracionyServicio", query = "SELECT c FROM ConfiguracionServicio c WHERE c.configuracionId = :configuracionId AND c.servicioDistribuidoId = :servicioDistribuidoId"), @NamedQuery(name = "ConfiguracionServicio.findByConfiguracionId", query = "SELECT c FROM ConfiguracionServicio c WHERE c.configuracionId = :configuracionId")})
public class ConfiguracionServicio implements Serializable {
    @Id
    @Column(name = "configuracion_servicio_id", nullable = false)
    private Integer configuracionServicioId;
    @Column(name = "configuracion_id", nullable = false)
    private int configuracionId;
    @Column(name = "servicio_distribuido_id", nullable = false)
    private int servicioDistribuidoId;
    @Column(name = "namespace_URI")
    private String nameSpaceURI;
    @Column(name = "nombre_servicio")
    private String nombreServicio;
    @Column(name = "nombre_puerto")
    private String nombrePuerto;
    @Column(name = "endpoint_address")
    private String endpointAddress;

    public ConfiguracionServicio() {
    }

    public ConfiguracionServicio(Integer configuracionServicioId) {
        this.configuracionServicioId = configuracionServicioId;
    }

    public ConfiguracionServicio(Integer configuracionServicioId, int configuracionId) {
        this.configuracionServicioId = configuracionServicioId;
        this.configuracionId = configuracionId;
    }

    public Integer getConfiguracionServicioId() {
        return configuracionServicioId;
    }

    public void setConfiguracionServicioId(Integer configuracionServicioId) {
        this.configuracionServicioId = configuracionServicioId;
    }

    public int getConfiguracionId() {
        return configuracionId;
    }

    public void setConfiguracionId(int configuracionId) {
        this.configuracionId = configuracionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracionServicioId != null ? configuracionServicioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionServicio)) {
            return false;
        }
        ConfiguracionServicio other = (ConfiguracionServicio) object;
        if ((this.configuracionServicioId == null && other.configuracionServicioId != null) || (this.configuracionServicioId != null && !this.configuracionServicioId.equals(other.configuracionServicioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.ConfiguracionServicio[configuracionServicioId=" + configuracionServicioId + "]";
    }

    public int getServicioDistribuidoId() {
        return servicioDistribuidoId;
    }

    public void setServicioDistribuidoId(int servicioDistribuidoId) {
        this.servicioDistribuidoId = servicioDistribuidoId;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombrePuerto() {
        return nombrePuerto;
    }

    public void setNombrePuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    public String getNameSpaceURI() {
        return nameSpaceURI;
    }

    public void setNameSpaceURI(String nameSpaceURI) {
        this.nameSpaceURI = nameSpaceURI;
    }

    public String getEndpointAddress() {
        return endpointAddress;
    }

    public void setEndpointAddress(String endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

}
