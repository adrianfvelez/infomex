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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import unam.fciencias.infomex.modelo.Marcador;
import unam.fciencias.infomex.modelo.UtilidadMarcador;
import unam.fciencias.infomex.modelo.UtilidadTema;
import unam.fciencias.infomex.modelo.Tema;

import unam.fciencias.infomex.modelo.Tema;
import unam.fciencias.infomex.modelo.UtilidadTema;

@ManagedBean
@RequestScoped
public class AgregarTema {
    
    private Tema tema = new Tema();
    private UtilidadTema u1 = new UtilidadTema();
    private UtilidadMarcador u = new UtilidadMarcador();
    private double longitud;

    private double latitud;
    
    private int id_mar;
    
    private int id_tema;

    private String correo_inf;

    private String nombre_mar;

    private String descripcion_mar;
    
    private MapModel simpleModel;
    
    private Marcador user = new Marcador();
    
    private List<Tema> options;
    private List<String> optionsNombre;
    
    private String nombreMarcador;
    
    private UtilidadTema uu = new UtilidadTema();

    public UtilidadTema getU1() {
        return u1;
    }

    public void setU1(UtilidadTema u1) {
        this.u1 = u1;
    }

    public UtilidadMarcador getU() {
        return u;
    }

    public void setU(UtilidadMarcador u) {
        this.u = u;
    }

    public UtilidadTema getUu() {
        return uu;
    }

    public void setUu(UtilidadTema uu) {
        this.uu = uu;
    }
    
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public AgregarTema() {
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale("es-Mx"));
    }
    
    public int getIdTema(){
        options =  uu.getTodosTemas();
        for(Tema i : options){
            if(tema.getNombre_tema().equals(i.getNombre_tema())) return i.getId_tema();
        }
        return -1;
    }
    
    public String addTema() {
        
        FacesContext context1 = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Informador i1 = (unam.fciencias.infomex.modelo.Informador)context1.getExternalContext().getSessionMap().get("usuario");
        tema.setCorreo_inf(i1.getCorreo_inf());
        u1.save(tema);
        
        user.setId_tema(tema.getId_tema());
        tema = null;
         FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Felicidades, el registro se ha realizado correctamente", ""));
        
         //
        Marker marke = new Marker(new LatLng(latitud, longitud), nombre_mar);
        simpleModel.addOverlay(marke);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marcador añadido", "Lat:" + latitud + ", Lng:" + longitud));
       
        user.setLatitud(latitud);
        user.setLongitud(longitud);
        user.setNombre_mar(nombre_mar);
        user.setDescripcion_mar(descripcion_mar);
        FacesContext context = FacesContext.getCurrentInstance();
        unam.fciencias.infomex.modelo.Informador i = (unam.fciencias.infomex.modelo.Informador)context.getExternalContext().getSessionMap().get("usuario");
        //user.setCorreo_inf("admin");
        user.setCorreo_inf(i.getCorreo_inf());
        user.setId_tema(getIdTema());
        
        u.save(user);
        //user=null;
        
        List<unam.fciencias.infomex.modelo.Marcador> listaCompleta = u.getTodosMarcadores();
        if(listaCompleta!=null){
            for(unam.fciencias.infomex.modelo.Marcador marca : listaCompleta){
                LatLng coord = new LatLng(marca.getLatitud(), marca.getLongitud());
                simpleModel.addOverlay(new Marker(coord, marca.getNombre_mar(),marca));
            }
        }
        return null;
    }
    
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
        
        List<Marcador> listaCompleta = u.getTodosMarcadores();
        
        if(listaCompleta!=null){
            for(Marcador marca : listaCompleta){
                LatLng coord = new LatLng(marca.getLatitud(), marca.getLongitud());
                simpleModel.addOverlay(new Marker(coord, marca.getNombre_mar(),marca));
            }
        }
        //Coordenadas del marcador inicial
        LatLng coord1 = new LatLng(19.432590, -99.131205);
          
        //Ponemos el marcador en el mapa
        simpleModel.addOverlay(new Marker(coord1, "Ciudad de Mexico"));
        
        options =  uu.getTodosTemas();
        if(options != null){
            optionsNombre = new ArrayList<String>();
            for(Tema i : options){
                optionsNombre.add(i.getNombre_tema());
            }            
        }
        
    }
    
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public int getId_mar() {
        return id_mar;
    }

    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public String getCorreo_inf() {
        return correo_inf;
    }

    public void setCorreo_inf(String correo_inf) {
        this.correo_inf = correo_inf;
    }

    public String getNombre_mar() {
        return nombre_mar;
    }

    public void setNombre_mar(String nombre_mar) {
        this.nombre_mar = nombre_mar;
    }

    public String getDescripcion_mar() {
        return descripcion_mar;
    }

    public void setDescripcion_mar(String descripcion_mar) {
        this.descripcion_mar = descripcion_mar;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public Marcador getUser() {
        return user;
    }

    public void setUser(Marcador user) {
        this.user = user;
    }

    public List<Tema> getOptions() {
        return options;
    }

    public void setOptions(List<Tema> options) {
        this.options = options;
    }

    public List<String> getOptionsNombre() {
        return optionsNombre;
    }

    public void setOptionsNombre(List<String> optionsNombre) {
        this.optionsNombre = optionsNombre;
    }

    public String getNombreMarcador() {
        return nombreMarcador;
    }

    public void setNombreMarcador(String nombreMarcador) {
        this.nombreMarcador = nombreMarcador;
    }
    
}
