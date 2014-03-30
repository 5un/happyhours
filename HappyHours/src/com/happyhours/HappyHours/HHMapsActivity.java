package com.happyhours.HappyHours;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.app.FragmentTransaction;

public class HHMapsActivity extends HappyHourBaseActivity{
	
	private MapFragment mMapFragment;
	private GoogleMap mMap;
	
	private static float EKKAMAI_LAT = 13.7246793f;
	private static float EKKAMAI_LON = 100.5871452f;
	
	private static float H01_LAT = 13.725044f;
	private static float H01_LON = 100.587424f;
	
	private static final int ICONTYPE_GLASS = 0;
	private static final int ICONTYPE_COCKTAIL = 1;
	private static final int ICONTYPE_BEER = 2;
	private static final int ICONTYPE_WINE = 3;

	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		
		mMapFragment = (MapFragment) this.getFragmentManager().findFragmentById(R.id.map);
		mMap = mMapFragment.getMap();
		
		mMap.setMyLocationEnabled(true);
		
		CameraUpdate center=
		        CameraUpdateFactory.newLatLng(new LatLng(EKKAMAI_LAT,
		                                                 EKKAMAI_LON));
		    CameraUpdate zoom=CameraUpdateFactory.zoomTo(17);

		    mMap.moveCamera(center);
		    mMap.animateCamera(zoom);
		
		    LatLng h01 = new LatLng(H01_LAT, H01_LON);
		    Marker marker01 = mMap.addMarker(new MarkerOptions()
		    					.position(h01)
		    					.title("Test")
		    					.snippet("Free Beer")
		    					.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_cocktail)));
		    
		    initBars();
	}
	
	private void initBars(){
		try {
				InputStream is = this.getAssets().open("data.json");
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
			    StringBuilder sb = new StringBuilder();

			    String line = null;
			    while ((line = reader.readLine()) != null)
			    {
			        sb.append(line + "\n");
			    }
			    String result = sb.toString();
			    
			    JSONArray array = new JSONArray(result);
			    for(int i=0; i<array.length(); i++){
			    	JSONObject obj = (JSONObject) array.getJSONObject(i);
			    	String title = obj.getString("name");

			    	float lat = Float.parseFloat((String) obj.get("lat"));
			    	float lon = Float.parseFloat((String) obj.get("lon"));
			    	Random rand = new Random();
			    	int iconType = rand.nextInt(3);
			    	addHotspot(lat,lon, title, "", iconType);
			    }
			    
		} catch(Exception e){
			
		}
	}
	
	private void addHotspot (float lat, float lon, String name, String description, int iconType){
		 LatLng loc = new LatLng(lat, lon);
		 BitmapDescriptor bd = null;
		 switch(iconType){
		 	case ICONTYPE_GLASS: bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_glass); 
		 						break;
		 	case ICONTYPE_BEER: bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_beer); 
				break;
		 	case ICONTYPE_COCKTAIL: bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_cocktail); 
				break;
		 	case ICONTYPE_WINE: bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_wine); 
				break;
		 }
		 
		 Marker marker = mMap.addMarker(new MarkerOptions()
		    					.position(loc)
		    					.title(name)
		    					.snippet(description)
		    					.icon(bd ));
		    
		    					
	}

	@Override
	protected int getTabIndex() {
		return 0;
	}
	
}
