/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import unam.fciencias.infomex.modelo.Comentarista;
import unam.fciencias.infomex.modelo.UtilidadComentarista;
import unam.fciencias.infomex.modelo.Informador;
import unam.fciencias.infomex.modelo.UtilidadInformador;

import java.util.concurrent.TimeUnit;
/**
 *
 * @author avelez
 */
@ManagedBean
@RequestScoped
public class IniciaSesion {
    
    //private Comentarista comentarista = new Comentarista();
    private UtilidadComentarista u_comentarista = new UtilidadComentarista();
    //private Informador informador = new Informador();
    private UtilidadInformador u_informador = new UtilidadInformador();
    private String correo_a_buscar = new String();
    private String contrasenia_a_buscar = new String();
    
    public IniciaSesion() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }

    public UtilidadComentarista getU_comentarista() {
        return u_comentarista;
    }

    public void setU_comentarista(UtilidadComentarista u_comentarista) {
        this.u_comentarista = u_comentarista;
    }

    public UtilidadInformador getU_informador() {
        return u_informador;
    }

    public void setU_informador(UtilidadInformador u_informador) {
        this.u_informador = u_informador;
    }

    public String getCorreo_a_buscar() {
        return correo_a_buscar;
    }

    public void setCorreo_a_buscar(String correo_a_buscar) {
        this.correo_a_buscar = correo_a_buscar;
    }

    public String getContrasenia_a_buscar() {
        return contrasenia_a_buscar;
    }

    public void setContrasenia_a_buscar(String contrasenia_a_buscar) {
        this.contrasenia_a_buscar = contrasenia_a_buscar;
    }
    
    public String inicia() throws InterruptedException {
        Comentarista usuario_com = u_comentarista.buscaPorCorreo(correo_a_buscar);
        if(usuario_com != null){
            if(usuario_com.getContrasenia_com().equals(contrasenia_a_buscar)){
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("tipo_usuario", "comentarista");
                context.getExternalContext().getSessionMap().put("usuario", usuario_com);
                FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se inició sesión correctamente como comentarista", ""));
                TimeUnit.SECONDS.sleep(3);
                return "welcome";
            }
            else{
                FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Correo o contraseña incorrectos", ""));
                return "";
            }
        }
        Informador usuario_inf = u_informador.buscaPorCorreo(correo_a_buscar);
        if(usuario_inf != null){
            if(usuario_inf.getContrasenia_inf().equals(contrasenia_a_buscar)){
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("tipo_usuario", "informador");
                context.getExternalContext().getSessionMap().put("usuario", usuario_inf);
                FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se inició sesión correctamente como informador", ""));
                TimeUnit.SECONDS.sleep(3);
                return "welcome";
            }
            else{
                FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Correo o contraseña incorrectos", ""));
            }
        }
        return "";
    }
    
    public void prueba(){
        FacesContext context = FacesContext.getCurrentInstance();
        Informador i = (Informador)context.getExternalContext().getSessionMap().get("usuario");         
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Hola "+i.getUsuario_inf(), ""));
    }    
}
