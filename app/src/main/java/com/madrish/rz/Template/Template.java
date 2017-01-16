package com.madrish.rz.Template;

public interface Template {

    interface VolleyRetryPolicy {
        int SOCKET_TIMEOUT = 3000;
        int RETRIES = 1;
    }

    interface Query {
        String NAMA = "nama=";
        String TGL = "tgl=";
    }
}
