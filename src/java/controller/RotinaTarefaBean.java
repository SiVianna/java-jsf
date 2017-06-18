/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.AnimalDao;
import dao.RotinaDao;
import dao.TarefaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Animal;
import model.Rotina;
import model.Tarefas;

/**
 *
 * @author tiago
 */
@ManagedBean
@ViewScoped
public class RotinaTarefaBean {

    private Rotina rotina;
    private Tarefas tarefa;
    private Animal animal;
    private int codAnimal;
    private List<Animal> lstAnimais;
    private Status status;

    public RotinaTarefaBean() {
        LoginTratadorBean lb = (LoginTratadorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginTratador");
        lstAnimais = lb.getTratador().getAnimalList();
        this.rotina = new Rotina();
        this.tarefa = new Tarefas();
        status = Status.Default;
    }

    public void addRotina(Animal animal) {
        this.status = Status.AddRotina;
        this.animal = animal;
    }

    public void addTarefa(Animal animal) {
        this.status = Status.AddTarefa;
        this.animal = animal;
        this.tarefa = new Tarefas();
    }
    
    public void showRotina(Animal animal){
        this.status = Status.ShowRotina;
        this.animal = animal;
    }
    
    public void back(){
        this.status = Status.Default;
    }

    public void storeRotina() {
        RotinaDao.getInstance().save(rotina);
        this.animal.setRotinaCodigo(rotina);
        AnimalDao.getInstance().update(animal);
        this.status = Status.Default;
    }
    
   
    public void storeTarefas() {
        tarefa.setRotinaCodigo(animal.getRotinaCodigo());
        animal.getRotinaCodigo().getTarefasList().add(tarefa);
        TarefaDao.getInstance().save(tarefa);
        this.status = Status.Default;
    }

    public Rotina getRotina() {
        return rotina;
    }

    public void setRotina(Rotina rotina) {
        this.rotina = rotina;
    }

    public Tarefas getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefas tarefa) {
        this.tarefa = tarefa;
    }

    public List<Animal> getLstAnimais() {
        return lstAnimais;
    }

    public void setLstAnimais(List<Animal> lstAnimais) {
        this.lstAnimais = lstAnimais;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
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

}
