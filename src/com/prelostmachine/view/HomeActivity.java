package com.prelostmachine.view;

import java.util.ArrayList;
import java.util.List;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
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
import com.prelostmachine.widget.SycleSearchView;

public class HomeActivity extends BaseActivity {

	private static final int REQUEST_ENABLE_BT = 2;
	private static final long SCAN_PERIOD = 30 * 1000;// 扫描时间

	private ImageView backView;
	private TextView titleView;
	private TextView rightView;
	private ImageView searchRadio;// 搜索按钮
//	private SycleSearchView searchBtn;
	private TextView tipText;// 提示文字
	private ListView deviceList;// 搜索到的设备

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
		 * 一进入应用，判断该设备是否支持对蓝牙BLE的支持
		 */
		boolean isSupport = getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_BLUETOOTH_LE);
		if (isSupport) {
			initView();
		} else {
			Toast.makeText(this, "当前设备不支持最新蓝牙4.0技术", 600);
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
				deviceData.clear();
				scanLeDevice(true);
			}
		});
		
		rightView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeActivity.this,SettingActivity.class);
				startActivity(intent);
			}
		});

	}

	private void initView() {
		findViewById();
		backView.setVisibility(View.GONE);
		titleView.setText("防丢小助手");
		rightView.setText("帮助");
		titleView.setPadding(0, 15, 0, 15);

		deviceData = new ArrayList<DeviceBean>();
		mAdapter = new HomeListAdapter(this, deviceData);
		deviceList.setAdapter(mAdapter);

		bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
		mBluetoothAdapter = bluetoothManager.getAdapter();
		// 蓝牙未开启，开启蓝牙
		if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
			Intent enableBtIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		}

		setListener();
	}

	/**
	 * 搜索设备
	 * @param enable
	 */
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
	 * 实现蓝牙数据回传接口
	 */
	private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {

		@Override
		public void onLeScan(final BluetoothDevice device, int rssi,
				byte[] scanRecord) {
			deviceData.add(new DeviceBean(device,rssi,scanRecord));
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					//单启线程刷新列表
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
			
			connected(device);
			
		}

	};
	
	private void connected(BluetoothDevice device){
		BluetoothGatt gatt = device.connectGatt(this,false,gattCallback);
		boolean isConnected = gatt.connect();
		if(isConnected){
			System.out.println("连接成功============================================");
		}else{
			System.out.println("连接失败============================================");
		}
	}
	
	
	private BluetoothGattCallback gattCallback = new BluetoothGattCallback(){
		
		@Override
		public void onCharacteristicChanged(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic) {
			super.onCharacteristicChanged(gatt, characteristic);
		}
		
		@Override
		public void onCharacteristicRead(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic, int status) {
			super.onCharacteristicRead(gatt, characteristic, status);
		}
		
		@Override
		public void onCharacteristicWrite(BluetoothGatt gatt,
				BluetoothGattCharacteristic characteristic, int status) {
			super.onCharacteristicWrite(gatt, characteristic, status);
		}
		
		@Override
		public void onConnectionStateChange(BluetoothGatt gatt, int status,
				int newState) {
			super.onConnectionStateChange(gatt, status, newState);
		}
		
		@Override
		public void onDescriptorRead(BluetoothGatt gatt,
				BluetoothGattDescriptor descriptor, int status) {
			super.onDescriptorRead(gatt, descriptor, status);
		}
		
		@Override
		public void onDescriptorWrite(BluetoothGatt gatt,
				BluetoothGattDescriptor descriptor, int status) {
			super.onDescriptorWrite(gatt, descriptor, status);
		}
		
		@Override
		public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
			super.onReadRemoteRssi(gatt, rssi, status);
		}
		
		@Override
		public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {
			super.onReliableWriteCompleted(gatt, status);
		}
		
		@Override
		public void onServicesDiscovered(BluetoothGatt gatt, int status) {
			super.onServicesDiscovered(gatt, status);
		}
		
	};

}
