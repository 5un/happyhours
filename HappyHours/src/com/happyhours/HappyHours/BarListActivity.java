package com.happyhours.HappyHours;

import java.io.FileInputStream;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;

public class BarListActivity extends HappyHourBaseActivity {

	private static final String TAG = "HHMainActivity";
	protected static final String EXTRA_MESSAGE = "com.startup.bangkok.happyhours.message";
	protected static final String EXTRA_BAR_ID = "com.startup.bangkok.happyhours.barid";
	static WebView myWebView;
	/*
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_main);
		setContentView(R.layout.grid_view);
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			
		}
		

	}*/
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.grid_view);

	    GridView gridview = (GridView) findViewById(R.id.myGrid);
	    gridview.setAdapter(new ImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	          Log.e(TAG, "onListItemClicked Position:"+position);
	          showSpecificBar(position);
	        }

			private void showSpecificBar(int barId) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), SpecificBarActivity.class);
				intent.putExtra(EXTRA_MESSAGE, "SHOW_ME_THE_BAR");
				intent.putExtra(EXTRA_BAR_ID, barId);
				startActivity(intent);
			}
	    });
	}
	
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.bar_list, menu);
	    return super.onCreateOptionsMenu(menu);
	}
		
	
	
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
	    switch (item.getItemId()) {
        case R.id.action_search:
            openSearch();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    
	    }
	}
	

	

	private void openSearch() {
		// TODO Auto-generated method stub
		Log.i(TAG, "openSearch");
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
			View rootView = inflater.inflate(R.layout.fragment_barlist, container,
					false);
			ImageView MyImageView = (ImageView)rootView.findViewById(R.id.imageView);
			Drawable d = Drawable.createFromPath( "");
			MyImageView.setImageDrawable(d);
			

			return rootView;
		}
	}
	
	
	public class ImageAdapter extends BaseAdapter {
	    private Context mContext;

	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    public int getCount() {
	        return mThumbIds.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }
	/*
	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView;
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(760, 400));
	            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	            imageView.setPadding(0, 0, 0, 0);
	        } else {
	            imageView = (ImageView) convertView;
	        }
	        imageView.setImageResource(mThumbIds[position]);       
	        return imageView;
	    }
	*/    
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) 
	    {
	       View MyView = convertView;
	       
	   //    if ( convertView == null )
	 //      {
	    	   
	          LayoutInflater li = getLayoutInflater();
	          MyView = li.inflate(R.layout.grid_item, null);
	          
	          // Add The Text!!!
	          TextView tv = (TextView)MyView.findViewById(R.id.grid_item_text);
	          tv.setText(mThumbText[position]);
	       
	          // Add The Image!!!           
	          ImageView iv = (ImageView)MyView.findViewById(R.id.grid_item_image);
	         
	          iv.setScaleType(ImageView.ScaleType.FIT_XY);
	          iv.setImageResource(mThumbIds[position]);
	          iv.setPadding(0, 0, 0, 0);
	     //  }
	
	       MyView.setLayoutParams(new GridView.LayoutParams(760, 490));
	       
	      // MyView.
	       return MyView;
	    }
	    
	    

	    // references to our images
	    Integer[] mThumbIds = {
	            R.drawable.b0001, 
	            R.drawable.b0002, 
	            R.drawable.b0003, 
	            R.drawable.b0004, 
	            R.drawable.b0005, 
	            R.drawable.b0006, 
	    };
	    
	    String[] mThumbText = {
	            "amBar\nBarcadi Breezer and Vodka Cruiser\n16:00 -21:00",
	            "Bawarchi\nBuy one get one for free\n17:00-19:00",
	            "Beer Vault\nAll Products 30% off\n17:30-21:30", 
	            "Black Swan\nCarlsberg, Heineken, Tiger pints, 100 baht\n16:00-21:00",
	            "Bradman’s Bistro\nLocal beers 69 baht\n14:00-19:00",
	            "Charlie Browns\nHalf Price for Margaritas\n18:00-23:30"
	    };
	    
	    
	    
	}


	@Override
	protected int getTabIndex() {
		return 1;
	}
	
	

}
