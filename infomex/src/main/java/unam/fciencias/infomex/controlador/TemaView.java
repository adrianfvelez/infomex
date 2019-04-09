/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import unam.fciencias.infomex.modelo.UtilidadTema;
import unam.fciencias.infomex.modelo.Tema;

/**
 *
 * @author oscar
 */

@ManagedBean(name="dtTemaView")
@ViewScoped

public class TemaView implements Serializable{
    
    private List<Tema> temas;

    private Tema elTema;

    private UtilidadTema u = new UtilidadTema();
    
    @ManagedProperty("#{buscaTema}")
    private BuscarTema tema;
    
    public void init(){

      u.buscaTemaPorNombre(elTema);

    }
    
    public void setTema(BuscarTema tema){
        this.tema = tema;
    }
    
    public List<Tema> getTemas(){
        return temas;
    }
    
}
