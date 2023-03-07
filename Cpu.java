
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
    public Cpu(){
        super();
        this.human=false;
    }
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
     @Override
    public String toString() {
        return String.format(" %s \n %s \nPlaypegcount: %d \n Showpegcount:%d \n Score: %d \n Dealer:%b \n Pone: %b\n Cards: %s\n Crib : %s\n\n", ruHuman(), getStatus(), getPPC(), getSPC(), getScore(), getDealer(), getPone(), getCards(), getCrib());
    }
    public ArrayList<Card> play(Player cpu, Player human, Play playList, ArrayList<Card> cpucards, ArrayList<Card> hcards) {// FIX THIS FIRST CHECK IF THE PLAYER IS A CPU!!! WITH AN IF STATEMENT
        Random rnd= new Random(cpucards.size());
      

        System.out.printf("%s  %s please put one card down 1st card=0, 2nd card=1.....", cpu.getStatus(), cpu.ruHuman());
        System.out.printf("%s \n\n", cpu.getCards());
        
        int cpick = rnd.nextInt(cpucards.size());
        System.out.println(cpick);
        
        while (cpick > cpucards.size()) {//ERROR HANDLING
            System.out.println("ERROR! INSERT AGAIN");
            System.out.printf("%s \n\n", cpu.getCards());
            cpick = rnd.nextInt(cpucards.size());
        }
        if (playList.go(cpu, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO and switches turn to human to chec the same.
            System.out.println(cpu + " Says: GO!");
            playList.playGo(human, cpu, playList, hcards);
            return cpucards;
        }
        playList.setPlay(cpucards.get(cpick));// adds chose card to play arraylist
        playList.setplaySum(hcards.get(cpick).getRank().count());
        cpucards.remove(cpick);
        return cpucards;
    }

    public void playGo(Player cpu, Player human, Play playList, ArrayList<Card> cpucards) {
        Random rnd = new Random();
        int cpick = 0;//cardpick

        System.out.printf("%s  %s please put one card down 1st card=0, 2nd card=1.....", cpu.getStatus(), this.ruHuman());
        System.out.printf("%s \n\n", cpu.getCards());
        cpick = rnd.nextInt(cpucards.size());
        while (cpick > cpucards.size()) {//ERROR HANDLING
            System.out.println("ERROR! INSERT AGAIN");
            System.out.printf("%s \n\n", cpu.getCards());
            cpick = rnd.nextInt(cpucards.size());
        }
        if (!playList.go(cpu, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO
            playList.setPlay(cpucards.get(cpick));// adds chose card to play arraylist

            playList.changeRemC(cpick, cpucards);//updates the cpu play cards bu removing something

        } else {// if count goes over 31 that means both the cpu and human cannot put any cards downso the play arraylist is reset
            System.out.println(cpu + " says  GO!!");
            playList.resetpicklist();

        }

    }

}
