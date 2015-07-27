package com.prelostmachine.view;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.prelostmachine.BaseActivity;
import com.prelostmachine.R;
import com.prelostmachine.adapter.DeviceAdapter;
import com.prelostmachine.utils.pojo.GoodsBean;

public class ChooseDeviceActivity extends BaseActivity{
	
	private ImageView backView;
	private TextView titleView;
	private TextView tipText;//提示文字
	private ListView deviceList;//搜索到的设备
	
	private DeviceAdapter mAdapter;
	private List<GoodsBean> listData;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_device);
		initView();
	}
	
	private void findViewById(){
		
		backView = (ImageView)findViewById(R.id.title_back);
		titleView = (TextView)findViewById(R.id.title_text);
		tipText = (TextView)findViewById(R.id.choose_device_tip);
		deviceList = (ListView)findViewById(R.id.choose_device_listview);
		
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
		titleView.setText("名称");
		listData = new ArrayList<GoodsBean>();
		mAdapter = new DeviceAdapter(this,listData);
		if(null!=listData&&listData.size()>0){
			deviceList.setVisibility(View.VISIBLE);
			tipText.setVisibility(View.GONE);
		}else{
			deviceList.setVisibility(View.GONE);
			tipText.setVisibility(View.VISIBLE);
		}
		deviceList.setAdapter(mAdapter);
		setListener();
	}
	
}
