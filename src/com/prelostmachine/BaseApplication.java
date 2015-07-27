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
 * 应用启动项，一些静态值在该类中进行初始化
 * @author LuoYong
 *
 */
public class BaseApplication extends Application{
	
	private final String TAG = BaseApplication.class.getSimpleName();

	public static Context mContext;
	private static Properties mProperties;
	public static BaseApplication instance;
	
	// 百度MapAPI的管理类
	public static BMapManager mBMapMan = null;
	boolean m_bKeyRight = true; // 授权Key正确，验证通过
	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this.getApplicationContext();
		init();
	}
	
	private void init() {
		loadConfigFile();//加载配置文件
	}
	
	private void initMap(){
		// 初始化百度地图
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
	 * 加载配置文件
	 */
	private void loadConfigFile() {
		mProperties = new Properties();
		try {
			InputStream input = BaseApplication.this.getAssets().open(
					"configuration.properties");
			mProperties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			Log.i(TAG, "加载配置文件出错:" + e.toString());
		}
	}
	
	/**
	 * Log开关
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
	
	// 常用事件监听，用来处理通常的网络错误，授权验证错误等
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
