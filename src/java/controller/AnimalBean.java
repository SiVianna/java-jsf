/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnimalDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
        AnimalDao.getInstance().save(animal);
        return "/tratador/home?faces-redirect=true";
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
