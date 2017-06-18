/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.AnimalDao;
import dao.TratadorDao;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Animal;


/**
 *
 * @author tiago
 */
@ManagedBean
@RequestScoped
public class AnimalBean {

    private Animal animal;

    public AnimalBean() {
        this.animal = new Animal();
    }

    public String store(){
        
        LoginTratadorBean lb = (LoginTratadorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginTratador");
        animal.getTratadorList().add(lb.getTratador());
        AnimalDao.getInstance().save(animal);
        lb.getTratador().getAnimalList().add(animal);
        TratadorDao.getInstance().update(lb.getTratador());
        showMessage();
        return "homeLogado?faces-redirect=true";
    }
    
    
    
    public void showMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Animal cadastrado com sucesso!!!!"));
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}
