/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VeterinarioDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Veterinario;

/**
 *
 * @author Guitar Jr
 */
@ManagedBean(name = "loginVeterinario")
@SessionScoped
public class LoginVeterinarioBean {

   private Veterinario veterinario;

   public LoginVeterinarioBean() {
        this.veterinario = new Veterinario();
    }
    
     public String login() {
        this.veterinario = VeterinarioDao.getInstance().Verificalogin(veterinario.getMatricula(), veterinario.getSenha());
        if (veterinario == null) {
            this.veterinario = new Veterinario();
            FacesContext.getCurrentInstance().addMessage("Aviso", new FacesMessage("Login ou Senha Incorreta!!!"));
            return "loginVeterinario?faces-redirect=true";
        }
        return "veterinario_consultas?faces-redirect=true";
    }

    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
        return "home?faces-redirect=true";
    }

    
    
    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
       
}
