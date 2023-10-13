package com.jungsoo.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * format에 대항하는 String 으로 변환
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public String dateToString(Date date, String format) {
		if (date != null && format != null) {
			SimpleDateFormat sfmt = new SimpleDateFormat(format);
			return sfmt.format(date);
		}
		return "";
		// return new SimpleDateFormat(format).format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm
	 * 해당 포맷의 String Date 변환
	 * 
	 * @param dateString
	 * @return
	 */
	public Date StringToDate(String dateString) {
		Date date = null;
		try {
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm",
			// Locale.getDefault());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * public java.sql.Date StringToSqlDate(String dateString) {
	 * java.sql.Date date = null;
	 * try {
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm",
	 * Locale.KOREA);
	 * date = new java.sql.Date(sdf.parse(dateString).getTime());
	 * } catch (ParseException e) {
	 * e.printStackTrace();
	 * }
	 * return date;
	 * }
	 */

	/**
	 * string date yyyyMMdd 를 먹으면 그 주의 일주일날짜를 yyyyMMdd 형식의 string[] 으로 반환
	 * 
	 * @param yyyymmdd
	 * @return
	 */
	@SuppressWarnings("static-access")
	public String[] weekCalendar(String yyyymmdd) {

		Calendar cal = Calendar.getInstance();
		int toYear = 0;
		int toMonth = 0;
		int toDay = 0;
		if (yyyymmdd == null || yyyymmdd.equals("")) { // 파라메타값이 없을경우 오늘날짜
			toYear = cal.get(cal.YEAR);
			toMonth = cal.get(cal.MONTH) + 1;
			toDay = cal.get(cal.DAY_OF_MONTH);

			int yoil = cal.get(cal.DAY_OF_WEEK); // 요일나오게하기(숫자로)

			if (yoil != 1) { // 해당요일이 일요일이 아닌경우
				yoil = yoil - 2;
			} else { // 해당요일이 일요일인경우
				yoil = 7;
			}
			cal.set(toYear, toMonth - 1, toDay - yoil); // 해당주월요일로 세팅
		} else {
			int yy = Integer.parseInt(yyyymmdd.substring(0, 4));
			int mm = Integer.parseInt(yyyymmdd.substring(4, 6)) - 1;
			int dd = Integer.parseInt(yyyymmdd.substring(6, 8));
			cal.set(yy, mm, dd);
		}
		String[] arrYMD = new String[7];

		int inYear = cal.get(cal.YEAR);
		int inMonth = cal.get(cal.MONTH);
		int inDay = cal.get(cal.DAY_OF_MONTH);
		int yoil = cal.get(cal.DAY_OF_WEEK); // 요일나오게하기(숫자로)
		if (yoil != 1) { // 해당요일이 일요일이 아닌경우
			yoil = yoil - 2;
		} else { // 해당요일이 일요일인경우
			yoil = 7;
		}
		inDay = inDay - yoil;
		for (int i = 0; i < 7; i++) {
			cal.set(inYear, inMonth, inDay + i); //
			String y = Integer.toString(cal.get(cal.YEAR));
			String m = Integer.toString(cal.get(cal.MONTH) + 1);
			String d = Integer.toString(cal.get(cal.DAY_OF_MONTH));
			if (m.length() == 1)
				m = "0" + m;
			if (d.length() == 1)
				d = "0" + d;

			arrYMD[i] = y + m + d;
			System.out.println("ymd =" + y + m + d);

		}

		return arrYMD;
	}
}
