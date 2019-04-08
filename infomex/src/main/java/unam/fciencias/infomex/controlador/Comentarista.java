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
public class Comentarista {

    private String correo_com;

    private String usuario_com;

    private String contrasenia_com;

    private String nombre;

    private String fecha_nacimiento;

    public String getCorreo_com() {
        return correo_com;
    }

    public void setCorreo_com(String correo_com) {
        this.correo_com = correo_com;
    }

    public String getUsuario_com() {
        return usuario_com;
    }

    public void setUsuario_com(String usuario_com) {
        this.usuario_com = usuario_com;
    }

    public String getContrasenia_com() {
        return contrasenia_com;
    }

    public void setContrasenia_com(String contrasenia_com) {
        this.contrasenia_com = contrasenia_com;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }   
    
}
