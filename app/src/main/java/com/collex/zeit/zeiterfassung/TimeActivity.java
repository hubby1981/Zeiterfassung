package com.collex.zeit.zeiterfassung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TimePicker;

import com.collex.zeit.zeiterfassung.data.TH;

import java.util.Date;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        TimePicker p = (TimePicker)findViewById(R.id.timePicker);
        p.setIs24HourView(true);

        if(TH.TIME_NOT_BACK&&TH.TICKS>0)
        {
            Date d = new Date(TH.TICKS);
            p.setCurrentHour(d.getHours());
            p.setCurrentMinute(d.getMinutes());

        }

        Switch s = (Switch)findViewById(R.id.switchTime);
        s.setChecked(TH.TIME_NOT_BACK);
    }

    @Override
    protected void onPause(){
        super.onPause();
        time();
    }

    public void time(){
        TimePicker p = (TimePicker)findViewById(R.id.timePicker);
        Date d = new Date(new Date().getYear(),new Date().getMonth(),new Date().getDay(),p.getCurrentHour(),p.getCurrentMinute());
        Switch s = (Switch)findViewById(R.id.switchTime);
        TH.TICKS = d.getTime();
        TH.TIME_NOT_BACK = s.isChecked();
    }
}
