package com.example.librarydemo.DTO;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.text.ParseException;

public class CommonFunc {

    public static Date getCurrentDate() throws ParseException {
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        return date;
    }

    public static String getCurrentUsersUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }



}
