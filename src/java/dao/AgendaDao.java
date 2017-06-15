/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
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

    public List<AgendaConsulta> findByVeterinario(int id) {
        Query q = em.createQuery("SELECT a FROM AgendaConsulta a WHERE a.veterinarioId.id = :id");
        q.setParameter("id", id);
        return q.getResultList();
    }

    public static AgendaDao getInstance() {
        if (instance == null) {
            instance = new AgendaDao();
        }
        return instance;
    }
}
