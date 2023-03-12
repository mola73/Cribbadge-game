
import java.util.ArrayList;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
// mae subclass of human and cpu from Player then oveeride a play method in each subclass
//cannot join between crib and hand mae a method that finds combinations of 4 cards at a time and apply to beth hand and crib.
public class Show {// everything works but the run method

    //Pone show mthod,counts all points, then assigns to the player the ponts
    //same thing for dealer but with crib
    //main play method that takes two p;ayers find the dealer and pone and applie their speciic methods
// the show has 5 cards each because of the start card
    private Player dealer;
    private Player pone;
    private int dealerpoints;
    private int ponepoints;
    private Card starterCard;

    public Show(Player a, Player b, Card startCard) {
        if (a.ruDealer()) {
            this.dealer = a;
            this.pone = b;
        } else {
            this.dealer = b;
            this.pone = a;
        }
        dealerpoints = 0;
        ponepoints = 0;
        starterCard = startCard;
    }

    public int check(ArrayList<Card> cards) {
        return pair(cards) + threepair(cards) + fourpair(cards) + pairfifteen(cards) + threefifteen(cards) + fourfifteen(cards)+ run(cards)  + fourflush(cards) + fiveflush(cards) + oneForHisNob(cards);
    }

    public void show() {
        this.dealer.setSPC(dealershow());
        this.pone.setSPC(poneshow());
    }

    public int poneshow() {
        ArrayList<Card> ponecards = new ArrayList();
        for (Card x : this.pone.getCards()) {
            ponecards.add(x);
        }
        ponecards.add(starterCard);
        return check(ponecards);

    }

    public int dealershow() {// the cards are not being copied properly sot he play is stopping i think
        ArrayList<Card> dealercards = new ArrayList();
        ArrayList<Card> dealercrib = new ArrayList();
        for (Card x : this.dealer.getCards()) {
            dealercards.add(x);
        }
        for (Card y : this.dealer.getCrib()) {
            dealercrib.add(y);
        }
        dealercards.add(starterCard);
        dealercrib.add(this.starterCard);

        return check(dealercards) + check(dealercrib);

    }

    public int pair(ArrayList<Card> cards) {
        int pairsum = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 1; j < cards.size(); j++) {
                if (i != j && cards.get(i).getRank() == cards.get(j).getRank()) {
                    pairsum = pairsum + 2;
                    System.out.println(cards.get(i).getRank()+ "  "+ cards.get(j).getRank());
                }

            }
        }
        return pairsum;
    }

    public int threepair(ArrayList<Card> cards) {
        int pairsum = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 1; j < cards.size(); j++) {
                for (int e = 2; e < cards.size(); e++) {

                    if ((i != j) && (j != e) && (cards.get(i).getRank() == cards.get(j).getRank()) && (cards.get(j).getRank() == cards.get(e).getRank())) {
                        pairsum = pairsum + 6;
                         System.out.println(cards.get(i).getRank()+ "  "+ cards.get(j).getRank()+" "+ cards.get(i).getRank());
                    }
                }

            }
        }
        return pairsum;
    }

    public int fourpair(ArrayList<Card> cards) {
        int pairsum = 0;

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (i != j) {
                    if (cards.get(i).getSuit() == cards.get(j).getSuit()) {
                        pairsum++;
                    }
                    if (pairsum == 4) {
                        System.out.println(cards.get(i).getRank()+ "  "+ cards.get(j).getRank());
                        return 4;
                        

                    }
                }
            }
            pairsum = 0; //reset the counter if there are not 4 same suites. 
        }
        return 0;

    }

    public int pairfifteen(ArrayList<Card> cards) {
        int fifteensum = 0;
        int j = 1;
        for (int i = 0; i < cards.size() - 1; i++) {
            for (; j < cards.size(); j++) {
                if (cards.get(i).getRank().count() + cards.get(cards.size() - j).getRank().count() == 15);
                fifteensum = fifteensum + 2;
                System.out.println(cards.get(i).getRank().count() +" " +cards.get(cards.size() - j).getRank().count());
            }
            j++;

        }
        return fifteensum / 2;
    }

    public int run(ArrayList<Card> cards) {//this has a problem
        int runcount = 0;
        ArrayList<Integer> cardnums = new ArrayList();
        for (Card x : cards) {
            cardnums.add(x.getRank().count()); //putthe count of the cards in an arraylist
        }
        Collections.sort(cardnums);
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < cardnums.size(); j++) {
                if (cardnums.get(i) == cardnums.get(j) - j) {//if 2 numbers are cnsecutive count it.
                    runcount++;
                }
                if (runcount >= 3) { //if 3 or more cards are consecutive return that
                    System.out.println(cardnums.get(i)+" "+ cardnums.get(j));
                    return runcount;
                }
            }
        }
        return 0;
    }

    public int fourflush(ArrayList<Card> cards) {
        int suitcount = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (i != j) {
                    if (cards.get(i).getSuit() == cards.get(j).getSuit()) {
                        suitcount++;
                    }
                    if (suitcount == 4) {
                        return 4;

                    }
                }
            }
            suitcount = 0; //reset the counter if there are not 4 same suites. 
        }
        return 0;
    }

    public int fiveflush(ArrayList<Card> cards) {
        if ((cards.get(0).getSuit() == cards.get(1).getSuit()) && (cards.get(1).getSuit() == cards.get(2).getSuit()) && (cards.get(2).getSuit() == cards.get(3).getSuit()) && (cards.get(3).getSuit() == cards.get(4).getSuit())) {

            return 5;
        }
        return 0;
    }

    public int oneForHisNob(ArrayList<Card> cards) {
        for (Card x : cards) {
            if(!this.starterCard.equals(x)){// becasue the card has been addd to the ArrayList so to bypass the copy already in the arraylist
            if (x.getSuit() == this.starterCard.getSuit()) {
                System.out.println(x+ "  one for his nob");
                return 2;
            }
            }
        }
        return 0;
    }

    public int threefifteen(ArrayList<Card> cards) {// change this 
        int fifteensum = 0;
        if (cards.get(0).getRank().count() + cards.get(1).getRank().count() + cards.get(2).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
        }
        if (cards.get(0).getRank().count() + cards.get(1).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
        }
        if (cards.get(0).getRank().count() + cards.get(2).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
        }
        if (cards.get(1).getRank().count() + cards.get(2).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
        }

        return fifteensum / 2;
    }

    public int fourfifteen(ArrayList<Card> cards) {//change this
        int fifteensum = 0;
        if (cards.get(0).getRank().count() + cards.get(1).getRank().count() + cards.get(2).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
        }
        return fifteensum;
    }

    public static void main(String[] args) {

    }

}
