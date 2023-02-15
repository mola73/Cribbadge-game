
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

    private ArrayList<Card> deck = new ArrayList();

    public Deck() {
        ArrayList<Card> fill = new ArrayList();
        Rank[] rank = Rank.values();
        Suit[] suit = Suit.values();
        for (int x = 0; x < rank.length; x++) {
            for (int j = 0; j < suit.length; j++) {

                fill.add(Card.getCard(rank[j], suit[x]));
            }
        }
        this.deck = fill;
    }

    public static void main(String[] args) {

        System.out.println(Card.getDeck());
    }

//    public ArrayList<Card> getDeck(){
//        return this.deck;
//    }
}
