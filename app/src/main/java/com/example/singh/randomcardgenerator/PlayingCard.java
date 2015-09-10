package com.example.singh.randomcardgenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 26/08/2015.
 */
public class PlayingCard extends Card {


    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        //to avoid someone setting our suit to invalid stuff
        if(PlayingCard.validSuits().contains(suit)){
            this.suit = suit;
        }
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        if(rank<=(PlayingCard.maxRank())) {
            this.rank = rank;
        }
    }

    //properties
    private String suit;
    private Integer rank;

    //overriding the match function of our PlayingCard
    @Override
    public int match(List<Card> otherCards){
      int score =0;
        //matching only one card at this stage, can be any numbers of cards
        if(otherCards.size()==1){
            //getting the last object here
            PlayingCard otherCard = (PlayingCard) otherCards.get(otherCards.size()-1);//typeCasting
            if(otherCard.getSuit().equals(this.getSuit())){score=1;}
            else if(otherCard.getRank()==this.getRank()){score = 4;}

        }
        return score;
    }


    //content of the playing card is the concatenation of rank and string
    private String contents(){
        List<String> rankString = PlayingCard.rankString();
        return rankString.get(this.getRank())+this.getSuit();
    }


    //valid suits
    public static List<String> validSuits(){

        //creating a list of strings
        List<String> ValidSuits = new ArrayList<String>();
        ValidSuits.add("♥️");
        ValidSuits.add("♦️");
        ValidSuits.add("♣️");
        ValidSuits.add("♠️");

        return  ValidSuits;
    }


    //ranks
    public static List<String> rankString(){

        List<String> rank = new ArrayList<String>();
        rank.add("?");
        for(int i=2;i<=10;i++) {
            rank.add(i + "");
        }
        rank.add("J");
        rank.add("Q");
        rank.add("K");

        return rank;
    }


    //max rank
    public static int maxRank(){
       return PlayingCard.rankString().size() -1;
    }



}


