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
	

	//bundle will be null the first time this this called. 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
