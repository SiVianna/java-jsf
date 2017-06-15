/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.Receita;

/**
 *
 * @author tiago
 */
public class ReceitaDao extends GenericDao<Receita> {

    private static ReceitaDao instance;

    private ReceitaDao() {
        super();
    }

    public void save(Receita object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public void update(Receita object){
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }
    
    public static ReceitaDao getInstance() {
        if (instance == null) {
            instance = new ReceitaDao();
        }
        return instance;
    }
}
