package com.example.btconfigchange;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private static final String ORN = "orn";
	private static final String EDT_STATE = "edt_state";
	private static final int PORTRAIT = 1;
	private static final int LANDSCAPE = 2;
	private static final int INITIAL = -99;
	private static final String TAG = "CONFIGC";
	
	
	Button btn;
	EditText edt;
	
	
	//bundle will be null the first time this this called. 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.btn);
		edt = (EditText) findViewById(R.id.edt);
		
		//if you put the code in onRestoreInstanceState() here, it'll crash because on initialization, the bundle is null.
		//so you must check for the null value if you put it here. 
		
		
		// LESSON 1 - CHECKING BUNDLE IN onCreate()
		// we can choose to handle the savedInstanceState here, but we must
		// check for null
		// Check whether we're recreating a previously destroyed instance
		if (savedInstanceState == null) {
			//setButtonColor(getResources().getConfiguration().orientation);
			setButtonColor(INITIAL);
			Log.i(TAG, "onCreate called: Bundle is " + String.valueOf(savedInstanceState) + ", newly crated activity.");
	
		} else {
			
			//Log.i(TAG, "onCreate called: Bundle is " + String.valueOf(savedInstanceState) );
			//Log.i(TAG, "onCreate called: Bundle is NOT null" );
		}
	}

	// entering running state (call super first)
	//will not get called on the first time around.
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		
		Log.i(TAG, "onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
		setButtonColor(savedInstanceState.getInt(ORN));
		String strEditTextValue = (String) savedInstanceState.get(EDT_STATE);
		edt.setText(strEditTextValue + savedInstanceState.getInt(ORN));

	}



	private void setButtonColor(int nOrn) {
		//int nOrn = savedInstanceState.getInt(ORN);

		switch (nOrn) {
		case PORTRAIT:
			Log.i(TAG, "Portrait-Color-Green");
			btn.setBackgroundColor(Color.GREEN);
			break;
		case LANDSCAPE:
			Log.i(TAG, "Landscape-Color-Purple");
			btn.setBackgroundColor(Color.rgb(255, 0, 255));
			break;
		case INITIAL:
			Log.i(TAG, "Initial-Color-Yellow");
			btn.setBackgroundColor(Color.YELLOW);
			break;
		default:
			break;
		}
	}

	// exiting running state (super-last)
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save the user's current state
		savedInstanceState.putInt(ORN,
				getResources().getConfiguration().orientation);
		
		savedInstanceState.putString(EDT_STATE, edt.getText().toString());


		// Always call the superclass so it can save the view hierarchy state
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
