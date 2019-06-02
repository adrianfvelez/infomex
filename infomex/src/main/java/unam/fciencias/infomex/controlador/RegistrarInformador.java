/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import unam.fciencias.infomex.modelo.Informador;
import unam.fciencias.infomex.modelo.UtilidadInformador;
import unam.fciencias.infomex.modelo.UtilidadComentarista;

/**
 *
 * @author avelez
 */
@ManagedBean
@RequestScoped
public class RegistrarInformador {
    private Informador user = new Informador();
    private UtilidadInformador u = new UtilidadInformador();
    private UtilidadComentarista uti_com = new UtilidadComentarista();
    
    private static final String MENSAJE = "Hola <b>{0}</b><br/>\nAhora eres informador para infomex. <br/>"
            + "Tu contraseña es: {2}<br/>\n"
            + "\n\n¡Bienvenido!<br/>\n\n"
            + "Atentamente: El equipo de infomex &#169;";
    
    private static final String ASUNTO = "Registro de informador exitoso en infomex";
    
    public Informador getUser() {
        return user;
    }

    public void setUser(Informador user) {
        this.user = user;
    }
    
    public RegistrarInformador() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public String addInformador() {
        if(u.buscaPorCorreo(user.getCorreo_inf()) != null
                || uti_com.buscaPorCorreo(user.getCorreo_inf()) != null){
            FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Correo ya registrado, ingrese otro por favor", ""));
            return "";
        }
        String pass = generaPassword();
        String pass_cifrada = cifraPassword(pass);
        user.setContrasenia_inf(pass_cifrada);
        u.save(user);
        enviaMensaje(pass);
        user = new Informador();
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Se ha registrado al informador correctamente", ""));
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            System.out.println("Error");
        }
        return "inicioSesion.xhmtl?faces-redirect=true";
    }
    
    private String cifraPassword(String ps){
        return new StringBuffer(ps).reverse().toString();
    }
    
    private String generaPassword(){
        int tipo, ran = 0;
        String pass = "";
        for(int i = 0; i < 10; i++){
            tipo = (int)(Math.random()*3) + 1;
            switch(tipo){
                case 1:{
                    ran = (int)Math.floor(Math.random()*(90-65)+65);
                    pass += (char)ran;
                    break;
                }
                case 2:{
                    ran = (int)Math.floor(Math.random()*(122-97)+97);
                    pass += (char)ran;
                    break;
                }
                case 3:{
                    ran = (int)Math.floor(Math.random()*(48-57)+57);
                    pass += (char)ran;
                    break;
                }  
            }
        }
        return pass;
    }
    
    private void enviaMensaje(String contrasenia){
        try{
            MessageFormat format = new MessageFormat(MENSAJE);
            final Object[] array = {user.getUsuario_inf(),host(),contrasenia};
            String mensaje = format.format(array);
            EmailSender.sendEmail(user.getCorreo_inf(), ASUNTO, mensaje);
        }catch(MessagingException ex){
            System.out.println("ERROR EN EL CORRRRRREEEEEO");
        }
    }
    
    private String host(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if(ipAddress == null)
            ipAddress = request.getRemoteHost();
        return ipAddress;
    }
}
