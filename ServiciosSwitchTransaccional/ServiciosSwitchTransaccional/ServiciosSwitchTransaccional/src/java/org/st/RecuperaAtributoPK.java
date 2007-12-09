/*
 * RecuperaAtributoPK.java
 * 
 * Created on 22-oct-2007, 17:03:59
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
public class RecuperaAtributoPK implements Serializable {
    @Column(name = "servicio_distribuido_id", nullable = false)
    private int servicioDistribuidoId;
    @Column(name = "atributo_id", nullable = false)
    private int atributoId;

    public RecuperaAtributoPK() {
    }

    public RecuperaAtributoPK(int servicioDistribuidoId, int atributoId) {
        this.servicioDistribuidoId = servicioDistribuidoId;
        this.atributoId = atributoId;
    }

    public int getServicioDistribuidoId() {
        return servicioDistribuidoId;
    }

    public void setServicioDistribuidoId(int servicioDistribuidoId) {
        this.servicioDistribuidoId = servicioDistribuidoId;
    }

    public int getAtributoId() {
        return atributoId;
    }

    public void setAtributoId(int atributoId) {
        this.atributoId = atributoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += servicioDistribuidoId;
        hash += atributoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecuperaAtributoPK)) {
            return false;
        }
        RecuperaAtributoPK other = (RecuperaAtributoPK) object;
        if (this.servicioDistribuidoId != other.servicioDistribuidoId) {
            return false;
        }
        if (this.atributoId != other.atributoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.RecuperaAtributoPK[servicioDistribuidoId=" + servicioDistribuidoId + ", atributoId=" + atributoId + "]";
    }

}
