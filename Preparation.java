/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.score;

import static com.mycompany.score.Deck.makeCrib;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mpereira
 */
public class Preparation {
    
    public static void pickDealer(Player human, Player cpu) {
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

        if (human.getDealer()) {
            human.setCrib(makeCrib(human, cpu));
        } else {
            cpu.setCrib(makeCrib(human, cpu));
        }
    
        
}
