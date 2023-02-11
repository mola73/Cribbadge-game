/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
import java.util.ArrayList;
public class Game {
    private ArrayList<Card> crib =new ArrayList();
    
    public ArrayList<Card> makeCrib(ArrayList<Card> cribpick){
        
        for(Card x: cribpick){
            crib.add(x);
        }
        
        
        return crib;
        // allow each player to pick two cards form their deck
        //those two cards are passed to the the make crib() and added to the crib arraylist
        //the arrayList is given to the player constructor of the player who is a dealer.
    }
    
    public static void round(){
        
    }
    
    public static void main(String[]args){
        System.out.println(Card.Deck());
         
          System.out.println(symbol);
                 
    }
}
