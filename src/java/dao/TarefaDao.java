/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Tarefas;

/**
 *
 * @author tiago
 */
public class TarefaDao extends GenericDao<Tarefas> {

    private static TarefaDao instance;

    private TarefaDao() {

    }

    public void save(Tarefas object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public static TarefaDao getInstance() {
        if (instance == null) {
            instance = new TarefaDao();
        }
        return instance;
    }
}
