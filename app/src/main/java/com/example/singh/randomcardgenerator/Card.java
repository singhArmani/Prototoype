package com.example.singh.randomcardgenerator;

import java.util.List;

/**
 * Created by singh on 26/08/2015.
 */
public class Card {
    private String contents;
    private Boolean faceUp;
    private Boolean unplayable;

    public Card() {
        faceUp=false;
        unplayable=false;
   }

//getters and setters

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Boolean getFaceUp() {
        return faceUp;
    }

    public void setFaceUp(Boolean faceUp) {
        this.faceUp = faceUp;
    }

    public Boolean getUnplayable() {
        return unplayable;
    }

    public void setUnplayable(Boolean unplayable) {
        this.unplayable = unplayable;
    }

    //method
    public int match(List<Card> otherCards)
    {
        int score=0;
        for(Card card:otherCards){
            if(card.getContents().equals(this.getContents())){
                score =1;
            }
        }
        return score;
    }
}
