/*
 * ServicioDistribuido.java
 * 
 * Created on 22-oct-2007, 17:03:56
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.st;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author demian
 */
@Entity
@Table(name = "servicio_distribuido")
@NamedQueries({@NamedQuery(name = "ServicioDistribuido.findByServicioDistribuidoId", query = "SELECT s FROM ServicioDistribuido s WHERE s.servicioDistribuidoId = :servicioDistribuidoId"), @NamedQuery(name = "ServicioDistribuido.findByCodigoServicio", query = "SELECT s FROM ServicioDistribuido s WHERE s.codigoServicio = :codigoServicio"), @NamedQuery(name = "ServicioDistribuido.findByNombre", query = "SELECT s FROM ServicioDistribuido s WHERE s.nombre = :nombre"), @NamedQuery(name = "ServicioDistribuido.findByDescripcion", query = "SELECT s FROM ServicioDistribuido s WHERE s.descripcion = :descripcion"), @NamedQuery(name = "ServicioDistribuido.findByObservaciones", query = "SELECT s FROM ServicioDistribuido s WHERE s.observaciones = :observaciones"), @NamedQuery(name = "ServicioDistribuido.findByActivo", query = "SELECT s FROM ServicioDistribuido s WHERE s.activo = :activo"), @NamedQuery(name = "ServicioDistribuido.findByAnulado", query = "SELECT s FROM ServicioDistribuido s WHERE s.anulado = :anulado"), @NamedQuery(name = "ServicioDistribuido.findByVigenciaDesde", query = "SELECT s FROM ServicioDistribuido s WHERE s.vigenciaDesde = :vigenciaDesde"), @NamedQuery(name = "ServicioDistribuido.findByVigenciaHasta", query = "SELECT s FROM ServicioDistribuido s WHERE s.vigenciaHasta = :vigenciaHasta"), @NamedQuery(name = "ServicioDistribuido.findByTipoValidacionXml", query = "SELECT s FROM ServicioDistribuido s WHERE s.tipoValidacionXml = :tipoValidacionXml")})
public class ServicioDistribuido implements Serializable {
    @Id
    @Column(name = "servicio_distribuido_id", nullable = false)
    private Integer servicioDistribuidoId;
    @Column(name = "codigo_servicio", nullable = false)
    private String codigoServicio;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "activo", nullable = false)
    private char activo;
    @Column(name = "anulado")
    private Character anulado;
    @Column(name = "vigencia_desde", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vigenciaDesde;
    @Column(name = "vigencia_hasta")
    @Temporal(TemporalType.DATE)
    private Date vigenciaHasta;
    @Column(name = "tipo_validacion_xml", nullable = false)
    private String tipoValidacionXml;
    @Lob
    @Column(name = "validacion")
    private String validacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioDistribuido")
    private Collection<RecuperaAtributo> recuperaAtributoCollection;

    public ServicioDistribuido() {
    }

    public ServicioDistribuido(Integer servicioDistribuidoId) {
        this.servicioDistribuidoId = servicioDistribuidoId;
    }

    public ServicioDistribuido(Integer servicioDistribuidoId, String codigoServicio, String nombre, char activo, Date vigenciaDesde, String tipoValidacionXml) {
        this.servicioDistribuidoId = servicioDistribuidoId;
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.activo = activo;
        this.vigenciaDesde = vigenciaDesde;
        this.tipoValidacionXml = tipoValidacionXml;
    }

    public Integer getServicioDistribuidoId() {
        return servicioDistribuidoId;
    }

    public void setServicioDistribuidoId(Integer servicioDistribuidoId) {
        this.servicioDistribuidoId = servicioDistribuidoId;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
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

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public Character getAnulado() {
        return anulado;
    }

    public void setAnulado(Character anulado) {
        this.anulado = anulado;
    }

    public Date getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(Date vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public Date getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(Date vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    public String getTipoValidacionXml() {
        return tipoValidacionXml;
    }

    public void setTipoValidacionXml(String tipoValidacionXml) {
        this.tipoValidacionXml = tipoValidacionXml;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public Collection<RecuperaAtributo> getRecuperaAtributoCollection() {
        return recuperaAtributoCollection;
    }

    public void setRecuperaAtributoCollection(Collection<RecuperaAtributo> recuperaAtributoCollection) {
        this.recuperaAtributoCollection = recuperaAtributoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicioDistribuidoId != null ? servicioDistribuidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioDistribuido)) {
            return false;
        }
        ServicioDistribuido other = (ServicioDistribuido) object;
        if ((this.servicioDistribuidoId == null && other.servicioDistribuidoId != null) || (this.servicioDistribuidoId != null && !this.servicioDistribuidoId.equals(other.servicioDistribuidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.st.ServicioDistribuido[servicioDistribuidoId=" + servicioDistribuidoId + "]";
    }

}
