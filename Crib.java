/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.score;

import java.util.ArrayList;

/**
 *
 * @author mpereira
 */
public class Crib {
    private ArrayList<Card> crib;

    
    public Crib(Player human, Player cpu) {//method called by dealer to create crib(2 from pone in parmater and 2 from dealerattributes)

        ArrayList<Card> pick1 = human.getcribPick();
        ArrayList<Card> pick2 = cpu.getcribPick();
        for (Card y : pick1) {
            this.crib.add(y);
        }
        
        for (Card x : pick2) {
            this.crib.add(x);
        }
    
    }
    
    public void assignCrib(Player dealer){
        if(dealer.ruDealer()){
            dealer.setCrib(this.crib);
        }
    }
    
    public void resetCrib(Player human, Player cpu){
        ArrayList<Card> pick1 = human.getcribPick();
        ArrayList<Card> pick2 = cpu.getcribPick();
        for (Card y : pick1) {
            this.crib.add(y);
        }
        
        for (Card x : pick2) {
            this.crib.add(x);
        }
    }
}
