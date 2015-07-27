package com.prelostmachine.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtils {

	private static SharedPreferencesUtils instanse;
	private SharedPreferences mSharedPreferences;
	private final String APP_INFO = "app_info";
	
	private final String IS_CLOSE_CALL_BELL = "is_close_call_bell";//ÊÇ·ñ¹Ø±Õ±¨¾¯Éù
	private final String IS_NOTICE = "is_notice";//ÊÇ·ñµ¯´°Í¨Öª
	private final String PRE_LOST_MACHINE = "pre_lost_machine";//·À¶ªÆ÷
	
	public SharedPreferencesUtils(Context context) {
		mSharedPreferences = context.getSharedPreferences(APP_INFO,
				Context.MODE_PRIVATE);
	}

	public static SharedPreferencesUtils createInstanse(Context context) {
		if (instanse == null) {
			instanse = new SharedPreferencesUtils(context);
		}
		return instanse;
	}

	public static SharedPreferencesUtils getInstanse(Context context) {
		if (instanse == null) {
			instanse = new SharedPreferencesUtils(context);
		}
		return instanse;
	}
	
	public void setIsCloseCallBell(boolean isAutoLogin){
		Editor editor = mSharedPreferences.edit();
		editor.putBoolean(IS_CLOSE_CALL_BELL, isAutoLogin);
		editor.commit();
	}
	
	public boolean getIsCloseCallBell(){
		boolean isCloseCallBell = mSharedPreferences.getBoolean(IS_CLOSE_CALL_BELL, false);
		return isCloseCallBell;
	}
	
	public void setIsNotice(boolean isAutoLogin){
		Editor editor = mSharedPreferences.edit();
		editor.putBoolean(IS_NOTICE, isAutoLogin);
		editor.commit();
	}
	
	public boolean getIsNotice(){
		boolean isNotice = mSharedPreferences.getBoolean(IS_NOTICE, false);
		return isNotice;
	}
	
	public void setPreLostMachine(boolean isAutoLogin){
		Editor editor = mSharedPreferences.edit();
		editor.putBoolean(PRE_LOST_MACHINE, isAutoLogin);
		editor.commit();
	}
	
	public boolean getPreLostMachine(){
		boolean preLostMachine = mSharedPreferences.getBoolean(PRE_LOST_MACHINE, false);
		return preLostMachine;
	}
	
}
