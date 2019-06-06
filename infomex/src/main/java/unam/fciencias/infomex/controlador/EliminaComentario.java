/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.ArrayList;
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
    
    private UtilidadComentario u = new UtilidadComentario();
    
    public EliminaComentario() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String removeComentario(int id) {
        System.out.println("\n--------------------ID: "+id+"----------------\n");
        u.deleteOnId(id);
        return null;
    }
    
    public List<Comentario> obtenerComentario(){
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Comentarista i = (unam.fciencias.infomex.modelo.Comentarista)context.getExternalContext().getSessionMap().get("usuario");
        List<Comentario> comentarios = new ArrayList<Comentario>();
        /* Para pasar el idMar usar el metodo de administrador marcador nose() */
        for(Comentario c : u.getTodosComentarios()){
            if(c.getCorreo_com().equals(i.getCorreo_com())){
                comentarios.add(c);
            }
        }
        return comentarios;
        
    }
}
