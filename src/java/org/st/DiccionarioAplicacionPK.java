/*
 * DiccionarioAplicacionPK.java
 * 
 * Created on 25-oct-2007, 16:23:06
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
public class DiccionarioAplicacionPK implements Serializable {
    @Column(name = "tipo_objeto", nullable = false)
    private String tipoObjeto;
    @Column(name = "nombre_objeto", nullable = false)
    private String nombreObjeto;

    public DiccionarioAplicacionPK() {
    }

    public DiccionarioAplicacionPK(String tipoObjeto, String nombreObjeto) {
        this.tipoObjeto = tipoObjeto;
        this.nombreObjeto = nombreObjeto;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoObjeto != null ? tipoObjeto.hashCode() : 0);
        hash += (nombreObjeto != null ? nombreObjeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiccionarioAplicacionPK)) {
            return false;
        }
        DiccionarioAplicacionPK other = (DiccionarioAplicacionPK) object;
        if ((this.tipoObjeto == null && other.tipoObjeto != null) || (this.tipoObjeto != null && !this.tipoObjeto.equals(other.tipoObjeto))) {
            return false;
        }
        if ((this.nombreObjeto == null && other.nombreObjeto != null) || (this.nombreObjeto != null && !this.nombreObjeto.equals(other.nombreObjeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.DiccionarioAplicacionPK[tipoObjeto=" + tipoObjeto + ", nombreObjeto=" + nombreObjeto + "]";
    }

}
