package entidad;

import entidad.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2014-03-24T16:37:25")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Short> idcliente;
    public static volatile SingularAttribute<Cliente, String> nombres;
    public static volatile SingularAttribute<Cliente, Integer> numidentificacion;
    public static volatile SingularAttribute<Cliente, String> apellidos;
    public static volatile SingularAttribute<Cliente, String> tipoident;
    public static volatile CollectionAttribute<Cliente, Reserva> reservaCollection;
    public static volatile SingularAttribute<Cliente, Short> cuposasignados;

}