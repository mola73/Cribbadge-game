
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
public class HumanPlay extends CpuPlay implements PlayInterface {
    
    @Override
    
    public ArrayList<Card> play(Player human, Player cpu, Play playList, ArrayList<Card> hcards, ArrayList<Card> cpucards) {
        Scanner sc = new Scanner(System.in);        
        
        int cpick = 0;//cardpick
        
        System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....", human.getStatus(), human.ruHuman());
        System.out.printf("%s \n\n", human.getCards());
        cpick = sc.nextInt();
        while (cpick > hcards.size() || cpick < 1) {//Error handling
            System.out.println("ERROR! INSERT AGAIN");
            System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....", human.getStatus(), human.ruHuman());
            System.out.printf("%s \n\n", human.getCards());
            cpick = sc.nextInt();
        }
        if (playList.go(human, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO
            System.out.println(human + " Says: GO!");
            playList.playGo(cpu, human, playList, cpucards);
            return hcards;
        }
        playList.setPlay(hcards.get(cpick - 1));
        playList.setplaySum(hcards.get(cpick - 1).getRank().count());
        hcards.remove(cpick - 1);
        return hcards;
    }
    
    @Override
    public void playGo(Player human, Player cpu, Play playList, ArrayList<Card> hcards) {// FIX THIS FIRST CHECK IF THE PLAYER IS A CPU!!! WITH AN IF STATEMENT
        Scanner sc = new Scanner(System.in);
        //    ArrayList<Card> hcards = human.getCards();//copy of human's card  FIX THIS
        int cpick = 0;//cardpick
        
        System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....", human.getStatus(), human.ruHuman());
        System.out.printf("%s \n\n", human.getCards());
        cpick = sc.nextInt() - 1;
        while (cpick > hcards.size() || cpick < 1) {//Error handling
            System.out.println("ERROR! INSERT AGAIN");
            System.out.printf("%s \n\n", human.getCards());
            cpick = sc.nextInt();
        }
        if (!playList.go(cpu, cpick)) {//VERIFIES IF THE CARD BEING PUT DOWN DOES NOT SURPASS 31, AND IF IT DOES, IT CALLS GO
            playList.setPlay(hcards.get(cpick));// adds chose card to play arraylist
            
            playList.changeRemC(cpick, hcards);//updates the cpu play cards bu removing something
            
        } else {// if count goes over 31 that means both the cpu and human cannot put any cards downso the play arraylist is reset
            System.out.println(cpu + " says  GO!!");
            playList.resetpicklist();
            
        }
        
    }
    
}
