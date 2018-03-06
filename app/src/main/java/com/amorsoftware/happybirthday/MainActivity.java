package com.amorsoftware.happybirthday;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int day,month,year;
    private Calendar calendar;
    private  EditText dateInputText;
    private  Intent copy;
    private  int maxday = 3;
    public static final String load_day = "saved_day";
    public static final String load_month = "saved_smonth";
    public static final String mypref = "pref";


    DateSetActivity dateset = new DateSetActivity();
    SharedPreferences sharedPref;
    Button  savebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.savebutton = (Button)findViewById(R.id.ViewDate);
        sharedPref = getSharedPreferences (mypref,Context.MODE_PRIVATE);

        savebutton.setVisibility(View.GONE);
        dateInputText = findViewById(R.id.editText);
        calendar = Calendar.getInstance();
        day = getResources().getInteger(R.integer.saved_day);
        month = getResources().getInteger(R.integer.saved_smonth);


        year = calendar.get(Calendar.YEAR);
        loadData();

           savebutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                SharedPreferences.Editor edits = sharedPref.edit();



                edits.putInt(load_day,day);
                edits.putInt(load_month,month);

                edits.apply();


                FormDate();

                /*
                if(copy != null) {
                    copy.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(copy);
                }
*/
            }
        });






    }

    public void setDate(View view){
        Intent screen = new Intent(this,DateSetActivity.class);
        copy = Res(screen); // new edition
        savebutton.setVisibility(View.VISIBLE);
        String data = dateInputText.getText().toString();
        String temp = "";
        CharSequence montherror = "pick a number between 1 and 12";
        int digitcounter = 0;
        // loop for string iteration
try {
    for (int i = 1; i < data.length(); i++) {
        temp = data.substring(0, i); // read string and set position

        if (i>=maxday || temp.contains("/")) {
            i--;
            temp = data.substring(0, i);
            digitcounter = i;
            i = data.length();
            day = Integer.parseInt(temp);
            temp = "";
        }
        digitcounter++;

    }


    for (int i = 3; i < data.length(); i++) {
        temp = data.substring(digitcounter, i);//3
        if (temp.contains("/")) {
            --i;
            temp = data.substring(digitcounter, i);//5
            i = data.length();
            month = Integer.parseInt(temp);
            if (month <= 0 || month > 13) {
                temp = "monthbreaker";
                month = Integer.parseInt(temp);
                // required to break app for invaid months
            }
        }
    }


// limits the days based on months
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
        if (day >= 32 || day <= -1) {
            temp = "breakday";
            day = Integer.parseInt(temp);
        }
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
        if (day >= 31 || day <= -1) {
            temp = "breakday";
            day = Integer.parseInt(temp);
        }
    } else if (month == 2) { // deals with month of feburary and leapyar

        if (year % 4 == 0) {
            if (day >= 29) {
                temp = "noleapyearwrongdate";
                day = Integer.parseInt(temp);
            }
        } else {
            if (day >= 30) {
                temp = "leapyear";
                day = Integer.parseInt(temp);

            }
        }
    }
      dateset.setDay(day);
      dateset.setMonth(month);
      dateset.setYear(year);
      FormDate();
      startActivity(screen);
    }
      catch(NumberFormatException e){
       Context context = getApplicationContext();
       CharSequence text = "Enter a valid date";
       int duration = Toast.LENGTH_SHORT;
       Toast toast = Toast.makeText(context,text,duration);
       toast.show();
       // load new date upon error
          loadData();
     }

    }

  public Intent Res(Intent intent){
   return intent;
  }


    public void loadData(){
        SharedPreferences.Editor edits = sharedPref.edit();

        int prevday = sharedPref.getInt(load_day,day);
        int prevmonth = sharedPref.getInt(load_month,month);
        dateInputText.setText(new StringBuilder().append(prevday).append("/").append(prevmonth)
                .append("/").append(year));

    }


    public void FormDate(){
        dateInputText.setText(new StringBuilder().append(day).append("/").append(month)
                .append("/").append(year));

    }



}
