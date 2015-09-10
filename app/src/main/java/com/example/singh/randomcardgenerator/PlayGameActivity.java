package com.example.singh.randomcardgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayGameActivity extends AppCompatActivity {

    private PlayingCardDeck deck;
    private int flipCount=0;
    private int Score=0;


    List<PlayingCard> card = new ArrayList<PlayingCard>() ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        /*
        myRandomButton = new Button[5];
        myRandomButton[0] = (Button) findViewById(R.id.card1);
        myRandomButton[1] = (Button) findViewById(R.id.card2);
        myRandomButton[2] = (Button) findViewById(R.id.button);
        myRandomButton[3] = (Button) findViewById(R.id.button2);
        myRandomButton[4] = (Button) findViewById(R.id.button3);
        */
        deck = new PlayingCardDeck();
        for(int i=0;i<20;i++)
        {
            card.add(i, (PlayingCard) (deck.drawRandomCard()));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //flipping card here
    public void onFlip(View view)
    {
        //incrementing the flipcount
        flipCount++;
        TextView flipLable = (TextView) findViewById(R.id.flip_count);
        flipLable.setText("Flips:"+flipCount);

        Button myCardButton = new Button(this);

        int buttonId = view.getId();

        switch (buttonId){
            case R.id.card1:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(0).getFaceUp()) {
                    myCardButton.setText(card.get(0).getRank() + card.get(0).getSuit());

                    //Matching logic     fix here
                    for(PlayingCard otherCard:card)
                    {
                        List<Card> matchingList = new ArrayList<>();
                        matchingList.add(otherCard);

                         if(otherCard.getFaceUp()){
                             int matchScore = card.get(0).match(matchingList);
                             if(matchScore!=0)
                             {
                                 otherCard.setUnplayable(true);
                                 card.get(0).setUnplayable(true);
                                 this.Score+=matchScore*4;
                             }
                             else
                             {
                                 otherCard.setFaceUp(false);
                                 this.Score-=2;
                             }
                             break;
                         }

                    //
                    }
                    this.Score-=1;

                    ((TextView)findViewById(R.id.score)).setText("Score: "+Score);
                    card.get(0).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(0).setFaceUp(false);
                }
                break;
            case R.id.card2:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(1).getFaceUp()) {
                    myCardButton.setText(card.get(1).getRank() + card.get(1).getSuit());

                    //Matching logic     fix here
                    for(PlayingCard otherCard:card)
                    {
                        List<Card> matchingList = new ArrayList<>();
                        matchingList.add(otherCard);

                        if(otherCard.getFaceUp()){
                            int matchScore = card.get(1).match(matchingList);
                            if(matchScore!=0)
                            {
                                otherCard.setUnplayable(true);
                                card.get(1).setUnplayable(true);
                                this.Score+=matchScore*4;
                            }
                            else
                            {
                                otherCard.setFaceUp(false);
                                this.Score-=2;
                            }
                            break;
                        }

                        //
                    }
                    this.Score-=1;
                    ((TextView)findViewById(R.id.score)).setText("Score: "+Score);
                    card.get(1).setFaceUp(true);//setting face up after fliping


                }
                else{
                    myCardButton.setText("Card");
                    card.get(1).setFaceUp(false);
                }
                break;
            case R.id.button:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(2).getFaceUp()) {
                    myCardButton.setText(card.get(2).getRank() + card.get(2).getSuit());

                    //Matching logic     fix here
                    for(PlayingCard otherCard:card)
                    {
                        List<Card> matchingList = new ArrayList<>();
                        matchingList.add(otherCard);

                        if(otherCard.getFaceUp()){
                            int matchScore = card.get(2).match(matchingList);
                            if(matchScore!=0)
                            {
                                otherCard.setUnplayable(true);
                                card.get(2).setUnplayable(true);
                                this.Score+=matchScore*4;
                            }
                            else
                            {
                                otherCard.setFaceUp(false);
                                this.Score-=2;
                            }
                            break;
                        }

                        //
                    }
                    this.Score-=1;

                    ((TextView)findViewById(R.id.score)).setText("Score: " + Score);

                    card.get(2).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(2).setFaceUp(false);
                }
                break;
            case R.id.button2:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(3).getFaceUp()) {
                    myCardButton.setText(card.get(3).getRank() + card.get(3).getSuit());

                    //Matching logic     fix here
                    for(PlayingCard otherCard:card)
                    {
                        List<Card> matchingList = new ArrayList<>();
                        matchingList.add(otherCard);

                        if(otherCard.getFaceUp()){
                            int matchScore = card.get(3).match(matchingList);
                            if(matchScore!=0)
                            {
                                otherCard.setUnplayable(true);
                                card.get(3).setUnplayable(true);
                                this.Score+=matchScore*4;
                            }
                            else
                            {
                                otherCard.setFaceUp(false);
                                this.Score-=2;
                            }
                            break;
                        }

                        //
                    }
                    this.Score-=1;

                    ((TextView)findViewById(R.id.score)).setText("Score: " + Score);

                    card.get(3).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(3).setFaceUp(false);
                }
                break;

            case R.id.button3:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(4).getFaceUp()) {
                    myCardButton.setText(card.get(4).getRank() + card.get(4).getSuit());
                    card.get(4).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(4).setFaceUp(false);
                }
                break;
            case R.id.button4:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(5).getFaceUp()) {
                    myCardButton.setText(card.get(5).getRank() + card.get(5).getSuit());
                    card.get(5).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(5).setFaceUp(false);
                }
                break;
            case R.id.button5:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(6).getFaceUp()) {
                    myCardButton.setText(card.get(6).getRank() + card.get(6).getSuit());
                    card.get(6).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(6).setFaceUp(false);
                }
                break;
            case R.id.button6:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(7).getFaceUp()) {
                    myCardButton.setText(card.get(7).getRank() + card.get(7).getSuit());
                    card.get(7).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(7).setFaceUp(false);
                }
                break;
            case R.id.button7:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(8).getFaceUp()) {
                    myCardButton.setText(card.get(8).getRank() + card.get(8).getSuit());
                    card.get(8).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(8).setFaceUp(false);
                }
                break;

            case R.id.button8:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(9).getFaceUp()) {
                    myCardButton.setText(card.get(9).getRank() + card.get(9).getSuit());
                    card.get(9).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(9).setFaceUp(false);
                }
                break;
            case R.id.button9:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(10).getFaceUp()) {
                    myCardButton.setText(card.get(10).getRank() + card.get(10).getSuit());
                    card.get(10).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(10).setFaceUp(false);
                }
                break;
            case R.id.button10:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(11).getFaceUp()) {
                    myCardButton.setText(card.get(11).getRank() + card.get(11).getSuit());
                    card.get(11).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(11).setFaceUp(false);
                }
                break;
            case R.id.button11:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(12).getFaceUp()) {
                    myCardButton.setText(card.get(12).getRank() + card.get(12).getSuit());
                    card.get(12).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(12).setFaceUp(false);
                }
                break;
            case R.id.button12:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(13).getFaceUp()) {
                    myCardButton.setText(card.get(13).getRank() + card.get(13).getSuit());
                    card.get(13).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(13).setFaceUp(false);
                }
                break;
            case R.id.button13:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(14).getFaceUp()) {
                    myCardButton.setText(card.get(14).getRank() + card.get(14).getSuit());
                    card.get(14).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(14).setFaceUp(false);
                }
                break;

            case R.id.button14:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(15).getFaceUp()) {
                    myCardButton.setText(card.get(15).getRank() + card.get(15).getSuit());
                    card.get(15).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(15).setFaceUp(false);
                }
                break;
            case R.id.button15:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(16).getFaceUp()) {
                    myCardButton.setText(card.get(16).getRank() + card.get(16).getSuit());
                    card.get(16).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(16).setFaceUp(false);
                }
                break;
            case R.id.button16:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(17).getFaceUp()) {
                    myCardButton.setText(card.get(17).getRank() + card.get(17).getSuit());
                    card.get(17).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(17).setFaceUp(false);
                }
                break;
            case R.id.button17:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(18).getFaceUp()) {
                    myCardButton.setText(card.get(18).getRank() + card.get(18).getSuit());
                    card.get(18).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(18).setFaceUp(false);
                }
                break;
            case R.id.button18:
                myCardButton = (Button) findViewById(view.getId());
                if(!card.get(19).getFaceUp()) {
                    myCardButton.setText(card.get(19).getRank() + card.get(19).getSuit());
                    card.get(19).setFaceUp(true);//setting face up after fliping
                }
                else{
                    myCardButton.setText("Card");
                    card.get(19).setFaceUp(false);
                }
                break;

            default:
                break;
        }






    }


}
