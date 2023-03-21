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
public class Play {
    //Try making the construcotr figure out who the player is and dealer/non dealer and keep the as member variables
    //even if the re is more comands after the play, it pauses

    // private static int count = 0;
    private int playSum;
    private ArrayList<Card> PlayList;
    private Card startCard;
    private ArrayList<Card> hcards;
    private ArrayList<Card> cpucards;
    private Human human;
    private Cpu cpu;
    private Player x;
    private boolean go;
   ArrayList<Card> cpucardturn = new ArrayList();//copy of cpu's cards
        ArrayList<Card> cardturn = new ArrayList();

    public boolean getGo() {
        return this.go;
    }

    public void setGo(boolean x) {
        this.go = x;
    }

    public Play(Human human, Cpu cpu, ArrayList<Card> hcards, ArrayList<Card> cpucards, Card startCard) {
        this.PlayList = new ArrayList();
        this.human = human;
        this.cpu = cpu;
        this.startCard = startCard;
        this.hcards = new ArrayList();
        for (Card x : hcards) {
            this.hcards.add(x);
        }
        this.cpucards = new ArrayList();
        for (Card y : cpucards) {
            this.cpucards.add(y);
        }
        this.x = null;

    }

    public ArrayList<Card> getPlayList() {
        return PlayList;
    }
//Play playList1 = new Play(new ArrayList());

    public void setPlay(Card c) {
        this.PlayList.add(c);
    }

    public Play(ArrayList<Card> Play, Card startcard) {
        this.PlayList = Play;
        this.playSum = 0;
        this.startCard = startcard;
    }

    public void setPlaySum(int cardcount) {
        playSum = playSum + cardcount;
    }

    public int getPlaySum() {
        return this.playSum;
    }

    public void resetplaySum() {
        this.playSum = this.playSum - this.playSum;
    }

    public void play() {
        
        this.x = this.human.getP1(this.cpu);// calls method that returns  who is the pone
        System.out.print("THE PLAY BEGINS");
         cardturn = this.hcards; 
         cpucardturn = this.cpucards;
        while (!(hcards.isEmpty()) || !(cpucards.isEmpty())) {

            if (x == human) {
               
                cardturn = human.play(human, cpu, this, cardturn, cpucardturn);
                System.out.println("updated card  " + cardturn);
                System.out.println("Playlist: " + this.PlayList);
                x.setPPC(this.check());
                System.out.println(this);

                //  System.out.println(human);
                x = x.switchPlayer(cpu);
                if (this.getGo()) { //does proper player switch after go
                    x = x.switchPlayer(human);
                    this.setGo(false);
                }

            }

            if (x == cpu) {
               
                cpucardturn = cpu.play(cpu, human, this, cpucardturn,cardturn );//FIX THIS
                System.out.println("updated card  " + cpucardturn);
                System.out.println("Playlist: " + this.PlayList);
                x.setPPC(this.check());
                System.out.println("one");
                System.out.println(this);

                x = x.switchPlayer(human);
                if (this.getGo()) { //does proper player switch after go
                    x = x.switchPlayer(cpu);
                    this.setGo(false);
                }
                // System.out.println("two");
            }

        }
    }

    public ArrayList<Card> changeRemC(int cpick, ArrayList<Card> playerpickcards) { //This method updates the Player a's remaining pick cards after a card is put down
        playerpickcards.remove(cpick);
        return playerpickcards;
    }

    public void resetpicklist() {
        this.PlayList.clear();
    }

    public int pair() {//this works
        int count = 0;
        System.out.println("pair");
        if (this.PlayList.size() >= 2) {
            if (this.PlayList.indexOf(this.PlayList.get(count + 1)) < this.PlayList.size()) { //gets index of 2nd card being compard and checkks if it goes out of bounds
                if (this.PlayList.get(count).getRank() == this.PlayList.get(count + 1).getRank()) {
                    System.out.println(this.PlayList.get(count).getRank() + "  " + this.PlayList.get(count + 1).getRank());// to show that the 2 cards are the same
                    count++;
                    return 2;
                }
            }

            return 0;
        }
        return 0;
    }

