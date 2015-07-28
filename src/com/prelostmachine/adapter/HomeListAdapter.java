package com.prelostmachine.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prelostmachine.R;
import com.prelostmachine.utils.pojo.DeviceBean;

public class HomeListAdapter extends BaseAdapter{

	private Context mContext;
	private List<DeviceBean> deveiceData;
	private HomeListAdapter instance;
	
	public HomeListAdapter(Context context,List<DeviceBean> list){
		mContext = context;
		deveiceData = list;
		instance = this;
	}
	
	@Override
	public int getCount() {
		if(null!=deveiceData&&deveiceData.size()>0){
			return deveiceData.size();
		}else{
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return deveiceData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(R.layout.home_page_list_item, null);
		
		TextView name = (TextView)convertView.findViewById(R.id.home_page_item_myobject);
		TextView isbind = (TextView)convertView.findViewById(R.id.home_page_item_isbind);
		final ImageView face =  (ImageView)convertView.findViewById(R.id.home_page_item_face);
		final ImageView delect =  (ImageView)convertView.findViewById(R.id.home_page_item_delete);
		
		
		name.setText(deveiceData.get(position).getDevice().getName());
		isbind.setText(deveiceData.get(position).getDevice().getAddress());
		
		face.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				face.setImageResource(R.drawable.face_icon_2);
				delect.setVisibility(View.VISIBLE);
			}
		});
		
		delect.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				deveiceData.remove(position);
				instance.notifyDataSetChanged();
			}
		});
		
		return convertView;
	}

}
