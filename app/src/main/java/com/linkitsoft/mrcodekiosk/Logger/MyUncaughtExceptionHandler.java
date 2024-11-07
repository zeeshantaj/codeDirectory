package com.linkitsoft.mrcodekiosk.Logger;

import android.content.Context;
import android.content.Intent;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final Context context;

    public MyUncaughtExceptionHandler(Context context) {
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // Perform any crash logging here if needed
        // ...
        Exception ex = new Exception(e);
        Logger.writeError(ex);
        // Restart the app
        restartApp();
    }

    private void restartApp() {
        Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(context.getPackageName());
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

        // Close the current process
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}

