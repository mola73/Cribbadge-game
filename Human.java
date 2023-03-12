
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
public class Human extends Player {

    private boolean human;

    public Human() {
        super();
        this.human = true;
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

    public ArrayList<Card> play(Human human, Cpu cpu, Play playList, ArrayList<Card> hcards, ArrayList<Card> cpucards) {
        Scanner sc = new Scanner(System.in);

        int cpick = 0;//cardpick
        System.out.print("human play");
        System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....\n", human.getStatus(), this.ruHuman());
        System.out.printf("Available cards:%s \n\n", hcards);
        System.out.printf("The playsum is %d\n", playList.getPlaySum());
        cpick = sc.nextInt() - 1;
        System.out.println(cpick + " info");
        while (cpick >= hcards.size() || cpick < 0) {//Error handling
            System.out.println("ERROR! INSERT AGAIN\n");
            System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....\n", human.getStatus(), this.ruHuman());
            System.out.printf("%s \n\n", human.getCards());
            cpick = sc.nextInt() - 1;
        }
        if (playList.go(hcards, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO
            System.out.println(human.getStatus() + " Says: GO!\n");
            cpu.playGo(cpu, human, playList, cpucards);

            return hcards;
        }
        playList.setPlay(hcards.get(cpick));
        playList.setPlaySum(hcards.get(cpick).getRank().count());
        playList.changeRemC(cpick, hcards);
        //  hcards.remove(cpick );
        return hcards;
    }

    //   @Override
    public void playGo(Human human, Cpu cpu, Play playList, ArrayList<Card> hcards) {
        boolean addcard = false;
        Scanner sc = new Scanner(System.in);
        //    ArrayList<Card> hcards = human.getCards();//copy of human's card  FIX THIS
        int cpick = 0;//cardpick
        while (!playList.getGo()) {
            System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2...../n can any card be put down that maes playsum <31", human.getStatus(), this.ruHuman());
            System.out.printf("Available cards:%s \n\n", hcards);
            System.out.printf("The playsum is %d", playList.getPlaySum());
            cpick = sc.nextInt() - 1;
            while (cpick >= hcards.size() || cpick < 0) {//Error handling
                System.out.println("ERROR! INSERT AGAIN");
                System.out.printf("%s \n\n", human.getCards());
                cpick = sc.nextInt() - 1;
            }

            if (!playList.go(hcards, cpick)) {//VERIFIES if any of the remaining cards do NOT SURPASS 31, AND IF they DO, IT CALLS GO
                playList.setPlay(hcards.get(cpick));// adds chose card to play arraylist

                playList.changeRemC(cpick, hcards);//updates the cpu play cards bu removing something
                addcard = true;
            }

            if (playList.go(hcards, cpick) && addcard == true) {
                playList.setGo(true);
                playList.resetpicklist();
                playList.resetplaySum();

            } else {
                // if count goes over 31 that means both the cpu and human cannot put any cards downso the play arraylist is reset
                // System.out.println(human.getStatus() + " says  GO!!");

                playList.resetpicklist();
                playList.resetplaySum();
            }
        }

    }

}
