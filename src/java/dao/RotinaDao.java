/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Rotina;

/**
 *
 * @author tiago
 */
public class RotinaDao extends GenericDao<Rotina> {

    private static RotinaDao instance;

    private RotinaDao(){
        
    }
    
    public void save(Rotina object){
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public static RotinaDao getInstance() {
        if (instance == null) {
            instance = new RotinaDao();
        }
        return instance;
    }

}
