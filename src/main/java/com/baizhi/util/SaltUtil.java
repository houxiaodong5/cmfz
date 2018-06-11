package com.baizhi.util;

import java.util.Random;

/**
 * Created by Administrator on 2018/6/6.
 */
public class SaltUtil {
    public static  String getSalt(){
        String ss="abcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(ss.length());
            sb.append(ss.charAt(number));
        }
        return sb.toString();
    }
    public static  String getCheckCode(){
        String ss="0123456789";
        Random random=new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(ss.length());
            sb.append(ss.charAt(number));
        }
        return sb.toString();
    }

}
