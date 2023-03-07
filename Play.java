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
public class Play extends Human {
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

    public void play(Human human, Cpu cpu) {

        ArrayList<Card> hcards = human.getCards();//copy of human's card
        ArrayList<Card> cpucards = cpu.getCards();//copy of cpu's cards
         ArrayList<Card> cardturn = new ArrayList();//copy of cpu's cards
        Player x = human.getP1(cpu);// calls method that returns  who is the pone

        while (!(hcards.isEmpty()) && !(cpucards.isEmpty())) {
            
            if(x==human){
                cardturn=hcards;
                cardturn = human.play(x, cpu, this, hcards, cpucards);
                System.out.println("updated card  " + cardturn);
                System.out.println(this.PlayList);
                x.setPPC(this.check());
                System.out.println(human);
                x = x.switchPlayer(cpu);// switches the player
                
            }
                
             if(x==cpu){
                cardturn=cpucards;
                cardturn = cpu.play(x, human, this, cpucards, hcards);//FIX THIS
                System.out.println("updated card  " + cardturn);
                System.out.println(this.PlayList);
                x.setPPC(this.check());
                System.out.println(cpu);
               
           
                
            }
              x = x.switchPlayer(cpu);
       

        }
    }

    public void changeRemC(int cpick, ArrayList<Card> playerpickcards) { //This method updates the Player a's remaining pick cards after a card is put down
        // playerpickcards = playList1.play(a ,b,playList1);
        playerpickcards.remove(cpick);
    }

    public void resetpicklist() {
        this.PlayList.clear();
    }
   


    public int pair() {//this works
        if (this.PlayList.size() >= 2) {
            if (this.PlayList.get(count).getRank() == this.PlayList.get(count + 1).getRank()) {
                System.out.println(this.PlayList.get(count).getRank() + "  " + this.PlayList.get(count + 1).getRank());// to show that the 2 cards are the same
                count++;
                return 2;

            }
            count++;
            return 0;
        }
        return 0;
    }

    public int threePair() {
       
        int start=0;
        if (this.PlayList.size() >= 3) {
            while( start+3 != this.PlayList.size()-1){
          ArrayList <Card> check=new ArrayList();
          for(int i=start;i<3;i++){
              check.add(this.PlayList.get(i));
                      }
           
            if (check.get(0).getRank() == check.get(1).getRank()&& check.get(1).getRank()== check.get(2).getRank()){
                //pcount++;
                return 6;
            }
            }
            
            return 0;
        }
        return 0;
    }

    public int fourPair() {
        int start=0;
        if (this.PlayList.size() >= 4) {
            while( start+4 != this.PlayList.size()-1){
          ArrayList <Card> check=new ArrayList();
          for(int i=start;i<4;i++){
              check.add(this.PlayList.get(i));
                      }
           
            if (check.get(0).getRank() == check.get(1).getRank()&& check.get(1).getRank()== check.get(2).getRank()&&check.get(2).getRank()== check.get(3).getRank()){
               
                return 12;
            }
            }
            
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
            }
        }
        return 0;
    }

    public int fifteen() {// this works
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
         int x= this.run() + this.pair()+ this.fifteen()+ this.fourPair()+this.threePair()+this.run();
        return x;

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
