package com.prelostmachine.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.prelostmachine.R;
import com.prelostmachine.utils.pojo.TapeBean;

public class TapeListAdapter extends BaseAdapter{

	private Context mContext;
	private List<TapeBean> tapeData;
	
	public TapeListAdapter(Context context,List<TapeBean> list){
		this.mContext = context;
		this.tapeData = list;
	}
	
	@Override
	public int getCount() {
		if(null!=tapeData&&tapeData.size()>0){
			return tapeData.size();
		}else{
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return tapeData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		convertView = LayoutInflater.from(mContext).inflate(R.layout.tape_list_item, null);
		TextView name = (TextView)convertView.findViewById(R.id.tape_name);
		TextView date = (TextView)convertView.findViewById(R.id.tape_date);
		TextView duration = (TextView)convertView.findViewById(R.id.tape_duration);
		
		name.setText(tapeData.get(position).getName());
		date.setText(tapeData.get(position).getDate());
		duration.setText(tapeData.get(position).getDuration());
		
		return convertView;
	}

}
