
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
import java.util.Random;
public class Deck {
Random rand= new Random();
    private ArrayList<Card> deck = new ArrayList();

    public Deck() {
        ArrayList<Card> fill = new ArrayList();
        Rank[] rank = Rank.values();
        Suit[] suit = Suit.values();
        for (Suit suit1 : suit) {
     for (Rank rank1 : rank) {
                fill.add(Card.getCard(rank1, suit1));
            }
    }
        this.deck = fill;
    }
    
    public void shuffle(){
        
        for(Card x: this.deck){
            int randnum=rand.nextInt(52);
          this.deck.set(randnum,x);// takes a random index and puts the Card x in  that index
            
        }
    }
    public ArrayList<Card> getDeck(){
        return this.deck;
    }
    public  void organizeDeck(){
       ArrayList<Card> fill = new ArrayList();
        Rank[] rank = Rank.values();
        Suit[] suit = Suit.values();
         for (Suit suit1 : suit) {
    for (Rank rank1 : rank) {
                fill.add(Card.getCard(rank1, suit1));
            }
    }
        this.deck = fill;
       }
        
    public void dealCards(Player human,Player CPU){//finish this
        for(int i= 0;i<6;i++){
            human.setCards(this.deck.get(i));
    }
         for(int j= 6;j<12;j++){
            human.setCards(this.deck.get(j));
    }
    
    public String toString(){
        return String.format("%s",this.deck);
    }

    public static void main(String[] args) {
Deck a= new Deck();
a.shuffle();
        System.out.println(a);
        a.organizeDeck();
        System.out.println(a);
    }


}
