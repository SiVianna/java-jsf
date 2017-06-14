/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Veterinario;

/**
 *
 * @author Guitar Jr
 */
public class VeterinarioDao {
    
    EntityManagerFactory emf;
    EntityManager em;

    private static VeterinarioDao instance;

    private VeterinarioDao() {
        this.emf = Persistence.createEntityManagerFactory("ZooPU");
        this.em = emf.createEntityManager();
    }

    public void save(Veterinario object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public void update(Veterinario object) {
        Veterinario veterinario = em.find(Veterinario.class, object.getId());
        em.getTransaction().begin();
        em.merge(veterinario);
        em.getTransaction().commit();
    }

    public Veterinario findById(int id) {
        try {
            Query q = em.createNamedQuery("Tratador.findById");
            q.setParameter("id", id);
            return (Veterinario) q.getSingleResult();
        } catch (NonUniqueResultException | NoResultException ex) {
            return null;
        }
    }
    
    public List<Veterinario> findAll(){
    
        Query q = em.createQuery("SELECT v FROM Veterinario v");

        return q.getResultList();
    }
    
    public Veterinario Verificalogin(String matricula, String senha) {
        try {
            Query q = em.createQuery("SELECT v FROM Veterinario v WHERE v.matricula = :matricula AND v.senha = :senha");
            q.setParameter("matricula", matricula);
            q.setParameter("senha", senha);
            return (Veterinario) q.getSingleResult();
        } catch (NonUniqueResultException | NoResultException ex) {
            return null;
        }
    }

    public static VeterinarioDao getInstance() {
        if (instance == null) {
            instance = new VeterinarioDao();
        }
        return instance;
    }
    
    
    
}
