package com.prelostmachine.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapView;
import com.prelostmachine.R;

public class MapLocationActivity extends MapActivity{

	private ImageView backView;
	private TextView titleView;
	private MapView mMapView;
	
	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		setContentView(R.layout.map);
		initView();
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	private void findViewById(){
		backView = (ImageView)findViewById(R.id.title_back);
		titleView = (TextView)findViewById(R.id.title_text);
		mMapView = (MapView)findViewById(R.id.prelost_machine_map);
	}
	
	private void setListener(){
		backView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	private void initView(){
		findViewById();
		titleView.setText("µØÍ¼");
		setListener();
	}

}
