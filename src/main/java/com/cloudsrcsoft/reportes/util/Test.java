package com.cloudsrcsoft.reportes.util;

import java.util.Calendar;

public class Test {
	public static void main(String args[]) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis() + 604798L);
		System.out.println(calendar.getTime());
	}
}
