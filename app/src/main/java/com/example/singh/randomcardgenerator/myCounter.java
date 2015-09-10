package com.example.singh.randomcardgenerator;

import android.app.AlertDialog;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by singh on 10/09/2015.
 */
public class myCounter extends CountDownTimer {

    TextView _myGameTimer;
    public myCounter(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        _myGameTimer.setText("Timer: " + millisUntilFinished / 1000);
    }

    @Override
    public void onFinish() {
        //game over dialog popup message with the score made

    }
}
