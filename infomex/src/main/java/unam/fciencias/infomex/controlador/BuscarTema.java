/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unam.fciencias.infomex.modelo.Tema;
import unam.fciencias.infomex.modelo.UtilidadTema;
/**
 *
 * @author oscar
 */

@ManagedBean(name = "buscaTema")
@ApplicationScoped
public class BuscarTema {
    
    private Tema tema = new Tema();
    private UtilidadTema u = new UtilidadTema();

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public BuscarTema() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String buscarTema() {
        
        u.buscaTemaPorNombre(tema);
        tema = new Tema();
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, se ha encontrado correctamente", ""));
        
        return null;
    }
}
