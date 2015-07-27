package com.prelostmachine.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.prelostmachine.BaseActivity;
import com.prelostmachine.R;

public class DetailActivity extends BaseActivity implements OnClickListener{

	private ImageView backView;
	private TextView titleView;
	private ImageView deviceImg;
	private TextView deviceName;
	private SeekBar distanceSeek;
	private RelativeLayout takeLayout;
	private RelativeLayout tapeLayout;
	private RelativeLayout mapLayout;
	private RelativeLayout setLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.device_detail);
		initView();
	}

	private void findViewById() {

		backView = (ImageView) findViewById(R.id.title_back);
		titleView = (TextView) findViewById(R.id.title_text);
		deviceImg = (ImageView)findViewById(R.id.detail_image);
		deviceName = (TextView) findViewById(R.id.detail_name);
		distanceSeek = (SeekBar) findViewById(R.id.detail_seekbar);
		takeLayout = (RelativeLayout)findViewById(R.id.take_layout);
		tapeLayout = (RelativeLayout)findViewById(R.id.tape_layout);
		mapLayout = (RelativeLayout)findViewById(R.id.map_layout);
		setLayout = (RelativeLayout)findViewById(R.id.set_layout);
		
	}
	
	private void setListener(){
		backView.setOnClickListener(this);
		takeLayout.setOnClickListener(this);
		tapeLayout.setOnClickListener(this);
		mapLayout.setOnClickListener(this);
		setLayout.setOnClickListener(this);
	}
	
	private void initView(){
		findViewById();
		titleView.setText("ฯ๊ว้");
		
		setListener();
	}

	@Override
	public void onClick(View v) {
		int resId = v.getId();
		switch(resId){
		case R.id.title_back:
			finish();
			break;
		case R.id.take_layout:
			break;
		case R.id.tape_layout:
			break;
		case R.id.map_layout:
			break;
		case R.id.set_layout:
			break;
		}
	}

}
