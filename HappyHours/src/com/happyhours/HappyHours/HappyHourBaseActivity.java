package com.happyhours.HappyHours;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public abstract class HappyHourBaseActivity extends Activity {

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		initTabs();
	}
	
	private void initTabs(){
		final ActionBar actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

	    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
	        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
	            
	        	Log.d("tab position", "tag " + tab.getPosition());
	        	// show the given tab
	        	if(tab.getPosition()==0 && getTabIndex()!=0){
	        		Intent intent = new Intent(HappyHourBaseActivity.this, HHMapsActivity.class);
	        		startActivity(intent);
	        	}if(tab.getPosition()==1 && getTabIndex()!=1){
	        		Intent intent = new Intent(HappyHourBaseActivity.this, BarListActivity.class);
	        		startActivity(intent);
	        	}
	        	else if(tab.getPosition()==2 && getTabIndex()!=2){
	        		Intent intent = new Intent(HappyHourBaseActivity.this, HHCalendarActivity.class);
	        		startActivity(intent);
	        	}
	        	else if(tab.getPosition()==3 && getTabIndex()!=3){
	        		Intent intent = new Intent(HappyHourBaseActivity.this, HappyDayActivity.class);
	        		startActivity(intent);
	        	}
	        	
	        }

	        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
	            // hide the given tab
	        }

	        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
	            // probably ignore this event
	        }
	    };
	    
	    actionBar.addTab(actionBar.newTab().setText("").setIcon(R.drawable.icon_location_white).setTabListener(tabListener), getTabIndex() == 0);
	    actionBar.addTab(actionBar.newTab().setText("").setIcon(R.drawable.icon_star_white).setTabListener(tabListener), getTabIndex() == 1);
	    actionBar.addTab(actionBar.newTab().setText("").setIcon(R.drawable.icon_calendar_white).setTabListener(tabListener), getTabIndex() == 2);
	    actionBar.addTab(actionBar.newTab().setText("").setIcon(R.drawable.icon_happy_white).setTabListener(tabListener), getTabIndex() == 3);

	    
	}
	
	protected abstract int getTabIndex();
	
}
