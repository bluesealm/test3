package com.wf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public String getnowDate(String format){
    	SimpleDateFormat simp=new SimpleDateFormat(format);
    	String nowStr="";
    	nowStr=simp.format(new Date());
    	return nowStr;
    }
    public String getDate(String format,int days){
    	Calendar calendar  = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }
    
   //测试github pull
    //分支testChildBranch
}
