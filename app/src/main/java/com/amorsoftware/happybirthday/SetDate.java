package com.BirthdayReminder.amorsoftware;

public class SetDate {
    private static String datetoscan;
    private String return_month;
    private String return_day;

    SetDate(String completedate) {
        this.datetoscan = completedate;

    }

    SetDate() {


    }


    public int datum(int counter, int val) { int stop = 0;
       // int counter = datetoscan.length();
        String days =  return_day = datetoscan;
        String[] datevalue = days.split("/",3);

            for(String string : datevalue){
                 //counter++;
                 stop++;
                 if(stop == counter){
                     val = Integer.parseInt(string);
                     break;
                 }
           }

        return val;
    }





    public int maxDaysInMonths(int day,int month){

        String error ="";
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day >= 32) {
                error = "breakday";
                day = Integer.parseInt(error);
            }
        }

        return day;
    }


    public int minDaysInMonths(int day, int month) {
        String error = "";

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 31 || day <= 0) {
                error = "breakday";
                day = Integer.parseInt(error);
            }
        }
        return day;
    }




    public int NegativeDateCheck(int  val){
        if (val <= -1 || val == 0) {
          String  error = "breakday";
            val = Integer.parseInt(error);
        }
        return val;
    }



    public int monthInBound(int month){
        if(month >= 13 ){
            String  error = "breakmonth";
            month = Integer.parseInt(error);

        }
        return month;
    }




}

