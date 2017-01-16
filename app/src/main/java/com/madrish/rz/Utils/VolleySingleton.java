package com.madrish.rz.Utils;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.madrish.rz.Application.MyApplication;

public class VolleySingleton {

    private static VolleySingleton sInstance = null;
    private RequestQueue mRequestQueue;

    private VolleySingleton() {
        mRequestQueue = Volley.newRequestQueue(MyApplication.getContext());
    }



    public static VolleySingleton getInstance() {
        if (sInstance == null) {
            sInstance = new VolleySingleton();
        }
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }


}
