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
import android.widget.TextView;

import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //define buttons and textView
    Button btn1Call, btn1Text;
    Button btn2Call, btn2Text;
    Button btn3Call, btn3Text;
    TextView tvcon1, tvcon2, tvcon3;
    android.content.res.Resources res;
    String[] con1;
    String[] con2;
    String[] con3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //initialize variables
        tvcon1 = findViewById(R.id.textViewCon1);
        tvcon2 = findViewById(R.id.textViewCon2);
        tvcon3 = findViewById(R.id.textViewCon3);
        //get String Arrays
        res = getResources();
        con1 = res.getStringArray(R.array.con1);
        con2 = res.getStringArray(R.array.con2);
        con3 = res.getStringArray(R.array.con3);
        tvcon1.setText(con1[0]);
        tvcon2.setText(con2[0]);
        tvcon3.setText(con3[0]);

        setupButtonClickEvents();
        }
        //method to set up btn clicks
    private void setupButtonClickEvents() {
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
        //Set Related Elements
        btn1Text = (Button) findViewById(R.id.button1Text);
        btn2Text = (Button) findViewById(R.id.button2Text);
        btn3Text = (Button) findViewById(R.id.button3Text);
        btn1Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Create text message intent
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                //assign phone #
                sendIntent.setData(Uri.parse("sms:"+con1[1]));
                //assign body
                sendIntent.putExtra("sms_body", "Hi");
                //Check for app to handle intent
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(sendIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe == true) {
                    //send text
                    startActivity(sendIntent);
                }
            }
        });

        btn2Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Create text message intent
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                //assign phone #
                sendIntent.setData(Uri.parse("sms:"+con2[1]));
                //assign body
                sendIntent.putExtra("sms_body", "Hi");
                //Check for app to handle intent
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(sendIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe == true) {
                    //send text
                    startActivity(sendIntent);
                }
            }
        });
        btn3Text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Create text message intent
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                //assign phone #
                sendIntent.setData(Uri.parse("sms:"+con3[1]));
                //assign body
                sendIntent.putExtra("sms_body", "Hi");
                //Check for app to handle intent
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(sendIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe == true) {
                    //send text
                    startActivity(sendIntent);
                }
            }
        });

    }
    //method to check call app
    private void CheckStartCallActivity(Intent intent) {
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    }