    public int threePair() {
        System.out.println("threepair");

        int start = 0;
        if (this.PlayList.size() >= 3) {
            while ((start + 3) <= this.PlayList.size() - 1) {
                System.out.println("while");
                ArrayList<Card> check = new ArrayList();
                for (int i = start; i < 3 + start; i++) {
                    check.add(this.PlayList.get(i));
                }

                if (check.get(0).getRank() == check.get(1).getRank() && check.get(1).getRank() == check.get(2).getRank()) {

                    return 6;
                }
                start++;
            }

            return 0;
        }
        return 0;
    }

    public int fourPair() {

        System.out.println("fourpIR");
        int start = 0;
        if (this.PlayList.size() >= 4) {
            while (start + 4 <= this.PlayList.size() - 1) {
                ArrayList<Card> check = new ArrayList();
                for (int i = start; i < 4 + start; i++) {
                    check.add(this.PlayList.get(i));
                }

                if (check.get(0).getRank() == check.get(1).getRank() && check.get(1).getRank() == check.get(2).getRank() && check.get(2).getRank() == check.get(3).getRank()) {

                    return 12;
                }
                start++;
            }

            return 0;
        }
        return 0;
    }

    public static boolean sequncheck(int c1, int c2) {
        return c1 == c2 + 1;

    }

    public int run() {
        System.out.println("run");
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
            }
        }
        return 0;
    }

    public int fifteen() {// this works

        System.out.println("fifteen");
        int sum = 0;
        for (Card c : this.PlayList) {
            sum = sum + c.getRank().count();
            if (sum == 15) {
                return 2;
            }
        }
        return 0;
    }

    public boolean go(ArrayList<Card> card, int cpick) {
        if (!card.isEmpty()) {
            if ((this.playSum + card.get(cpick).getRank().count()) > 31) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // add playsum, remove hand,add to playlist
    public void go(ArrayList<Card> cards) {
        if (!cards.isEmpty()) {
            this.setGo(false);//reset go checker to be false;
            int count = 0;
            boolean cardadd = false;
            for (int i = 0; i < cards.size(); i++) {
                if ((this.playSum + cards.get(i).getRank().count()) <= 31) {
                    cardadd = true;
                    count++;
                    this.setPlaySum(cards.get(i).getRank().count());
                    System.out.println(this);
                   this.PlayList.add(cards.get(i));
                    System.out.println(this);//check this
                    this.cpucardturn.remove(cards.get(i)); 
                    System.out.printf("The %s card can be added by cpu %n", cards.get(i));
                    // this.x = x.switchPlayer(cpu);// switch player because the cpu put a card down after the humans turn
                }
            }
            if (cardadd == true) {// if the remaining cards cannot be added to be <31 and at least one card has been added.
                System.out.println(cpu.getStatus() + " says  GO!!");
                this.setGo(true);
                this.resetpicklist();
                this.resetplaySum();

            } else if (cardadd == false) {// if the remaining cards cannot be added to be <31 and no cards have been added.
                System.out.println(cpu.getStatus() + " says  GO!!");
                this.resetpicklist();
                this.resetplaySum();

            }

        } else if (cards.isEmpty()) {
            //if all the cards have been added to the Playlist...
            System.out.println(cpu.getStatus() + " says  GO!!");
            this.resetpicklist();
            this.resetplaySum();
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
        int x = this.run() + this.pair() + this.fifteen() + this.fourPair() + this.threePair();
        return x;

    }

    @Override
    public String toString() {
        return String.format("-------%nPlay List %s %n Playsum: %d %n human cards is %s %n Cpu cards is %s%n--------", this.getPlayList(), this.getPlaySum(), hcards, cpucards);
    }

    public static void main(String[] args) {// IT WORKS
        ArrayList<Card> card1 = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            card1.add(Card.getCard(rnd.nextInt(52)));

        }

    }
}
