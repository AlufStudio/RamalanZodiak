package com.madrish.ramalanzodiak.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.madrish.ramalanzodiak.R;

/**
 * Created by A MADRISH on 10/15/2016
 */

public class HasilWatak extends AppCompatActivity {
    TextView a;
    int bulan;
    String zodiak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_watak);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                bulan = Integer.parseInt(null);
                zodiak = null;
            } else {
                bulan= extras.getInt("bulan");
                zodiak = extras.getString("zodiak");
            }
        } else {
            bulan= (int) savedInstanceState.getSerializable("bulan");
            zodiak= (String) savedInstanceState.getSerializable("zodiak");
        }
        customActionBar(zodiak);
        a = (TextView)findViewById(R.id.textView);
        setContent(bulan);
    }

    private void customActionBar(String zodiak) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        View viewActionBar = getLayoutInflater().inflate(R.layout.title_abs, null);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        TextView tit = (TextView)viewActionBar.findViewById(R.id.mytext);
        tit.setText(zodiak);
        getSupportActionBar().setCustomView(viewActionBar, params);
    }

    private void setContent(int x) {
        switch (x){
            case 0:
                a.setText(R.string.capricorn);
                break;
            case 1:
                a.setText(R.string.aquarius);
                break;
            case 2:
                a.setText(R.string.Pisces);
                break;
            case 3:
                a.setText(R.string.Aries);
                break;
            case 4:
                a.setText(R.string.Taurus);
                break;
            case 5:
                a.setText(R.string.Gemini);
                break;
            case 6:
                a.setText(R.string.Cancer);
                break;
            case 7:
                a.setText(R.string.Leo);
                break;
            case 8:
                a.setText(R.string.Virgo);
                break;
            case 9:
                a.setText(R.string.Libra);
                break;
            case 10:
                a.setText(R.string.Scorpio);
                break;
            case 11:
                a.setText(R.string.Sagitarius);
                break;
            default:
                a.setText("");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}

