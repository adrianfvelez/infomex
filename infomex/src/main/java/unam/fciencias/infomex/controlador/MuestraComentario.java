/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import unam.fciencias.infomex.modelo.Comentario;
import unam.fciencias.infomex.modelo.UtilidadComentario;

/**
 *
 * @author valde
 */
@ManagedBean(name = "despliega")
@ViewScoped
public class MuestraComentario {
    
    private List<unam.fciencias.infomex.modelo.Comentario> comments;
    private UtilidadComentario u = new UtilidadComentario();
    
    @PostConstruct
    public void init() {
        comments = u.getComentarios();
    }

    public List<Comentario> getComments() {
        return comments;
    }

    public void setComments(List<Comentario> comments) {
        this.comments = comments;
    }
}
