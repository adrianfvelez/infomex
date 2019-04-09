/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unam.fciencias.infomex.modelo.Comentarista;
import unam.fciencias.infomex.modelo.UtilidadComentarista;

/**
 *
 * @author avelez
 */
@ManagedBean
@RequestScoped
public class RegistraComentarista {
    
    private Comentarista user = new Comentarista();
    private UtilidadComentarista u = new UtilidadComentarista();
    
    public Comentarista getUser() {
        return user;
    }

    public void setUser(Comentarista user) {
        this.user = user;
    }

    public RegistraComentarista() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String addUser(){
        u.save(user);
        user = null;
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, el registro se ha realizado correctamente", ""));
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            System.out.println("Error");
        }
        return "inicioSesion";
    }
    
}
