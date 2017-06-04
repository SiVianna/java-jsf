/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TratadorDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Tratador;

/**
 *
 * @author tiago
 */
@ManagedBean
@RequestScoped
public class TratadorBean {

    private Tratador tratador;

    public TratadorBean() {
        this.tratador = new Tratador();
    }

    public String store() {
        TratadorDao.getInstance().save(tratador);
        return "login?faces-redirect=true";
    }
    
    public Tratador getTratador() {
        return tratador;
    }

    public void setTratador(Tratador tratador) {
        this.tratador = tratador;
    }

}
