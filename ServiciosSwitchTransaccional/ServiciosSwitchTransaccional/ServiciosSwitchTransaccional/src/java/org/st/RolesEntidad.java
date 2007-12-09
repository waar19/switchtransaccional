/*
 * RolesEntidad.java
 * 
 * Created on 25-oct-2007, 16:23:34
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "roles_entidad")
@NamedQueries({@NamedQuery(name = "RolesEntidad.findByDesde", query = "SELECT r FROM RolesEntidad r WHERE r.desde = :desde"), @NamedQuery(name = "RolesEntidad.findByHasta", query = "SELECT r FROM RolesEntidad r WHERE r.hasta = :hasta"), @NamedQuery(name = "RolesEntidad.findByActivo", query = "SELECT r FROM RolesEntidad r WHERE r.activo = :activo"), @NamedQuery(name = "RolesEntidad.findByAnulado", query = "SELECT r FROM RolesEntidad r WHERE r.anulado = :anulado"), @NamedQuery(name = "RolesEntidad.findByEntidadId", query = "SELECT r FROM RolesEntidad r WHERE r.rolesEntidadPK.entidadId = :entidadId"), @NamedQuery(name = "RolesEntidad.findByRol", query = "SELECT r FROM RolesEntidad r WHERE r.rolesEntidadPK.rol = :rol")})
public class RolesEntidad implements Serializable {
    @EmbeddedId
    protected RolesEntidadPK rolesEntidadPK;
    @Column(name = "desde", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @Column(name = "activo", nullable = false)
    private char activo;
    @Column(name = "anulado", nullable = false)
    private char anulado;

    public RolesEntidad() {
    }

    public RolesEntidad(RolesEntidadPK rolesEntidadPK) {
        this.rolesEntidadPK = rolesEntidadPK;
    }

    public RolesEntidad(RolesEntidadPK rolesEntidadPK, Date desde, char activo, char anulado) {
        this.rolesEntidadPK = rolesEntidadPK;
        this.desde = desde;
        this.activo = activo;
        this.anulado = anulado;
    }

    public RolesEntidad(int entidadId, String rol) {
        this.rolesEntidadPK = new RolesEntidadPK(entidadId, rol);
    }

    public RolesEntidadPK getRolesEntidadPK() {
        return rolesEntidadPK;
    }

    public void setRolesEntidadPK(RolesEntidadPK rolesEntidadPK) {
        this.rolesEntidadPK = rolesEntidadPK;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public char getAnulado() {
        return anulado;
    }

    public void setAnulado(char anulado) {
        this.anulado = anulado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolesEntidadPK != null ? rolesEntidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesEntidad)) {
            return false;
        }
        RolesEntidad other = (RolesEntidad) object;
        if ((this.rolesEntidadPK == null && other.rolesEntidadPK != null) || (this.rolesEntidadPK != null && !this.rolesEntidadPK.equals(other.rolesEntidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.RolesEntidad[rolesEntidadPK=" + rolesEntidadPK + "]";
    }

}
