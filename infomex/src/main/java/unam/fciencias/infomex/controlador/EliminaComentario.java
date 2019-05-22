/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unam.fciencias.infomex.modelo.Comentario;
import unam.fciencias.infomex.modelo.UtilidadComentario;

/**
 *
 * @author valde
 */
@ManagedBean
@RequestScoped
public class EliminaComentario {
    
    private int id;
    private UtilidadComentario u = new UtilidadComentario();
    
    public int getComment() {
        return id;
    }

    public void setComment(int id) {
        this.id = id;
    }
    
    public EliminaComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String removeComentario() {
        u.deleteOnId(id);
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario eliminado", ""));
        return null;
    }
    
    public List<Comentario> getComentarios() {
        List<Comentario> comments = u.getTodosComentarios();
        return comments;
    }
}
