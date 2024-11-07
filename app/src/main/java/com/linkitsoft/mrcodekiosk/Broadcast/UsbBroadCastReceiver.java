package com.linkitsoft.mrcodekiosk.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;

import com.linkitsoft.mrcodekiosk.Helper.UIHelper;


public class UsbBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        UsbDevice device = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
//        switch (intent.getAction()) {
////            case UsbManager.ACTION_USB_DEVICE_ATTACHED:
////                UIHelper.showShortToast(context.getApplicationContext(), "vid: "+ device.getVendorId() + "  pid:" + device.getProductId());
////                break;
////            case UsbManager.ACTION_USB_DEVICE_DETACHED:
////                UIHelper.showShortToast(context.getApplicationContext(),"vid: "+ device.getVendorId() + "  pid:" + device.getProductId());
////                break;
//        }
    }

}
