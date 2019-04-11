/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import unam.fciencias.infomex.modelo.Comentario;
import unam.fciencias.infomex.modelo.UtilidadComentario;

/**
 *
 * @author a-valderrama
 * 
 * Idea de clase para la vista de la gratión de comentarios
 * para la segunda iteración
 */
@ManagedBean
public class SelectOneMenuView {
    
    /*private String option;  
    private List<Comentario> options;
    
    private UtilidadComentario u = new UtilidadComentario();
    
    @PostConstruct
    public void init() {
        options = u.getTodosComentarios();
    }
    
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
    public List<Comentario> getOptions() {
        return options;
    }
 
    public void setOptions(List<Comentario> options) {
        this.options = options;
    }*/
    
    private int text;
 
    public int getIdComment() {
        return text;
    }
    public void setIdComment(int text) {
        this.text = text;
    }
}