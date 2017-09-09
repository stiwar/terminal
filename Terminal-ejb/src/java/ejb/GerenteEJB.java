/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Gerente;
import entidad.Viaje;
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
public class GerenteEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName= "Terminal-ejbPU" )
    private EntityManager em;

   public List<Gerente> obtenerGerentes(){
        
        List<Gerente> gerents = new ArrayList<Gerente>();
        
        Query q = em.createNamedQuery("Gerente.findAll");
        System.out.println("gerente  EJB:   "+q);
        try {
            gerents=q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return gerents;
    }
   
   public boolean creargerente(Gerente g){
        //System.out.println(g.getNombres().getNombre());
        try {
            em.persist(g);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
   
   public boolean editarGerente(Gerente g){
        /*System.out.println(c.getNombres());
        System.out.println(c.getApellidos());
        System.out.println(c.getTi());
        System.out.println(c.getIdentificacion());
        System.out.println(c.getLogin());
        System.out.println(c.getClave());*/
      
        try {
            em.merge(g);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
   
       public boolean eliminarGerente(Gerente g){
        //System.out.println(c.getNombre());
   
        try {
            em.remove(em.merge (g)); 
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    }
       
      
       

    
    
}
