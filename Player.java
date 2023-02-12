/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Player {

    private int playpegcount;
    private int showpegcount;
    private int score;
    private boolean dealer;
    private boolean pone;
    private ArrayList<Card> cards;
    private ArrayList<Card> crib;
    private ArrayList<Card> cribpick;

    private ArrayList<Card> makeCards() {
        Random ran = new Random();
        ArrayList<Card> x = new ArrayList();
        for (int i = 0; i < 6; i++) {
            x.add(Card.getCard(ran.nextInt(52)));
        }
        return x;
    }

    public static boolean rupone() {
        Random ran = new Random();
        int x = ran.nextInt(2);
        return x == 1;
    }

    public Player() {//How to make only one palyer a dealer
        this.playpegcount = 0;
        this.showpegcount = 0;
        this.score = 0;
        this.pone = rupone();
        this.dealer = !rupone();
        this.cards = makeCards();
        this.cribpick = this.provCrib();
        if (dealer) {
            this.crib = null;

        }
    }

    public final ArrayList<Card> makeCrib(Player opponent) {//method called by dealer to create crib(2 from pone in parmater and 2 from dealerattributes)
        for (Card y : this.cribpick) {
            this.crib.add(y);
        }
        for (Card x : opponent.cribpick) {
            this.crib.add(x);
        }

        return crib;
        // allow each player to pick two cards form their deck
        //those two cards are passed to the the make crib() and added to the crib arraylist
        //the arrayList is given to the player constructor of the player who is a dealer.
    }

    public final ArrayList<Card> provCrib() {
        Scanner read1 = new Scanner(System.in);
        ArrayList<Card> picked = new ArrayList();
        while (picked.size() < 2) {
            System.out.printf("OH %s, Please pick a card to put in the crib, 1 for the 1st card and 2 for the second card...\n", this.getStatus());
            System.out.println(this.cards);
            int pick = read1.nextInt();
            while (pick < 1) {
                System.out.println("Invalid number");
                System.out.println(this.cards);
                pick = read1.nextInt();
            }
            picked.add(this.cards.get(pick - 1));
            this.cards.remove(pick - 1);
            System.out.println(this.cards);
        }
        return picked;
    }
    public void setPPC(int playnum){//score of show after each round
        this.playpegcount= this.playpegcount+ playnum;
    }
    public void setSPC(int shownum){ //score of show after each round
        this.showpegcount=this.showpegcount+ shownum;
    }
    public void setScore(int mostpoints){// the total score of each player to 121
        this.score=this.score+ mostpoints;
    }
    public void setDealer(){
        this.dealer=!this.dealer;
    }
    

    public int getPPC() {
        return this.playpegcount;
    }

    public int getSPC() {
        return this.showpegcount;
    }

    public int getScore() {// amount of point accumulated in a hand or show.
        return this.score;
    }

    public boolean getDealer() {
        return this.dealer;

    }

    public boolean getPone() {
        return this.pone;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public ArrayList<Card> getCrib() {
        if (this.dealer) {
            return this.crib;
        } else {
            return null;
        }
    }

    public String getStatus() {
        if (this.dealer) {
            return "Dealer";
        } else {
            return "PONE";
        }
    }
    public void roundreset(int scoreadd){//add peg movement, remake crib at the beggining of the round seperately.
        this.playpegcount=0;
    this.showpegcount=0;
    this.setScore(scoreadd);
    this.dealer=!this.dealer;
    this.pone=!pone;
    this.cards.clear();
    this.cards=this.makeCards();
    this.cribpick.clear();
    this.provCrib();
    if(dealer){
        this.crib.clear();
       
    }
   
    }

    @Override
    public String toString() {
        return String.format("%s \nPlaypegcount: %d \n Showpegcount:%d \n Score: %d \n Dealer:%b \n Pone: %b\n Cards: %s\n Crib : %s", getStatus(), getPPC(), getSPC(), getScore(), getDealer(), getPone(), getCards(), getCrib());
    }

}
