package com.prelostmachine.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.prelostmachine.R;
import com.prelostmachine.utils.pojo.SearchResultBean;

public class SearchResultAdapter extends BaseAdapter{

	private Context mContext;
	private List<SearchResultBean> listData;
	
	public SearchResultAdapter(Context context,List<SearchResultBean> list){
		this.mContext = context;
		this.listData = list;
	}
	
	@Override
	public int getCount() {
		if(null!=listData&&listData.size()>0){
			return listData.size();
		}else{
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return listData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(R.layout.search_result_item, null);
		TextView name = (TextView)convertView.findViewById(R.id.search_result_item_name);
		TextView address = (TextView)convertView.findViewById(R.id.search_result_item_ip);
		Button connect = (Button)convertView.findViewById(R.id.search_result_connected);
		
		name.setText(listData.get(position).getName());
		address.setText(listData.get(position).getAddress());
		boolean isConnected = listData.get(position).isIsconnected();
		if(isConnected){
			connect.setBackgroundResource(R.drawable.connected_btn);
		}else{
			connect.setBackgroundResource(R.drawable.notconnect_btn);
		}
		return convertView;
	}
}
