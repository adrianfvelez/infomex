/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

/**
 *
 * @author oscar
 */

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import unam.fciencias.infomex.modelo.Comentarista;
import unam.fciencias.infomex.modelo.UtilidadComentarista;


@ManagedBean
@RequestScoped
public class EditarCuenta {
    
    private Comentarista comentarista = new Comentarista();
    private UtilidadComentarista u = new UtilidadComentarista();
    private String conf_password = "";
    private String actual_contrasenia = "";

    public String getConf_password() {
        return conf_password;
    }

    public void setConf_password(String conf_password) {
        this.conf_password = conf_password;
    }
 
    public String getActual_contrasenia() {
        return actual_contrasenia;
    }

    public void setActual_contrasenia(String actual_contrasenia) {
        this.actual_contrasenia = actual_contrasenia;
    }
    
    public Comentarista getComentarista() {
        return comentarista;
    }

    public void setComentarista(Comentarista comentarista) {
        this.comentarista = comentarista;
    }

    public UtilidadComentarista getU() {
        return u;
    }

    public void setU(UtilidadComentarista u) {
        this.u = u;
    }
    
    public String editarDatos(){
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i1 = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
           if(!comentarista.getContrasenia_com().equals(i1.getContrasenia_com())){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "La contraseña actual no es correcta", ""));
             return "";
        }
               
        if(!conf_password.equals(comentarista.getContrasenia_com())){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Las contraseñas no conciden", ""));
             return "";
        }
        u.update(comentarista);
        return "";
    }
    
    private String cifraPassword(String ps){
        return new StringBuffer(ps).reverse().toString();
}
    
    
}
