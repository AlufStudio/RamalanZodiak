package com.madrish.rz.Application;

import android.app.Application;
import android.content.Context;

import com.android.volley.VolleyLog;

public class MyApplication extends Application{
        static final boolean LOG = false; // rubah disini

        public static void i(String tag, String string) {
            if (LOG) android.util.Log.i(tag, string);
        }
        public static void e(String tag, String string) {
            if (LOG) android.util.Log.e(tag, string);
        }
        public static void d(String tag, String string) {
            if (LOG) android.util.Log.d(tag, string);
        }
        public static void v(String tag, String string) {
            if (LOG) android.util.Log.v(tag, string);
        }
        public static void w(String tag, String string) {
            if (LOG) android.util.Log.w(tag, string);
        }
        public static void d(String tag, String string, Throwable tr) {
            if (LOG) android.util.Log.d(tag, string, tr);
        }
        public static void e(String tag, String string, Throwable tr) {
            if (LOG) android.util.Log.e(tag, string, tr);
        }

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