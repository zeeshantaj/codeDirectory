package com.linkitsoft.mrcodekiosk.RelaunchFromBG;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.linkitsoft.mrcodekiosk.Activities.SplashScreen;
import com.linkitsoft.mrcodekiosk.R;

public class MyForegroundService extends Service {
    @Override
    public int onStartCommand(Intent i, int flags, int startId) {
        Log.d("MyApp", "Foreground Service onStartCommand called");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(new ComponentName(getApplication().getPackageName(),"com.linkitsoft.mrcodekiosk.Activity.Activities.SplashScreen"));
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP
                    | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            try {
                startActivity(intent);
                Log.d("MyApp", "SplashScreen launched successfully");
            } catch (Exception e) {
                Log.e("MyApp", "Error launching SplashScreen: " + e.getMessage());
            }

        }

        stopSelf();
        return START_NOT_STICKY;

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyApp","service on create called ");
        // Ensure the notification channel is created (Android 8.0+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            NotificationChannel channel = new NotificationChannel(
                    "CHANNEL_ID",
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
        // todo launch the app on android 11
        Intent notificationIntent = new Intent(this, SplashScreen.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        // todo launch the app on android 11

        // Create a notification to run the service in the foreground
        Notification notification = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setContentTitle("App Relaunch Service")
                .setContentText("Relaunching the app...")
                .setSmallIcon(R.drawable.ic_launcher_foreground)  // Ensure you have this icon in your drawable folder
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)  // Optional, for setting the notification priority
                .setContentIntent(pendingIntent)
                .build();

        // Start the service in the foreground with the notification
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            startForeground(1, notification);
        } else {
            startForeground(1, notification,
                        ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC);
        }
    }
}
