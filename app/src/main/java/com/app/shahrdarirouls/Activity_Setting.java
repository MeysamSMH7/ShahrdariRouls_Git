package com.app.shahrdarirouls;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Activity_Setting extends AppCompatActivity {

    TextView txttest;

    String[] fontsName = {"نازنین", "نازنین بزرگ", "یکان", "یکان بزرگ", "زر", "زر بزرگ", "ایران سنس", "ایران سنس بزرگ",};
    String[] fonts = {"fonts/b_nazanin.ttf", "fonts/b_nazanin_b.ttf", "fonts/b_yekan.ttf", "fonts/b_yekan_b.ttf", "fonts/b_zar.ttf", "fonts/b_zar_b.ttf", "fonts/iransans_normal.ttf", "fonts/iransans_b.ttf"};
    String font = "fonts/b_zar.ttf";
    SeekBar seekBarFont;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FontSize fontSize = new FontSize(this);fontSize.setFontSize();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Spinner SpinnerFont = (Spinner) findViewById(R.id.SpinnerFont);
        seekBarFont = (SeekBar) findViewById(R.id.seekBarFont);
        txttest = (TextView) findViewById(R.id.txttest);

        final SharedPreferences shared = getSharedPreferences("prefes", 0);
        int Size = shared.getInt("size?", 16);
        txttest.setTextSize(Size);
        seekBarFont.setProgress((Size-10)/3);


        ArrayAdapter arrayAdapter_Spinner = new ArrayAdapter(Activity_Setting.this, android.R.layout.simple_spinner_item, fontsName);
        SpinnerFont.setAdapter(arrayAdapter_Spinner);
        SpinnerFont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final SharedPreferences shared = getSharedPreferences("prefes", 0);

                font = fontsName[i];
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("font?", font);
                editor.putInt("idSpinner?", i);
                editor.commit();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        int spinnerSelection = shared.getInt("idSpinner?", 0);
        SpinnerFont.setSelection(spinnerSelection);


        seekBarFont.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txttest.setTextSize(i * 3 + 10);
                final SharedPreferences shared = getSharedPreferences("prefes", 0);
                SharedPreferences.Editor editor = shared.edit();

                editor.putInt("size?", i * 3 + 10);
                editor.commit();

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



