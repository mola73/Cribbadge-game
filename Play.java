/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import static com.mycompany.score.Card.getCard;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mpereira
 */
public class Play {

    private static int count = 0;

    public static void play(Player human, Player cpu) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<Card> hcards = human.getCards();//copy of human's card
        ArrayList<Card> cpucards = cpu.getCards();//copy of cpu's cards
        ArrayList<Card> play = new ArrayList();// list to track placement of cards in play
        int tnumb = 2;// tnumb is counting the count of turns for the paly. the pone puts a card down 1st, the dealer puts a card second.....
        int cpick = 0;
        //assigning the pone
        Player x = human;
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
            if (tnumb % 2 == 0) {
                if (human.ruDealer()) {
                    x = human;
                } else {
                    x = cpu;
                }
            }
            if (tnumb % 2 != 0) {
                if (human.ruDealer()) {
                    x = human;
                } else {
                    x = cpu;
                }
            }

            System.out.printf("%s  %s please put one card down 1st card=1, 2nd card=2.....", x.getStatus(), x.ruHuman());
            System.out.printf("%s \n\n", x.getCards());

            if (x.ruHumanb()) {
                cpick = sc.nextInt();
            }
            if (!x.ruHumanb()) {
                cpick = rand.nextInt(x.getCards().size() + 1);// pick random number from 1 to4, then from 1 to 3... 
            }

            play.add(x.getCards().get(cpick - 1));//put the selected card into the arraylist called play to keep track of the placed cards

            if (x.ruHumanb()) {//delete the given card
                hcards.remove(cpick - 1);
            }
            if (!x.ruHumanb()) {
                cpucards.remove(cpick - 1);
            }
            tnumb++;// move to the next turn
            System.out.println(play);

        }
    }

    public static int pair(ArrayList<Card> c1) {
if(c1.size()>=2){
        if (c1.get(count).getRank() == c1.get(count + 1).getRank()) {
            System.out.println(c1.get(count).getRank() +"  " + c1.get(count + 1).getRank());
            count++;
            return 2;

        }
        count++;
        return 0;
    }
return 0;
    }

    public static void main(String[] args) {// IT WORKS
        ArrayList<Card> card1 = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            card1.add(Card.getCard(rnd.nextInt(52)));
            System.out.println(card1);
               System.out.println(pair(card1));
        }
        
     
    }
}