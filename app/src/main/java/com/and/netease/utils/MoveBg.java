package com.and.netease.utils;

import android.view.View;
import android.view.animation.TranslateAnimation;

public class MoveBg {

    /**
     * move front to background
     *
     * @param v      the view to be moved
     * @param startX start x position
     * @param toX    to
     * @param startY
     * @param toY
     */
    public static void moveFrontBg(View v, int startX, int toX, int startY, int toY) {
        TranslateAnimation anim = new TranslateAnimation(startX, toX, startY, toY);
        anim.setDuration(200);
        anim.setFillAfter(true);
        v.startAnimation(anim);
    }
}
