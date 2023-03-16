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


    public static void flipDealer(Player human, Player cpu) {
        human.flipDealer();
        cpu.flipDealer();
    }
//after the count is 31 and the count a list is rest, the count does not count
    //make method in Game which loops thorugh rounds  until a player reaches 121 as a score
    //check the show combinations for correctness

    public static void main(String[] args) {
       
        Human a = new Human();
        Cpu b = new Cpu();
          guiGameFrame frame= new guiGameFrame(a.getCards(),b.getCards());
        Referee x= new Referee(a,b);
        Deck deck = new Deck(frame);
        System.out.println(a);
        System.out.println(b);
        // problem with human error handling
        deck.shuffle();
        deck.dealCards(a, b);
        System.out.println(a);
        System.out.println(b);
     
      frame.getGameBoard().humancolor(20);
     
        Preparation.pickDealer(a, b);
        System.out.println(a);
        System.out.println(b);

        a.setCribPick(Preparation.provCrib(a));
        b.setCribPick(Preparation.provCrib(b));

        Crib crib = new Crib(a, b,frame);
        crib.assignCrib(a, b);

        System.out.println(a);
        System.out.println(b);
        // play methods for last card to be 31 or close to 31
        Play playList2 = new Play(a, b, a.getCards(), b.getCards(), deck.getStartCard());
        playList2.play();

        Show one= new Show(a,b,deck.getStartCard());
        one.show();
        System.out.println(a);
        System.out.println(b);
        a.playerreset(a.getPPC()+a.getSPC());
        b.playerreset(b.getPPC()+b.getSPC());
        System.out.println(a);
        System.out.println(b);
//DEBUGGIN USE THE SAME SEED TO CHECK FOR ERRORS.
        // switch when both player say go, swith back to first 
        // check thog and 
        // shffle, deal, make the crib, cut deck of non dealer
        // front peg back peg
        /*
       Game board object
       
         */
    }
}
