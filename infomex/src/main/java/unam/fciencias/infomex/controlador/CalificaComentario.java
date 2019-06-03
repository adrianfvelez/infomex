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
import org.primefaces.event.RateEvent;

import unam.fciencias.infomex.modelo.Calificacion;
import unam.fciencias.infomex.modelo.UtilidadCalificacion;

/**
 *
 * @author valde
 */
@ManagedBean
@RequestScoped
public class CalificaComentario {
    
    private int nuevaCalificacion = 4;
    private Calificacion calificacion = new Calificacion();
    private UtilidadCalificacion u = new UtilidadCalificacion();

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    
    public int getNuevaCalificacion() {
        return nuevaCalificacion;
    }

    public void setNuevaCalificacion(int nuevaCalificacion) {
        this.nuevaCalificacion = nuevaCalificacion;
    }
    
    public CalificaComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String setCalificacion() {
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        calificacion.setCorreo_com(i.getCorreo_com());
        calificacion.setCalificacion(nuevaCalificacion);
        u.save(calificacion);
        calificacion = null;
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario Calificado", ""));
        return null;
    }
    
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificado", "Nueva Calificacion" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        nuevaCalificacion = ((Integer) rateEvent.getRating()).intValue(); 
    }
    
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Reset", "Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
