package com.madrish.rz.Interface;


import com.android.volley.VolleyError;

import org.json.JSONObject;


public interface VolleyInterface {
    void onPrepare();
    void onSucces(JSONObject jsonObject);
    void onFailed(VolleyError errorListener);
}
