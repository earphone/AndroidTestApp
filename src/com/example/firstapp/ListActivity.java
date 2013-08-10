package com.example.firstapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		Context context = getApplicationContext();
		CharSequence text = "OPENING VIEW ALL";
		int duration = Toast.LENGTH_SHORT;
		Toast.makeText(context, text, duration).show();
		
		// Set up a Parse query adapter
		ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(this, "UserMessages");
		adapter.setTextKey("Message");
		
		// Find the listView in activity_list.xml
		ListView messageListView = (ListView) findViewById(R.id.messageList);
		// Display the adapter
		messageListView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
    	case R.id.up_to_chooser:
    		// If Chooser clicked, then up to ChooseActivity
    		MainActivity mainActiv = new MainActivity();
    		mainActiv.chooser();
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
