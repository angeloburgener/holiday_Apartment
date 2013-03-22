package ch.holidayaparment.client;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.Maps;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geocode.DirectionQueryOptions;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sun.org.apache.xml.internal.security.Init;

public class MainView extends Composite{
	private VerticalPanel vPanel;


	public MainView(){
		initWidget(this.vPanel);

		//load the maps - API-KEY - API LEVEL 2
		Maps.loadMapsApi("", "2", false, new Runnable() {
			public void run() {
				buildMap();
			}
		});
	}
	
	//----------------------------------
	//setting up the map
	//----------------------------------
	private void buildMap() {
		LatLng strPoint = LatLng.newInstance(39.509, -98.434);

		MapWidget map = new MapWidget(strPoint, 15);
		map.setSize("400px", "480px");
		map.setUIToDefault();
		map.getElement().getStyle().setPropertyPx("margin", 15);

		map.setSize("480px", "450px");
		// Add some controls for the zoom level
		map.addControl(new LargeMapControl());

		 // Add a marker
		LatLng cawkerCity = LatLng.newInstance(39.509, -98.434);
	    map.addOverlay(new Marker(cawkerCity));
	    
		//opts = new DirectionQueryOptions(map);
		// Add the map to the HTML host page
		vPanel.add(map);
	}

}

