
import java.util.ArrayList;

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
public class Show {
    //Pone show mthod,counts all points, then assigns to the player the ponts
    //same thing for dealer but with crib
    //main play method that takes two p;ayers find the dealer and pone and applie their speciic methods

    private Player dealer;
    private Player pone;
    private int dealerpoints;
    private int ponepoints;

    public Show(Player a, Player b) {
        if (a.ruDealer()) {
            this.dealer = a;
            this.pone = b;
        } else {
            this.dealer = b;
            this.pone = a;
        }
        dealerpoints = 0;
        ponepoints = 0;
    }

    public void show() {
        this.dealer.setSPC(dealershow());
        this.pone.setSPC(poneshow());
    }

    public int poneshow() {
        ArrayList<Card> ponecards = new ArrayList();
        ponecards = this.pone.getCards();
        return ponecheck(ponecards);

    }

    public int dealershow() {
        ArrayList<Card> dealercards = new ArrayList();
        for (Card x : this.dealer.getCrib()) {
            dealercards.add(x);
        }
        for (Card y : this.dealer.getCards()) {
            dealercards.add(y);
        }
        return dealercheck(dealercards);
    }

    public int dealercheck(ArrayList<Card> cards) {
//int sum= fifteen(cards);
return sum;
    }

    public int ponecheck(ArrayList<Card> cards) {
return 0;
    }

    public int pair(ArrayList<Card> cards) {
        int pairsum = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 1; j < cards.size(); j++) {
                if (i != j && cards.get(i).getRank() == cards.get(j).getRank()) {
                    pairsum = pairsum + 2;
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
                    }
                }

            }
        }
        return pairsum;
    }

    public int fourpair(ArrayList<Card> cards) {
        int pairsum = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 1; j < cards.size(); j++) {
                for (int e = 2; e < cards.size(); e++) {
                    for (int z = 2; z < cards.size(); z++) {

                        if ((i != j) && (j != e) && (e != z) && (cards.get(i).getRank() == cards.get(j).getRank()) && (cards.get(j).getRank() == cards.get(e).getRank()) && ((cards.get(e).getRank() == cards.get(z).getRank()))) {
                            pairsum = pairsum + 6;
                        }
                    }
                }

            }
        }
        return pairsum;
    }
    public int pairfifteen(ArrayList<Card> cards) {
        int fifteensum = 0;
        int j = 1;
        for (int i = 0; i < cards.size()-1; i++) {
            for ( ; j < cards.size(); j++) {
               if(cards.get(i).getRank().count()+ cards.get(cards.size()-j).getRank().count()==15);
               fifteensum=fifteensum+2;
            }
            j++;
           
        }
         return fifteensum/2;
    }
        
         public int threefifteen(ArrayList<Card> cards) {
        int fifteensum = 0;
       if(cards.get(0).getRank().count()+ cards.get(1).getRank().count()+ cards.get(2).getRank().count()==15){
               fifteensum=fifteensum+2;
            }
        if(cards.get(0).getRank().count()+ cards.get(1).getRank().count()+ cards.get(3).getRank().count()==15){
               fifteensum=fifteensum+2;
            }
         if(cards.get(0).getRank().count()+ cards.get(2).getRank().count()+ cards.get(3).getRank().count()==15){
               fifteensum=fifteensum+2;
            }
          if(cards.get(1).getRank().count()+ cards.get(2).getRank().count()+ cards.get(3).getRank().count()==15){
               fifteensum=fifteensum+2;
            }
         
            return fifteensum/2;
        }
          public int fourfifteen(ArrayList<Card> cards) {
        int fifteensum = 0;
         if(cards.get(0).getRank().count()+ cards.get(1).getRank().count()+ cards.get(2).getRank().count()+ cards.get(3).getRank().count()==15){
               fifteensum=fifteensum+2;
            }
         return fifteensum;
          }

   

    
}
