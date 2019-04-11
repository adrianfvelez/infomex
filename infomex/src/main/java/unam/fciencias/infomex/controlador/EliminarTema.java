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
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unam.fciencias.infomex.modelo.Tema;
import unam.fciencias.infomex.modelo.UtilidadTema;

@ManagedBean(name="eliminarTema")
@ApplicationScoped
@RequestScoped

public class EliminarTema {
    
    private Tema tema = new Tema();
    private UtilidadTema u = new UtilidadTema();
    
    /**
     * Método que obtiene el Tema.
     * @return Tema
     */
    public Tema getTema() {
        return tema;
    }
    
    /**
     * Método que obtiene el Tema.
     * @param tema 
     */
    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    /**
     * Constructor que inicializa el objeton Tema y establece la locación en México.
     */
    public EliminarTema() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    /**
     * Método que obtiene busca el Tema en la base de datos.
     * @return Objeto tipo Tema
     */
    public String borrarTema() {
        
        u.eliminaTema(tema);
        tema = new Tema();
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, se ha eliminado correctamente", ""));
        
        return null;
    }
}
