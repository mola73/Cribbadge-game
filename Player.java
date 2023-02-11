/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Random;
public class Player  {
 private int playpegcount;
 private int showpegcount;
private int score; 
private boolean dealer;
private boolean pone;
private ArrayList <Card> cards;
private ArrayList <Card> crib ;


private ArrayList<Card> makeCards(){
    Random ran= new Random(); 
    ArrayList<Card> x= new ArrayList();
    for(int i=0;i<6;i++){
        x.add(Card.getCard(ran.nextInt(52)));
    }
  return x;  
}
public static boolean rupone(){
     Random ran= new Random();
     int x=ran.nextInt(2);
     return x==1;
     }
 public final ArrayList<Card> makeCrib(ArrayList<Card> cribpick){
        
        for(Card x: cribpick){
            crib.add(x);
        }
        
        
        return crib;
        // allow each player to pick two cards form their deck
        //those two cards are passed to the the make crib() and added to the crib arraylist
        //the arrayList is given to the player constructor of the player who is a dealer.
    }
public Player(){
    this.playpegcount=0;
   this.showpegcount=0;
    this.score=0;
    this.pone=rupone();
    this.dealer=!rupone();
    this.cards=makeCards();
    if(dealer){
        this.crib=makeCrib(provCrib());;
    }else{
        this.makeCrib(provCrib());
    }
}
public final ArrayList<Card> provCrib(){
    Scanner read1= new Scanner(System.in);
     ArrayList<Card> picked= new ArrayList();
    while (picked.size()<2){
    System.out.println("Please pick a card to put in the crib, 1 for the 1st card and 2 for the second card...");
    System.out.println(this.cards);
    int pick= read1.nextInt();
   while(pick<1){
       System.out.println("Invalid number");
        System.out.println(this.cards);
        pick= read1.nextInt();    
   }
    picked.add(this.cards.get(pick-1));
    this.cards.remove(pick-1);
    System.out.println(this.cards);
    }
        return picked;
        }
    

public int getPPC(){
    return this.playpegcount;
}
public int getSPC(){
    return this.showpegcount;
}
public int getScore(){// amount of point accumulated in a hand or show.
    return  this.score;
}
public boolean getDealer(){
    return this.dealer;
    
}
public boolean getPone(){
    return this.pone;
}
 public ArrayList<Card> getCards(){
     return this.cards;
 }
 public ArrayList<Card> getCrib(){
     if(this.dealer){
         return this.crib;
     }
     else return null;
 }

@Override
public String toString(){
    return String.format("playpegcount: %d \n showpegcount:%d \n score: %d \n dealer:%b \n pone: %b\n  cards: %s\n crib : %s",getPPC(),getSPC(), getScore(),getDealer(),getPone(), getCards(),getCrib());
}

}
