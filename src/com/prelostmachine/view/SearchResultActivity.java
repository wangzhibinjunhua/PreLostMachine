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
import com.prelostmachine.adapter.SearchResultAdapter;
import com.prelostmachine.utils.pojo.SearchResultBean;

public class SearchResultActivity extends BaseActivity{

	private ImageView backView;
	private TextView titleView;
	private ListView resultList;
	private TextView tipText;
	
	private SearchResultAdapter mAdapter;
	private List<SearchResultBean> listData;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_result);
		initView();
	}
	
	private void findViewById(){
		
		backView = (ImageView)findViewById(R.id.title_back);
		titleView = (TextView)findViewById(R.id.title_text);
		resultList = (ListView)findViewById(R.id.search_result_listview);
		tipText = (TextView)findViewById(R.id.search_result_tip);
		
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
		titleView.setText("ËÑË÷½á¹û");
		listData = new ArrayList<SearchResultBean>();
		mAdapter = new SearchResultAdapter(this,listData);
		getSimulation();
		if(null!=listData&&listData.size()>0){
			resultList.setVisibility(View.VISIBLE);
			tipText.setVisibility(View.GONE);
		}else{
			resultList.setVisibility(View.GONE);
			tipText.setVisibility(View.VISIBLE);
		}
		resultList.setAdapter(mAdapter);
		setListener();
	}
	
	private void getSimulation(){
		
		listData.add(new SearchResultBean("XIAOMI","4B-65-3C-0A-4E-7D",true));
		listData.add(new SearchResultBean("HUAWEI","4B-54-3C-76-4E-7D",false));
		listData.add(new SearchResultBean("MEIZU","4B-65-87-4M-4E-7D",false));
		
	}

}
