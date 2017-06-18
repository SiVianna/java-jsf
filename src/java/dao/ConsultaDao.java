/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Consulta;

/**
 *
 * @author Guitar Jr
 */
public class ConsultaDao extends GenericDao<Consulta> {
    
    private static ConsultaDao instance;

    private ConsultaDao() {
        super();
    }
    
    
    public void save(Consulta object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
     public static ConsultaDao getInstance() {
        if (instance == null) {
            instance = new ConsultaDao();
        }
        return instance;
    }

    
}
