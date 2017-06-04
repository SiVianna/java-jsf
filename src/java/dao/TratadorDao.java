/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Tratador;

/**
 *
 * @author tiago
 */
public class TratadorDao {

    EntityManagerFactory emf;
    EntityManager em;

    private static TratadorDao instance;

    private TratadorDao() {
        this.emf = Persistence.createEntityManagerFactory("ZooPU");
        this.em = emf.createEntityManager();
    }

    public void save(Tratador object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public void update(Tratador object) {
        Tratador tratador = em.find(Tratador.class, object.getId());
        em.getTransaction().begin();
        em.merge(tratador);
        em.getTransaction().commit();
    }

    public Tratador findById(int id) {
        try {
            Query q = em.createNamedQuery("Tratador.findById");
            q.setParameter("id", id);
            return (Tratador) q.getSingleResult();
        } catch (NonUniqueResultException | NoResultException ex) {
            return null;
        }
    }

    public Tratador Verificalogin(String matricula, String senha) {
        try {
            Query q = em.createQuery("SELECT t FROM Tratador t WHERE t.matricula = :matricula AND t.senha = :senha");
            q.setParameter("matricula", matricula);
            q.setParameter("senha", senha);
            return (Tratador) q.getSingleResult();
        } catch (NonUniqueResultException | NoResultException ex) {
            return null;
        }
    }

    public static TratadorDao getInstance() {
        if (instance == null) {
            instance = new TratadorDao();
        }
        return instance;
    }
}
