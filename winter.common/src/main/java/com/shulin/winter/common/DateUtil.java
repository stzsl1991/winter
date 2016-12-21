package com.shulin.winter.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * Created by shulin on 16/5/10.
 */
public class DateUtil {

    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String DATE_FORMAT_YMDHM ="yyyy-MM-dd HH:mm" ;
    public static final String DATE_FORMAT_YMD ="yyyy-MM-dd" ;

    public static Date long2Date(long millis) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millis);
        return c.getTime();
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd hh:MM:ss"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYMDHMS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd hh:MM"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYMDHHmm(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd hh:MM:ss"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYMDHM(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy年MM月dd日"
     *
     * @param date
     * @return
     */
    public static String convertDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        if (date != null) {
            return df.format(date);
        } else {
            return "";
        }
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy.MM.dd"
     *
     * @param date
     * @return
     */
    public static String convertDate1(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        if (date != null) {
            return df.format(date);
        } else {
            return "";
        }
    }

    /**
     * M月d日 HH:ss格式
     * @param date
     * @return
     */
    public static String convertsDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("M月d日 HH:mm");
        if (date != null) {
            return df.format(date);
        } else {
            return "";
        }
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM-dd"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYMD(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy-MM"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToYM(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        return f.format(date);
    }

    public static String convertDateToYMDHS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        return f.format(date);
    }

    /**
     * 格式化到毫秒，产生时间戳
     *
     * @param date
     * @return
     */
    public static String convertDateToYMDHMSS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmssSSS");
        return f.format(date);
    }

    public static String convertDateToStr(Date date,String formatStr) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat(formatStr);
        return f.format(date);
    }
    public static Date convertStrToDate(String dateStr,String formatStr) {
        SimpleDateFormat f = new SimpleDateFormat(formatStr);
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }

    public static String convertDateToYM1(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy_MM");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "MM-dd hh:MM"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateToMD(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("MM-dd");
        return f.format(date);
    }

    public static Date convertStringToDate(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }

    public static Date convertStringToHMS(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }

    public static Date addMonth(Date d, int diff){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(c.MONTH, diff);
        return c.getTime();
    }

    public static Date addDate(Date d, int diff){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(c.DATE, diff);
        return c.getTime();
    }

    public static String getMonthLastDay(Date d){

        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(c.MONTH, 1);
        c.add(c.DATE, -1);
        return convertDateToYMD(c.getTime());
    }

    public static Date convertStringToDateYMD(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }

    /**
     * String -> date
     *
     * @param dateStr
     * @param format <br/>
     *          1. yyyy-MM-dd<br/>
     *          2. yyyy-MM-dd HH:mm
     *          ...
     * @return
     *      date
     */
    public static Date convertStringToDate(String dateStr,String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }

        return null;
    }

    public static Date convertStringToDateYM(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }


    /**
     * @param dateStr
     * @return
     */
    public static Date convertStringToDateYMDHMS(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }

    /**
     * 获取Calendar的日期
     * "yyyy-MM-dd"
     *
     * @param cal 时间
     * @return 格式化以后的时间字符串
     */
    public static String getDate(Calendar cal) {
        String v_strDate = "";
        int v_intYear = cal.get(Calendar.YEAR);
        int v_intMonth = cal.get(Calendar.MONTH) + 1;
        int v_intDAY = cal.get(Calendar.DAY_OF_MONTH);

        v_strDate = v_strDate + v_intYear + "-";

        if (v_intMonth < 10) {
            v_strDate = v_strDate + "0" + v_intMonth + "-";
        } else {
            v_strDate = v_strDate + v_intMonth + "-";
        }
        if (v_intDAY < 10) {
            v_strDate = v_strDate + "0" + v_intDAY + "";
        } else {
            v_strDate = v_strDate + v_intDAY + "";
        }

        return v_strDate;
    }

    /**
     * 获取选定日期的目标间隔日期
     *
     * @param date   选定日期
     * @param number 间隔日期
     */
    public static String getDateStr(Date date, int number) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, number);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(calendar.getTime());
    }

    /**
     * 获取选定日期的目标间隔日期
     *
     * @param date   选定日期
     * @param number 间隔日期
     */
    public static Date getDateBy(Date date, int number) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, number);
        return calendar.getTime();
    }

    /** * 获取指定日期是星期几
     * 参数为null时表示获取当前日期是星期几
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekOfDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        if(date != null){
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return weekOfDays[w];
    }

    /**
     * 将日期本周内转化为星期，本周以外转化为xxxx年xx月xx日
     * @param date
     * @return
     */
    public static String getWeeksOfDate(Date date){
        if(date != null) {
            String da = DateUtil.getWeekOfDate(new Date());
            try {
                int count = daysBetween(date, new Date());
                if(da.equals("周一")){
                    if(count == 0){
                        return DateUtil.getWeekOfDate(date);
                    }else{
                        return DateUtil.convertDate(date);
                    }
                }
                if(da.equals("周二")){
                    if(count <= 1){
                        return DateUtil.getWeekOfDate(date);
                    }else{
                        return DateUtil.convertDate(date);
                    }
                }
                if(da.equals("周三")){
                    if(count <= 2){
                        return DateUtil.getWeekOfDate(date);
                    }else{
                        return DateUtil.convertDate(date);
                    }
                }
                if(da.equals("周四")){
                    if(count <= 3){
                        return DateUtil.getWeekOfDate(date);
                    }else{
                        return DateUtil.convertDate(date);
                    }
                }
                if(da.equals("周五")){
                    if(count <= 4){
                        return DateUtil.getWeekOfDate(date);
                    }else{
                        return DateUtil.convertDate(date);
                    }
                }
                if(da.equals("周六")){
                    if(count <= 5){
                        return DateUtil.getWeekOfDate(date);
                    }else{
                        return DateUtil.convertDate(date);
                    }
                }
                if(da.equals("周日")){
                    if(count <= 6){
                        return DateUtil.getWeekOfDate(date);
                    }else{
                        return DateUtil.convertDate(date);
                    }
                }
            } catch (ParseException p) {
                logger.error("日期解析错误", p);
            }
        }
        return null;

    }


    /**
     * 计算两个日期之间的天数
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     *
     * @param date
     * @param number
     * @return
     */
    public static String getDateStr2(Date date, int number) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, number);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(calendar.getTime());
    }

    /**
     * 指定日期格式化 yyyy-MM
     * @param date
     * @param number
     * @return
     */
    public static String getDateStr3(Date date, int number) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, number);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        return df.format(calendar.getTime());
    }


    /**
     * 比较两个时间的间隔天数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public static int getSpaceByCompareTwoDate(Date startTime,Date endTime){
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startTime);
        end.setTime(endTime);
        int betweenYears = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        int betweenDays = end.get(Calendar.DAY_OF_YEAR)
                - start.get(Calendar.DAY_OF_YEAR);
        for (int i = 0; i < betweenYears; i++) {
            start.set(Calendar.YEAR, (start.get(Calendar.YEAR) + 1));
            betweenDays += start.getMaximum(Calendar.DAY_OF_YEAR);
        }
        return betweenDays;
    }



    /**
     * 把时间类型转化为规定格式的字符串
     * "yyyy.MM.dd hh:MM:ss"
     *
     * @param date 时间
     * @return 格式化以后的时间字符串
     */
    public static String convertDateYMDHMS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return f.format(date);
    }

    /**
     * 把时间类型转化为规定格式的字符串
     * "HH:mm"
     *
     * @param date
     * @return
     */
    public static String convertDateToTime(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        return f.format(date);
    }

    /** create by jason 2015-07-20
     *  获得当天的开始时间 e.g. 2015-07-10 00 :00:00
     */
    public static Date getStartTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        Date startTime = todayStart.getTime();
        return startTime;
    }

    /** create by jason 2015-07-20
     *  获得当天的开始时间 e.g. 2015-07-10 00 :00:00
     */
    public static Date getStartTime(Date startTime) {
        if(startTime == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        startTime = calendar.getTime();
        return startTime;
    }

    /** create by jason 2015-07-20
     *  获得昨天的开始时间 e.g. 2015-07-10 00 :00:00
     */
    public static Date getYstdStartTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.DATE, todayStart.get(Calendar.DATE) - 1);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        Date startTime = todayStart.getTime();
        return startTime;
    }
    /** create by jason 2015-07-20
     *  获得当天的开始时间 e.g. 2015-07-10 23 :59:59
     */
    public static Date getEndTime(Date endTime){
        if(endTime == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endTime);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        endTime = calendar.getTime();
        return endTime;
    }


    /** create by jason 2015-11-07
     *  获得昨天的结束时间 e.g. 2015-11-07 59:59:59
     */
    public static Date getYstdEndTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.DATE, todayStart.get(Calendar.DATE) - 1);
        todayStart.set(Calendar.HOUR_OF_DAY, 23);
        todayStart.set(Calendar.MINUTE, 59);
        todayStart.set(Calendar.SECOND, 59);
        todayStart.set(Calendar.MILLISECOND, 59);
        Date startTime = todayStart.getTime();
        return startTime;
    }
    /**
     * 获取当前日期
     * @return
     */
    public static Date currentDate(){
        return new Date();
    }

    /**
     * 获取制定时间的月初时间，默认当月
     * @param dateTime
     * @return
     */
    public static Date getStartMonth(Date dateTime){
        Calendar calendar = Calendar.getInstance();
        if(dateTime != null){
            calendar.setTime(dateTime);
        }
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取制定时间的月末时间，默认当月
     * @param dateTime
     * @return
     */
    public static Date getEndMonth(Date dateTime){
        Calendar calendar = Calendar.getInstance();
        if(dateTime != null){
            calendar.setTime(dateTime);
        }
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取指定月份的第一天
     * 如现在是2015-12-14，
     * day = 1  ：返回2016-01-01
     * day = -1 ：返回2015-11-01
     * day = 0  ：返回2015-12-01
     *
     * @param day
     * @return
     */
    public static String getFirstMonthDay(Integer day){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, day);//设置月份
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String day_first = df.format(calendar.getTime());
        return day_first;
    }

    /**
     * 获取指定月份的最后一天
     *  如现在是2015-12-14，
     * day = 1  ：返回2016-01-31
     * day = -1 ：返回2015-11-30
     * day = 0  ：返回2015-12-31
     *
     * @param day
     * @return
     */
    public static String getLastMonthDay(Integer day){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,day);//设置月份
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号
        calendar.add(Calendar.MONTH, 1);//月增加1天
        calendar.add(Calendar.DAY_OF_MONTH, -1);//日期倒数一日,既得到此月份的最后一天
        String day_last = df.format(calendar.getTime());
        return day_last;
    }

    /**
     * 获取上一年
     *
     * @param date   当前日期
     * @param number 间隔
     * @return
     */
    public static Date getLastYear(Date date, int number) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, number);
        return calendar.getTime();
    }

    public static String convertDateToHMS(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
        return f.format(date);
    }

    public static Date queryDateToYM(String date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        Date time=null;
        try {
            time=f.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取上一月份的开始时间
     */
    public static Date getLastMonthStart(Date date){
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        time.add(Calendar.MONTH, -1);
        Date lastMonth=time.getTime();
        Date lastMonthStart=DateUtil.getStartMonth(lastMonth);
        return lastMonthStart;
    }


    /**
     * 任意一个时间，转成10的整数，全部进一位，比如5:31转成5:40
     *
     * @param date
     * @return
     */
    public static Date formatDate(Date date) {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        int minute = time.get(Calendar.MINUTE);
        if(minute>0) {
            time.set(Calendar.MINUTE, (minute / 10 + 1) * 10);
        }else{
            time.set(Calendar.MINUTE,0);
        }
        time.set(Calendar.SECOND, 0);
        Date result = time.getTime();
        return result;
    }



    public static String convertDateToHHmm(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        return f.format(date);
    }

    public static String convertDateToMMddHHmm(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat("MM-dd HH:mm");
        return f.format(date);
    }

    public static Date convertStringToHM(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }

    public static Date convertStringToyyyyMMddHHmm(String dateStr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            logger.error("转化为时间失败", e);
        }
        return null;
    }


    /**
     * 将这样的一个时间（Thu Jan 01 17:18:00 CST 1970）格式化为今天的17:18:00
     *
     * @param openDate
     * @param intervalDay 间隔天数
     * @return
     */
    public static Date formatDateToToday(Date openDate,Integer intervalDay) {
        Calendar open = Calendar.getInstance();
        open.setTime(openDate);
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        open.set(Calendar.YEAR, today.get(Calendar.YEAR));
        open.set(Calendar.MONTH, today.get(Calendar.MONTH));
        open.set(Calendar.DAY_OF_MONTH, today.get(Calendar.DAY_OF_MONTH)+intervalDay);
        return open.getTime();
    }

    /**
     * 计算时间差(秒)
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long computeSubSecond(Date startDate,Date endDate){
        if (startDate == null || endDate == null) {
            return null;
        }
        return (endDate.getTime() - startDate.getTime()) / 1000;
    }


    /**
     * 几秒后
     * @param currentDate
     * @param second
     * @return
     */
    public static Date afterSecondTime(Date currentDate, Integer second) {
        if (second == null){
            second = 0;
        }
        Calendar c = new GregorianCalendar();
        c.setTime(currentDate);//设置参数时间
        c.add(Calendar.SECOND,second);//把日期往后增加SECOND 秒.整数往后推,负数往前移动
        return c.getTime();
    }




}
