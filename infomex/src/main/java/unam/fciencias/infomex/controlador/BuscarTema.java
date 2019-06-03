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
    private ArrayList<Tema> te;

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
    
    public String mostrarTemas(String tema){
        te = u.MostrarTemas(tema);
        return "resultado?faces-redirect=true";
    }
    
    public List<Tema> obtenerTema(){
        return u.getTodosTemas();
    }

    public ArrayList<Tema> getTe() {
        return te;
    }

    public void setTe(ArrayList<Tema> te) {
        this.te = te;
    }
}
