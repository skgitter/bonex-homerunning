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
    
    /** �p�^�[��(yyyyMMdd) */
    public static final String DATE_PATTERN_0 = "yyyyMMdd";
    
    /** �p�^�[��(yyyyMMddHHmmssSSS) */
    public static final String DATE_PATTERN_1 = "yyyyMMddHHmmssSSS";
    
    /** �p�^�[��(yyyy/MM/dd) */
    public static final String DATE_PATTERN_2 = "yyyy/MM/dd";
    
    /** �p�^�[��(yyyy/MM/dd HH:mm:ss) */
    public static final String DATE_PATTERN_3 = "yyyy/MM/dd HH:mm:ss";
    
    /** �p�^�[��(yy/MM/dd) */
    public static final String DATE_PATTERN_4 = "yy/MM/dd";
    
    /** �p�^�[��(yyyy/MM/dd HH:mm:ss.SSS) */
    public static final String DATE_PATTERN_5 = "yyyy/MM/dd HH:mm:ss.SSS";
    
    /** �p�^�[��(yyyyMM) */
    public static final String DATE_PATTERN_6 = "yyyyMM";
    
    /** �p�^�[��(yyMMdd) */
    public static final String DATE_PATTERN_7 = "yyMMdd";

    /** �p�^�[��(yyyy-MM-dd HH:mm:ss.SSS) */
    public static final String DATE_PATTERN_8 = "yyyy-MM-dd HH:mm:ss.SSS";
    
    /** �p�^�[��(yyyy/MM/dd HH:mm) */
    public static final String DATE_PATTERN_9 = "yyyy/MM/dd HH:mm";
    
    /** �p�^�[��(yyyy/MM) */
    public static final String DATE_PATTERN_10 = "yyyy/MM";

    /** �p�^�[��(yyyyMMddHHmmss) */
    public static final String DATE_PATTERN_11 = "yyyyMMddHHmmss";

    /** �p�^�[��(yyyy�NMM��dd��) */
    public static final String DATE_PATTERN_12 = "yyyy�NMM��dd��";
    
    /** �p�^�[��(yy/MM) */
    public static final String DATE_PATTERN_13 = "yy/MM";
    
    /** �p�^�[��(yy/MM/dd HH:mm:ss) */
    public static final String DATE_PATTERN_14 = "yy/MM/dd HH:mm:ss";
    
    /** �p�^�[��(yy�NMM��dd��) */
    public static final String DATE_PATTERN_15 = "yy�NMM��dd��";

    /** �p�^�[��(yy/MM/dd HH:mm) */
    public static final String DATE_PATTERN_16 = "yy/MM/dd HH:mm";
    
    /** �p�^�[��(yyyy-MM-dd) */
    public static final String DATE_PATTERN_17 = "yyyy-MM-dd";

    /**
     * �w�肳�ꂽ�t�H�[�}�b�g�ɂ���āA���t���t�H�[�}�b�g����B
     * @param date �@�@���t
     * @param format �t�H�[�}�b�g
     * @return ���t
     */
    public static String formatDate(Date date, String format) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }
    
    /**
     * �w�肳�ꂽ�t�H�[�}�b�g�ɂ���āA�V�X�e�����t�擾�B
     * @param format �t�H�[�}�b�g
     * @return ���t
     */
    public static String getCurrentDate(String format) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }

    /**
     * �w�肳�ꂽ�t�H�[�}�b�g�ɂ���āA�V�X�e�����t���Z�@�\
     * @param date �w����t
     * @param days �ǉ��������t
     * @return String ���t
     */
    public static String addDays(String date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.toDate(date, DATE_PATTERN_0));
        calendar.add(Calendar.DATE, days);
        return DateUtil.formatDate(calendar.getTime(), DATE_PATTERN_0);
    }
    
    /**
     * �w�肳�ꂽ�t�H�[�}�b�g�ɂ���āA�V�X�e�����t���Z�@�\
     * @param date �w����t
     * @param days �ǉ��������t
     * @return Timestamp ���t
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
     * ���͂����X�g�����O�͓��̓t�H�[�}�b�g�ɒ��ւ���B
     * @param date ���͂����X�g�����O(NULL�֎~)
     * @param format ���͂����t�H�[�}�b�g(NULL�֎~)
     * @return ���ւ�����t
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
     * �w�肳�ꂽ�t�H�[�}�b�g�ɂ���āA���t���t�H�[�}�b�g����B
     * @param dateStr �@�@���t
     * @param smft �t�H�[�}�b�g
     * @return Timestamp ���t
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
     * �w��N���̓������擾����B
     * @param yearMonth yyyyMM
     * @return int �w��N���̓���
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
     * �uYYYYMM�v�Ƃ̃t�H�[�}�b�g��YY/MM���t�������ϊ�����B
     *
     * @param strDateYYYYMM �I���W�i�����t������
     * @return �ϊ�����t������
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
     * �uYYYYMM�v�����́uYY/MM�v�Ƃ̃t�H�[�}�b�g��YYMM���t�������ϊ�����B
     *
     * @param strDateYYYYMM �I���W�i�����t������
     * @return �ϊ�����t������
     */
    public static String formatDateToYYMM(String strDateYYYYMM) {

        if (StringUtil.isEmpty(strDateYYYYMM)) {
            return StringUtil.BLANK;
        }
        if (strDateYYYYMM.trim().length() == 6) {
            String yy = strDateYYYYMM.substring(2, 4);
            String mm = strDateYYYYMM.substring(4);
            return yy + mm;
            // �uYY/MM�v�̏ꍇ�A YYMM���t������ɕϊ�
        } else if (strDateYYYYMM.length() == 5) {
            return strDateYYYYMM.replaceAll("/", "");
        }

        return strDateYYYYMM;
    }
    
    /**
     * �w��N���Ǝw�茎�������Z����B
     * 
     * @param dt �w��N��
     * @param iMonth �w�茎��
     * @return �v�Z����Date
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
     * ���t�iYYYYMM�j���w�肳�ꂽ���������Z���ĕԂ�
     * 
     * @param date ���͂������t
     * @param months ���͂�������
     * @return ���ʌ���
     */
    public static String addMonths(String date, int months) {

        if ((date == null) || "".equals(date)) {
            return "";
        }

        try {

            //�t�H�[�}�b�g�̏�����
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_6);

            // �{���̃J�����_�[��ݒ肷��
            Calendar calendar = dateFormat.getCalendar();
            calendar.setTime(dateFormat.parse(date));
            // �����̃J�����_�[��ݒ肷��
            Calendar calendarNext = (Calendar) calendar.clone();

            // ���̌������v�Z����
            int nextM = calendar.get(Calendar.MONTH) + months;

            // ���̌����̍Ō�����擾����
            calendarNext.set(Calendar.DAY_OF_MONTH, 1);
            calendarNext.set(Calendar.MONTH, nextM + 1);
            calendarNext.add(Calendar.DATE, -1);
            // �w�肵��������ݒ肷��
            calendar.add(Calendar.MONTH, months);

            // �w�肵���������擾����
            if (calendar.after(calendarNext)) {
                calendar = calendarNext;
            }
            return dateFormat.format(calendar.getTime()).substring(4, 6);
            
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * �w�肳�ꂽ�t�H�[�}�b�g�ɂ���āA�V�X�e�����t���Z�@�\
     * 
     * @param date �w����t(YYYYMM)
     * @param months �ǉ��������t
     * @return String ���t(YYYYMM + 1)
     */
    public static String addMonth(String date, int months) {
        if ((date == null) || "".equals(date)) {
            return "";
        }

        try {

            //�t�H�[�}�b�g�̏�����
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_6);

            // �{���̃J�����_�[��ݒ肷��
            Calendar calendar = dateFormat.getCalendar();
            calendar.setTime(dateFormat.parse(date));
            // �����̃J�����_�[��ݒ肷��
            Calendar calendarNext = (Calendar) calendar.clone();

            // ���̌������v�Z����
            int nextM = calendar.get(Calendar.MONTH) + months;

            // ���̌����̍Ō�����擾����
            calendarNext.set(Calendar.DAY_OF_MONTH, 1);
            calendarNext.set(Calendar.MONTH, nextM + 1);
            calendarNext.add(Calendar.DATE, -1);
            // �w�肵��������ݒ肷��
            calendar.add(Calendar.MONTH, months);

            // �w�肵���������擾����
            if (calendar.after(calendarNext)) {
                calendar = calendarNext;
            }
            return dateFormat.format(calendar.getTime()).substring(0, 6);

        } catch (Exception ex) {
            return "";
        }
    }
}
