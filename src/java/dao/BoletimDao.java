/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Boletim;

/**
 *
 * @author tiago
 */
public class BoletimDao extends GenericDao<Boletim>{
     private static BoletimDao instance;

    private BoletimDao() {
        super();
    }

    public void save(Boletim object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public void update(Boletim object){
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    public static BoletimDao getInstance() {
        if (instance == null) {
            instance = new BoletimDao();
        }
        return instance;
    }
}
