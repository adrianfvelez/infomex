/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author valde
 */
@ManagedBean(eager = true)
@SessionScoped
public class GetId implements Serializable{
    
   public String data = "";

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public void showResult() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      data =  params.get("idComentario"); 
   }
    
}
