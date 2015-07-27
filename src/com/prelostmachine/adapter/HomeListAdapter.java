package com.prelostmachine.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prelostmachine.R;
import com.prelostmachine.utils.pojo.DeviceBean;

public class HomeListAdapter extends BaseAdapter{

	private Context mContext;
	private List<DeviceBean> deveiceData;
	
	public HomeListAdapter(Context context,List<DeviceBean> list){
		mContext = context;
		deveiceData = list;
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
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(R.layout.home_page_list_item, null);
		ImageView image = (ImageView)convertView.findViewById(R.id.home_page_item_image);
		TextView name = (TextView)convertView.findViewById(R.id.home_page_item_myobject);
		TextView isbind = (TextView)convertView.findViewById(R.id.home_page_item_isbind);
		
		image.setImageResource(deveiceData.get(position).getResource());
		name.setText(deveiceData.get(position).getName());
		boolean isBind = deveiceData.get(position).isIsbind();
		if(isBind){
			isbind.setText("ÒÑ°ó¶¨");
		}else{
			isbind.setText("Î´°ó¶¨");
		}
		return convertView;
	}

}
