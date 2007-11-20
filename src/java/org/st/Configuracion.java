/*
 * Configuracion.java
 * 
 * Created on 25-oct-2007, 18:46:22
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author demian
 */
@Entity
@Table(name = "configuracion")
@NamedQueries({@NamedQuery(name = "Configuracion.findByConfiguracionId", query = "SELECT c FROM Configuracion c WHERE c.configuracionId = :configuracionId"), @NamedQuery(name = "Configuracion.findByNombre", query = "SELECT c FROM Configuracion c WHERE c.nombre = :nombre"), @NamedQuery(name = "Configuracion.findByDescripcion", query = "SELECT c FROM Configuracion c WHERE c.descripcion = :descripcion"), @NamedQuery(name = "Configuracion.findByObservaciones", query = "SELECT c FROM Configuracion c WHERE c.observaciones = :observaciones"), @NamedQuery(name = "Configuracion.findByCardinalidad", query = "SELECT c FROM Configuracion c WHERE c.cardinalidad = :cardinalidad"), @NamedQuery(name = "Configuracion.findByPrioridad", query = "SELECT c FROM Configuracion c WHERE c.prioridad = :prioridad")})
public class Configuracion implements Serializable {
    @Id
    @Column(name = "configuracion_id", nullable = false)
    private Integer configuracionId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "cardinalidad", nullable = false)
    private int cardinalidad;
    @Column(name = "prioridad", nullable = false)
    private int prioridad;

    public Configuracion() {
    }

    public Configuracion(Integer configuracionId) {
        this.configuracionId = configuracionId;
    }

    public Configuracion(Integer configuracionId, String nombre, int cardinalidad, int prioridad) {
        this.configuracionId = configuracionId;
        this.nombre = nombre;
        this.cardinalidad = cardinalidad;
        this.prioridad = prioridad;
    }

    public Integer getConfiguracionId() {
        return configuracionId;
    }

    public void setConfiguracionId(Integer configuracionId) {
        this.configuracionId = configuracionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCardinalidad() {
        return cardinalidad;
    }

    public void setCardinalidad(int cardinalidad) {
        this.cardinalidad = cardinalidad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracionId != null ? configuracionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.configuracionId == null && other.configuracionId != null) || (this.configuracionId != null && !this.configuracionId.equals(other.configuracionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.Configuracion[configuracionId=" + configuracionId + "]";
    }

}
