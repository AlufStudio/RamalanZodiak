package com.madrish.ramalanzodiak.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.madrish.ramalanzodiak.Interface.VolleyInterface;
import com.madrish.ramalanzodiak.R;
import com.madrish.ramalanzodiak.Template.EndpointAPI;
import com.madrish.ramalanzodiak.Template.Template;
import com.madrish.ramalanzodiak.Utils.VolleyRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by A MADRISH on 10/15/2016
 */

public class HasilRamal extends AppCompatActivity implements VolleyInterface{
    VolleyRequest mRequest;
    ProgressDialog progress;
    private TextView r_single_out, r_couple_out, r_karir_out,r_umum_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_ramal);
        mRequest = new VolleyRequest(this);

        r_umum_out = (TextView)findViewById(R.id.umum);
        r_single_out = (TextView)findViewById(R.id.single);
        r_couple_out =(TextView)findViewById(R.id.couple);
        r_karir_out = (TextView)findViewById(R.id.karir);


        progress = ProgressDialog.show(this, "Mencari data",
                "Loading...", true);
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("bulan");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("bulan");
        }

        mRequest.sendGetRequest(EndpointAPI.IBACOR+ Template.Query.NAMA+"a&"+ Template.Query.TGL+"01-"+newString+"-2000");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onSucces(JSONObject jsonObject) {
        String r_umum = null;
        String r_single = null;
        String r_couple = null;
        String r_karir = null;


        try {
            JSONObject ramalan_ = jsonObject.getJSONObject("ramalan");
            r_umum = ramalan_.getString("umum");
            JSONObject percintaan = ramalan_.getJSONObject("percintaan");
            r_single = percintaan.getString("single");
            r_couple = percintaan.getString("couple");
            r_karir = ramalan_.getString("karir_keuangan");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(r_karir!=null){
            r_umum_out.setText(r_umum);
            r_single_out.setText("Single - "+r_single);
            r_couple_out.setText("Couple - "+r_couple);
            r_karir_out.setText(r_karir);
        }
        progress.dismiss();

    }

    @Override
    public void onFailed(VolleyError errorListener) {
        progress.dismiss();
    }
}

