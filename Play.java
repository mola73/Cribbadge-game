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
    //THE RANDOM IS NOT WORKIG OF RTHE CPUPLAY, FIX THE CONSTARINTS ON THE CPU RAND INTEGER,EVERYTHING ELSE IS OK, JUST TEST ECH COMBINATION ONE BY ONE.
// Make point methods private,test if the methods work.

    private static int count = 0;
    private int playSum;
    private ArrayList<Card> PlayList;

    public ArrayList<Card> getPlayList() {
        return PlayList;
    }
//Play playList1 = new Play(new ArrayList());

    public ArrayList<Card> getPlay() {
        return PlayList;
    }

    public void setPlay(Card c) {
        this.PlayList.add(c);
    }

    public Play(ArrayList<Card> Play) {
        this.PlayList = Play;
        this.playSum = 0;
    }

    public void setplaySum(int cardcount) {
        playSum = playSum + cardcount;
    }

    public void play(Player human, Player cpu) {

        ArrayList<Card> hcards = human.getCards();//copy of human's card
        ArrayList<Card> cpucards = cpu.getCards();//copy of cpu's cards
        //int tnumb=2;
        Player x = human.getP1(cpu);// calls method that returns  who is the pone

        while (!(hcards.isEmpty()) && !(cpucards.isEmpty())) {

            if (x.ruHumanb()) { //if human
                hcards = this.play(human, cpu, this, hcards, cpucards);
                System.out.println("updated card  " + hcards);
                System.out.println(this);
                x.setPPC(this.check());
                x = x.switchPlayer(cpu);// switches the player
            }

            if (!x.ruHumanb()) {//if non human(cpu)
                cpucards = this.play(cpu, human, this, cpucards, hcards);
                System.out.println("updated card  " + cpucards);
                System.out.println(this);
                x.setPPC(this.check());
                x = x.switchPlayer(human);// switches the player
            }
        }
    }

    public void changeRemC(int cpick, ArrayList<Card> playerpickcards) { //This method updates the Player a's remaining pick cards after a card is put down
        // playerpickcards = playList1.play(a ,b,playList1);
        playerpickcards.remove(cpick);
    }

    public void resetpicklist() {
        this.PlayList.clear();
    }
    //  public void

//if (go(x, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO
//              play.clear();               
//              System.out.println(x + " Says: GO!");
//              continue;
//        }
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
    public int pair() {
        if (this.PlayList.size() >= 2) {
            if (this.PlayList.get(count).getRank() == this.PlayList.get(count + 1).getRank()) {
                System.out.println(this.PlayList.get(count).getRank() + "  " + this.PlayList.get(count + 1).getRank());
                count++;
                return 2;

            }
            count++;
            return 0;
        }
        return 0;
    }

    public int threePair() {
        if (this.PlayList.size() >= 3) {
            if (this.PlayList.get(count).getRank() == this.PlayList.get(count + 1).getRank() && this.PlayList.get(count).getRank() == this.PlayList.get(count + 2).getRank()) {
                System.out.println(this.PlayList.get(count).getRank() + "  " + this.PlayList.get(count + 1).getRank());
                count++;
                return 6;

            }
            count++;
            return 0;
        }
        return 0;
    }

    public int fourPair() {
        if (this.PlayList.size() >= 4) {
            if (this.PlayList.get(count).getRank() == this.PlayList.get(count + 1).getRank() && this.PlayList.get(count).getRank() == this.PlayList.get(count + 2).getRank() && this.PlayList.get(count).getRank() == this.PlayList.get(count + 3).getRank()) {
                System.out.println(this.PlayList.get(count).getRank() + "  " + this.PlayList.get(count + 1).getRank());
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

    public int run() {
        ArrayList<Integer> sortedCards = new ArrayList();
        int pointCount = 0;
        for (Card c : this.PlayList) {
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

    public int fifteen() {
        int sum = 0;
        for (Card c : this.PlayList) {
            sum = sum + c.getRank().count();
            if (sum == 15) {
                return 2;
            }
        }
        return 0;
    }

    public boolean go(Player p1, int cpick) {
        if (this.playSum + p1.getCards().get(cpick - 1).getRank().count() > 31) {
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

    public int check() {
         this.playSum =this.playSum+ this.pair();
        return playSum;

    }

    public String toStirng() {
        return String.format("Play List %s %n Playsum: %d", this.PlayList, this.playSum);
    }

    public static void main(String[] args) {// IT WORKS
        ArrayList<Card> card1 = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            card1.add(Card.getCard(rnd.nextInt(52)));

        }

    }
}
