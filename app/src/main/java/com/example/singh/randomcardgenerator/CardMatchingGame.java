package com.example.singh.randomcardgenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 26/08/2015.
 */
public class CardMatchingGame {
    //data members
    private int Score=0;
    private static final int MATCH_BONUS= 4, MISMATCH_PENALITY=2,FLIP_COST =1;
    private List<Card> cards;

    public static CardMatchingGame currentCardMatchingGame;

    //lazy instantiation
    public List<Card> getCard() {
        if(cards==null) {
            cards = new ArrayList<Card>();
        }
        return cards;
    }

    public int getScore() {
        return Score;
    }
//methods




    public CardMatchingGame(int count, Deck deck)
    {
         for(int i=0;i<count;i++){
             Card card = deck.drawRandomCard();//draw random card out of deck

             //checking if count is 100, which is  not correct
             if(card!=null){
                 this.getCard().add(i, card);//adding card in the inbuilt array
             }
             else
             {
                 break;
             }
         }
        currentCardMatchingGame = this;
    }

    public void flipCardAtIndex(int index){
        Card card = this.cardAtIndex(index); //callling cardAtIndex to get card

        //if there's card and is playable
        if(card!=null && !card.getUnplayable()){

            //only do this card match when we are flipping the facedown card
            if(!card.getFaceUp()){
                for(Card otherCard:cards){
                    List<Card> matchingList = new ArrayList<>();
                    matchingList.add(otherCard);//converting one card in matching list as our match function expects a list

                    if(otherCard.getFaceUp() && !otherCard.getUnplayable()){
                        int matchScore = card.match(matchingList);

                        //if matchScore is non zero it means there's some match
                        if(matchScore!=0){
                            otherCard.setUnplayable(true);//making otherCard unplayable
                            card.setUnplayable(true);//making card unplayable
                            this.Score+= matchScore*this.MATCH_BONUS;
                        }
                        //if no matching. match score ==0
                        else{

                            otherCard.setFaceUp(false);//turning the otherCard face down again.
                            this.Score -= this.MISMATCH_PENALITY;
                        }
                        break;//break out of loop when otherCard is dealt
                    }
                }
                this.Score-=this.FLIP_COST;//only happens when card is face down only.
            }
            card.setFaceUp(!card.getFaceUp());//flipping card logic goes here.
        }

    }

    public Card cardAtIndex(int index){
        return(index<(this.cards.size()))? this.cards.get(index):null;
    }

}
