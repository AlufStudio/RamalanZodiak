package com.madrish.ramalanzodiak.Application;

import android.app.Application;
import android.content.Context;

import com.android.volley.VolleyLog;

public class MyApplication extends Application{

    private static MyApplication myApplication;

    public static synchronized MyApplication getInstance() {
        return myApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        VolleyLog.DEBUG = false;
    }
    public static Context getContext() {
        return myApplication.getApplicationContext();
    }

}