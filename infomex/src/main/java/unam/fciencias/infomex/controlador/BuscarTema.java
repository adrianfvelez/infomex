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
     * Constructor que inicializa el objeto Tema y establece la locación en México.
     */
    public BuscarTema() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    /**
     * Método que obtiene la busqueda del Tema en la base de datos.
     * @return Objeto tipo Tema
     */
    public Tema buscarTema() {
        
        Tema t = u.buscaTemaPorNombre(tema);
        
        if(t == null){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "No se ha encontrado el tema", ""));
        }else{
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, se ha encontrado correctamente", ""));
        }
        
        tema = new Tema();
        return null;
    }
}
