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
public class EliminarInformador {
    
    private Informador inf = new Informador();
    private UtilidadInformador u = new UtilidadInformador();

    public Informador getInf() {
        return inf;
    }

    public void setInf(Informador inf) {
        this.inf = inf;
    }
        
    public EliminarInformador() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String eliminarInformador(){
        if(u.buscaPorCorreo(inf.getCorreo_inf()) == null){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "No hay ninguna cuenta asociada a ese correo.", ""));
            return "";
        }
        u.delete(inf);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se ha eliminado correctamente al informador :)", ""));
        return "";
    }
}
