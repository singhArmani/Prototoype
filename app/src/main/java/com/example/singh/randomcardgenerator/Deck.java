package com.example.singh.randomcardgenerator;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by singh on 26/08/2015.
 */
public class Deck {

    private List<Card> cards;

    public List<Card> getCards() {
        if(cards==null){
            //do lazy instantiation when someone calls the getter
            cards = new ArrayList<Card>();
        }
        return cards;
    }

    public void addCard(Card card, Boolean atTop){

        //if there's a card passed as argument
        if(card!=null){
         if(atTop){
            this.getCards().add(0,card);
         }
            else
         {
             this.getCards().add(card);
         }
        }
    }

    //drawRandom Card
    public Card drawRandomCard(){
        Card randomCard =null;
        Random gen = new Random();
         int sizeofDeck = this.cards.size();
        if(sizeofDeck>0) {
            int index = Math.abs((gen.nextInt()) % (sizeofDeck));
            randomCard = this.cards.get(index);//getting the random card at this point
            this.cards.remove(index); //removing that random card out of the deck

        }
        else{
            Log.e("DivideByZero","size over");
        }
        return randomCard;
    }
}
