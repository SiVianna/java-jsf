/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnimalDao;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Animal;
import model.Boletim;
import model.Tratador;

/**
 *
 * @author tiago
 */
@ManagedBean
@ViewScoped
public class BoletimDiarioBean {

    private Boletim boletimDiario;
    private List<Animal> lstAnimal;
    private Animal animal;
    private Status status;
    private Tratador tratador;

    public BoletimDiarioBean() {
        LoginTratadorBean lb = (LoginTratadorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginTratador");
        this.lstAnimal = lb.getTratador().getAnimalList();
        this.tratador = lb.getTratador();
        this.boletimDiario = new Boletim();
        this.animal = new Animal();
        this.status = Status.Default;
    }

    public void store() {
        boletimDiario.setAnimalCodigo(animal);
        boletimDiario.setData(new Date());
        boletimDiario.setTratadorId(tratador);
        animal.getBoletimList().add(boletimDiario);
        AnimalDao.getInstance().update(animal);
        this.boletimDiario = new Boletim();
        this.status = Status.Default;
    }

    public void addBoletimAnimal(Animal animal) {
        this.animal = animal;
        this.status = Status.Boletim;
    }
    
    public void showBoletinsAnimal(Animal animal){
        this.animal = AnimalDao.getInstance().findById(animal.getCodigo());
        this.status = Status.ShowBoletins;
    }
    
    public void back(){
        this.status = Status.Default;
    }
    
    public Boletim getBoletimDiario() {
        return boletimDiario;
    }

    public void setBoletimDiario(Boletim boletimDiario) {
        this.boletimDiario = boletimDiario;
    }

    public List<Animal> getLstAnimal() {
        return lstAnimal;
    }

    public void setLstAnimal(List<Animal> lstAnimal) {
        this.lstAnimal = lstAnimal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tratador getTratador() {
        return tratador;
    }

    public void setTratador(Tratador tratador) {
        this.tratador = tratador;
    }

}
