package com.example.firstapp;

import com.parse.Parse;
import com.parse.ParseAnalytics;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	       // Parse: Initialize
	    	Parse.initialize(this, "OdAVwKCSwWGzcYYziwk0MxsZgP11D4xYBbD7cdSN", "aMu14e9jrNTV9C1qF62ZV8wRSz7KZe7qffwMG4qX");  
	        
	        // Parse: Used to track how many times app is opened
	        ParseAnalytics.trackAppOpened(getIntent());
	        
		setContentView(R.layout.login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
