package com.prelostmachine.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.prelostmachine.BaseActivity;
import com.prelostmachine.R;
import com.prelostmachine.utils.SharedPreferencesUtils;

public class SettingActivity extends BaseActivity implements OnCheckedChangeListener,OnClickListener{
	
	private ImageView backView;
	private TextView titleView;
	private TextView goodsName;
	private TextView bellName;
	private RelativeLayout goodsLayout;
	private RelativeLayout bellLayout;
	private ToggleButton callBellToggle;
	private ToggleButton noticeToggle;
	private ToggleButton plmachineToggle;
	private Button ignoreplmBtn;
	
	private Intent mIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		initView();
	}
	
	private void findViewById(){
		
		backView = (ImageView)findViewById(R.id.title_back);
		titleView = (TextView)findViewById(R.id.title_text);
		
		goodsName = (TextView)findViewById(R.id.goods_name);
		bellName = (TextView)findViewById(R.id.bell_name);
		goodsLayout = (RelativeLayout)findViewById(R.id.goods_layout);
		bellLayout = (RelativeLayout)findViewById(R.id.bell_layout);
		callBellToggle = (ToggleButton)findViewById(R.id.call_bell_toggle);
		noticeToggle = (ToggleButton)findViewById(R.id.popup_notice);
		plmachineToggle = (ToggleButton)findViewById(R.id.prelost_machine);
		ignoreplmBtn = (Button)findViewById(R.id.ignore_prelost_machine);
		
	}
	
	private void setListener(){
		backView.setOnClickListener(this);
		goodsLayout.setOnClickListener(this);
		bellLayout.setOnClickListener(this);
		ignoreplmBtn.setOnClickListener(this);
		callBellToggle.setOnCheckedChangeListener(this);
		noticeToggle.setOnCheckedChangeListener(this);
		plmachineToggle.setOnCheckedChangeListener(this);
		
	}
	
	private void initView(){
		
		findViewById();
		titleView.setText("ÉèÖÃ");
		setListener();
		
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(buttonView==callBellToggle){
			if(isChecked){
				SharedPreferencesUtils.getInstanse(this).setIsCloseCallBell(true);
			}else{
				SharedPreferencesUtils.getInstanse(this).setIsCloseCallBell(false);
			}
		}else if(buttonView==noticeToggle){
			if(isChecked){
				SharedPreferencesUtils.getInstanse(this).setIsNotice(true);
			}else{
				SharedPreferencesUtils.getInstanse(this).setIsNotice(false);
			}
		}else if(buttonView==plmachineToggle){
			if(isChecked){
				SharedPreferencesUtils.getInstanse(this).setPreLostMachine(true);
			}else{
				SharedPreferencesUtils.getInstanse(this).setPreLostMachine(false);
			}
		}
	}

	@Override
	public void onClick(View v) {
		int resId = v.getId();
		switch(resId){
		case R.id.title_back:
			finish();
			break;
		case R.id.goods_layout:
			mIntent = new Intent(this,ChooseDeviceActivity.class);
			startActivity(mIntent);
			break;
		case R.id.bell_layout:
			//TODO Ñ¡ÔñÁåÉù
			break;
		case R.id.ignore_prelost_machine:
			//TODO ºöÂÔ´Ë·À¶ªÆ÷
			break;
		}
	}
	
}
