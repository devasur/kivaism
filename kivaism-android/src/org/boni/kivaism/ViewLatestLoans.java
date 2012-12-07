package org.boni.kivaism;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ViewLatestLoans extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_latest_loans);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_latest_loans, menu);
		return true;
	}

}
