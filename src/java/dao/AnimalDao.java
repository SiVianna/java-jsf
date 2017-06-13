/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import javax.persistence.Query;
import model.Animal;

/**
 *
 * @author tiago
 */
public class AnimalDao extends GenericDao<Animal> {

    private static AnimalDao instance;

    private AnimalDao() {
        super();
    }

    public void save(Animal object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public void update(Animal object){
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }
    
    public Animal findById(int id){
        Query q = em.createNamedQuery("Animal.findByCodigo");
        q.setParameter("codigo", id);
        return (Animal)q.getSingleResult();
    }
    
    

    public static AnimalDao getInstance() {
        if (instance == null) {
            instance = new AnimalDao();
        }
        return instance;
    }
}
