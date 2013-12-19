package com.example.muccourseworkmarcclelland; 

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import com.example.muccourseworkmarcclelland.searchMapClick;
import com.example.muccourseworkmarcclelland.selectMapClick;

public class MainActivity extends Activity 
{
	 GoogleMap mapView;
	 Location location, lastocation;
	 Button selectMap, search, hostcities;
	 final Context context = this;
	 ViewFlipper viewFlipper;
	 
	 //Spinner hostCities;
	 //OnItemSelectedListener CitySelectorSpinner;
	 
	 //selectMapClick mapClick;
	 //searchMapClick searchClick; 
	 
	 @Override 
	 protected void onCreate(Bundle savedInstanceState) 
	 { 
	 super.onCreate(savedInstanceState); 
	 setContentView(R.layout.activity_main); 
	 viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
	 
	 viewFlipper.setDisplayedChild(0);
	 
	// Get a handle to the default Map Fragment
     mapView = ((MapFragment) getFragmentManager()
             .findFragmentById(R.id.map)).getMap();

     // LatLng and attributes for default camera position and Glasgow 
     LatLng glasgow = new LatLng( 55.874, -4.287);
     mapView.setMyLocationEnabled(true);
     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(glasgow, 13));
     mapView.addMarker(new MarkerOptions()
             .title("Glasgow 2014")
             .snippet("Home of the 2014 Commonwealth Games")
             .icon(null)
             .position(glasgow)); 
     
     //LatLng and attributes for Celtic park 
     LatLng celticPark = new LatLng ( 55.849593, -4.205547);
     mapView.addMarker(new MarkerOptions()
     	.title("Celtic Park")
     	.snippet("Opening Ceremony")
     	.position(celticPark));
     
     // LatLng and attributes for Ibrox Stadium
     LatLng ibroxStadium = new LatLng ( 55.853316, -4.308668);
     mapView.addMarker(new MarkerOptions()
     	.title("Ibrox Stadium")
     	.snippet("Sport: Rugby Sevens")
     	.position(ibroxStadium));
     
     // LatLng and attributes for Shooting centre 
     LatLng barryBuddon = new LatLng ( 56.502565, -2.703250);
     mapView.addMarker(new MarkerOptions()
     	.title("Barry Buddon Shooting Centre")
     	.snippet("Sport: Shooting")
     	.position(barryBuddon));
     
     //LatLng and attributes for Mountain Bike trails 
     LatLng cathkinBraes = new LatLng( 55.794291, -4.219072);
     mapView.addMarker(new MarkerOptions()
     	.title("Cathkin Braes Mountain Bike Trails")
     	.snippet("Sport: Mountian Biking")
     	.position(cathkinBraes));
     
     //LatLng and attributes for Emirates Arena 
     LatLng emiratesArena = new LatLng( 55.846847, -4.207008);
     mapView.addMarker(new MarkerOptions()
     	.title("Emirates Arena and Chris Hoy Velodrome")
     	.snippet("Sport: Track Cycling, " +
     			"Badminton")
     	.position(emiratesArena));
     
     //LatLng and attributes for Glasgow hockey pitches 
     LatLng glasgowHockey = new LatLng( 55.844960, -4.236709);
     mapView.addMarker(new MarkerOptions()
     	.title("Glasgow National Hockey Centre")
     	.snippet("Sport: Hockey")
     	.position(glasgowHockey));
     
     //LatLng and attributes for Hampden park 
     LatLng hampdenPark = new LatLng( 55.825703, -4.252386);
     mapView.addMarker(new MarkerOptions()
     	.title("Hampden Park")
     	.snippet("Sport: Track & Field")
     	.position(hampdenPark));
     
     //LatLng and attributes for Kelvin Grove 
     LatLng kelvingroveBowls = new LatLng( 55.867324, -4.288245);
     mapView.addMarker(new MarkerOptions()
     	.title("Kelvingrove Lawn Bowls Centre")
     	.snippet("Sport: Lawn Bowls")
     	.position(kelvingroveBowls));
     
     //LatLng and attributes for Commonwealth pool
     LatLng commonwealthPool = new LatLng( 55.939202, -3.172731);
     mapView.addMarker(new MarkerOptions()
     	.title("Royal Commonwealth Pool")
     	.snippet("Sport: Diving")
     	.position(commonwealthPool));
     
