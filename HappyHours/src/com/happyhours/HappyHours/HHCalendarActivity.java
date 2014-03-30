package com.happyhours.HappyHours;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class HHCalendarActivity extends HappyHourBaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
		CalendarView cv = (CalendarView) findViewById(R.id.calendar);
		cv.setOnDateChangeListener(new OnDateChangeListener(){
			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				Intent intent = new Intent(HHCalendarActivity.this, BarListActivity.class);
        		startActivity(intent);
			}			
		});
	}
	
	@Override
	protected int getTabIndex() {
		return 2;
	}

}
