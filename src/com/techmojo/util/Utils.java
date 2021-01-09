package com.techmojo.util;

import com.techmojo.exception.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private final static SimpleDateFormat formatDate = new SimpleDateFormat(" yyyy – MM – dd hh:mm a");

    public static Date convertToDate(String s[]){
        try{
            Date date = formatDate.parse(s[1] + s[2]);
            return date;
        }catch (ParseException e){
            throw new CustomException("Invalid Input");
        }

    }

}
