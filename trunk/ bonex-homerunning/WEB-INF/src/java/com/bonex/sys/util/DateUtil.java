/*
 * $Id: DateUtil.java 98782 2008-08-28 03:05:26Z pengs $
 * Copyright(C) 2007-2008 Information Services International-Dentsu, LTD.
 */
package com.bonex.sys.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiewj
 *
 */
public class DateUtil {
    
    /** パターン(yyyyMMdd) */
    public static final String DATE_PATTERN_0 = "yyyyMMdd";
    
    /** パターン(yyyyMMddHHmmssSSS) */
    public static final String DATE_PATTERN_1 = "yyyyMMddHHmmssSSS";
    
    /** パターン(yyyy/MM/dd) */
    public static final String DATE_PATTERN_2 = "yyyy/MM/dd";
    
    /** パターン(yyyy/MM/dd HH:mm:ss) */
    public static final String DATE_PATTERN_3 = "yyyy/MM/dd HH:mm:ss";
    
    /** パターン(yy/MM/dd) */
    public static final String DATE_PATTERN_4 = "yy/MM/dd";
    
    /** パターン(yyyy/MM/dd HH:mm:ss.SSS) */
    public static final String DATE_PATTERN_5 = "yyyy/MM/dd HH:mm:ss.SSS";
    
    /** パターン(yyyyMM) */
    public static final String DATE_PATTERN_6 = "yyyyMM";
    
    /** パターン(yyMMdd) */
    public static final String DATE_PATTERN_7 = "yyMMdd";

    /** パターン(yyyy-MM-dd HH:mm:ss.SSS) */
    public static final String DATE_PATTERN_8 = "yyyy-MM-dd HH:mm:ss.SSS";
    
    /** パターン(yyyy/MM/dd HH:mm) */
    public static final String DATE_PATTERN_9 = "yyyy/MM/dd HH:mm";
    
    /** パターン(yyyy/MM) */
    public static final String DATE_PATTERN_10 = "yyyy/MM";

    /** パターン(yyyyMMddHHmmss) */
    public static final String DATE_PATTERN_11 = "yyyyMMddHHmmss";

    /** パターン(yyyy年MM月dd日) */
    public static final String DATE_PATTERN_12 = "yyyy年MM月dd日";
    
    /** パターン(yy/MM) */
    public static final String DATE_PATTERN_13 = "yy/MM";
    
    /** パターン(yy/MM/dd HH:mm:ss) */
    public static final String DATE_PATTERN_14 = "yy/MM/dd HH:mm:ss";
    
    /** パターン(yy年MM月dd日) */
    public static final String DATE_PATTERN_15 = "yy年MM月dd日";

    /** パターン(yy/MM/dd HH:mm) */
    public static final String DATE_PATTERN_16 = "yy/MM/dd HH:mm";
    
    /** パターン(yyyy-MM-dd) */
    public static final String DATE_PATTERN_17 = "yyyy-MM-dd";

