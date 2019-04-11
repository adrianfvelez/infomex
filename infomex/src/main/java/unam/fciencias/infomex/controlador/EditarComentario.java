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
 * Clase necesaria para editar los comentarios desde la
 * vista (.xhtml).
 * A su vez esta clase llama a los métodos pertinentes del "modelo"
 * que están en la clase de UtilidadComentario.java
 * 
 * Las nuevas características del comentario están definidas en el
 * .xthml, que son las que el usuario ingresa en el sistema.
 */
@ManagedBean
@RequestScoped
public class EditarComentario {
    
    private int id;
    private String nuevaDescripcion;
    private int nuevaCalificacion;
    private UtilidadComentario u = new UtilidadComentario();

    /**
     * Getter del id del comentario que se desea modificar
     * @return id identificador del comentario
     */
    public int getId() {
        return id;
    }
    /**
     * Setter del id del comentario que se desea modificar
     * @param id identificador del comentario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de la nueva descripcion del comentario
     * @return nuevaDescripcion la nueva descripcion del 
     *         comentario
     */
    public String getNuevaDescripcion() {
        return nuevaDescripcion;
    }
    /**
     * Setter de la nueva descripción del comentario
     * @param nuevaDescripcion la nueva descripción del 
     *        comentario
     */
    public void setNuevaDescripcion(String nuevaDescripcion) {
        this.nuevaDescripcion = nuevaDescripcion;
    }

    /**
     * Getter de la nueva calificación del comentario
     * @return nuevaCalificacion la nueva calificación del 
     *        comentario
     */
    public int getNuevaCalificacion() {
        return nuevaCalificacion;
    }
    /**
     * Setter de la nueva calificación del comentario
     * @param nuevaCalificacion la nueva calificación del 
     *        comentario
     */
    public void setNuevaCalificacion(int nuevaCalificacion) {
        this.nuevaCalificacion = nuevaCalificacion;
    }
    
    /**
     * Constructor de la clase
     */
    public EditarComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    /**
     * Método que se encarga de llamar a los métodos que acceden a la
     * base de datos para modificar los atributos.
     * Los atributos editables por el usuario. Estos son: la 
     * descripción y la calififación.
     * 
     * Estos atributos son modificados por el usuario, a trabés del 
     * .xhtml
     * 
     * En caso de que necesitemos que la vista (.xhtml) realice
     * una acción después de esta, regresamos la cadena que describe 
     * esta acción
     * 
     * @return null no necesitamos que regrese ninguna acción en 
     *              particular
     */
    public String editComentario() {
        u.setDescripcion(id, nuevaDescripcion);
        u.setCalificacion(id, nuevaCalificacion);
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comentario editado", ""));
        return null;
    }
}
