/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import cribbadgegui.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author muham
 */
public class guiCpuCard extends JComponent {// make a comp of 4 buttons for each player

    private ArrayList<Card> cpucards = new ArrayList();
    JButton card1;
    JButton card2;
    JButton card3;
    JButton card4;
    JButton card5;
    JButton card6;
    private JPanel cards;

    public guiCpuCard() {
        cards = new JPanel(new GridLayout(3, 2));
//        for(Card x: realcards){
//            cpucards.add(x);
//        }
        card1 = new JButton(); //realcards.get(0).toString()
        cards.add(card1);
        card2 = new JButton();//(realcards.get(1).toString()
        cards.add(card2);
        card3 = new JButton();//realcards.get(2).toString()
        cards.add(card3);
        card4 = new JButton();//realcards.get(3).toString()
        cards.add(card4);
        card5 = new JButton();//realcards.get(4).toString()
        cards.add(card5);
        card6 = new JButton();//realcards.get(5).toString()
        cards.add(card6);
    }

    public void setButtons(ArrayList<Card> cpucards) {
        cards.removeAll();
        card1 = new JButton(cpucards.get(0).toString());
        cards.add(card1);
        card2 = new JButton(cpucards.get(1).toString());
        cards.add(card2);
        card3 = new JButton(cpucards.get(2).toString());
        cards.add(card3);
        card4 = new JButton(cpucards.get(3).toString());
        cards.add(card4);
        card5 = new JButton(cpucards.get(4).toString());
        cards.add(card5);
        card6 = new JButton(cpucards.get(5).toString());
        cards.add(card6);

    }

    public JPanel getbuttons() {
        return this.cards;
    }
}
