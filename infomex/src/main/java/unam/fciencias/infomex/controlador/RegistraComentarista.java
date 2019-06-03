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
import unam.fciencias.infomex.modelo.UtilidadInformador;

/**
 *
 * @author avelez
 */
@ManagedBean
@RequestScoped
public class RegistraComentarista {
    
    private Comentarista user = new Comentarista();
    private UtilidadComentarista u = new UtilidadComentarista();
    private String conf_password = "";
    private UtilidadInformador uti_inf = new UtilidadInformador();

    public String getConf_password() {
        return conf_password;
    }

    public void setConf_password(String conf_password) {
        this.conf_password = conf_password;
    }
    
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
        if(!conf_password.equals(user.getContrasenia_com())){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Las contraseñas no coinciden", ""));
            return "";
        }
        user.setContrasenia_com(cifraPassword(conf_password));
        if(u.buscaPorCorreo(user.getCorreo_com()) != null
                || uti_inf.buscaPorCorreo(user.getCorreo_com()) != null){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Ya hay una cuenta asociada a ese correo, ingrese otro por favor", ""));
            return "";
        }
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
        return "inicioSesion.xhmtl?faces-redirect=true";
    }
    
    private String cifraPassword(String ps){
        return new StringBuffer(ps).reverse().toString();
    }
}
