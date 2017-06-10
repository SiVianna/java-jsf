/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RotinaDao;
import dao.TarefaDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    public RotinaTarefaBean() {
        this.rotina = new Rotina();
        this.tarefa = new Tarefas();
    }
    
    public void storeRotina(){
        //LoginTratadorBean lb = (LoginTratadorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginTratador");
        RotinaDao.getInstance().save(rotina);
    }
    
    public void storeTarefas(){
        TarefaDao.getInstance().save(tarefa);
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
    
    
    
}
