package com.example.singh.randomcardgenerator;

/**
 * Created by singh on 26/08/2015.
 */
public class PlayingCardDeck extends Deck {

    public PlayingCardDeck() {
        super();
        //creating deck of cards here

        for(String suit:(PlayingCard.validSuits())){
            for(int rank =1; rank <=PlayingCard.maxRank();rank++){
                PlayingCard card = new PlayingCard();
                card.setRank(rank);
                card.setSuit(suit);
                //adding the card
                this.addCard(card,true);
            }
        }
    }
}
