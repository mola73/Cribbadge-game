/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.score;
/**
 *
 * @author mpereira
 */
public class Score {
    private int showScore = 0;
    private int palyScore = 0;
    

    public int getShowScore() {
        return showScore;
    }

    public int getPalyScore() {
        return palyScore;
    }

    private int fifteenShow(Player player1){//arraylist, check if there is a match, divide by 2. Returns 2 per combination
        int point = 0;
        for(Card c: player1.getCards()){
            for(Card c2: player1.getCards()){
                if(player1.getCards().indexOf(c) != player1.getCards().indexOf(c2)){
                    if(c.getRank().count()+c2.getRank().count()==15){
                        point +=2;
                    }
                }
            }
        }
        return point;
    }
    
    private int equalCards(){
        return 1;
    }
    
    
}
