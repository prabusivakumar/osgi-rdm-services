package com.scb.edmi.xml.bind;

import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;

public class DateTypeConverter {

	public static Calendar parseDateTime(String dateTime) {
		if (dateTime != null && dateTime.trim().length() > 0)
			return DatatypeConverter.parseDateTime(dateTime);
		else
			return null;
	}

	public static String printDateTime(Calendar dateTime) {
		return DatatypeConverter.printDateTime(dateTime);
	}
}
