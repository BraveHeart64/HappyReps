package com.BirthdayReminder.amorsoftware;

import java.util.Calendar;

/**
 * Created by ryan on 3/18/18.
 */

public class SpecialDates {
    Integer day = 0;
    Integer month = 0;
    Calendar calendar = Calendar.getInstance();
    Integer year = calendar.get(Calendar.YEAR);
    String keyvalue = ""; //  static crashes the program
    static String missingmonth = "";
    static int daycounter = 0;
    static int objectcounter = 0;

    // set the day with this constructor for this object
    public SpecialDates(String keyvalue, Integer day, Integer month,  Integer year) {
        this.keyvalue = setKey(keyvalue);
        this.month = setMonth(month);
        this.day = setDay(day);
        this.year = year;
        returnKeyValue();
        missingmonth = "month";
        daycounter = daycounter + 2;
        objectcounter ++;
    }



    public Integer setMonth(Integer month) {

        return month;
    }



    public Integer getMonth(){
        return month;
    }



    public Integer getDay(){
        return day;
    }
    public Integer getYear(){
        return year;
    }



    public Integer setDay(Integer day) {

        return day;
    }



    public String returnKeyValue(){

        return keyvalue;
    }




    public String setKey(String key) {

        return this.keyvalue = key;
    }



    public String getKey() {

        return keyvalue;
    }


    public String returnKey(){

        return keyvalue ;
    }

    public void CheckTodayDate(){
        Calendar today;
         today = calendar;


    }




}
