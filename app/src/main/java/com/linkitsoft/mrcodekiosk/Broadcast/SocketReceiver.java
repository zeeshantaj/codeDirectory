package com.linkitsoft.mrcodekiosk.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONObject;

public class SocketReceiver extends BroadcastReceiver {
//
//    private Context context;
//    private static SyncSocket SyncSocket;
//    private static PreviewAndRestartSocket previewAndRestartSocket;
//    private static boolean isSocketInitialized = false;
//    private ConnectivityReceiver connectivityReceiver;
//    NotifyKioskOnlineTask notifyKioskOnlineTask;
//    String restaurantId, vendingId, syncSocketId,previewAndRestartSocketId;

    @Override
    public void onReceive(Context context, Intent intent) {
//        this.context = context.getApplicationContext();
//        restaurantId = intent.getStringExtra("restaurantID");
//        vendingId = intent.getStringExtra("vendingId");
//        if (!isSocketInitialized) {
//            initSockets(context, restaurantId, vendingId);
//            registerConnectivityReceiver(restaurantId, vendingId);
//        }
    }
//
//    private void initSockets(Context context, String restaurantId, String vendingId) {
////       *********************************Sync Socket Init****************************
//        SyncSocket = new SyncSocket();
//        SyncSocket.restaurantId = restaurantId;
//        SyncSocket.socket.on(restaurantId, menuSocketListener);
//        SyncSocket.socket.on(Socket.EVENT_CONNECT, args -> {
//            syncSocketId = SyncSocket.socket.id();
//            System.out.println("kiosk sync socket id: " + syncSocketId);
//            Intent broadcastIntent = new Intent(AppConstants.SOCKET_EVENT_ACTION);
//            broadcastIntent.putExtra("status", "connected");
//            context.sendBroadcast(broadcastIntent);
//            notifyKioskOnline();
//        });
//        SyncSocket.socket.connect();
//        isSocketInitialized = true;
////       *********************************Sync Socket Init****************************
//
////        **********************************Preview And Restart Socket Init**************
//        previewAndRestartSocket = new PreviewAndRestartSocket();
//        previewAndRestartSocket.kioskId = vendingId;
//        previewAndRestartSocket.socket.on("Kiosk-" + vendingId, previewAndRestartSocketListener);
//        previewAndRestartSocket.socket.on(Socket.EVENT_CONNECT, args -> {
//            previewAndRestartSocketId = previewAndRestartSocket.socket.id();
//            System.out.println("kiosk preview & restart socket id: " + previewAndRestartSocketId);
//            Intent broadcastIntent = new Intent(AppConstants.SOCKET_EVENT_ACTION);
//            broadcastIntent.putExtra("status", "connected");
//            context.sendBroadcast(broadcastIntent);
//        });
//        previewAndRestartSocket.socket.connect();
////        **********************************Preview And Restart Socket Init**************
//    }
//
//    private final Emitter.Listener menuSocketListener = args -> runOnUiThread(() -> {
//        JSONObject data = (JSONObject) args[0];
//        try {
//            System.out.println("Menu Socket data: " + data.toString());
//            if (data.has("type") && data.has("status")  && data.getInt("status") == 2) {
//                Log.d("Need To Hit menu Socket", "yes");
//                sendBroadCast("menu");
//            }else if (data.has("type") && data.getString("type").equalsIgnoreCase("kiosk-theme")){
//                sendBroadCast("theme");
//            }
//        } catch (Exception e) {
//            Log.d("Sync Socket exception", "" + e);
//        }
//    });
//
//    private final Emitter.Listener previewAndRestartSocketListener = args -> runOnUiThread(() -> {
//        JSONObject data = (JSONObject) args[0];
//        try {
//            Log.d("Preview socket data: ",""+data.toString());
//            if (data.has("type") && data.getString("type").equalsIgnoreCase("requestPreview")) {
//                Log.d("Need To Hit preview Socket", "yes");
//                sendBroadCast("preview");
//            } else if(data.has("type") && data.getString("type").equalsIgnoreCase("kiosk-restart")) {
//                Log.d("Need To Hit restart Socket", "yes");
//                sendBroadCast("restart");
//            }
//        } catch (Exception e) {
//            Log.d("Preview or restart Socket exception", "" + e);
//        }
//    });
//
//
//    private void runOnUiThread(Runnable action) {
//        new Handler(Looper.getMainLooper()).post(action);
//    }
//
//    private void registerConnectivityReceiver(String restaurantId, String vendingId) {
//        connectivityReceiver = new ConnectivityReceiver(restaurantId, vendingId);
//        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        context.registerReceiver(connectivityReceiver, filter);
//    }
//
//    private void unregisterConnectivityReceiver() {
//        if (connectivityReceiver != null) {
//            context.unregisterReceiver(connectivityReceiver);
//        }
//    }
//
//    public void disconnectSocket() {
//        if (SyncSocket != null && isSocketInitialized) {
//            SyncSocket.socket.disconnect();
//            SyncSocket = null;
//            isSocketInitialized = false;
//        }
//        if (previewAndRestartSocket != null){
//            previewAndRestartSocket.socket.disconnect();
//            previewAndRestartSocket = null;
//        }
//    }
//
//    private class ConnectivityReceiver extends BroadcastReceiver {
//        private String restaurantId;
//        private String vendingId;
//
//        public ConnectivityReceiver(String restaurantId, String vendingId) {
//            this.restaurantId = restaurantId;
//            this.vendingId = vendingId;
//        }
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
//            if (!isConnected) {
//                Log.d("ConnectivityReceiver", "Internet lost, disconnecting sockets...");
//                disconnectSocket();
//            } else if (isConnected && !isSocketInitialized) {
//                Log.d("ConnectivityReceiver", "Internet connected, initializing sockets...");
//                initSockets(context, restaurantId, vendingId);
//            }
//        }
//    }
//
//    private void notifyKioskOnline() {
//        notifyKioskOnlineTask = new NotifyKioskOnlineTask(vendingId, syncSocketId);
//        notifyKioskOnlineTask.execute();
//    }
//
//    private void sendBroadCast(String type){
//        switch (type.toLowerCase()) {
//            case "menu":
//                LocalDataManager.getInstance().putBoolean("menuSyncStatus", true);
//                LocalDataManager.getInstance().putBoolean("restartStatus", false);
//                LocalDataManager.getInstance().putBoolean("previewStatus", false);
//                LocalDataManager.getInstance().putBoolean("themeStatus", false);
//                break;
//            case "preview":
//                LocalDataManager.getInstance().putBoolean("previewStatus", true);
//                LocalDataManager.getInstance().putBoolean("menuSyncStatus", false);
//                LocalDataManager.getInstance().putBoolean("restartStatus", false);
//                LocalDataManager.getInstance().putBoolean("themeStatus", false);
//                break;
//            case "restart":
//                LocalDataManager.getInstance().putBoolean("restartStatus", true);
//                LocalDataManager.getInstance().putBoolean("menuSyncStatus", false);
//                LocalDataManager.getInstance().putBoolean("previewStatus", false);
//                LocalDataManager.getInstance().putBoolean("themeStatus", false);
//                break;
//            case "theme":
//                LocalDataManager.getInstance().putBoolean("restartStatus", false);
//                LocalDataManager.getInstance().putBoolean("menuSyncStatus", false);
//                LocalDataManager.getInstance().putBoolean("previewStatus", false);
//                LocalDataManager.getInstance().putBoolean("themeStatus", true);
//                break;
//            default:
//                // Handle unknown type
//                System.out.println("no socket type available");
//                break;
//        }
//        Intent broadcastIntent = new Intent(AppConstants.SOCKET_EVENT_ACTION);
//        broadcastIntent.putExtra("status", "message_received");
//        context.sendBroadcast(broadcastIntent);
//    }
}