    /**
     * 指定されたフォーマットによって、日付をフォーマットする。
     * @param date 　　日付
     * @param format フォーマット
     * @return 日付
     */
    public static String formatDate(Date date, String format) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }
    
    /**
     * 指定されたフォーマットによって、システム日付取得。
     * @param format フォーマット
     * @return 日付
     */
    public static String getCurrentDate(String format) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }

    /**
     * 指定されたフォーマットによって、システム日付演算機能
     * @param date 指定日付
     * @param days 追加される日付
     * @return String 日付
     */
    public static String addDays(String date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.toDate(date, DATE_PATTERN_0));
        calendar.add(Calendar.DATE, days);
        return DateUtil.formatDate(calendar.getTime(), DATE_PATTERN_0);
    }
    
    /**
     * 指定されたフォーマットによって、システム日付演算機能
     * @param date 指定日付
     * @param days 追加される日付
     * @return Timestamp 日付
     */
    public static Timestamp addDays(Timestamp date, int days) {
        if (null != date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, days);
            return new Timestamp(calendar.getTime().getTime());
        } else {
            return null;
        }
    }

    /**
     * 入力したストリングは入力フォーマットに着替える。
     * @param date 入力したストリング(NULL禁止)
     * @param format 入力したフォーマット(NULL禁止)
     * @return 着替える日付
     */
    public static Date toDate(String date, String format) {
        if (StringUtil.isEmpty(date)) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            return null;
        }
    } 
  
    /**
     * 指定されたフォーマットによって、日付をフォーマットする。
     * @param dateStr 　　日付
     * @param smft フォーマット
     * @return Timestamp 日付
     */
    public static Timestamp formatStrTOStampBySmt(String dateStr, String smft) {
        if (StringUtil.isEmpty(dateStr) || StringUtil.isEmpty(smft)) {
            return null;
        }
        Timestamp rs = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(smft);
            rs = new Timestamp(formatter.parse(dateStr).getTime());
            return rs;
        } catch (ParseException e) {
            return null;
        }
    }
    
    /**
     * 指定年月の日数を取得する。
     * @param yearMonth yyyyMM
     * @return int 指定年月の日数
     */
    public static int getDaysOfMonth(String yearMonth) {
        if (StringUtil.isEmpty(yearMonth)) {
            return 0;
        }
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(4, 6)) - 1;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * 「YYYYMM」とのフォーマットへYY/MM日付文字列を変換する。
     *
     * @param strDateYYYYMM オリジナル日付文字列
     * @return 変換後日付文字列
     */
    public static String formatDateYYYYMM(String strDateYYYYMM) {

        if (StringUtil.isEmpty(strDateYYYYMM)) {
            return StringUtil.BLANK;
        }
        if (strDateYYYYMM.trim().length() == 6) {
            String yy = strDateYYYYMM.substring(2, 4);
            String mm = strDateYYYYMM.substring(4);
            return yy + "/" + mm;
        }
        return strDateYYYYMM;
    }
    
    /**
     * 「YYYYMM」或いは「YY/MM」とのフォーマットへYYMM日付文字列を変換する。
     *
     * @param strDateYYYYMM オリジナル日付文字列
     * @return 変換後日付文字列
     */
    public static String formatDateToYYMM(String strDateYYYYMM) {

        if (StringUtil.isEmpty(strDateYYYYMM)) {
            return StringUtil.BLANK;
        }
        if (strDateYYYYMM.trim().length() == 6) {
            String yy = strDateYYYYMM.substring(2, 4);
            String mm = strDateYYYYMM.substring(4);
            return yy + mm;
            // 「YY/MM」の場合、 YYMM日付文字列に変換
        } else if (strDateYYYYMM.length() == 5) {
            return strDateYYYYMM.replaceAll("/", "");
        }

        return strDateYYYYMM;
    }
    
    /**
     * 指定年月と指定月数を加算する。
     * 
     * @param dt 指定年月
     * @param iMonth 指定月数
     * @return 計算したDate
     */
    public static Date getAddMonthEnday(Date dt, int iMonth) {
        if (null != dt) {
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.MONTH, iMonth + 1);
            c.set(Calendar.DATE, 1);
            c.add(Calendar.DAY_OF_MONTH, -1);
            return new Date(c.getTime().getTime());
        } else {
            return null;
        }
    }
    
    /**
     * 日付（YYYYMM）を指定された月分を加算して返す
     * 
     * @param date 入力した日付
     * @param months 入力した月数
     * @return 結果月分
     */
    public static String addMonths(String date, int months) {

        if ((date == null) || "".equals(date)) {
            return "";
        }

        try {

            //フォーマットの初期化
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_6);

            // 本月のカレンダーを設定する
            Calendar calendar = dateFormat.getCalendar();
            calendar.setTime(dateFormat.parse(date));
            // 来月のカレンダーを設定する
            Calendar calendarNext = (Calendar) calendar.clone();

            // 次の月数を計算する
            int nextM = calendar.get(Calendar.MONTH) + months;

            // 次の月分の最後日を取得する
            calendarNext.set(Calendar.DAY_OF_MONTH, 1);
            calendarNext.set(Calendar.MONTH, nextM + 1);
            calendarNext.add(Calendar.DATE, -1);
            // 指定した月分を設定する
            calendar.add(Calendar.MONTH, months);

            // 指定した月分を取得する
            if (calendar.after(calendarNext)) {
                calendar = calendarNext;
            }
            return dateFormat.format(calendar.getTime()).substring(4, 6);
            
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 指定されたフォーマットによって、システム日付演算機能
     * 
     * @param date 指定日付(YYYYMM)
     * @param months 追加される日付
     * @return String 日付(YYYYMM + 1)
     */
    public static String addMonth(String date, int months) {
        if ((date == null) || "".equals(date)) {
            return "";
        }

        try {

            //フォーマットの初期化
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_6);

            // 本月のカレンダーを設定する
            Calendar calendar = dateFormat.getCalendar();
            calendar.setTime(dateFormat.parse(date));
            // 来月のカレンダーを設定する
            Calendar calendarNext = (Calendar) calendar.clone();

            // 次の月数を計算する
            int nextM = calendar.get(Calendar.MONTH) + months;

            // 次の月分の最後日を取得する
            calendarNext.set(Calendar.DAY_OF_MONTH, 1);
            calendarNext.set(Calendar.MONTH, nextM + 1);
            calendarNext.add(Calendar.DATE, -1);
            // 指定した月分を設定する
            calendar.add(Calendar.MONTH, months);

            // 指定した月分を取得する
            if (calendar.after(calendarNext)) {
                calendar = calendarNext;
            }
            return dateFormat.format(calendar.getTime()).substring(0, 6);

        } catch (Exception ex) {
            return "";
        }
    }
}
