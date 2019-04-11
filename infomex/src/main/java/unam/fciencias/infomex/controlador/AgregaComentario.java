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
 * 
 * Clase necesaria para agregar los comentarios desde la
 * vista (.xhtml).
 * A su vez esta clase llama a los métodos pertinentes del "modelo"
 * que están en la clase de UtilidadComentario.java
 * 
 * El comentario y sus características están definidas en la clase 
 * Comentario.java del "controlador".
 */
@ManagedBean
@RequestScoped
public class AgregaComentario {
    
    private Comentario comment = new Comentario();
    private UtilidadComentario u = new UtilidadComentario();
    
    /**
     * Getter del comentario que queremos modificar
     * @return comment comentario a modificiar
     */
    public Comentario getComment() {
        return comment;
    }

    /**
     * Setter del comentario que queremos modificar
     * @param comment comentrio 
     */
    public void setComment(Comentario comment) {
        this.comment = comment;
    }

    /**
     * Constructor de la calse
     */
    public AgregaComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    /**
     * Método que se encarga de llamar al método que guarda en la 
     * base de datos con los parámetros correspondientes, los 
     * atributos del nuevo comentario.
     * Estos atributos fueron modificados por el usuario, lo cuales
     * se ven registran en el .xhtml
     * 
     * En caso de que necesitemos que la vista (.xhtml) realice
     * una acción después de esta, regresamos la cadena que describe 
     * esta acción
     * 
     * @return null no necesitamos que regrese ninguna acción en 
     *              particular
     */
    public String addComentario() {
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        comment.setCorreo_com(i.getCorreo_com());
        /*Establecemos la FK como default (1) para resolver el problema
          en la primera iteración*/
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
