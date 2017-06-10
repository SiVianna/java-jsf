/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tiago
 * @param <T>
 */
public abstract class GenericDao<T> {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    
    public GenericDao() {
        this.emf = Persistence.createEntityManagerFactory("ZooPU");
        this.em = emf.createEntityManager();
    }
}
