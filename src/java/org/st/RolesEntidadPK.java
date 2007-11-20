/*
 * RolesEntidadPK.java
 * 
 * Created on 25-oct-2007, 16:23:34
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author demian
 */
@Embeddable
public class RolesEntidadPK implements Serializable {
    @Column(name = "entidad_id", nullable = false)
    private int entidadId;
    @Column(name = "rol", nullable = false)
    private String rol;

    public RolesEntidadPK() {
    }

    public RolesEntidadPK(int entidadId, String rol) {
        this.entidadId = entidadId;
        this.rol = rol;
    }

    public int getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(int entidadId) {
        this.entidadId = entidadId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) entidadId;
        hash += (rol != null ? rol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesEntidadPK)) {
            return false;
        }
        RolesEntidadPK other = (RolesEntidadPK) object;
        if (this.entidadId != other.entidadId) {
            return false;
        }
        if ((this.rol == null && other.rol != null) || (this.rol != null && !this.rol.equals(other.rol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.RolesEntidadPK[entidadId=" + entidadId + ", rol=" + rol + "]";
    }

}
