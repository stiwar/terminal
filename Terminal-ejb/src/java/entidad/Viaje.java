/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stiven
 */
@Entity
@Table(name = "VIAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v"),
    @NamedQuery(name = "Viaje.findByIdviaje", query = "SELECT v FROM Viaje v WHERE v.idviaje = :idviaje"),
    @NamedQuery(name = "Viaje.findByIdgerente", query = "SELECT v FROM Viaje v WHERE v.idgerente = :idgerente"),
    @NamedQuery(name = "Viaje.findByCodigo", query = "SELECT v FROM Viaje v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "Viaje.findByFechaviaje", query = "SELECT v FROM Viaje v WHERE v.fechaviaje = :fechaviaje"),
    @NamedQuery(name = "Viaje.findByHorasalida", query = "SELECT v FROM Viaje v WHERE v.horasalida = :horasalida"),
    @NamedQuery(name = "Viaje.findByCuposdisponibles", query = "SELECT v FROM Viaje v WHERE v.cuposdisponibles = :cuposdisponibles")})
public class Viaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
 //   @NotNull
    @Column(name = "IDVIAJE")
    private Short idviaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAVIAJE")
    @Temporal(TemporalType.DATE)
    private Date fechaviaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORASALIDA")
    @Temporal(TemporalType.TIME)
    private Date horasalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUPOSDISPONIBLES")
    private short cuposdisponibles;
    @OneToMany(mappedBy = "idviaje")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "IDGERENTE", referencedColumnName = "IDGERENTE")
    @ManyToOne
    private Gerente idgerente;
    @JoinColumn(name = "DESTINO", referencedColumnName = "IDCIUDAD")
    @ManyToOne
    private Ciudad destino;

    public Viaje() {
    }

    public Viaje(Short idviaje) {
        this.idviaje = idviaje;
    }

    public Viaje(Short idviaje, String codigo, Date fechaviaje, Date horasalida, short cuposdisponibles) {
        this.idviaje = idviaje;
        this.codigo = codigo;
        this.fechaviaje = fechaviaje;
        this.horasalida = horasalida;
        this.cuposdisponibles = cuposdisponibles;
    }

    public Short getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(Short idviaje) {
        this.idviaje = idviaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaviaje() {
        //-------------------
       
        //-------------------
        
        return fechaviaje;
    }

    public void setFechaviaje(Date fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public Date getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Date horasalida) {
        this.horasalida = horasalida;
    }

    public short getCuposdisponibles() {
        return cuposdisponibles;
    }

    public void setCuposdisponibles(short cuposdisponibles) {
        this.cuposdisponibles = cuposdisponibles;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public Gerente getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(Gerente idgerente) {
        this.idgerente = idgerente;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idviaje != null ? idviaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idviaje == null && other.idviaje != null) || (this.idviaje != null && !this.idviaje.equals(other.idviaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Viaje[ idviaje=" + idviaje + " ]";
    }
    
}
