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
import unam.fciencias.infomex.modelo.UtilidadComentarista;

/**
 *
 * @author avelez
 */
@ManagedBean
@RequestScoped
public class EliminarCuenta {
    
    private UtilidadComentarista u = new UtilidadComentarista();
    
    public EliminarCuenta() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String eliminaCuenta(){
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        u.delete(i);
        context.getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se ha eliminado tu cuenta :)", ""));
        return "mapa.xhmtl?faces-redirect=true";
    }    
}
