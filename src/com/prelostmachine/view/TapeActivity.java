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
import com.prelostmachine.adapter.TapeListAdapter;
import com.prelostmachine.utils.pojo.TapeBean;

public class TapeActivity extends BaseActivity{
	
	private ImageView backView;
	private TextView titleView;
	private ImageView tapeImage;
	private ListView tapeList;
	
	private TapeListAdapter mAdapter;
	private List<TapeBean> tapeData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tape);
		initView();
	}
	
	private void findViewById(){
		
		backView = (ImageView)findViewById(R.id.title_back);
		titleView = (TextView)findViewById(R.id.title_text);
		tapeImage = (ImageView)findViewById(R.id.tape_image);
		tapeList = (ListView)findViewById(R.id.tape_listview);
		
	}
	
	private void setListener(){
		
		backView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		tapeImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//TODO 开始录音
			}
		});
		
	}
	
	private void initView(){
		
		findViewById();
		titleView.setText("录音");
		tapeData = new ArrayList<TapeBean>();// TODO 此处需替换成获取录音的操作
		mAdapter = new TapeListAdapter(this,tapeData);
		tapeList.setAdapter(mAdapter);
		setListener();
		
	}
	
	
}
