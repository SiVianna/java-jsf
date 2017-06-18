/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AgendaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AgendaConsulta;
import model.Animal;
import model.Veterinario;

/**
 *
 * @author tiago
 */
@ManagedBean
@ViewScoped
public class ConsultaBean {

    private Status status;
    private Animal animal;
    private AgendaConsulta agendaConsulta;
    private List<AgendaConsulta> lstAgenda;
    private Veterinario veterinario;
    
    public ConsultaBean() {
        LoginVeterinarioBean lb = (LoginVeterinarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginVeterinario");
        this.veterinario = lb.getVeterinario();
        this.lstAgenda = AgendaDao.getInstance().findByVeterinario(veterinario.getId());
        this.animal = new Animal();
        this.agendaConsulta = new AgendaConsulta();
        this.status = Status.Default;
    }

     public void consultar(AgendaConsulta agendaConsulta ) {
     this.agendaConsulta = agendaConsulta;
     this.status = Status.Consultar;
     
    }
    
    public List<AgendaConsulta> getLstAgenda() {
        return lstAgenda;
    }

    public void setLstAgenda(List<AgendaConsulta> lstAgenda) {
        this.lstAgenda = lstAgenda;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public AgendaConsulta getAgendaConsulta() {
        return agendaConsulta;
    }

    public void setAgendaConsulta(AgendaConsulta agendaConsulta) {
        this.agendaConsulta = agendaConsulta;
    }
    
    

    
    
}
