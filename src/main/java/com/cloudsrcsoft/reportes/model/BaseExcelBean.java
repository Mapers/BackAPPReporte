package com.cloudsrcsoft.reportes.model;

import java.util.Map;

public class BaseExcelBean {
	private String[] columns;
	private Map<String, Object[]> data;
	private String sheetName;
	private int size;
	
	public BaseExcelBean(){
		
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public Map<String, Object[]> getData() {
		return data;
	}

	public void setData(Map<String, Object[]> data) {
		this.data = data;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

	
}
