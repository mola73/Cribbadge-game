
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
    public final ArrayList<Card> deck = new ArrayList();
    public Deck(){
          Rank[] rands= Rank.values();
 Suit[] randss=Suit.values();
 for(int x=0;x<4;x++){
     for(int j=0;j<rands.length;j++){
          
         deck.add(Card.getCard(rands[j],randss[x]));
     }
 }
    }
    public static void main (String[] args){
        
      Deck a= new Deck();
      System.out.println(a.deck);
    }
}
