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

import unam.fciencias.infomex.modelo.Comentario;
import unam.fciencias.infomex.modelo.UtilidadComentario;

/**
 *
 * @author valde
 */
@ManagedBean
@RequestScoped
public class EliminaComentario {
    
    private int comment;
    private UtilidadComentario u = new UtilidadComentario();
    
    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
    
    public EliminaComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String removeComentario() {
        u.deleteOnId(comment);
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario eliminado", ""));
        return null;
    }
}
