package com.tech.movie.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class ToolsUtil {

    //构造date
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-kk-mm-ss");

    //解析date
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * 获取随机序列
     * @param length
     * @return
     */

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机整数
     * @param length
     * @return
     */
    public static Integer getRandomInteger(int length){
        String str="123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(9);
            sb.append(str.charAt(number));
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * 两个日期的差值（单位:天）
     * @param date1
     * @param date2
     * @return
     */
    public  static int differentDayMillisecond(Date date1, Date date2)
    {
        int day = (int)((date2.getTime()-date1.getTime())/(3600*1000*24));
        return day;
    }
    
    
    /**
     * 字符串转int
     * @param s
     * @return
     */
	public int StrToInt(String s) {
		try {
			return Integer.parseInt(CheckReplace(s));
		} catch (Exception e) {
		}
		return 0;
	}

	/**
	 * 字符串转布尔型
	 * @param s
	 * @return
	 */
	public boolean StringToBoolean(String s) {
		if ((s != null) && (s.equals("Yes")))
			return true;
		return false;
	}
	
	public String CheckReplace(String s) {
		try {
			if ((s == null) || (s.equals("")))
				return "";

			StringBuffer stringbuffer = new StringBuffer();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch (c) {
				case '"':
					stringbuffer.append("&quot;");
					break;
				case '\'':
					stringbuffer.append("&#039;");
					break;
				case '|':
					stringbuffer.append("");
					break;
				case '&':
					stringbuffer.append("&amp;");
					break;
				case '<':
					stringbuffer.append("&lt;");
					break;
				case '>':
					stringbuffer.append("&gt;");
					break;
				default:
					stringbuffer.append(c);
				}
			}

			return stringbuffer.toString().trim();
		} catch (Exception e) {
		}
		return "";
	}

	public String CheckDate(String[] s1, String[] s2) {
		boolean OK = true;
		StringBuffer sb = new StringBuffer();
		try {
			for (int i = 0; i < s1.length; i++) {
				if ((s1[i] == null) || (s1[i].equals("")) || (s1[i].equals(" "))) {
					sb.append("<li> [ " + s2[i] + " ] 不能为空!");
					OK = false;
				}
			}
			if (OK)
				return "Yes";
			return sb.toString().trim();
		} catch (Exception e) {
		}
		return "操作失败！";
	}
}
