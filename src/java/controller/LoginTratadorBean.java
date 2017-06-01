/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TratadorDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Tratador;

/**
 *
 * @author tiago
 */
@ManagedBean(name = "loginTratador")
@SessionScoped
public class LoginTratadorBean {

    private Tratador tratador;

    public LoginTratadorBean() {
        this.tratador = new Tratador();
    }

    public String login() {
        this.tratador = TratadorDao.getInstance().Verificalogin(tratador.getMatricula(), tratador.getSenha());
        if (tratador == null) {
            this.tratador = new Tratador();
            FacesContext.getCurrentInstance().addMessage("Aviso", new FacesMessage("Login ou Senha Incorreta!!!"));
            return "login";
        }
        return "homeLogado";
    }

    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
        return "home";
    }

    public Tratador getTratador() {
        return tratador;
    }

    public void setTratador(Tratador tratador) {
        this.tratador = tratador;
    }

}
