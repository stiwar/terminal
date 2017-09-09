package entidad;

import entidad.Viaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2014-03-24T16:37:25")
@StaticMetamodel(Gerente.class)
public class Gerente_ { 

    public static volatile SingularAttribute<Gerente, Integer> numeroidentificacion;
    public static volatile SingularAttribute<Gerente, String> nombres;
    public static volatile SingularAttribute<Gerente, String> apellidos;
    public static volatile SingularAttribute<Gerente, String> nombreempresa;
    public static volatile SingularAttribute<Gerente, String> tipoidentificacion;
    public static volatile SingularAttribute<Gerente, String> login;
    public static volatile SingularAttribute<Gerente, Short> idgerente;
    public static volatile SingularAttribute<Gerente, String> password;
    public static volatile CollectionAttribute<Gerente, Viaje> viajeCollection;

}