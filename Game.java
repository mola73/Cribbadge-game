/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    //fix inital status print\

    private ArrayList<Card> crib = new ArrayList();

//    public static void pickDealer(Player human, Player cpu) {
//        int pick1;
//        Scanner sc = new Scanner(System.in);
//        Random rand = new Random();
//        do {
//            System.out.println("Player 1(human) please pick a card from number 1 to 52");
//            pick1 = sc.nextInt();
//        } while (pick1 > 52 || pick1 < 1);
//        int pick2 = rand.nextInt(52) + 1;
//        Card p1pick = Card.getCard(pick1);
//        Card cpupick = Card.getCard(pick2);
//        boolean hdealer = (p1pick.getRank().count() < cpupick.getRank().count());
//        human.setDealer(hdealer);
//        cpu.setDealer(!hdealer);
//
//        if (human.getDealer()) {
//            human.setCrib(makeCrib(human, cpu));
//        } else {
//            cpu.setCrib(makeCrib(human, cpu));
//        }
//
//    }
//    public static final ArrayList<Card> provCrib(Player x) {//provides 2 cards from a player for the crib
//        int pick;
//        Random rand = new Random();
//        Scanner read1 = new Scanner(System.in);
//        ArrayList<Card> picked = new ArrayList();
//        while (picked.size() < 2) {
//            System.out.printf("OH %s, %s, Please pick a card to put in the crib, 1 for the 1st card and 2 for the second card...\n", x.ruHuman(), x.getStatus());
//            System.out.printf("%s \n\n", x.getCards());
//
//            if (x.ruHuman().equals("Human")) {//pick a  pick = read1.nextInt();random number for the cpu card pick or ask the human user for a number.
//                pick = read1.nextInt();
//
//            } else {
//                pick = rand.nextInt(x.getCards().size()) + 1;
//                System.out.println(pick);
//            }
//
//            while (pick < 1 || (pick > x.getCards().size())) {
//                System.out.printf("%d is an invalid number\n", pick);
//                System.out.println(x.getCards());
//
//                if (x.ruHuman().equals("Human")) {//pick a random number for the cpu card pick or ask the human user for a number.
//                    pick = read1.nextInt(x.getCards().size()) + 1;
//
//                } else {
//                    pick = rand.nextInt(52) + 1;
//                    System.out.println(pick);
//                }
//            }
//
//            picked.add(x.getCards().get(pick - 1));
//            x.getCards().remove(pick - 1);
//            System.out.println("updated cards  " + x.getCards());
//        }
//
//        return picked;
//    }
    public static void flipDealer(Player human, Player cpu) {
        human.flipDealer();
        cpu.flipDealer();
    }

//    public static final ArrayList<Card> makeCrib(Player human, Player cpu) {// takes the provided cards for the crib and put it into one crib
//        ArrayList<Card> crib = new ArrayList();
//        //FIX THIS.
//
//        for (Card y : provCrib(human)) {
//
//            crib.add(y);
//        }
//
//        for (Card x : provCrib(cpu)) {
//
//            crib.add(x);
//        }
//        return crib;
//    }
//    public static void round(){
//        
//    }
//    
//    public static void show(){
//        
//    }
//    public static void review(){
//        
//    }
//    public static void round(Player x, Player y){
//        if(x.getDealer()==y.getDealer()){
//            y.setDealer();
//        }
//        
//    }
    public static void main(String[] args) {
        Human a = new Human();
        Cpu b = new Cpu();
        Deck deck = new Deck();
        System.out.println(a);
        System.out.println(b);
        // problem with human error handling
        deck.shuffle();
        deck.dealCards(a, b);
        System.out.println(a);
        System.out.println(b);

        Preparation.pickDealer(a, b);
        System.out.println(a);
        System.out.println(b);

        a.setCribPick(Preparation.provCrib(a));
        b.setCribPick(Preparation.provCrib(b));

        Crib crib = new Crib(a, b);
        crib.assignCrib(a, b);

        System.out.println(a);
        System.out.println(b);
//        
        Play playList2 = new Play(a, b, a.getCards(), b.getCards(), deck.getStartCard());
        playList2.play();

//        Show one= new Show(a,b,deck.getStartCard());
//        one.show();
        System.out.println(a);
        System.out.println(b);

        // switch when both player say go, swith back to first 
        // check thog and 
        // shffle, deal, make the crib, cut deck of non dealer
        // front peg back peg
        /*
       Game board object
       
         */
    }
}