     //LatLng and attributes for thw SECC
     LatLng sSECC = new LatLng( 55.862770, -4.294390);
     mapView.addMarker(new MarkerOptions()
     	.title("SECC")
     	.snippet("Sport: Boxing, " +
     			"Gymnastics" +
     			"Judo, " +
     			"Netball, " +
     			"Weightlifting, " +
     			"Wrestling") 
     	.position(sSECC));
     
     // LatLng and attributes for Scotstoun campus 
     LatLng scotstounCampus = new LatLng( 55.864237, -4.251806);
     mapView.addMarker(new MarkerOptions()
     	.title("Scotstoun Sports Campus")
     	.snippet("Sport: Squash, " +
     			"Table Tennis")
     	.position(scotstounCampus));
     
     // LatLng and attributes for Strathclyde park
     LatLng strathclydePark = new LatLng( 55.785288, -4.014812);
     mapView.addMarker(new MarkerOptions()
     	.title("Strathclyde Country Park")
     	.snippet("Sport: Triathalon")
     	.position(strathclydePark));
     
     // LatLng and attributes for Tollcross swimming centre 
     LatLng tollcross = new LatLng( 55.845048, -4.176075);
     mapView.addMarker(new MarkerOptions()
     	.title("Tollcross International Swimming Centre")
     	.snippet("Sport: Swimming")
     	.position(tollcross));
     
     // LatLng and attributes for the Athletes' village living area
     LatLng athleteVillage = new LatLng( 55.864237, -4.251806);
     mapView.addMarker(new MarkerOptions()
     	.title("Athletes' Village")
     	.snippet("Athletes' Living Area")
     	.position(athleteVillage));
	 
	 	try 
	 	{
	 		// Loading map
	 		initializeMap();
	 	}
	 	catch (Exception e)
	 	{
	 		e.printStackTrace();
	 	}
	 	
	 	// Get Button that will allow the user to select one of 10 cities 
	 	hostcities = (Button) findViewById(R.id.hostCities);
	 	hostcities.setOnClickListener(new OnClickListener() 
	 	{
			@Override
			public void onClick(View v) 
			{
				viewFlipper.showNext();
				
				Button glasgow = (Button) findViewById(R.id.glasgow);
				glasgow.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng glasgow = new LatLng( 55.874, -4.287);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(glasgow, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Glasgow 2014")
					             .snippet("Home of the 2014 Commonwealth Games")
					             .position(glasgow)); 
					     viewFlipper.showPrevious();
					}
				});
				
