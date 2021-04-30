package com.cloudsrcsoft.reportes.util;

import java.util.Iterator;
import java.util.List;


public class ReportesUtil {
    
	public static String getStringFromListString(List<String> lst) {
		String result = "";
		String separator = "|";
		
		Iterator<String> iterator = lst.iterator();
		while(iterator.hasNext()) {
			result += iterator.next();
			if(iterator.hasNext()) {
				result += separator;
			}
		}
		
		return result;
    }
	
	public static String[] getListFromString(String data){
		return data.split("Ã");
	}
	
	public static String getStringFromValue(String[] datos, int index) {
		try {
			if(datos[index] == null || datos[index].trim().isEmpty()) {
				return "";
			}
			
			return datos[index].trim();
		}catch(Exception ex){
			return "";
		}
	}
}
