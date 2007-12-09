/*
 * ClaseAtributoRol.java
 * 
 * Created on 25-oct-2007, 16:21:34
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
@Table(name = "clase_atributo_rol")
@NamedQueries({@NamedQuery(name = "ClaseAtributoRol.findByClaseAtributoRolId", query = "SELECT c FROM ClaseAtributoRol c WHERE c.claseAtributoRolId = :claseAtributoRolId"), @NamedQuery(name = "ClaseAtributoRol.findByEtiqueta", query = "SELECT c FROM ClaseAtributoRol c WHERE c.etiqueta = :etiqueta")})
public class ClaseAtributoRol implements Serializable {
    @Id
    @Column(name = "clase_atributo_rol_id", nullable = false)
    private Integer claseAtributoRolId;
    @Column(name = "etiqueta", nullable = false)
    private String etiqueta;

    public ClaseAtributoRol() {
    }

    public ClaseAtributoRol(Integer claseAtributoRolId) {
        this.claseAtributoRolId = claseAtributoRolId;
    }

    public ClaseAtributoRol(Integer claseAtributoRolId, String etiqueta) {
        this.claseAtributoRolId = claseAtributoRolId;
        this.etiqueta = etiqueta;
    }

    public Integer getClaseAtributoRolId() {
        return claseAtributoRolId;
    }

    public void setClaseAtributoRolId(Integer claseAtributoRolId) {
        this.claseAtributoRolId = claseAtributoRolId;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claseAtributoRolId != null ? claseAtributoRolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaseAtributoRol)) {
            return false;
        }
        ClaseAtributoRol other = (ClaseAtributoRol) object;
        if ((this.claseAtributoRolId == null && other.claseAtributoRolId != null) || (this.claseAtributoRolId != null && !this.claseAtributoRolId.equals(other.claseAtributoRolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.ClaseAtributoRol[claseAtributoRolId=" + claseAtributoRolId + "]";
    }

}
