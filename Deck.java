
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */

public class Deck {
    public static void main (String[] args){
        ArrayList<Card> deck = new ArrayList();
        Rank[] rands= Rank.values();
 Suit[] randss=Suit.values();
 for(int x=0;x<4;x++){
     for(int j=0;j<rands.length;j++){
          
         deck.add(new Card(rands[j],randss[i]));
     }
 }
    }
}
