/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnimalDao;
import dao.VeterinarioDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AgendaConsulta;
import model.Animal;
import model.Veterinario;

/**
 *
 * @author Guitar Jr
 */
@ManagedBean
@ViewScoped
public class agendaBean {
    
    private AgendaConsulta agendaConsulta;
    private List<Animal> lstAnimal;
    private List<Veterinario> lstVeterinario;
    private Animal animal;
    private Veterinario veterinario;
    private Status status;

   
    

    
    /**
     * Creates a new instance of agendaBean
     */
    public agendaBean() {
      LoginTratadorBean lb = (LoginTratadorBean) 
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginTratador");
      this.agendaConsulta = new AgendaConsulta();
      this.lstAnimal = lb.getTratador().getAnimalList();
      this.animal = new Animal();
      this.veterinario = new Veterinario();
      this.lstVeterinario = lstVeterinario;
      this.status = Status.Default;
    }
    
   public void listaAnimal(Animal animal){
     this.animal = AnimalDao.getInstance().findById(animal.getCodigo());
     this.status = Status.ShowAgendaConsulta;
    }
   
   public void listaVeterinario(Veterinario veterinario){
     this.veterinario = VeterinarioDao.getInstance().findById(veterinario.getId());
     this.status = Status.ShowAgendaConsulta;
    }
   
   public void addAgendaConsulta(Animal animal) {
      this.animal = animal;
      this.status = Status.agendar;
    }
   public void back(){
        this.status = Status.Default;
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

    public AgendaConsulta getAgendaConsulta() {
        return agendaConsulta;
    }

    public void setAgendaConsulta(AgendaConsulta agendaConsulta) {
        this.agendaConsulta = agendaConsulta;
    }
    
   public List<Veterinario> getLstVeterinario() {
        return lstVeterinario;
    }

    public void setLstVeterinario(List<Veterinario> lstVeterinario) {
        this.lstVeterinario = lstVeterinario;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
    
    
    
    
}
