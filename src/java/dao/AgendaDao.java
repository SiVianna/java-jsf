/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.AgendaConsulta;

/**
 *
 * @author tiago
 */
public class AgendaDao extends GenericDao<AgendaConsulta> {

    private static AgendaDao instance;

    private AgendaDao() {

    }

    public void save(AgendaConsulta object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public static AgendaDao getInstance() {
        if (instance == null) {
            instance = new AgendaDao();
        }
        return instance;
    }
}
