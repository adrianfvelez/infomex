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
    
    /**
     * Método que obtiene un objeto de tipo Tema.
     * @return Un objeto tipo Tema 
     */
    public Tema getTema() {
        return tema;
    }
    
    /**
     * Método que asigna un objeto de tipo a Tema.
     * @param tema 
     */
    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    /**
     * Constructor que inicializa el objeton Tema y establece la locación en México.
     */
    public AgregarTema() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    /**
     * Método que crea la conexión con la base de datos.
     * @return Una cadena con la URL a donde se va a redirecionar
     */
    public String addTema() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Informador i = (unam.fciencias.infomex.modelo.Informador)context.getExternalContext().getSessionMap().get("usuario");
        tema.setCorreo_inf(i.getCorreo_inf());
        u.save(tema);
        tema = null;
         FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, el registro se ha realizado correctamente", "")); 
        return null;
    }
    
}
