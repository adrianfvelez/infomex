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
import javax.faces.context.FacesContext;
import unam.fciencias.infomex.modelo.Informador;

/**
 *
 * @author avelez
 */

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable{
    private static final long serialVersionUID = 1L;

	private String name;
        
        public HelloBean(){
            FacesContext context = FacesContext.getCurrentInstance();
            Informador i = (Informador)context.getExternalContext().getSessionMap().get("usuario");         
            name = i.getUsuario_inf();
        }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
