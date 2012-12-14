package org.boni.kivaism;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;

public class SearchLoansActivity extends Activity {

	public static final String SEARCH_LOANS_EXTRA_TEXT = "org.boni.kivaism.search_loans.extra";

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_loans);
	}
	
	public void doSend(View view){
		Intent intent = new Intent(this,DisplayMessageActivity.class); 
		EditText editText = (EditText)findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(SEARCH_LOANS_EXTRA_TEXT, message);
		startActivity(intent);
	}


}
