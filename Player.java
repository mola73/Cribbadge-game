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
    private boolean human;

    public String ruHuman() {
        if (this.human) {
            return "Human";
        } else {
            return "CPU";
        }
    }

    public boolean ruHumanb() {
        return this.human;

    }

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

    public Player() {

        this.playpegcount = 0;
        this.showpegcount = 0;
        this.score = 0;
        this.pone = false;// will be made at the beggining of the game
        this.dealer = false;// will be made at the beggining of the game
        this.cards = null;
        this.cribpick = null;
       
            this.crib = new ArrayList();

        
    }

    public Player switchPlayer(Player cpu) {
        return cpu;
    }

    public Player getP1(Player cpu) { //get first player to put a card down (pone)
        if (!this.ruDealer()) {//if human is a pone rtruen it else return cpu
            return this;
        } else {
            return cpu;
        }

    }

    public boolean ruDealer() {
        return this.dealer;
    }

    public void flipDealer() {
        this.dealer = !this.dealer;
        this.pone = !this.pone;
    }

    public ArrayList<Card> getcribPick() {
        return this.cribpick;
    }

    public void setCribPick(ArrayList cribpick) {
        this.cribpick = cribpick;
    }

    public final void makeCrib(Player pone) {//method called by dealer to create crib(2 from pone in parmater and 2 from dealerattributes)

        ArrayList<Card> pick1 = this.getcribPick();
        ArrayList<Card> pick2 = pone.getcribPick();
        for (Card y : pick1) {

            this.getCrib().add(y);
        }

        for (Card x : pick2) {

            this.getCrib().add(x);
        }
        System.out.printf("%s \n the crib is set", this.getCrib());
    }

    public void setPPC(int playnum) {//score of show after each round
        this.playpegcount = this.playpegcount + playnum;
    }

    public void setSPC(int shownum) { //score of show after each round
        this.showpegcount = this.showpegcount + shownum;
    }

    public void setScore(int mostpoints) {// the total score of each player to 121
        this.score = this.score + mostpoints;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
        this.pone = !dealer;
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

    public void setCards(ArrayList x) {
        this.cards = x;
    }

    public void setCrib(ArrayList crib) {
        if (this.dealer) {
            this.crib = crib;
        }
    }

    public ArrayList<Card> getCrib() {

        return this.crib;

    }

    public String getStatus() {
        if ((this.dealer == false) && (this.pone == false)) {

            return "none";
        }

        if (this.dealer) {
            return "Dealer";
        } else {
            return "PONE";
        }

    }

    public void playerreset(int scoreadd) {//add peg movement, remake crib at the beggining of the round seperately.RESETS A PLAYER!!!!
        this.setScore(this.getPPC());// add peg and show pints to score.
        this.setScore(this.getSPC());
        this.playpegcount = 0;
        this.showpegcount = 0;
        this.flipDealer();
        this.cards.clear();
        this.cribpick.clear();
        if(!this.crib.isEmpty()){
         this.crib.clear();
        }

    }

    @Override
    public String toString() {
        return String.format("  %s \nPlaypegcount: %d \n Showpegcount:%d \n Score: %d \n Dealer:%b \n Pone: %b\n Cards: %s\n Crib : %s\n\n", getStatus(), getPPC(), getSPC(), getScore(), getDealer(), getPone(), getCards(), getCrib());
    }

}
