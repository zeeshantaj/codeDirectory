package com.linkitsoft.mrcodekiosk.Helper;

import android.content.Context;

import androidx.recyclerview.widget.LinearSmoothScroller;

public class CustomSmoothScroller extends LinearSmoothScroller {
    private int offset;

    public CustomSmoothScroller(Context context) {
        super(context);
    }

    public CustomSmoothScroller(Context context,int offset) {
        super(context);
        this.offset = offset;
    }


    @Override
    protected int getVerticalSnapPreference() {
        // Return SNAP_TO_START for precise control.
        return SNAP_TO_START;
    }

    @Override
    public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
        return boxStart - viewStart - offset;
    }
}
