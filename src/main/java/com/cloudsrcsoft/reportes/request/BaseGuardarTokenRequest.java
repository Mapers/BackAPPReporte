package com.cloudsrcsoft.reportes.request;
import java.util.List;
public class BaseGuardarTokenRequest {
	private String notification_token;
	private String device;
	public String getNotification_token() {
		return notification_token;
	}
	public void setNotification_token(String notification_token) {
		this.notification_token = notification_token;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	
	
	
}