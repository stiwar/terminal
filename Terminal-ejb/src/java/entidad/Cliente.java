/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stiven
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Cliente.findByTipoident", query = "SELECT c FROM Cliente c WHERE c.tipoident = :tipoident"),
    @NamedQuery(name = "Cliente.findByNumidentificacion", query = "SELECT c FROM Cliente c WHERE c.numidentificacion = :numidentificacion"),
    @NamedQuery(name = "Cliente.findByCuposasignados", query = "SELECT c FROM Cliente c WHERE c.cuposasignados = :cuposasignados")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Column(name = "IDCLIENTE")
    private Short idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPOIDENT")
    private String tipoident;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMIDENTIFICACION")
    private int numidentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUPOSASIGNADOS")
    private short cuposasignados;
    @OneToMany(mappedBy = "idcliente")
    private Collection<Reserva> reservaCollection;

    public Cliente() {
    }

    public Cliente(Short idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Short idcliente, String nombres, String apellidos, String tipoident, int numidentificacion, short cuposasignados) {
        this.idcliente = idcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoident = tipoident;
        this.numidentificacion = numidentificacion;
        this.cuposasignados = cuposasignados;
    }

    public Short getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Short idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoident() {
        return tipoident;
    }

    public void setTipoident(String tipoident) {
        this.tipoident = tipoident;
    }

    public int getNumidentificacion() {
        return numidentificacion;
    }

    public void setNumidentificacion(int numidentificacion) {
        this.numidentificacion = numidentificacion;
    }

    public short getCuposasignados() {
        return cuposasignados;
    }

    public void setCuposasignados(short cuposasignados) {
        this.cuposasignados = cuposasignados;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
