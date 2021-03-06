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
    
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public EliminarTema() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String borrarTema() {
        FacesContext context = FacesContext.getCurrentInstance();
        String tipo = (String) context.getExternalContext().getSessionMap().get("tipo_usuario");
        unam.fciencias.infomex.modelo.Informador informador = (unam.fciencias.infomex.modelo.Informador) context.getExternalContext().getSessionMap().get("usuario");
        Tema theme = u.buscaTemaPorNombre(tema);
        if(theme == null){
            context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "El tema no existe.", ""));
            return null;
        }
        if(tipo.equals("informador")){
            if(!informador.getCorreo_inf().equals(theme.getCorreo_inf())){
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Ese tema no te pertence.", ""));
                return null;
            }
        }
        
        //tema.setId_tema(u.getId());
        u.eliminaTema(tema);
        tema = new Tema();
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, se ha eliminado correctamente", ""));
        
        return null;
    }
}
