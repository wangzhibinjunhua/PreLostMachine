package com.prelostmachine.utils.pojo;

import android.bluetooth.BluetoothDevice;

public class DeviceBean {

	BluetoothDevice device;
	int rssi;
	byte[] scanrecord;

	public DeviceBean(BluetoothDevice device, int rssi, byte[] scanrecord) {
		this.device = device;
		this.rssi = rssi;
		this.scanrecord = scanrecord;
	}

	public BluetoothDevice getDevice() {
		return device;
	}

	public void setDevice(BluetoothDevice device) {
		this.device = device;
	}

	public int getRssi() {
		return rssi;
	}

	public void setRssi(int rssi) {
		this.rssi = rssi;
	}

	public byte[] getScanrecord() {
		return scanrecord;
	}

	public void setScanrecord(byte[] scanrecord) {
		this.scanrecord = scanrecord;
	}

}
