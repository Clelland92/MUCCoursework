package com.example.muccourseworkmarcclelland;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_TERRAIN;

import com.google.android.gms.maps.GoogleMap;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class selectMapClick extends MainActivity implements OnClickListener 
{
	@Override
	public void onClick(View v) 
	{ 
		setContentView(R.layout.activity_main);
		// This class is called when the select map button is clicked by the user. 
		selectMap = (Button) findViewById(R.id.selectMap);
	  	selectMap.setOnClickListener(new OnClickListener() 
	 {
		@Override
		public void onClick(View v) 
		{
			// Custom Dialog for the map selector button
			Dialog mapType = new Dialog (context);
			mapType.setContentView(R.layout.dialog_buttons);
			mapType.setTitle("Select Map Type.");
			
			Button normal = (Button) mapType.findViewById(R.id.normalMap);
			// if button is clicked, close the custom dialog
			normal.setOnClickListener(new OnClickListener() 
			{
				@Override
				public void onClick(View v) 
				{
					// set map type to normal
					mapView.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				}
			});
			
			Button satellite = (Button) mapType.findViewById(R.id.satelliteMap);
			satellite.setOnClickListener(new OnClickListener() 
			{	
				@Override
				public void onClick(View v) 
				{
					// set map type to satellite
					mapView.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				}
			});
			
			Button hybrid = (Button) mapType.findViewById(R.id.hybridMap);
			hybrid.setOnClickListener(new OnClickListener() 
			{
				@Override
				public void onClick(View v) 
				{
					// set map to hybrid
					mapView.setMapType(GoogleMap.MAP_TYPE_HYBRID);
				}
			});
			
			Button terrain = (Button) mapType.findViewById(R.id.terrainMap);
			terrain.setOnClickListener(new OnClickListener() 
			{
				@Override
				public void onClick(View v) 
				{
					// set map to terrain
					mapView.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
				}
			});

			mapType.show();
		  }
		}); 	
	}		
}
