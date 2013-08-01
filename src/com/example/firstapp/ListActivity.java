package com.example.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
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
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}
	
}
