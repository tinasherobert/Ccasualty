package it.sephiroth.android.library.floatingmenu.app;

import it.sephiroth.android.library.floatingmenu.FloatingActionItem;
import it.sephiroth.android.library.floatingmenu.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements AdapterView.OnItemClickListener, FloatingActionMenu.OnItemClickListener {

	private static final String TAG = "MainActivity";
	private ListView mListView;
	private FloatingActionMenu mFloatingMenu;

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
			new ArrayAdapter<String>(this, R.layout.activity_list_item, R.id.textView1, objects);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(this);

		Resources res = getResources();
		int action_item_padding = res.getDimensionPixelSize(R.dimen.float_action_item_padding);

		boolean visible = true;
		if(null != savedInstanceState){
			visible = savedInstanceState.getBoolean("floating-menu-visible", true);
		}
		mListView.setOnScrollListener(new OnScrollListener() {
		    @Override
		    public void onScrollStateChanged(AbsListView view, int scrollState) { }

		    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@Override
		    public void onScroll(AbsListView view, int firstVisibleItem,
		        int visibleItemCount, int totalItemCount) {

		        if(mListView.getFirstVisiblePosition() != 0)
		        	Toast.makeText(getApplicationContext(), "scrolling", 2).show();
		        	
		        	
		        else if(mListView.getFirstVisiblePosition() == 10)
		        	//actionBar.hide();
		        	Toast.makeText(getApplicationContext(), "scrolling", 2).show();
		            //getSupportActionBar().hide();
		    }
		});
		//@formatter:off
		FloatingActionItem item1 = new FloatingActionItem.Builder(0)
			.withResId(R.drawable.ic_facebook)
			.withDelay(0)
			.withPadding(action_item_padding)
			.build();

		FloatingActionItem item2 = new FloatingActionItem.Builder(1)
			.withResId(R.drawable.ic_googleplus)
			.withDelay(50)
			.withPadding(action_item_padding)
			.build();

		FloatingActionItem item3 = new FloatingActionItem.Builder(2)
			.withResId(R.drawable.ic_twitter)
			.withDelay(100)
			.withPadding(action_item_padding)
			.build();

		mFloatingMenu = new FloatingActionMenu
			.Builder(this)
			.addItem(item1)
		    .addItem(item2)
			.addItem(item3)
			.withScrollDelegate(new FloatingActionMenu.AbsListViewScrollDelegate(mListView))
			.withThreshold(R.dimen.float_action_threshold)
			.withGap(R.dimen.float_action_item_gap)
			.withVerticalPadding(R.dimen.float_action_v_padding)
			.withGravity(FloatingActionMenu.Gravity.CENTER_HORIZONTAL | FloatingActionMenu.Gravity.BOTTOM)
			.withDirection(FloatingActionMenu.Direction.Vertical)
			.animationDuration(300)
			.animationInterpolator(new OvershootInterpolator())
			.visible(visible)
		    .build();
		//@formatter:on

		mFloatingMenu.setOnItemClickListener(this);
	}

	@Override
	protected void onSaveInstanceState(final Bundle outState) {
		Log.i(TAG, "onSaveInstanceState");
		super.onSaveInstanceState(outState);

		outState.putBoolean("floating-menu-visible", mFloatingMenu.getVisible());
	}

	@Override
	protected void onRestoreInstanceState(final Bundle savedInstanceState) {
		Log.i(TAG, "onRestoreInstanceState: " + savedInstanceState);
		super.onRestoreInstanceState(savedInstanceState);
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
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.example2) {
			//startActivity(new Intent(this, MainActivity2.class));
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
	}

	@Override
	public void onItemClick(final FloatingActionMenu menu, final int id) {
		switch (id){
		case 0:
			Intent i = new Intent(MainActivity.this, ScrollViewActivity.class);
			startActivity(i);
			break;
		case 1:
			NewAppointment dialog = new NewAppointment();
			dialog.show(getSupportFragmentManager(), "QuickContactFragment");
			
			break;
		case 2:
			break;
		}
		
	}
	
	
}
