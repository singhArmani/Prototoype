package com.example.singh.randomcardgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class helpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ((TextView)findViewById(R.id.instructions)).setText("•\tGame timer starts once you tap first card.\n\n" +
                        "•\tOnly one minute is given for matching.\n\n"
                        + "•\tFlipping has a cost associated with it given that it’s face down card.\n\n"
                        + "•\tFor a mismatch you will be punished with penalty of 2 points.\n\n"
                        +"•\tMatching the same suit card will reward you with 4 points.\n\n"
                        +"•\tMatching the same rank card will give you bonus reward of 16 points.\n\n"
                +"•\tIf there’s a mismatch, cards will turn to face down again.\n\n"
                +"•\tIf there’s a match, cards will become little transparent and disabled.\n\n"
                +"•\tYou can start a new game anytime in between your current game.\n\n"
                +"•\tGame is over when you run out of time.\n\n"
        );
    }


}
