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
import unam.fciencias.infomex.modelo.Comentarista;
import unam.fciencias.infomex.modelo.UtilidadComentarista;

/**
 *
 * @author avelez
 */
@ManagedBean
@RequestScoped
public class EliminarComentarista {
    
    private Comentarista com = new Comentarista();
    private UtilidadComentarista u = new UtilidadComentarista();

    public Comentarista getCom() {
        return com;
    }

    public void setCom(Comentarista com) {
        this.com = com;
    }
        
    public EliminarComentarista() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String eliminarComentarista() {
        if(u.buscaPorCorreo(com.getCorreo_com()) == null){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "No hay ninguna cuenta asociada a ese correo.", ""));
            return "";
        }
        u.delete(com);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se ha eliminado correctamente al comentarista :)", ""));
        return "";
    }
}
