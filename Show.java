
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

        System.out.println("-------------------The Show-----------------");
        System.out.println("card list" + cards);
        return pair(cards) + threepair(cards) + fourpair(cards) + pairfifteen(cards) + threefifteen(cards) + fourfifteen(cards) + run(cards) + fourflush(cards) + fiveflush(cards) + oneForHisNob(cards);
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

    public int dealershow() {
        ArrayList<Card> dealercards = new ArrayList();
        ArrayList<Card> dealercrib = new ArrayList();
        for (Card x : this.dealer.getCards()) {
            dealercards.add(x);
        }
        for (Card y : this.dealer.getCrib()) {
            dealercrib.add(y);
        }
        dealercards.add(this.starterCard);
        dealercrib.add(this.starterCard);

        return check(dealercards) + check(dealercrib);

    }

    public int pair(ArrayList<Card> cards) {
        int j = 0;
        int pairsum = 0;
        for (int i = 0; i < 4; i++) {
            j++;
            for (; j < cards.size(); j++) {
                if (cards.get(i).getRank().equals(cards.get(j).getRank())) {
                    pairsum = pairsum + 2;
                    System.out.println("pair" + cards.get(i).getRank() + "  " + cards.get(j).getRank());

                }

            }

        }
        return pairsum;
    }

    public int threepair(ArrayList<Card> cards) {
        int pairsum = 0;

        ArrayList<Integer> cardnums = new ArrayList();
        for (Card x : cards) {
            cardnums.add(x.getRank().count()); //putthe count of the cards in an arraylist
        }

        Collections.sort(cardnums);
        if (cardnums.get(0).equals(cardnums.get(1)) && cardnums.get(1).equals(cardnums.get(2)) && cardnums.get(2).equals(cardnums.get(3))) {
            pairsum += 6;
            System.out.printf("three pair %s  %s %s ", cardnums.get(0), cardnums.get(1), cardnums.get(2));

        }
        if (cardnums.get(1).equals(cardnums.get(2)) && cardnums.get(2).equals(cardnums.get(3)) && cardnums.get(3).equals(cardnums.get(4))) {
            pairsum += 6;
            System.out.printf("three pair %s  %s %s ", cardnums.get(1), cardnums.get(2), cardnums.get(3));

        }

        return pairsum;
    }

    public int fourpair(ArrayList<Card> cards) {
        int pairsum = 0;

        ArrayList<Integer> cardnums = new ArrayList();
        for (Card x : cards) {
            cardnums.add(x.getRank().count()); //putthe count of the cards in an arraylist
        }

        Collections.sort(cardnums);
        if (cardnums.get(0).equals(cardnums.get(1)) && cardnums.get(1).equals(cardnums.get(2)) && cardnums.get(2).equals(cardnums.get(3))) {
            pairsum += 6;
            System.out.printf("four pair %s  %s %s ", cardnums.get(0), cardnums.get(1), cardnums.get(2), cardnums.get(3));
        }
        if (cardnums.get(1).equals(cardnums.get(2)) && cardnums.get(2).equals(cardnums.get(3)) && cardnums.get(3).equals(cardnums.get(4))) {
            pairsum += 6;
            System.out.printf("four pair %s  %s %s ", cardnums.get(1), cardnums.get(2), cardnums.get(3), cardnums.get(4));
        }

        return pairsum;

    }

    public int pairfifteen(ArrayList<Card> cards) {
        int fifteensum = 0;
        int j = 1;
        int x;
        for (int i = 0; i < 4; i++) {

            for (; j < cards.size(); j++) {
                if (cards.get(i).getRank().count() + cards.get(j).getRank().count() == 15) {
                    fifteensum = fifteensum + 2;
                    System.out.println("pair fifteen " + cards.get(i).getRank().count() + " " + cards.get(j).getRank().count());
                }
            }
            j++;

        }
        return fifteensum;
    }

    public int run(ArrayList<Card> cards) {//this has a problem
        int runcount = 0;
        ArrayList<Integer> cardnums = new ArrayList();
        for (Card x : cards) {
            cardnums.add(x.getRank().count()); //putthe count of the cards in an arraylist
        }
        Collections.sort(cardnums);
        for (int i = 0; i < 4; i++) {
            if (cardnums.get(i) == cardnums.get(i + 1) - 1) {//if 2 numbers are cnsecutive count it.
                runcount++;
            }
            if (runcount >= 3) { //if 3 or more cards are consecutive return that
                System.out.println("run of" + runcount + " cards");
                return runcount;
            }

        }
        return 0;
    }

    public int fourflush(ArrayList<Card> cardnums) {
        int fourcount = 0;
        if (cardnums.get(0).equals(cardnums.get(1)) && cardnums.get(1).equals(cardnums.get(2)) && cardnums.get(2).equals(cardnums.get(3))) {
            fourcount += 4;
            System.out.printf("four pair %s  %s %s ", cardnums.get(0), cardnums.get(1), cardnums.get(2), cardnums.get(3));
        }
        if (cardnums.get(1).equals(cardnums.get(2)) && cardnums.get(2).equals(cardnums.get(3)) && cardnums.get(3).equals(cardnums.get(4))) {

            System.out.printf("four pair %s  %s %s ", cardnums.get(1), cardnums.get(2), cardnums.get(3), cardnums.get(4));
            fourcount += 4;
        }
        return fourcount;
    }

    public int fiveflush(ArrayList<Card> cards) {
        if ((cards.get(0).getSuit() == cards.get(1).getSuit()) && (cards.get(1).getSuit() == cards.get(2).getSuit()) && (cards.get(2).getSuit() == cards.get(3).getSuit()) && (cards.get(3).getSuit() == cards.get(4).getSuit())) {
            System.out.println("fiveflush");
            return 5;
        }
        return 0;
    }

    public int oneForHisNob(ArrayList<Card> cards) {
        for (Card x : cards) {
            if (!this.starterCard.equals(x)) {// becasue the card has been addd to the ArrayList so to bypass the copy already in the arraylist
                if (x.getSuit() == this.starterCard.getSuit()) {
                    System.out.println(x + "  one for his nob");
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
            System.out.printf("  three fifteen %d %d %d%n", cards.get(0).getRank().count(), cards.get(1).getRank().count(), cards.get(2).getRank().count());
        }
        if (cards.get(0).getRank().count() + cards.get(1).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("  three fifteen %d %d %d%n", cards.get(0).getRank().count(), cards.get(1).getRank().count(), cards.get(3).getRank().count());
        }

        if (cards.get(0).getRank().count() + cards.get(1).getRank().count() + cards.get(4).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("  three fifteen %d %d %d%n", cards.get(0).getRank().count(), cards.get(1).getRank().count(), cards.get(4).getRank().count());
        }
        if (cards.get(0).getRank().count() + cards.get(2).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("  three fifteen %d %d %d%n", cards.get(0).getRank().count(), cards.get(2).getRank().count(), cards.get(3).getRank().count());
        }
        if (cards.get(0).getRank().count() + cards.get(2).getRank().count() + cards.get(4).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("  three fifteen %d %d %d%n", cards.get(0).getRank().count(), cards.get(2).getRank().count(), cards.get(4).getRank().count());
        }
        if (cards.get(0).getRank().count() + cards.get(3).getRank().count() + cards.get(4).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("  three fifteen %d %d %d%n", cards.get(0).getRank().count(), cards.get(3).getRank().count(), cards.get(4).getRank().count());
        }
        if (cards.get(1).getRank().count() + cards.get(2).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("  three fifteen %d %d %d%n", cards.get(1).getRank().count(), cards.get(2).getRank().count(), cards.get(3).getRank().count());
        }
        if (cards.get(1).getRank().count() + cards.get(2).getRank().count() + cards.get(4).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("  three fifteen %d %d %d%n", cards.get(1).getRank().count(), cards.get(2).getRank().count(), cards.get(4).getRank().count());
        }

        return fifteensum;
    }

    public int fourfifteen(ArrayList<Card> cards) {//change this
        int fifteensum = 0;
        if (cards.get(0).getRank().count() + cards.get(1).getRank().count() + cards.get(2).getRank().count() + cards.get(3).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("four fifteen %d %d %d %d", cards.get(0).getRank().count(), cards.get(1).getRank().count(), cards.get(2).getRank().count(), cards.get(3).getRank().count());
        }
        if (cards.get(1).getRank().count() + cards.get(2).getRank().count() + cards.get(3).getRank().count() + cards.get(4).getRank().count() == 15) {
            fifteensum = fifteensum + 2;
            System.out.printf("four fifteen %d %d %d %d", cards.get(1).getRank().count(), cards.get(2).getRank().count(), cards.get(3).getRank().count(), cards.get(4).getRank().count());
            fifteensum = fifteensum + 2;

        }
        return fifteensum;
    }

    public static void main(String[] args) {

    }

}
