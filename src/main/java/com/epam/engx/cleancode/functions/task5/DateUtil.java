package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static final int DAY_START = 0;

	public Date convertToNextMidnight(Date date) {
		int nextDay = DAY_START + 1;
		Calendar midnight = convertToMidnight(date);
		midnight.add(Calendar.DATE, nextDay);
		return midnight.getTime();
	}

	public Date convertToPreviousMidnight(Date date) {
		int previousDay = DAY_START - 1;
		Calendar midnight = convertToMidnight(date);
		midnight.add(Calendar.DATE, previousDay);
		return midnight.getTime();
	}

	private Calendar convertToMidnight(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, DAY_START);
		calendar.set(Calendar.MINUTE, DAY_START);
		calendar.set(Calendar.SECOND, DAY_START);
		calendar.set(Calendar.MILLISECOND, DAY_START);
		return calendar;
	}
}
