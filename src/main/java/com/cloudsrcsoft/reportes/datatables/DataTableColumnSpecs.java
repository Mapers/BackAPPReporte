package com.cloudsrcsoft.reportes.datatables;

import javax.servlet.http.HttpServletRequest;

public class DataTableColumnSpecs {
	private int index;
	private String data;
	private String name;
	private boolean searchable;
	private boolean orderable;
	private String search;
	private String sortDir;
	private boolean regex;
	
	public DataTableColumnSpecs(HttpServletRequest request, int i) {
		this.setIndex(i);
		prepareColumnSpecs(request, i);
	}
	
	private void prepareColumnSpecs(HttpServletRequest request, int i) {
		this.setData(request.getParameter("columns["+ i +"][data]"));
		this.setName(request.getParameter("columns["+ i +"][name]"));
		this.setOrderable(Boolean.valueOf(request.getParameter("columns["+ i +"][orderable]")));
		this.setRegex(Boolean.valueOf(request.getParameter("columns["+ i +"][search][regex]")));
		this.setSearch(request.getParameter("columns["+ i +"][search][value]"));
		this.setSearchable(Boolean.valueOf(request.getParameter("columns["+ i +"][searchable]")));
		
		int sortableCol = Integer.parseInt(request.getParameter("order[0][column]"));
		String sortDir = request.getParameter("order[0][dir]");
		
		if(i == sortableCol) {
			this.setSortDir(sortDir);
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public boolean isOrderable() {
		return orderable;
	}

	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public boolean isRegex() {
		return regex;
	}

	public void setRegex(boolean regex) {
		this.regex = regex;
	}
	
	
	
}
