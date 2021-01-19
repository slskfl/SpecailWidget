package com.example.specailwidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono1;
    Button btnStart,btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView1;
    TimePicker TPicker1;
    TextView tvResult;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono1=findViewById(R.id.chrono1);
        btnStart=findViewById(R.id.btnStart);
        btnEnd=findViewById(R.id.btnEnd);
        rdoCal=findViewById(R.id.rdoCal);
        rdoTime=findViewById(R.id.rdoTime);
        calView1=findViewById(R.id.calView1);
        TPicker1=findViewById(R.id.TPicker1);
        tvResult=findViewById(R.id.tvResult);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono1.setBase(SystemClock.elapsedRealtime()); //크로노미터 초기화
                chrono1.start();
                chrono1.setTextColor(Color.RED);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono1.stop();
                chrono1.setTextColor(Color.BLACK);
                tvResult.setText(selectYear+"년"+selectMonth+"월"+selectDay+"일"
                        +TPicker1.getCurrentHour()+"시"+TPicker1.getCurrentMinute()+"분에 예약됨.");
            }
        });
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView1.setVisibility(View.VISIBLE);
                TPicker1.setVisibility(View.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView1.setVisibility(View.INVISIBLE);
                TPicker1.setVisibility(View.VISIBLE);
            }
        });
        calView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear=year;
                selectMonth=month+1;
                selectDay=dayOfMonth;
            }
        });
    }
}