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

    public Game() {

    }

    public static void flipDealer(Player human, Player cpu) {
        human.flipDealer();
        cpu.flipDealer();
    }

    public void startGame() {
int count=0;
        Human a = new Human();
        Cpu b = new Cpu();
        guiGameFrame frame = new guiGameFrame(a.getCards(), b.getCards());
        Referee x = new Referee(a, b);
        Deck deck = new Deck(frame);
while(a.getScore()<121&&b.getScore()<121){
    if (count>0){
        System.out.println("----------------------NEXT ROUND-----------------------");
    }
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
        //pairs should not print twice
        //three fifteen and 4 fifteen
        // run

        Crib crib = new Crib(a, b, frame);
        crib.assignCrib(a, b);

        System.out.println(a);
        System.out.println(b);

        // play methods for last card to be 31 or close to 31
        
        Play playList2 = new Play(a, b, a.getCards(), b.getCards(), deck.getStartCard());
        playList2.play();

        Show one = new Show(a, b, deck.getStartCard());
        one.show();
        System.out.println(a);
        System.out.println(b);
        a.playerreset();
        b.playerreset();
        count++;
}
x.anouncement();
x.endGame();
    }
//after the count is 31 and the count a list is rest, the count does not count
    //make method in Game which loops thorugh rounds  until a player reaches 121 as a score
    //check the show combinations for correctness

    public static void main(String[] args) {
//The play go does ssomething wierd when th e cards finisnh. it does not stop if the array is empty.
//methods for who put the card last point
        Game a = new Game();
        a.startGame();
    }
}
