/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

/**
 *
 * @author avelez
 */
public class Informador {
    
    private String correo_inf;
    private String usuario_inf;
    private String contrasenia_inf;

    public String getCorreo_inf() {
        return correo_inf;
    }

    public void setCorreo_inf(String correo_inf) {
        this.correo_inf = correo_inf;
    }

    public String getUsuario_inf() {
        return usuario_inf;
    }

    public void setUsuario_inf(String usuario_inf) {
        this.usuario_inf = usuario_inf;
    }

    public String getContrasenia_inf() {
        return contrasenia_inf;
    }

    public void setContrasenia_inf(String contrasenia_inf) {
        this.contrasenia_inf = contrasenia_inf;
    }
}
