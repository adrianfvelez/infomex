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
import org.primefaces.model.map.Marker;

import unam.fciencias.infomex.modelo.Comentario;
import unam.fciencias.infomex.modelo.UtilidadComentario;

/**
 *
 * @author valde
 */
@ManagedBean
@RequestScoped
public class EditarComentario {
    
    private String nuevaDescripcion;
    private int nuevaCalificacion;
    private UtilidadComentario u = new UtilidadComentario();

    public String getNuevaDescripcion() {
        return nuevaDescripcion;
    }

    public void setNuevaDescripcion(String nuevaDescripcion) {
        this.nuevaDescripcion = nuevaDescripcion;
    }

    public int getNuevaCalificacion() {
        return nuevaCalificacion;
    }

    public void setNuevaCalificacion(int nuevaCalificacion) {
        this.nuevaCalificacion = nuevaCalificacion;
    }
    
    public EditarComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String editComentario() {
        int id = getIdComentario();
        u.setDescripcion(id, nuevaDescripcion);
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario editado", ""));
        return "mapa.xhmtl?faces-redirect=true";
    }
    
    public void saveIdComentario(int idComment){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("id_comentario",idComment);
    }
    
    public int getIdComentario(){
        FacesContext context = FacesContext.getCurrentInstance();
        int i = (int) context.getExternalContext().getSessionMap().get("id_comentario");
        return i;
    }
}
