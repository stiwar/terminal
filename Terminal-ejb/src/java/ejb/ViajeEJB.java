/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Ciudad;
import entidad.Gerente;
import entidad.Viaje;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author stiven
 */
@Stateless
@LocalBean
public class ViajeEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName= "Terminal-ejbPU" )
    private EntityManager em;
    
    
        public List<Viaje> obtenerViajes(){
        
        List<Viaje> viajes = new ArrayList<Viaje>();
        Query q = em.createNamedQuery("Viaje.findAll");
        try {
            viajes=q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return viajes;
    }
        
        public boolean crearviaje(Viaje v){
        //System.out.println();
        try {
            em.persist(v);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
        
        Ciudad co = new Ciudad();
       public Ciudad fijarDestino(Short d){ 
        
        Query q = em.createNamedQuery("Ciudad.findByIdciudad");
        Integer i=new Integer(d);
        q.setParameter("idciudad", new Short(i.shortValue()));
            co = (Ciudad)q.getSingleResult();
        System.out.println("nombre: "+co.getNombre());
        return co;
    }
       
        //---------------------
       Gerente co2 = new Gerente();
       
        public Gerente fijarIdGerente(Short d){ 
        
        //Query q = em.createNamedQuery("Ciudad.findByIdciudad");
            Query q = em.createNamedQuery("Gerente.findByIdgerente");
        Integer i=new Integer(d);
        q.setParameter("idgerente", new Short(i.shortValue()));
            co2 = (Gerente)q.getSingleResult();
        System.out.println("nombre: "+co2.getIdgerente());
        return co2;
    }
       //---------------------
       
       
       
      public List<Viaje>  recuperarDestino (Short d){
       List<Viaje> viajes = new ArrayList<Viaje>();
       String consulta="SELECT v FROM Viaje v WHERE v.idgerente = :"+d;
       System.out.println("gerente:  id   "+consulta);
       Query q = em.createNamedQuery("Viaje.findAll"); 
       System.out.println("gerente:  id   "+q);
        try {
            viajes=q.getResultList();
            
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return viajes;
      }
        


}
