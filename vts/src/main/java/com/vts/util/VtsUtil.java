package com.vts.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class VtsUtil {

	public String getDate() {
		DateFormat format = new SimpleDateFormat("DD-MMM-YYYY");
		Calendar cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}

	public String getCurrentYear() {
		DateFormat format = new SimpleDateFormat("YYYY");
		Calendar cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}

	public String getPreviousYear() {
		Calendar prevYear = Calendar.getInstance();
		prevYear.add(Calendar.YEAR, -1);
		return prevYear.get(Calendar.YEAR)+"";
	}
}
