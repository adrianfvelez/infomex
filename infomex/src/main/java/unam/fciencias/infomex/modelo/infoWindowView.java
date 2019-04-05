package com.modelo;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class infoWindowView implements Serializable {
      
    private MapModel advancedModel;
  
    private Marker marker;
  
    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();
          
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Basic marker
        advancedModel.addOverlay(new Marker(coord1, "Konyaalti"));
        advancedModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
        advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
        advancedModel.addOverlay(new Marker(coord4, "Kaleici"));
    }
  
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
    
    public void setAdvanceModel(MapModel a){
        advancedModel = a;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }
}