/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidad.Ciudad;
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
public class CiudadEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName= "Terminal-ejbPU" )
    private EntityManager em;
    
        public List<Ciudad> obtenerCiudades(){
        
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Query q = em.createNamedQuery("Ciudad.findAll");
        try {
            ciudades=q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return ciudades;
    }
        
       public boolean crearciudad(Ciudad c){
        //System.out.println(c.getNombre());
        try {
            em.persist(c);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
        return true;
    } 
    

}
