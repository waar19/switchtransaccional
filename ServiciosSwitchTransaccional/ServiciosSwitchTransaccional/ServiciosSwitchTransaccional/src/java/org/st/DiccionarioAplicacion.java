/*
 * DiccionarioAplicacion.java
 * 
 * Created on 25-oct-2007, 16:23:05
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author demian
 */
@Entity
@Table(name = "diccionario_aplicacion")
@NamedQueries({@NamedQuery(name = "DiccionarioAplicacion.findByTipoObjeto", query = "SELECT d FROM DiccionarioAplicacion d WHERE d.diccionarioAplicacionPK.tipoObjeto = :tipoObjeto"), @NamedQuery(name = "DiccionarioAplicacion.findByNombreObjeto", query = "SELECT d FROM DiccionarioAplicacion d WHERE d.diccionarioAplicacionPK.nombreObjeto = :nombreObjeto")})
public class DiccionarioAplicacion implements Serializable {
    @EmbeddedId
    protected DiccionarioAplicacionPK diccionarioAplicacionPK;

    public DiccionarioAplicacion() {
    }

    public DiccionarioAplicacion(DiccionarioAplicacionPK diccionarioAplicacionPK) {
        this.diccionarioAplicacionPK = diccionarioAplicacionPK;
    }

    public DiccionarioAplicacion(String tipoObjeto, String nombreObjeto) {
        this.diccionarioAplicacionPK = new DiccionarioAplicacionPK(tipoObjeto, nombreObjeto);
    }

    public DiccionarioAplicacionPK getDiccionarioAplicacionPK() {
        return diccionarioAplicacionPK;
    }

    public void setDiccionarioAplicacionPK(DiccionarioAplicacionPK diccionarioAplicacionPK) {
        this.diccionarioAplicacionPK = diccionarioAplicacionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diccionarioAplicacionPK != null ? diccionarioAplicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiccionarioAplicacion)) {
            return false;
        }
        DiccionarioAplicacion other = (DiccionarioAplicacion) object;
        if ((this.diccionarioAplicacionPK == null && other.diccionarioAplicacionPK != null) || (this.diccionarioAplicacionPK != null && !this.diccionarioAplicacionPK.equals(other.diccionarioAplicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.DiccionarioAplicacion[diccionarioAplicacionPK=" + diccionarioAplicacionPK + "]";
    }

}
