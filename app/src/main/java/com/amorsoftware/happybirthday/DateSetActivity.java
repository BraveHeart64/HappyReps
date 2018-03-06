package com.amorsoftware.happybirthday;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;




public class DateSetActivity extends AppCompatActivity {

    private static int day, month, year;



    public int setDay(int day) {

        return this.day = day;
    }


    public int setMonth(int month) {
        if (month == 0) {
            return month + 1;

        } else {
            return this.month = month - 1;

        }
    }

    public int getMonth(int month)
    {
        return this.month = month+1;
    }

    public int setYear(int year) {

        return this.year = year;
    }

    //Context con ;

    DatePicker datepicker;// questionable code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_date_set);
         datepicker = findViewById(R.id.datePicker);
        datepicker.updateDate(year, month, day);






    }






}
