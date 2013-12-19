package com.example.muccourseworkmarcclelland;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muccourseworkmarcclelland.MainActivity;

public class searchMapClick extends MainActivity implements OnClickListener
{ 
	@Override
	public void onClick(View v) 
	{
		setContentView(R.layout.activity_main);
		// This class is called when the search map button is clicked by the user.
		search = (Button) findViewById(R.layout.search_bar);
	  	search.setOnClickListener(new OnClickListener() 
	  	{
			@Override
			public void onClick(View v) 
			{
				// Custom Dialog for the Search Button
				Dialog searchBar = new Dialog(context);
				searchBar.setContentView(R.layout.search_bar);
				searchBar.setTitle("Search Location");
				
				final EditText searcher = (EditText) searchBar.findViewById(R.id.searchField);
						
				Button enter = (Button) searchBar.findViewById(R.id.enter);
				// if button is clicked, close the custom dialog
				enter.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						// Get user input 
						searcher.getText().toString();
						Toast.makeText(getApplicationContext(),
								 "Searching for " + searcher, 
								 Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
	  	}
	}
	  	
	
