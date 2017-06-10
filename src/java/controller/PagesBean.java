/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author tiago
 */
@ManagedBean
@RequestScoped
public class PagesBean {

    /**
     * Creates a new instance of PagesBean
     */
    public PagesBean() {
    }
    
    public String login(){
        return "login?faces-redirect=true";
    }
    
    public String newAnimal(){
        return "animalCadastro?faces-redirect=true";
    }
}
