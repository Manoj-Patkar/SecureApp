package com.example.myfirst.secureapp;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Manoj_pc on 6/17/2017.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(getActivity(),this,year, month, day){
            @Override
            protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                int day = Resources.getSystem().getIdentifier("day", "id", "android");

                if(day != 0){
                    View dayPicker = findViewById(day);
                    if(dayPicker != null){
                        dayPicker.setVisibility(View.GONE);
                    }
                }
            }
        };

        int daytemp = Resources.getSystem().getIdentifier("day", "id", "android");
         DatePicker dp=dpd.getDatePicker();
        if(daytemp != 0){
            View dayspinner=dp.findViewById(daytemp);
            if(dayspinner!=null){
                dayspinner.setVisibility(View.GONE);
            }
        }
        dp.setCalendarViewShown(false);
        dp.setSpinnersShown(true);

        return dpd;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //Do something with the date chosen by the user
        TextView tv = (TextView) getActivity().findViewById(R.id.expiryDate);

        String stringOfDate = monthOfYear + "/" + year;
        tv.setText(stringOfDate);
    }
}
