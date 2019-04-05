
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author avelez
 */

@Entity
@Table(catalog = "infomex", schema = "public", name = "comentarista")
public class Comentarista {
    
    @Id
    @Column(name = "correo_com")
    private String correo_com;
    
    @Column(name = "usuario_com")
    private String usuario_com;
    
    @Column(name = "contrasenia_com")
    private String contrasenia_com;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fecha_nacimiento")
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
