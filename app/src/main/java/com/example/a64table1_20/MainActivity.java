package com.example.a64table1_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablelistView;

    public void generateTimesTable(int timesTable){

        ArrayList<String> timesTableContent=new ArrayList<String>();
        for (int i = 1; i <=20 ; i++)
        {

            timesTableContent.add(timesTable+"*"+i+"="+Integer.toString(i*timesTable));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        timesTablelistView.setAdapter(arrayAdapter);
    }
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SeekBar seekBar=findViewById(R.id.seekBar);
        timesTablelistView=findViewById(R.id.listView);

        seekBar.setMax(20);       //max value it can scroll till
        seekBar.setProgress(1);  //increase by 1
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTable;
                if (i < min) {
                    timesTable = min;
                    seekBar.setProgress(min);
                } else {
                    timesTable = i;
                }
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        }
    }
