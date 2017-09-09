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
@Table(name = "GERENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g"),
    @NamedQuery(name = "Gerente.findByIdgerente", query = "SELECT g FROM Gerente g WHERE g.idgerente = :idgerente"),
    @NamedQuery(name = "Gerente.findByNombres", query = "SELECT g FROM Gerente g WHERE g.nombres = :nombres"),
    @NamedQuery(name = "Gerente.findByApellidos", query = "SELECT g FROM Gerente g WHERE g.apellidos = :apellidos"),
    @NamedQuery(name = "Gerente.findByTipoidentificacion", query = "SELECT g FROM Gerente g WHERE g.tipoidentificacion = :tipoidentificacion"),
    @NamedQuery(name = "Gerente.findByNumeroidentificacion", query = "SELECT g FROM Gerente g WHERE g.numeroidentificacion = :numeroidentificacion"),
    @NamedQuery(name = "Gerente.findByNombreempresa", query = "SELECT g FROM Gerente g WHERE g.nombreempresa = :nombreempresa"),
    @NamedQuery(name = "Gerente.findByLogin", query = "SELECT g FROM Gerente g WHERE g.login = :login"),
    @NamedQuery(name = "Gerente.findByPassword", query = "SELECT g FROM Gerente g WHERE g.password = :password")})
public class Gerente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Column(name = "IDGERENTE")
    private Short idgerente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TIPOIDENTIFICACION")
    private String tipoidentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROIDENTIFICACION")
    private int numeroidentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBREEMPRESA")
    private String nombreempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "idgerente")
    private Collection<Viaje> viajeCollection;

    public Gerente() {
    }

    public Gerente(Short idgerente) {
        this.idgerente = idgerente;
    }

    public Gerente(Short idgerente, String nombres, String apellidos, String tipoidentificacion, int numeroidentificacion, String nombreempresa, String login, String password) {
        this.idgerente = idgerente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoidentificacion = tipoidentificacion;
        this.numeroidentificacion = numeroidentificacion;
        this.nombreempresa = nombreempresa;
        this.login = login;
        this.password = password;
    }

    public Short getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(Short idgerente) {
        this.idgerente = idgerente;
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

    public String getTipoidentificacion() {
        return tipoidentificacion;
    }

    public void setTipoidentificacion(String tipoidentificacion) {
        this.tipoidentificacion = tipoidentificacion;
    }

    public int getNumeroidentificacion() {
        return numeroidentificacion;
    }

    public void setNumeroidentificacion(int numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgerente != null ? idgerente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerente)) {
            return false;
        }
        Gerente other = (Gerente) object;
        if ((this.idgerente == null && other.idgerente != null) || (this.idgerente != null && !this.idgerente.equals(other.idgerente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Gerente[ idgerente=" + idgerente + " ]";
    }
    
}
