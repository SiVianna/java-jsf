/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnimalDao;
import dao.TratadorDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Animal;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author tiago
 */
@ManagedBean
@RequestScoped
public class AnimalBean {

    private Animal animal;
    private UploadedFile file;

    public AnimalBean() {
        this.animal = new Animal();
    }

    public String store(){
        
        LoginTratadorBean lb = (LoginTratadorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginTratador");
        animal.getTratadorList().add(lb.getTratador());
        AnimalDao.getInstance().save(animal);
        lb.getTratador().getAnimalList().add(animal);
        TratadorDao.getInstance().update(lb.getTratador());
        return "home?faces-redirect=true";
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}
