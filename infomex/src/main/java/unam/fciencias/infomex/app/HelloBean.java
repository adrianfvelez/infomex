/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author avelez
 */

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value="#{name}")
    private String name;
    
    @ManagedProperty(value="#{tipo}")
    private String tipo;

    public HelloBean(){
        name = "PRUEBA";
        tipo = "COMEN";
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
