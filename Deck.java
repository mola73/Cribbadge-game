
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
        ArrayList<Card> humancard= new ArrayList();
        ArrayList<Card> cpucard= new ArrayList();
        for(int i= 0;i<6;i++){
          humancard.add(this.deck.get(i));
    }
        human.setCards(humancard);
        
         for(int j= 6;j<12;j++){
           cpucard.add(this.deck.get(j));
    } 
         CPU.setCards(cpucard);
    }
         
    @Override
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
