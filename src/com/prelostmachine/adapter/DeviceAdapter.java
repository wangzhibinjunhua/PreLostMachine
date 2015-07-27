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
import com.prelostmachine.utils.pojo.GoodsBean;

public class DeviceAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<GoodsBean> mListData;
	
	private int flag = -1;
	
	public DeviceAdapter(Context context,List<GoodsBean> list){
		this.mContext = context;
		this.mListData = list;
	}

	@Override
	public int getCount() {
		if(null!=mListData&&mListData.size()>0){
			return mListData.size();
		}else{
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return mListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(R.layout.choose_device_item, null);
		TextView name = (TextView)convertView.findViewById(R.id.device_name);
		ImageView tick = (ImageView)convertView.findViewById(R.id.device_tick);
		
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				flag = position;
			}
		});
		
		if(flag==position){
			tick.setVisibility(View.VISIBLE);
		}else{
			tick.setVisibility(View.GONE);
		}
		
		return convertView;
	}

}
