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
 * @author a-valderrama
 */
@ManagedBean
@RequestScoped
public class AgregaComentario {
    
    private Comentario comment = new Comentario();
    private UtilidadComentario u = new UtilidadComentario();
    
    public Comentario getComment() {
        return comment;
    }

    public void setComment(Comentario comment) {
        this.comment = comment;
    }

    public AgregaComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String addComentario() {
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        comment.setCorreo_com(i.getCorreo_com());
        comment.setId_mar(1);
        comment.setId_tema(1);
        u.save(comment);
        comment = null;
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario agregado", ""));
        return null;
    }
    
}
