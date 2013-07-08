package com.example.firstapp;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.firstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        
        // Parse: Test to make sure that the SDK is working properly
        final ParseObject purpleTest = new ParseObject("purpleNurple");
        purpleTest.put("herro", "thar");
        purpleTest.put("foo", "bar");
        
        // Parse: Creating a second class for relationship
        final ParseObject orangeTest = new ParseObject("fiddleHurdle");
        orangeTest.put("foo", "hot");
     
        // Parse: Add a relation between 'purple' and 'orange'
        orangeTest.put("parent", purpleTest);
        
        // Parse: Save both 'purple' and 'orange' and their relations
        	// by just saving orange which is the dependent one
        // pupleTest.saveInBackground();
        orangeTest.saveInBackground();
       
        // Parse: Retrieve object from database
        ParseQuery<ParseObject> foundClue = ParseQuery.getQuery("blueClue");
        foundClue.getInBackground("N9Tf2C4ZbP", new GetCallback<ParseObject>() {
        	public void done(ParseObject object, ParseException e) {
        		if(e == null) {
        			// Take the value of an item and create a new item with the same value
        			String pawValue = object.getString("paw");
        			object.put("updated", "yes");
        			object.put("same?", pawValue);
        			object.saveInBackground();
        		}
        		else {
        			// something went wrong
        		}
        	}
        });
        
        setContentView(R.layout.activity_main);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Send button **/
    public void sendMessage(View view) {
    	// Do something in response to button
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
}
