package com.c.casualty.app;
import java.util.ArrayList;
import java.util.List;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ClerkMenu extends FragmentActivity implements AdapterView.OnItemClickListener {

	private static final String TAG = "MainActivity";
	private ListView mListView;
	@TargetApi(Build.VERSION_CODES.DONUT)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate: " + savedInstanceState);
		super.onCreate(savedInstanceState);
		 getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.activity_main);

		List<String> objects = new ArrayList<String>();
		populateData(objects);
		
		ArrayAdapter<String> adapter =
			new ArrayAdapter<String>(this, R.layout.clerk_list_item, R.id.textView1, objects);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent i = new Intent(ClerkMenu.this, ClerkPatientDetails.class);
				startActivity(i);
				
			}
		});

		
	}

	

	private void populateData(final List<String> objects) {
		for (int i = 0; i < 100; i++) {
			objects.add(String.format("Item %d", i));
		}
	}

	
	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mListView = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

	@Override
	public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
	}


	
	
}
