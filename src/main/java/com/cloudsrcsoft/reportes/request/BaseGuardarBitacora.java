package com.cloudsrcsoft.reportes.request;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BaseGuardarBitacora {
	public BaseGuardarBitacora(Date date, String type_phone, String type_model, String imei) {
		super();
		this.date = date;
		this.type_phone = type_phone;
		this.type_model = type_model;
		this.imei = imei;
	}
	private Date date;
	private String type_phone;
	private String type_model;
	private String imei;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType_phone() {
		return type_phone;
	}
	public void setType_phone(String type_phone) {
		this.type_phone = type_phone;
	}
	public String getType_model() {
		return type_model;
	}
	public void setType_model(String type_model) {
		this.type_model = type_model;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
}
