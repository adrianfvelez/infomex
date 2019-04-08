/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unam.fciencias.infomex.modelo.Informador;
import unam.fciencias.infomex.modelo.UtilidadInformador;

/**
 *
 * @author avelez
 */
@ManagedBean
@RequestScoped
public class RegistrarInformador {
    private Informador user = new Informador();
    private UtilidadInformador u = new UtilidadInformador();
    
    public Informador getUser() {
        return user;
    }

    public void setUser(Informador user) {
        this.user = user;
    }
    
    public RegistrarInformador() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String addInformador() {
        u.save(user);
        user = new Informador();
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se ha registrado al informador correctamente", ""));
        return null;
    }
    
}
