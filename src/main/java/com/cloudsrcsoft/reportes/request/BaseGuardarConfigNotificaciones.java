package com.cloudsrcsoft.reportes.request;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

public class BaseGuardarConfigNotificaciones {

	public BaseGuardarConfigNotificaciones() {}

	public BaseGuardarConfigNotificaciones(Integer enable, LocalDate date, String type_query,
										   LinkedHashMap<String, Double> type_queries, LocalDate date_end, String type_send, List<String> specialities, Integer id) {
		super();
		this.enable = enable;
		this.date = date;
		this.type_query = type_query;
		this.type_queries = type_queries;
		this.date_end = date_end;
		this.type_send = type_send;
		this.specialities = specialities;
		this.id = id;
	}

	
	private Integer enable;
	private LocalDate date;
	private String type_query;
    private LinkedHashMap<String, Double> type_queries;
    private LocalDate date_end;
    private String type_send;
	private List<String> specialities;
	private Integer id;
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getType_query() {
		return type_query;
	}
	public void setType_query(String type_query) {
		this.type_query = type_query;
	}
	public LinkedHashMap<String, Double> getType_queries() {
		return type_queries;
	}
	public void setType_queries(LinkedHashMap<String, Double> type_queries) {
		this.type_queries = type_queries;
	}
	public LocalDate getDate_end() {
		return date_end;
	}
	public void setDate_end(LocalDate date_end) {
		this.date_end = date_end;
	}
	public String getType_send() {
		return type_send;
	}
	public void setType_send(String type_send) {
		this.type_send = type_send;
	}
	public List<String> getSpecialities() {
		return specialities;
	}
	public void setSpecialities(List<String> specialities) {
		this.specialities = specialities;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    

}
