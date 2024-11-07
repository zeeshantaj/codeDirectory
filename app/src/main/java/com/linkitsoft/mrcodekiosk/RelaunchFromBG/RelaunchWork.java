package com.linkitsoft.mrcodekiosk.RelaunchFromBG;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class RelaunchWork extends Worker {
    Context context;
    public RelaunchWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        // Relaunch the app
        Log.d("MyApp","do work called");

        // call the service class in to when app in background to relaunch the app
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q) {
            Log.d("MyApp","Foreground service called ");
            Intent serviceIntent = new Intent(getApplicationContext(), MyForegroundService.class);
            ContextCompat.startForegroundService(getApplicationContext(), serviceIntent);


        }else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
            // todo working in android 9
            Log.d("MyApp","relaunch without foreground service ");
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(new ComponentName(getApplicationContext().getPackageName(),"com.linkitsoft.mrcodekiosk.Activity.Activities.SplashScreen"));
//            intent.setComponent(new ComponentName("com.linkitsoft.jumbilinPaxChowlyKiosk","com.linkitsoft.jumbilinPaxChowlyKiosk.Activities.SplashScreen"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

        return Result.success();
    }
}
