package com.example.singh.randomcardgenerator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by singh on 10/09/2015.
 */
public class myCounter extends CountDownTimer {

    private boolean _timeHasStarted = false;
    private boolean _gameOver = false;

    public Activity currentActivity;

    public boolean is_timeHasStarted() {
        return _timeHasStarted;
    }

    public void set_timeHasStarted(boolean _timeHasStarted) {
        this._timeHasStarted = _timeHasStarted;
    }

    TextView _myGameTimer;
    public myCounter(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        _myGameTimer.setText("Timer: " + millisUntilFinished / 1000+"s");
    }

    @Override
    public void onFinish() {
        //game over dialog popup message with the score made
        _myGameTimer.setText("Game Over");
         _gameOver= true;//setting the gameOver true;

        CardMatchingGame.currentCardMatchingGame.getScore();
        AlertDialog.Builder myalert = new AlertDialog.Builder(currentActivity);
        myalert.setTitle("Game Over");
        myalert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });

        myalert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do somehting else
            }
        });
        myalert.show();

    }
}