				// TODO Auto-generated method stub
				Button delhi = (Button) findViewById(R.id.delhi);
				delhi.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng delhi = new LatLng( 28.704059, 77.102490);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(delhi, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Dehli 2010")
					             .snippet("Scotland won 26 medals")
					             .position(delhi)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button melbourne = (Button) findViewById(R.id.melbourne);
				melbourne.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng melbourne = new LatLng( -37.814107, 144.963280);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(melbourne, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Melbourne 2006")
					             .snippet("Scotland won 29 medals")
					             .position(melbourne)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				
				Button manchester = (Button) findViewById(R.id.manchester);
				manchester.setOnClickListener(new OnClickListener() 
				{	
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng manchester = new LatLng( 53.479324, -2.248485);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(manchester, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Manchester 2002")
					             .snippet("Scotland won 29 medals")
					             .position(manchester)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button kuala_Lumpur = (Button) findViewById(R.id.kuala_lumpur);
				kuala_Lumpur.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng kuala_Lumpur = new LatLng( 3.139003, 101.686855);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(kuala_Lumpur, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Kuala Lumpur 1998")
					             .snippet("Scotland won 12 medals")
					             .position(kuala_Lumpur)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button victoria = (Button) findViewById(R.id.victoria);
				victoria.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng victoria = new LatLng( 48.428421, -123.365644);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(victoria, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Victoria 1994")
					             .snippet("Scotland won 20 medals")
					             .position(victoria)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button aukland = (Button) findViewById(R.id.aukland);
				aukland.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v)
					{
						// TODO Auto-generated method stub
						LatLng aukland = new LatLng( -36.848460, 174.763332);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(aukland, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Aukland 1990")
					             .snippet("Scotland won 22 medals")
					             .position(aukland)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button edinburgh = (Button) findViewById(R.id.edinburgh);
				edinburgh.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng edinburgh = new LatLng( 55.953252, -3.188267);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(edinburgh, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Edinburgh 1986")
					             .snippet("Scotland won 33 medals")
					             .position(edinburgh)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button brisbane = (Button) findViewById(R.id.brisbane);
				brisbane.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng brisbane = new LatLng( -27.471011, 153.023449);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(brisbane, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Brisbane 1982")
					             .snippet("Scotland won 26 medals")
					             .position(brisbane)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button edmonton = (Button) findViewById(R.id.edmonton);
				edmonton.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng edmonton = new LatLng( 53.544389, -113.490927);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(edmonton, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Edmonton 1978")
					             .snippet("Scotland won 14 medals")
					             .position(edmonton)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
				Button christchurch = (Button) findViewById(R.id.christchurch);
				christchurch.setOnClickListener(new OnClickListener() 
				{	
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						LatLng christchurch = new LatLng( -43.532054, 172.636225);
					     mapView.setMyLocationEnabled(true);
					     mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(christchurch, 13));
					     mapView.addMarker(new MarkerOptions()
					             .title("Christchurch 1974")
					             .snippet("Scotland won 19 medals")
					             .position(christchurch)
					             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
					     viewFlipper.showPrevious();
					}
				});
			}
		});
	 
	// Get button to search the map  
     search = (Button) findViewById(R.id.search);
     search.setOnClickListener(new OnClickListener() 
	  	{
			@Override
			public void onClick(View v) 
			{
				// Custom Dialog for the Search Button
				final Dialog searchBar = new Dialog(context);
				searchBar.setContentView(R.layout.search_bar);
				searchBar.setTitle("Search Location");
				
				final EditText searcher = (EditText) searchBar.findViewById(R.id.searchField);
						
				// Enter button that will take user input
				Button enter = (Button) searchBar.findViewById(R.id.enter);
				// if button is clicked, take input and use it to display the specified location
				enter.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// Get user input 
						String searchfor = searcher.getText().toString();
						mapView.clear();
			        	 LatLng searchLocation = new LatLng(location.getLatitude(),
			        			 location.getLongitude());
			        	 mapView.addMarker(new MarkerOptions()
			        	 .position(searchLocation)
			        	 .snippet("Lat:" + location.getLatitude() + "Lng:"+ location.getLongitude())
			        	 .title("" + searchfor));
						Toast.makeText(getApplicationContext(),
								 "Searching for " + searchfor, 
								 Toast.LENGTH_SHORT).show();
					}
				});
				searchBar.show();
			}
		});
  	 
  	 // Get button to select map type
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
			
			//Button that will change the map type 
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
	 
  	 //hostCities = (Spinner) findViewById(R.id.hostCities);
  	 // Create an array adapter using host city string array
  	 //ArrayAdapter<CharSequence> listHostCity = 
  	//		 ArrayAdapter.createFromResource(this, R.array.hostCityList, android.R.layout.simple_spinner_item);
  	 // Specify the layout to use when the list of choices appears
  	 //listHostCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
  	 // Apply the adapter to the spinner
  	 //hostCities.setAdapter(listHostCity);
  	 //hostCities.setOnItemSelectedListener(this);

         // Enabling MyLocation Layer of Google Map
         mapView.setMyLocationEnabled(true);

         // Getting LocationManager object from System Service LOCATION_SERVICE
         LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

         // Creating a criteria object to retrieve provider
         Criteria criteria = new Criteria();

         // Getting the name of the best provider
         String provider = locationManager.getBestProvider(criteria, true);


         LocationListener locationListener = new LocationListener() 
         {
           public void onLocationChanged(Location location) 
           {
           // redraw the marker when get location update.
           drawMarker(location);
           }
         }; 

         if(location!=null)
         {
            //PLACE THE INITIAL MARKER              
            drawMarker(location);
         }
     }
         private void drawMarker(Location location)
         {
        	 mapView.clear();
        	 LatLng currentPosition = new LatLng(location.getLatitude(),
        			 location.getLongitude());
        	 mapView.addMarker(new MarkerOptions()
        	 .position(currentPosition)
        	 .snippet("Lat:" + location.getLatitude() + "Lng:"+ location.getLongitude())
        	 .title("ME"));
         }
	 
	 
	 /**
	  *  Function to load map. If map isn't created it will create it for you
	  **/
	 private void initializeMap()
	 {
		 if (mapView == null)
		 {
			 mapView = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 
			 // Check if map is created successfully or not
			 if(mapView ==null)
			 {
				 Toast.makeText(getApplicationContext(),
						 "Sorry! Unable to create map", 
						 Toast.LENGTH_SHORT).show();
			 }
		 }
	 }	 
	 
	 @Override 
	 protected void onResume()
	 {
		 super.onResume();
		 initializeMap();
	 }	 
	    
}
