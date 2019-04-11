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
 * 
 * Clase necesaria para eliminar los comentarios desde la
 * vista (.xhtml).
 * A su vez esta clase llama a los métodos pertinentes del "modelo"
 * que están en la clase de UtilidadComentario.java
 * 
 * El comentario y sus características están definidas en la clase 
 * Comentario.java del "controlado
 */
@ManagedBean
@RequestScoped
public class EliminaComentario {
    
    private int id;
    private UtilidadComentario u = new UtilidadComentario();
    
    /**
     * Getter del id del comentario que queremos eliminar
     * @return id id del comentario que queremos eliminar
     */
    public int getComment() {
        return id;
    }
    /**
     * Setter del id del comentario que queremos eliminar
     * @param id id del comentario que queremos eliminar
     */
    public void setComment(int id) {
        this.id = id;
    }
    
    /**
     * Constructor de la clase
     */
    public EliminaComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    /**
     * Método que se encarga de llamar al método que elimina al 
     * comentario de la base de datos.
     * 
     * En esta versión del sistema el usuario ingresa el id del
     * comentario en cuestión a través de la vista (.xhtml).
     * 
     * En caso de que necesitemos que la vista (.xhtml) realice
     * una acción después de esta, regresamos la cadena que describe 
     * esta acción
     * 
     * @return null no necesitamos que regrese ninguna acción en 
     *              particular
     */
    public String removeComentario() {
        u.deleteOnId(id);
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario eliminado", ""));
        return null;
    }
}
