package entidad;

import entidad.Ciudad;
import entidad.Gerente;
import entidad.Reserva;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2014-03-24T16:37:25")
@StaticMetamodel(Viaje.class)
public class Viaje_ { 

    public static volatile SingularAttribute<Viaje, String> codigo;
    public static volatile SingularAttribute<Viaje, Ciudad> destino;
    public static volatile SingularAttribute<Viaje, Date> horasalida;
    public static volatile SingularAttribute<Viaje, Date> fechaviaje;
    public static volatile SingularAttribute<Viaje, Short> cuposdisponibles;
    public static volatile SingularAttribute<Viaje, Short> idviaje;
    public static volatile SingularAttribute<Viaje, Gerente> idgerente;
    public static volatile CollectionAttribute<Viaje, Reserva> reservaCollection;

}