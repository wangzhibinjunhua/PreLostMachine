package com.prelostmachine.view;

import java.util.ArrayList;
import java.util.List;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.prelostmachine.BaseActivity;
import com.prelostmachine.R;
import com.prelostmachine.adapter.HomeListAdapter;
import com.prelostmachine.utils.pojo.DeviceBean;

public class HomeActivity extends BaseActivity {

	private static final int REQUEST_ENABLE_BT = 2;
	private static final long SCAN_PERIOD = 15 * 1000;// ɨ��ʱ��

	private ImageView backView;
	private TextView titleView;
	private TextView rightView;
	private ImageView searchRadio;// ������ť
	private TextView tipText;// ��ʾ����
	private ListView deviceList;// ���������豸

	private Handler mHandler;
	private HomeListAdapter mAdapter;
	private List<DeviceBean> deviceData;
	private BluetoothAdapter mBluetoothAdapter;
	private BluetoothManager bluetoothManager;
	private boolean mScanning;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		mHandler = new Handler();
		/**
		 * һ����Ӧ�ã��жϸ��豸�Ƿ�֧�ֶ�����BLE��֧��
		 */
		boolean isSupport = getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_BLUETOOTH_LE);
		if (isSupport) {
			initView();
		} else {
			Toast.makeText(this, "��ǰ�豸��֧����������4.0����", 600);
			finish();
		}

	}

	private void findViewById() {

		backView = (ImageView) findViewById(R.id.title_back);
		titleView = (TextView) findViewById(R.id.title_text);
		rightView = (TextView) findViewById(R.id.title_right_text);
		searchRadio = (ImageView) findViewById(R.id.home_page_search_btn);
		tipText = (TextView) findViewById(R.id.home_page_device_tip);
		deviceList = (ListView) findViewById(R.id.home_page_device_list);
	}

	private void setListener() {

		searchRadio.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				scanLeDevice(true);
			}
		});

	}

	private void initView() {
		findViewById();
		backView.setVisibility(View.GONE);
		titleView.setText("����С����");
		rightView.setText("����");
		titleView.setPadding(0, 15, 0, 15);

		deviceData = new ArrayList<DeviceBean>();
		mAdapter = new HomeListAdapter(this, deviceData);
		deviceList.setAdapter(mAdapter);

		bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
		mBluetoothAdapter = bluetoothManager.getAdapter();
		// ����δ��������������
		if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
			Intent enableBtIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		}

		setListener();

	}

	private void scanLeDevice(final boolean enable) {
		if (enable) {
			mHandler.postDelayed(new Runnable() {

				@Override
				public void run() {
					mScanning = false;
					mBluetoothAdapter.stopLeScan(mLeScanCallback);
				}

			}, SCAN_PERIOD);
			mScanning = true;
			mBluetoothAdapter.startLeScan(mLeScanCallback);
		}else{
			mScanning = false;
	        mBluetoothAdapter.stopLeScan(mLeScanCallback);
		}
	}

	/**
	 * ʵ���������ݻش��ӿ�
	 */
	private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {

		@Override
		public void onLeScan(final BluetoothDevice device, int rssi,
				byte[] scanRecord) {

			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					deviceData.add(new DeviceBean(R.drawable.bluetooth_icon,device.getName(), false));
					if(null!=deviceData&&deviceData.size()>0){
						deviceList.setVisibility(View.VISIBLE);
						tipText.setVisibility(View.GONE);
					}else{
						deviceList.setVisibility(View.GONE);
						tipText.setVisibility(View.VISIBLE);
					}
					mAdapter.notifyDataSetChanged();
				}

			});
		}

	};

}
