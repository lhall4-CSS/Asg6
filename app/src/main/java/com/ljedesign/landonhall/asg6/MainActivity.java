package com.ljedesign.landonhall.asg6;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Initialize buttons and textView
    Button btn1Call, btn1Text;
    Button btn2Call, btn2Text;
    Button btn3Call, btn3Text;
    android.content.res.Resources res;
    String[] con1;
    String[] con2;
    String[] con3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        con1 = res.getStringArray(R.array.con1);
        con2 = res.getStringArray(R.array.con2);
        con3 = res.getStringArray(R.array.con3);
        setupButtonClickEvents();
        }
    private void setupButtonClickEvents() {
        /**
         *   Set up button click event listener for the web info button for the first performance
         */
            //Set Related Elements
            btn1Call = (Button) findViewById(R.id.button1Call);
            btn2Call = (Button) findViewById(R.id.button2Call);
            btn3Call = (Button) findViewById(R.id.button3Call);
            btn1Call.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + con1[1]));
                    CheckStartCallActivity(callIntent);
                }
            });
            btn2Call.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + con2[1]));
                    CheckStartCallActivity(callIntent);
                }
            });
            btn3Call.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + con3[1]));
                    CheckStartCallActivity(callIntent);
                }
            });
        /**
         *   Set up button click event listener for the celendar button for the first performance
         *       Use the calendar intent to set an event reminder on the calendar
         */
        //Set Related Elements
        btn1Text = (Button) findViewById(R.id.button1Text);
        btn2Text = (Button) findViewById(R.id.button2Text);
        btn3Text = (Button) findViewById(R.id.button3Text);
        btn1Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //set text
                //textViewStatus.setText("Code should set a calendar event for performance 1");
                //create new calendar intent
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                //set date & time
                calIntent.putExtra(CalendarContract.Events.TITLE, "SAL Colloquium 'The Robot Next Door'");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Tower Hall 4119");
                GregorianCalendar begDate = new GregorianCalendar(2017, 2, 24, 3, 40);
                GregorianCalendar endDate = new GregorianCalendar(2017, 2, 24, 4, 40);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        begDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDate.getTimeInMillis());
                //Check for app to handle intent
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(calIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe == true) {
                    startActivity(calIntent);
                }
            }
        });

        btn2Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //set text
                //textViewStatus.setText("Code should set a calendar event for performance 2");
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "Celebrate Spring");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Tower Hall 4119");
                GregorianCalendar begDate = new GregorianCalendar(2018, 3, 8, 7, 30);
                GregorianCalendar endDate = new GregorianCalendar(2018, 3, 8, 9, 30);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        begDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDate.getTimeInMillis());
                //Check for app to handle intent
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(calIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe == true) {
                    startActivity(calIntent);
                }
            }
        });
        btn3Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //set text
                //textViewStatus.setText("Code should set a calendar event for performance 3");
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "Celebrate Spring");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Mitchell Auditorium");
                GregorianCalendar begDate = new GregorianCalendar(2018, 4, 13, 7, 30);
                GregorianCalendar endDate = new GregorianCalendar(2018, 4, 13, 9, 30);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        begDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDate.getTimeInMillis());
                //Check for app to handle intent
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(calIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe == true) {
                    startActivity(calIntent);
                }
            }
        });

    }
    private void CheckStartCallActivity(Intent intent) {
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    }
