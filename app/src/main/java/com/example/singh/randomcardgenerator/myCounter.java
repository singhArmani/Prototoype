package com.example.singh.randomcardgenerator;

import android.os.CountDownTimer;

/**
 * Created by singh on 10/09/2015.
 */
public class myCounter extends CountDownTimer {
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public myCounter(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //
    }

    @Override
    public void onFinish() {

    }
}
