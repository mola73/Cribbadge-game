
import java.util.ArrayList;
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
    
    public ArrayList<Card> play(Player human, Play play) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Card> hcards = human.getCards();//copy of human's card
        int cpick = 0;//cardpick
        
        System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....", human.getStatus(), human.ruHuman());
        System.out.printf("%s \n\n", human.getCards());
        cpick = sc.nextInt()-1;
        while(cpick > hcards.size() ){
            System.out.println("ERROR! INSERT AGAIN");
            System.out.printf("%s \n\n", human.getCards());
            cpick = sc.nextInt();
        }
        play.setPlay(hcards.get(cpick));
        hcards.remove(cpick);
        return hcards;
    }
    
}