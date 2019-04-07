/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

/**
 *
 * @author oscar
 */

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unam.fciencias.infomex.modelo.Tema;
import unam.fciencias.infomex.modelo.UtilidadTema;

@ManagedBean
@RequestScoped
public class AgregarTema {
    
    private Tema tema = new Tema();
    private UtilidadTema u = new UtilidadTema();
    
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public AgregarTema() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
     public String addTema() {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, el registro se ha realizado correctamente", ""));
        //tema.setId_tema(u.getId());
        u.save(tema);
        tema = null;
        
        return null;
    }
    
}
