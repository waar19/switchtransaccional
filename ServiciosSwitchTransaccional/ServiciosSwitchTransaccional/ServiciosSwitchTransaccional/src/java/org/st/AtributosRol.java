/*
 * AtributosRol.java
 * 
 * Created on 24-oct-2007, 20:46:41
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
@Table(name = "atributos_rol")
@NamedQueries({@NamedQuery(name = "AtributosRol.findByAtributoId", query = "SELECT a FROM AtributosRol a WHERE a.atributoId = :atributoId"), @NamedQuery(name = "AtributosRol.findByNombre", query = "SELECT a FROM AtributosRol a WHERE a.nombre = :nombre"), @NamedQuery(name = "AtributosRol.findByDescripcion", query = "SELECT a FROM AtributosRol a WHERE a.descripcion = :descripcion"), @NamedQuery(name = "AtributosRol.findByObservaciones", query = "SELECT a FROM AtributosRol a WHERE a.observaciones = :observaciones"), @NamedQuery(name = "AtributosRol.findByDesde", query = "SELECT a FROM AtributosRol a WHERE a.desde = :desde"), @NamedQuery(name = "AtributosRol.findByHasta", query = "SELECT a FROM AtributosRol a WHERE a.hasta = :hasta"), @NamedQuery(name = "AtributosRol.findByClave", query = "SELECT a FROM AtributosRol a WHERE a.clave = :clave"), @NamedQuery(name = "AtributosRol.findByAnulado", query = "SELECT a FROM AtributosRol a WHERE a.anulado = :anulado"), @NamedQuery(name = "AtributosRol.findByObligatorio", query = "SELECT a FROM AtributosRol a WHERE a.obligatorio = :obligatorio"), @NamedQuery(name = "AtributosRol.findByClaseLovAtributoId", query = "SELECT a FROM AtributosRol a WHERE a.claseLovAtributoId = :claseLovAtributoId"), @NamedQuery(name = "AtributosRol.findByTipoDato", query = "SELECT a FROM AtributosRol a WHERE a.tipoDato = :tipoDato"), @NamedQuery(name = "AtributosRol.findByLov", query = "SELECT a FROM AtributosRol a WHERE a.lov = :lov"), @NamedQuery(name = "AtributosRol.findByValidador", query = "SELECT a FROM AtributosRol a WHERE a.validador = :validador")})
public class AtributosRol implements Serializable {
    @Id
    @Column(name = "atributo_id", nullable = false)
    private Integer atributoId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "desde", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @Column(name = "clave", nullable = false)
    private char clave;
    @Column(name = "anulado", nullable = false)
    private char anulado;
    @Column(name = "obligatorio", nullable = false)
    private char obligatorio;
    @Column(name = "clase_lov_atributo_id")
    private Integer claseLovAtributoId;
    @Column(name = "tipo_dato", nullable = false)
    private String tipoDato;
    @Column(name = "lov")
    private String lov;
    @Column(name = "validador")
    private String validador;

    public AtributosRol() {
    }

    public AtributosRol(Integer atributoId) {
        this.atributoId = atributoId;
    }

    public AtributosRol(Integer atributoId, String nombre, Date desde, char clave, char anulado, char obligatorio, String tipoDato) {
        this.atributoId = atributoId;
        this.nombre = nombre;
        this.desde = desde;
        this.clave = clave;
        this.anulado = anulado;
        this.obligatorio = obligatorio;
        this.tipoDato = tipoDato;
    }

    public Integer getAtributoId() {
        return atributoId;
    }

    public void setAtributoId(Integer atributoId) {
        this.atributoId = atributoId;
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

    public char getClave() {
        return clave;
    }

    public void setClave(char clave) {
        this.clave = clave;
    }

    public char getAnulado() {
        return anulado;
    }

    public void setAnulado(char anulado) {
        this.anulado = anulado;
    }

    public char getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(char obligatorio) {
        this.obligatorio = obligatorio;
    }

    public Integer getClaseLovAtributoId() {
        return claseLovAtributoId;
    }

    public void setClaseLovAtributoId(Integer claseLovAtributoId) {
        this.claseLovAtributoId = claseLovAtributoId;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getLov() {
        return lov;
    }

    public void setLov(String lov) {
        this.lov = lov;
    }

    public String getValidador() {
        return validador;
    }

    public void setValidador(String validador) {
        this.validador = validador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atributoId != null ? atributoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributosRol)) {
            return false;
        }
        AtributosRol other = (AtributosRol) object;
        if ((this.atributoId == null && other.atributoId != null) || (this.atributoId != null && !this.atributoId.equals(other.atributoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.AtributosRol[atributoId=" + atributoId + "]";
    }

}
