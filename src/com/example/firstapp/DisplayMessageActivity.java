package com.example.firstapp;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class DisplayMessageActivity extends Activity {

	@SuppressLint("NewApi")

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);	        		
		
		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			// Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);	
		}
		
		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		// Attach Parse user to the message
		ParseUser user = ParseUser.getCurrentUser();
		if(user == null) {
			Toast.makeText(getApplicationContext(), "noone logged in ", Toast.LENGTH_SHORT).show();
		}
		ParseObject userMessage = new ParseObject("UserMessages");
		userMessage.put("Message", message);
		userMessage.put("USER", user);
		userMessage.put("ADDED", "YES");
		userMessage.saveInBackground();
		user.saveInBackground();
		
		// Create the text view
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);
		
		// Set the text view as the activity layout
		setContentView(textView);
		
		
	}

	
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    
    // Options for ActionBar
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
    	case android.R.id.home:
    		// If app icon clicked, go home
    		Intent intent = new Intent(this, MainActivity.class);
    		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    		startActivity(intent);
    		return true;
    	case R.id.Logout:
    		// If logout clicked, then logout :p
    		MainActivity mainAct = new MainActivity();
    		mainAct.logout();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
        }
    }
    
}
