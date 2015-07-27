package com.prelostmachine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKEvent;
import com.baidu.mapapi.MKGeneralListener;

/**
 * Ӧ�������һЩ��ֵ̬�ڸ����н��г�ʼ��
 * @author LuoYong
 *
 */
public class BaseApplication extends Application{
	
	private final String TAG = BaseApplication.class.getSimpleName();

	public static Context mContext;
	private static Properties mProperties;
	public static BaseApplication instance;
	
	// �ٶ�MapAPI�Ĺ�����
	public static BMapManager mBMapMan = null;
	boolean m_bKeyRight = true; // ��ȨKey��ȷ����֤ͨ��
	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this.getApplicationContext();
		init();
	}
	
	private void init() {
		loadConfigFile();//���������ļ�
	}
	
	private void initMap(){
		// ��ʼ���ٶȵ�ͼ
		mBMapMan = new BMapManager(this);
//		mBMapMan.init(mStrKey, new MyGeneralListener());
		mBMapMan.getLocationManager().setNotifyInternal(10, 5);
	}
	
	public void setBaseApplication(BaseApplication application) {
		instance = application;
	}

	public static BaseApplication getBaseApplication() {
		return instance;
	}
	
	/**
	 * ���������ļ�
	 */
	private void loadConfigFile() {
		mProperties = new Properties();
		try {
			InputStream input = BaseApplication.this.getAssets().open(
					"configuration.properties");
			mProperties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			Log.i(TAG, "���������ļ�����:" + e.toString());
		}
	}
	
	/**
	 * Log����
	 * @return
	 */
	public static boolean isOpenLog() {
		String isOpenLog = mProperties.getProperty("isOpenLog").trim();
		if ("0".equals(isOpenLog)) {
			return true;
		} else {
			return false;
		}
	}
	
	// �����¼���������������ͨ�������������Ȩ��֤�����
	public static class MyGeneralListener implements MKGeneralListener {
		@Override
		public void onGetNetworkState(int iError) {
		}

		@Override
		public void onGetPermissionState(int iError) {
			if (iError == MKEvent.ERROR_PERMISSION_DENIED) {
				instance.m_bKeyRight = false;
			}
		}
	}

}
