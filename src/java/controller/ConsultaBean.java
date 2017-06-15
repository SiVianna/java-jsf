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
import model.Veterinario;

/**
 *
 * @author tiago
 */
@ManagedBean
@ViewScoped
public class ConsultaBean {

    /**
     * Creates a new instance of ConsultaBean
     */
    private List<AgendaConsulta> lstAgenda;
    private Veterinario veterinario;
    public ConsultaBean() {
        LoginVeterinarioBean lb = (LoginVeterinarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginVeterinario");
        this.veterinario = lb.getVeterinario();
        this.lstAgenda = AgendaDao.getInstance().findByVeterinario(veterinario.getId());
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

    
    
}
