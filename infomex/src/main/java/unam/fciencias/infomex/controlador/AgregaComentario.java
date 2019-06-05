/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.map.Marker;

import unam.fciencias.infomex.modelo.Comentario;
import unam.fciencias.infomex.modelo.UtilidadComentario;

/**
 *
 * @author a-valderrama
 */
@ManagedBean
@RequestScoped
public class AgregaComentario implements Serializable {
    
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
    
    public String addComentario(String idMar, int idTema) {
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        comment.setCorreo_com(i.getCorreo_com());
        int idMark = Integer.parseInt(idMar);
        comment.setId_mar(idMark);
        comment.setId_tema(idTema);
        u.save(comment);
        comment = null;
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario agregado", ""));
        return "mapa.xhmtl?faces-redirect=true";
    }
    
}
