package com.BirthdayReminder.amorsoftware;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import java.util.Iterator;
import java.util.Calendar;


public  class PIckSpecialDay extends AppCompatActivity {
    DateSetActivity newCalander = new DateSetActivity();
    MainActivity datelist = new MainActivity();
    Intent screen;
    private boolean exist_button = false;

    private Calendar calendar;
    int manid = 0;
    static String keytodelete = "";
    static LinearLayout lin;
    String defaultbutton ="GoBack!";
    Button button, back;

    // prototype code
    private static boolean deletemode = false;
    // prototype code

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LoadBigDay
        ScrollView scroll = new ScrollView(this);
        lin = (LinearLayout) View.inflate(this,R.layout.activity_pick_special_day,null);
        scroll.addView(lin);
        datelist.spdates.size();
        back = new Button(this);
        back.setText(defaultbutton);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                clearKeyToDelete();
                deletemode = false;
                returnToPreviousScreen();

            }

        });
        this.lin.addView(back);
       // datelist.obj.clear();

        setContentView(scroll);
        createDate();
    }



     OnClickListener click = new OnClickListener() {

         public void onClick(View view) {

             int counter = 0;
             //    Integer loaded_day = 0;
             //    Integer loaded_month = 0;
             String keyval = "";



             manid = view.getId();
             button = (Button) findViewById(manid);
             String comparestring = (String) button.getText();

                  // prints the right event
               while(comparestring != keyval) {

                   keyval = datelist.mylist().get(counter).getKey();
                   if(comparestring != keyval) {
                       counter++;
                   }
                   if(counter >datelist.mylist().size() ){ --counter;}
               }



              Integer day = datelist.spdates.get(counter).getDay();
              Integer month = datelist.spdates.get(counter).getMonth();
              int year = datelist.spdates.get(counter).getYear();
             // int year = calendar.get(Calendar.YEAR);
               if(deletemode == false) {
                   newCalander.setDay(day);
                   newCalander.setMonth(month);
                   newCalander.setYear(year);
                   //  screen = returnDateActivity(screen);
                   returnDateActivity();
                   // startActivity(screen);
               }
               else if(deletemode == true){
                   // prototype code
                   datelist.setKeyToDelete(comparestring);
                  // deletemode = true;
                   clearSpdatesOfElement(comparestring);
                   button.setVisibility(View.GONE);
                   //returnMainActivity();
               }
         }

     };



 public boolean changeModes(boolean value){
     deletemode = value;
     return deletemode;
 }

   public String removeButton(String key){
       keytodelete = key;
       deletemode = true;
       return keytodelete;

       }


public void returnToPreviousScreen(){

    Intent screen = new Intent(this,DateSetActivity.class);
    screen.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
    clearKeyToDelete();
    startActivityIfNeeded(screen,0);
}

public void clearKeyToDelete(){
    keytodelete = "";
}


// this will create buttons based on this data
    // Extra bouse sort teh daa alpabetically every time its created
    // keytodelete need to not be static maybe a temporary method call
    public void createDate(){
        int i  = 0;

        calendar = Calendar.getInstance();

        while(i != datelist.spdates.size()) {


                button = new Button(this);
                button.setText(datelist.spdates.get(i).keyvalue.toString());
                button.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                this.button.setOnClickListener(click);

                  if(datelist.spdates.get(i).toString().contains("month")){
                      datelist.spdates.remove(i);
                           }
                           else {//datelist.spdates.get(i).toString()
                                  if(!keytodelete.equalsIgnoreCase(datelist.spdates.get(i).returnKey())) {
                                      manid++;
                                      button.setId(manid);
                                      this.lin.addView(button);
                                      i++;
                                  }
                                  else if(keytodelete.equalsIgnoreCase(datelist.spdates.get(i).keyvalue)){
                                      datelist.spdates.remove(i);

                                  }
                                }



                           exist_button = true;
                          }

                           manid = 0;
                         clearKeyToDelete();

        }


// prototype code
    public void clearSpdatesOfElement(String comp){
         Iterator itr = datelist.spdates.iterator();
         int i = 0;
         while(itr.hasNext()){
             System.out.println(datelist.spdates.get(i).returnKeyValue());
             if(datelist.spdates.get(i).returnKeyValue().contains(comp)){
                 //itr.remove();
                 datelist.spdates.remove(i);
                 datelist.deleteOldList(comp);
                 break;
             }
             itr.next();
             i++;

         }

    }


    public void returnDateActivity(){
        finish();
        Intent screen = new Intent(this,DateSetActivity.class);
        screen.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(screen,0);

    }



      public void returnMainActivity(){
          finish();
          Intent screen = new Intent(this,MainActivity.class);
          screen.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
          startActivityIfNeeded(screen,0);
    }


}
