package com.even.exceptionretry.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class NoGenerateUtil {


    public String generateCustId(String prefix) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String da = format.format(date);
        long s = System.currentTimeMillis();
        return prefix + da + s;
    }


    public static void main(String[] args) {
        //System.out.println(generateCustId("I"));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String da = format.format(date);
        System.out.println(da);
    }
}
