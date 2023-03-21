
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mpereira
 */
public class Cpu extends Player {

    private boolean human;

    public Cpu() {
        super();
        this.human = false;
    }

    @Override
    public String ruHuman() {
        if (this.human) {
            return "Human";
        } else {
            return "CPU";
        }
    }

    @Override
    public boolean ruHumanb() {
        return this.human;

    }

    @Override
    public String toString() {
        return String.format(" %s \n %s \nPlaypegcount: %d \n Showpegcount:%d \n Score: %d \n Dealer:%b \n Pone: %b\n Cards: %s\n Crib : %s\n\n", ruHuman(), getStatus(), getPPC(), getSPC(), getScore(), getDealer(), getPone(), getCards(), getCrib());
    }

    public ArrayList<Card> play(Cpu cpu, Human human, Play play, ArrayList<Card> cpucards, ArrayList<Card> hcards) {// FIX THIS FIRST CHECK IF THE PLAYER IS A CPU!!! WITH AN IF STATEMENT
        System.out.println("NEXT TURN--------------------------------------------------------------------------------------------------------------------------");
         if(cpucards.isEmpty()){
              System.out.printf("Available cards:%s %n", cpucards);
              System.out.printf("No more cards \n\n");
            return cpucards;
         }
        if (!cpucards.isEmpty()) {//if all the cpu's cards are not used
            Random rnd = new Random(1234);

            System.out.printf("%s  %s please put one card down 1st card=0, 2nd card=1.....\n", cpu.getStatus(), cpu.ruHuman());
            System.out.printf("Available cards:%s %n", cpucards);
            System.out.printf("The playsum is %d\n", play.getPlaySum());

            int cpick = rnd.nextInt(cpucards.size());
            System.out.println(cpick);

            while (cpick<0&&!cpucards.isEmpty()) {//ERROR HANDLING
                System.out.println("ERROR! INSERT AGAIN\n");
                System.out.printf("The playsum is %d\n", play.getPlaySum());
                System.out.printf("%s \n\n", cpucards);
                cpick = rnd.nextInt(cpucards.size());
            }
            if (play.go(cpucards, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO and switches turn to human to chec the same.
                System.out.println(cpu.getStatus() + " Says: GO!");
                human.playGo(human, cpu, play, hcards);
                return cpucards;
            }
            play.setPlay(cpucards.get(cpick));// adds chose card to play arraylist
            play.setPlaySum(cpucards.get(cpick).getRank().count());
             return play.changeRemC(cpick, cpucards);
           
        }
       
        return cpucards;
    }

    public void playGo(Player cpu, Player human, Play playList, ArrayList<Card> cpucards) {
 System.out.println("---THIS IS FOR A GO CPU----");
        playList.go(cpucards);
        System.out.println(playList);

    }

}
