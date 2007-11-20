/*
 * RecuperaAtributo.java
 * 
 * Created on 22-oct-2007, 17:03:59
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author demian
 */
@Entity
@Table(name = "recupera_atributo")
@NamedQueries({@NamedQuery(name = "RecuperaAtributo.findByServicioDistribuidoId", query = "SELECT r FROM RecuperaAtributo r WHERE r.recuperaAtributoPK.servicioDistribuidoId = :servicioDistribuidoId"), @NamedQuery(name = "RecuperaAtributo.findByAtributoId", query = "SELECT r FROM RecuperaAtributo r WHERE r.recuperaAtributoPK.atributoId = :atributoId"), @NamedQuery(name = "RecuperaAtributo.findByMetodoXml", query = "SELECT r FROM RecuperaAtributo r WHERE r.metodoXml = :metodoXml")})
public class RecuperaAtributo implements Serializable {
    @EmbeddedId
    protected RecuperaAtributoPK recuperaAtributoPK;
    @Column(name = "metodo_xml", nullable = false)
    private String metodoXml;
    @Lob
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @JoinColumn(name = "servicio_distribuido_id", referencedColumnName = "servicio_distribuido_id", insertable = false, updatable = false)
    @ManyToOne
    private ServicioDistribuido servicioDistribuido;

    public RecuperaAtributo() {
    }

    public RecuperaAtributo(RecuperaAtributoPK recuperaAtributoPK) {
        this.recuperaAtributoPK = recuperaAtributoPK;
    }

    public RecuperaAtributo(RecuperaAtributoPK recuperaAtributoPK, String metodoXml, String codigo) {
        this.recuperaAtributoPK = recuperaAtributoPK;
        this.metodoXml = metodoXml;
        this.codigo = codigo;
    }

    public RecuperaAtributo(int servicioDistribuidoId, int atributoId) {
        this.recuperaAtributoPK = new RecuperaAtributoPK(servicioDistribuidoId, atributoId);
    }

    public RecuperaAtributoPK getRecuperaAtributoPK() {
        return recuperaAtributoPK;
    }

    public void setRecuperaAtributoPK(RecuperaAtributoPK recuperaAtributoPK) {
        this.recuperaAtributoPK = recuperaAtributoPK;
    }

    public String getMetodoXml() {
        return metodoXml;
    }

    public void setMetodoXml(String metodoXml) {
        this.metodoXml = metodoXml;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ServicioDistribuido getServicioDistribuido() {
        return servicioDistribuido;
    }

    public void setServicioDistribuido(ServicioDistribuido servicioDistribuido) {
        this.servicioDistribuido = servicioDistribuido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recuperaAtributoPK != null ? recuperaAtributoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecuperaAtributo)) {
            return false;
        }
        RecuperaAtributo other = (RecuperaAtributo) object;
        if ((this.recuperaAtributoPK == null && other.recuperaAtributoPK != null) || (this.recuperaAtributoPK != null && !this.recuperaAtributoPK.equals(other.recuperaAtributoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.RecuperaAtributo[recuperaAtributoPK=" + recuperaAtributoPK + "]";
    }

}
