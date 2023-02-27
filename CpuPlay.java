
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
public class CpuPlay implements PlayInterface{
    public ArrayList<Card> play(Player cpu, Play play) {
        Random rnd = new Random();
        ArrayList<Card> cpucards = cpu.getCards();//copy of human's card
        int cpick = 0;//cardpick
        
        System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....", cpu.getStatus(), cpu.ruHuman());
        System.out.printf("%s \n\n", cpu.getCards());
        cpick = rnd.nextInt(cpucards.size());
        while(cpick > cpucards.size() ){//ERROR HANDLING
            System.out.println("ERROR! INSERT AGAIN");
            System.out.printf("%s \n\n", cpu.getCards());
            cpick = rnd.nextInt();
        }
        play.setPlay(cpucards.get(cpick));
        cpucards.remove(cpick);
        return cpucards;
    }
}
