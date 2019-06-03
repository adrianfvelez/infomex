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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import unam.fciencias.infomex.modelo.Comentarista;
import unam.fciencias.infomex.modelo.UtilidadComentarista;


@ManagedBean
@RequestScoped
public class EditarCuenta {
    
    private Comentarista comentarista = new Comentarista();
    private UtilidadComentarista u = new UtilidadComentarista();

    public Comentarista getComentarista() {
        return comentarista;
    }

    public void setComentarista(Comentarista comentarista) {
        this.comentarista = comentarista;
    }

    public UtilidadComentarista getU() {
        return u;
    }

    public void setU(UtilidadComentarista u) {
        this.u = u;
    }
    
    
}
