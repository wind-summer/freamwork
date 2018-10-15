package com.my.core;

import java.security.Timestamp;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author wenlf
 * @date 2018/7/30
 */
public class Test {



    /*public static void main(String[] args) {
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
        System.out.println(new Date(current));//当前时间
        System.out.println(new Date(yesterday));//昨天这一时间点
        System.out.println(new Date(zero));//今天零点零分零秒
        System.out.println(new Date(twelve));//今天23点59分59秒
    }*/

    public static void main(String[] args) {
        String gzhCode = "---w-3--";
        String[] s = gzhCode.split("-");
        System.out.println(s.length);
    }
}