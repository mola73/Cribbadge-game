/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import static com.mycompany.score.Card.getCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mpereira
 */
public class Play extends HumanPlay {
// Redo check method, add it into the main play method of this class,test if the methods work.
    private static int count = 0;
    private static int playSum = 0;
    private ArrayList<Card> Play;

    public ArrayList<Card> getPlay() {
        return Play;
    }

    public void setPlay(Card c) {
        this.Play.add(c);
    }

    public Play(ArrayList<Card> Play) {
        this.Play = Play;
    }

    public void play(Player human, Player cpu) {
        Play play = new Play(new ArrayList());
        ArrayList<Card> hcards = human.getCards();//copy of human's card
        ArrayList<Card> cpucards = cpu.getCards();//copy of cpu's cards
        //int tnumb=2;
        Player x = human.getP1(cpu);// calls method that returns  who is the pone

        while (!(hcards.isEmpty()) && !(cpucards.isEmpty())) {

            if (x.ruHumanb()) { //if human
                hcards = play.play(human, play);
                System.out.println("updated card  "+ hcards );
                System.out.println(play);
           x = x.switchPlayer(cpu);// switches the player
            }
            
            if (!x.ruHumanb()) {//if non human(cpu)
                cpucards = play.play(cpu, play);
                 System.out.println("updated card  "+ cpucards );
                  System.out.println(play);
                  check
                   x = x.switchPlayer(human);// switches the player
            }
            }
            

        }
    

//    public static void play(Player human, Player cpu) {
//        
//        Play play = new Play(new ArrayList());
//        Random rand = new Random();
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Card> hcards = human.getCards();//copy of human's card
//        ArrayList<Card> cpucards = cpu.getCards();//copy of cpu's cards
////        ArrayList<Card> play = new ArrayList();// list to track placement of cards in play
//        int tnumb = 2;// tnumb is counting the count of turns for the paly. the pone puts a card down 1st, the dealer puts a card second.....
//        int cpick = 0;
//        //assigning the pone
//        Player x = human;
//        if (!human.ruDealer()) {
//            x = human;
//        } else {
//            if (!human.ruDealer()) {
//                x = cpu;
//            }
//
//        }
//
//        System.out.println("THE    ROUND    BEGINSSSS");
//        while (!(hcards.isEmpty()) && !(cpucards.isEmpty())) { //while all the card of both players are not used
//            //this part switches the player in the play
//            if (tnumb % 2 == 0) {
//                if (human.ruDealer()) {
//                    x = human;
//                } else {
//                    x = cpu;
//                }
//            }
//            if (tnumb % 2 != 0) {
//                if (human.ruDealer()) {
//                    x = human;
//                } else {
//                    x = cpu;
//                }
//            }
//
//            System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....", x.getStatus(), x.ruHuman());
//            System.out.printf("%s \n\n", x.getCards());
//
//            if (x.ruHumanb()) {
//                cpick = sc.nextInt();
//            }
//            if (!x.ruHumanb()) {
//                cpick = rand.nextInt(x.getCards().size() + 1);// pick random number from 1 to4, then from 1 to 3... 
//            }
//
//            if (go(x, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO
//                play.clear();
//                System.out.println(x + " Says: GO!");
//                continue;
//            }
//
//            play.add(x.getCards().get(cpick - 1));//put the selected card into the arraylist called play to keep track of the placed cards
//
//            playSum = playSum + x.getCards().get(cpick - 1).getRank().count();
//            
//            //CHECK METHOD SHOULD BE AROUND HERE
//            
//            if (x.ruHumanb()) {//delete the given card
//                hcards.remove(cpick - 1);
//            }
//            if (!x.ruHumanb()) {
//                cpucards.remove(cpick - 1);
//            }
//            tnumb++;// move to the next turn
//            System.out.println(play);
//
//            if (playSum >= 31) {
//                play.clear();
//                playSum = 0;
//            }
//        }
//  }

    public static int pair(ArrayList<Card> c1) {
        if (c1.size() >= 2) {
            if (c1.get(count).getRank() == c1.get(count + 1).getRank()) {
                System.out.println(c1.get(count).getRank() + "  " + c1.get(count + 1).getRank());
                count++;
                return 2;

            }
            count++;
            return 0;
        }
        return 0;
    }

    public static int threePair(ArrayList<Card> c1) {
        if (c1.size() >= 3) {
            if (c1.get(count).getRank() == c1.get(count + 1).getRank() && c1.get(count).getRank() == c1.get(count + 2).getRank()) {
                System.out.println(c1.get(count).getRank() + "  " + c1.get(count + 1).getRank());
                count++;
                return 6;

            }
            count++;
            return 0;
        }
        return 0;
    }

    public static int fourPair(ArrayList<Card> c1) {
        if (c1.size() >= 4) {
            if (c1.get(count).getRank() == c1.get(count + 1).getRank() && c1.get(count).getRank() == c1.get(count + 2).getRank() && c1.get(count).getRank() == c1.get(count + 3).getRank()) {
                System.out.println(c1.get(count).getRank() + "  " + c1.get(count + 1).getRank());
                count++;
                return 12;

            }
            count++;
            return 0;
        }
        return 0;
    }
    public static boolean sequncheck(int c1, int c2) {
        return c1 == c2 + 1;

    }

    public static int run(ArrayList<Card> c1) {
        ArrayList<Integer> sortedCards = new ArrayList();
        int pointCount = 0;
        for (Card c : c1) {
            sortedCards.add(c.getRank().count());
            Collections.sort(sortedCards);
        }
        if (sortedCards.size() > 2) {
            for (int i = 1; i < sortedCards.size(); i++) {
                pointCount = i;
                if (sequncheck(sortedCards.get(i), sortedCards.get(i - 1)) && i >= 2) {//THE EQUAL OR HIGHER THAN 2 IS TO MAKE SURE THERE ARE AT LEAST THREE OR MORE CARDS THAT ARE EQUAL
                    pointCount = pointCount + 1;//SUMS UP THE POINTS THAT WILL BE RETURNED
                } else if (!sequncheck(sortedCards.get(i), sortedCards.get(i - 1)) && i >= 2) {//SO, WHEN IT IS FALSE, BUT i IS STILL HIGHER THAN 2
                    return pointCount;
                }

//                if(sortedCards.get(i)+1 == sortedCards.get(i+1)) {//&& sortedCards.get(i)+1 == sortedCards.get(i+2)-1){
//                    return 3;
//                }
            }
        }
        return 0;
    }

    public static int fifteen(ArrayList<Card> c1) {
        int sum = 0;
        for (Card c : c1) {
            sum = sum + c.getRank().count();
            if (sum == 15) {
                return 2;
            }
        }
        return 0;
    }

    public static boolean go(Player p1, int cpick) {
        if (playSum + p1.getCards().get(cpick - 1).getRank().count() > 31) {
            return true;
        } else {
            return false;
        }
    }

    public static int total31(ArrayList<Card> hCard, ArrayList<Card> cCard, int playSum) {//the ArrayList used here is either hcards or cpucards
        if (playSum == 31 && hCard.size() + cCard.size() == 1) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int less31(ArrayList<Card> hCard, ArrayList<Card> cCard, int playSum) {//the ArrayList used here is either hcards or cpucards
        if (playSum < 31 && hCard.size() + cCard.size() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {// IT WORKS
        ArrayList<Card> card1 = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            card1.add(Card.getCard(rnd.nextInt(52)));
            run(card1);
        }

    }
}
