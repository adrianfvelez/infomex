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
    
    private int nuevaCalificacion;
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
    
    public String calificar(int comentario) {
        System.out.println(".---------------------Calificacion: "+nuevaCalificacion+"--------------------------");
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        calificacion.setCorreo_com(i.getCorreo_com());
        calificacion.setCalificacion(nuevaCalificacion);
        calificacion.setId_comentario(comentario);
        u.save(calificacion);
        calificacion = null;
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario Calificado", ""));
        return "mapa.xhmtl?faces-redirect=true";
    }
    
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccionado", "Nueva Calificacion: " + ((Integer) rateEvent.getRating()).intValue());
        nuevaCalificacion = ((Integer) rateEvent.getRating()).intValue(); 
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Reset", "Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
