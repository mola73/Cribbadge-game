/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import static com.mycompany.score.Deck.makeCrib;
//import static Game.provCrib;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mpereira
 */
public class Preparation {//Picks dealer, gets cribpicks, and assigns crib to dealer
    
    
    
    public static void pickDealer(Player human, Player cpu) {//This  method picks the dealer, se
        int pick1;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        do {
            System.out.println("Player 1(human) please pick a card from number 1 to 52");
            pick1 = sc.nextInt()-1;
        } while (pick1 > 52 || pick1 < 1);
        int pick2 = rand.nextInt(52) + 1;
        Card p1pick = Card.getCard(pick1);
        Card cpupick = Card.getCard(pick2);
        
        boolean hdealer = (p1pick.getRank().count() < cpupick.getRank().count());
        human.setDealer(hdealer);
        cpu.setDealer(!hdealer);
        
//        
//        //This part pick the cribpick from the 2 players
//        human.setCribPick(provCrib(human));
//        cpu.setCribPick(provCrib(cpu));

    }
        public static final ArrayList<Card> makeCrib(Player human, Player cpu) {// takes the provided cards for the crib and put it into one crib
        ArrayList<Card> crib = new ArrayList();
        //FIX THIS.

        for (Card y : provCrib(human)) {

            crib.add(y);
        }

        for (Card x : provCrib(cpu)) {

            crib.add(x);
        }
        return crib;
        }
        public static final ArrayList<Card> provCrib(Player x) {//provides 2 cards from a player for the crib
        int pick;
        Random rand = new Random();
        Scanner read1 = new Scanner(System.in);
        ArrayList<Card> picked = new ArrayList();
        while (picked.size() < 2) {
            System.out.printf("OH %s, %s, Please pick a card to put in the crib, 1 for the 1st card and 2 for the second card...\n", x.ruHuman(), x.getStatus());
            System.out.printf("%s \n\n", x.getCards());

            if (x.ruHumanb()) {//pick a  pick = read1.nextInt();random number for the cpu card pick or ask the human user for a number.
                pick = read1.nextInt();

            } else {
                pick = rand.nextInt(x.getCards().size()) + 1;
                System.out.println("cpu pick : " + pick);
            }

            while (pick < 1 || (pick > x.getCards().size())) {//error handling
                System.out.printf("%d is an invalid number\n", pick);
                System.out.println(x.getCards());

                if (x.ruHuman().equals("Human")) {//pick a random number for the cpu card pick or ask the human user for a number.
                    pick = read1.nextInt(x.getCards().size()) + 1;

                } else {
                    pick = rand.nextInt(52) + 1;
                    System.out.println(pick);
                }
            }

            picked.add(x.getCards().get(pick - 1));
            x.getCards().remove(pick - 1);
            System.out.println("updated cards  " + x.getCards());
        }

        return picked;
    }
    
        
}