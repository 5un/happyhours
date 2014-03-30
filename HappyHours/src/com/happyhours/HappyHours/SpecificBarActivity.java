package com.happyhours.HappyHours;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;

public class SpecificBarActivity extends Activity {

	private static final String TAG = "BarActivity";
	static Integer barId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_specific_bar);

		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			
		}
		Intent intent = getIntent();
		barId = intent.getIntExtra(BarListActivity.EXTRA_BAR_ID, -1);
		//int barId = savedInstanceState.getInt(MainActivity. EXTRA_BAR_ID);
		Log.e(TAG, "show bar No. " + barId);


		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.specific_bar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_specific_bar,
					container, false);
			
			
			TextView tv1 = (TextView) rootView.findViewById(R.id.textView1);
	          tv1.setText(config.barNames[barId]);
	          
				TextView tv2 = (TextView) rootView.findViewById(R.id.textView2);
		          tv2.setText(config.dates[barId]);
		          
					TextView tv3 = (TextView) rootView.findViewById(R.id.textView3);
			          tv3.setText(config.discounts[barId]);
		          
	          
						TextView tv4 = (TextView) rootView.findViewById(R.id.textView4);
				          tv4.setText(config.items[barId]);
				          
							TextView tv5 = (TextView) rootView.findViewById(R.id.textView5);
					          tv5.setText(config.happyHours[barId]);	       
	          // Add The Image!!!           
					          
	          ImageView iv = (ImageView)rootView.findViewById(R.id.bar_image);
	        
	          iv.setScaleType(ImageView.ScaleType.FIT_XY);
	          iv.setImageResource(config.mThumbIds[barId]);
	          iv.setPadding(0, 0, 0, 0);
			
			return rootView;
			
			
		}
	}

}
