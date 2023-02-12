/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**Muhammad Alfatih Olaniyan
 * UNBC ID:230148724
 * 
 *
 * @author muham
 */
import java.util.ArrayList;

public class Card {

    ArrayList cards = new ArrayList();
    private Rank cardrank;
    private Suit cardsuit;

    private Card(Rank r, Suit s) { //Constructors
        this.cardrank = r;
        this.cardsuit = s;
    }

    private Card(int i) {//Make an array of all 52 cards and pick 1 with i, then assign it to the attributes being created
 ArrayList<Card> deck = new ArrayList();
 Rank[] r= Rank.values();
 Suit[] s=Suit.values();
        for (Suit x  : s) {
            for (Rank y: r) {
                deck.add(new Card(y, x));
            }  
        }
        if (i >= 0 && i <= 52) {
            this.cardrank = deck.get(i).getRank();
            this.cardsuit = deck.get(i).getSuit();
        }
    }
    
    public static ArrayList<Card> getDeck(){// how do i make a deck in a class?
         ArrayList<Card> deck = new ArrayList();
 Rank[] ranks= Rank.values();
 Suit[] suits=Suit.values();
 for(int x=0;x<4;x++){
     for(int j=0;j<ranks.length;j++){
          
         deck.add(new Card(ranks[j],suits[x]));
     }
 }
 return deck;
    }

    public static Card getCard(Rank r, Suit s) { // public static mhtods for Constructors
        return new Card(r, s);
    }

    public static Card getCard(int i) {
        return new Card(i);
    }

    public Rank getRank() {
        return this.cardrank;
    }

    public Suit getSuit() {
        return this.cardsuit;
    }

    public String getCribCount(ArrayList<Card> Cards, String line) {
        int sum = 0;
        for (Card x : Cards) {
            sum = sum + x.cardrank.count();
        }

        return String.format("%s : total count is %d", line, sum);
    }

    public static String getfifteens(ArrayList<Card> cards2, String cl) {
        if (cards2.size() > 5 || cards2.size() < 5) {
            return String.format("That is not 5 cards");
        }
        int comb = 0;

        for (Card x : cards2) {
            int i;
            for (i = 0; i < cards2.size(); i++) {

                if ((cards2.get(i).getRank().count()) + (x.getRank().count()) == 15 && (x != cards2.get(i))) {
                    ++comb;
                }

            }
        }

        return String.format("%s : there are %d fifteens", cl, comb / 2);
    }

    public static Rank convertRank(String x) {// convert a string to rank type
        Rank y = null;
        switch (x) {
            case "A":
                y = Rank.Ace;
                break;
            case "2":
                y = Rank.Two;
                break;
            case "3":
                y = Rank.Three;
                break;
            case "4":
                y = Rank.Four;
                break;
            case "5":
                y = Rank.Five;
                break;
            case "6":
                y = Rank.Six;
                break;
            case "7":
                y = Rank.Seven;
                break;
            case "8":
                y = Rank.Eight;
                break;
            case "9":
                y = Rank.Nine;
                break;
            case "T":
                y = Rank.Ten;
                break;
            case "K":
                y = Rank.King;
                break;
            case "Q":
                y = Rank.Queen;
                break;
            case "J":
                y = Rank.Jack;
                break;
        }
        return y;
    }

    public static Suit convertSuit(String x) {//convert a Stirng to a suit type
        Suit y = null;
        switch (x) {
            case "C":
                y = Suit.Clubs;
                break;
            case "H":
                y = Suit.Hearts;
                break;
            case "D":
                y = Suit.Diamonds;
                break;
            case "S":
                y = Suit.Spades;
                break;

        }
        return y;
    }

    public static Card convertCard(Rank r, Suit s) {

        return getCard(r, s);

    }

    public char symbol(Suit x) {// switch a given a suit to its symbol

        char symbol = ' ';
        switch (x) {
            case Clubs:
                symbol = '\u2663';

            case Diamonds:
                symbol = '\u2662';
                break;
            case Hearts:
                symbol = '\u2661';
                break;
            case Spades:
                symbol = '\u2660';
                break;
        }
        return symbol;
    }

//
    @Override
    public String toString() {// How do i print a rank and suit type. %...  %...
        return String.format("%s of %s", this.getRank(), symbol(this.getSuit()));
    }

}
