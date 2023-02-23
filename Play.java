
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
public class Play {
     public static void play(Player human, Player cpu) {
        
        Random rand= new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<Card> hcards = human.getCards();//copy of human's card
        ArrayList<Card> cpucards = cpu.getCards();//copy of cpu's cards
        ArrayList<Card> play = new ArrayList();// list to track placement of cards in play
       int tnumb = 2;// tnumb is counting the count of turns for the paly. the pone puts a card down 1st, the dealer puts a card second.....
       int cpick=0;
        //assigning the pone
        Player x= human;
        if (!human.ruDealer()) {
            x = human;
        } else {
            if (!human.ruDealer()) {
               x = cpu;
            }

        }

        System.out.println("THE    ROUND    BEGINSSSS");
        while (!(hcards.isEmpty()) && !(cpucards.isEmpty())) { //while all the card of both players are not used
            //this part switches the player in the play
            if(tnumb%2==0){
                if(human.ruDealer()){
                    x=human;
                }else{
                    x=cpu;
                }
            }
                if(tnumb%2!=0){
                if(human.ruDealer()){
                    x=human;
                }else{
                    x=cpu;
                }
                }
            
        System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....",x.getStatus(),x.ruHuman());
        System.out.printf("%s \n\n", x.getCards());
        
        if(x.ruHumanb()){
         cpick= sc.nextInt();
        } 
        if (!x.ruHumanb()){
        cpick= rand.nextInt(x.getCards().size()+1);// pick random number from 1 to4, then from 1 to 3... 
                }
        
       play.add(x.getCards().get(cpick-1));//put the selected card into the arraylist called play to keep track of the placed cards
       
       if(x.ruHumanb()){//delete the given card
      hcards.remove(cpick-1);
       }
       if(!x.ruHumanb()){
           cpucards.remove(cpick-1);
       }
        tnumb++;// move to the next turn
    System.out.println(play);
       

    
        }
    }
}
