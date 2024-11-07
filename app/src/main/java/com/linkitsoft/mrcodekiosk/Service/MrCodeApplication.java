package com.linkitsoft.mrcodekiosk.Service;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.android.volley.toolbox.Volley;
import com.linkitsoft.mrcodekiosk.RelaunchFromBG.AppLifeCycleObserver;
import com.linkitsoft.mrcodekiosk.Utils.LocalDataManager;

public class MrCodeApplication extends Application {
    private static MrCodeApplication instance;
    private com.android.volley.RequestQueue requestQueue;

    @Override public void onCreate() {
        super.onCreate();
        instance = this;
        LocalDataManager.createInstance(this);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        Log.d("MyApp","application class onCreate");
        AppLifeCycleObserver observer = new AppLifeCycleObserver(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(observer);
    }

    public static synchronized MrCodeApplication getInstance() {
        return instance;
    }

    public com.android.volley.RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
