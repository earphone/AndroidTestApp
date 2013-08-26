package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ChooseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose, menu);
		return true;
	}
	
	// Options for ActionBar
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
    	case R.id.chooserLogout:
    		// If logout clicked, then logout :p
    		MainActivity mainAct = new MainActivity();
    		mainAct.logout();
    		return true;
    	default:
    		return super.onOptionsItemSelected(item);
        }
    }
	
	// Sends the user to MainActivity to add a new word to the list
	public void addWord(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void addDate(View view) {
		Intent intent = new Intent(this,AddDate.class);
		startActivity(intent);
	}
	
	// Sends the user to view all
	public void viewAll(View view) {
		Intent intent = new Intent(this, ListActivity.class);
		startActivity(intent);
	}

}
