package com.linkitsoft.mrcodekiosk.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.linkitsoft.mrcodekiosk.Activities.SplashScreen;


public class RestartAppReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // The app has been terminated, so launch it again
        Intent i = new Intent(context, SplashScreen.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
