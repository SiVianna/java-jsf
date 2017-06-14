/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnimalDao;
import dao.ReceitaDao;
import dao.TratadorDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Receita;

/**
 *
 * @author Guitar Jr
 */
@ManagedBean
@RequestScoped
public class receitaBean {
    
    private Receita receita;

    /**
     * Creates a new instance of receitaBean
     */
    public receitaBean() {
        
        this.receita = new Receita();
    }
    
    public String store(){
        
        LoginVeterinarioBean lvt = (LoginVeterinarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginVeterinario");
        ReceitaDao.getInstance().save(receita);
        return "home?faces-redirect=true";
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }
     
}
