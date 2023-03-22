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
public class guiPersonCard extends JComponent {

    private ArrayList<Card> hcards = new ArrayList();
    JButton card1;
    JButton card2;
    JButton card3;
    JButton card4;
    JButton card5;
    JButton card6;
    private JPanel cards;

    /*  behaviors:
              1.Card can be picked witha button
              after it ispicked it goes null.
              2. card is is sent to the play
              3. play checks combinations
              
              
     */
    public guiPersonCard() {
        cards = new JPanel(new GridLayout(3, 2));
//        for(Card x: realcards){
//            hcards.add(x);
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

    public JPanel getbuttons() {
        return this.cards;
    }

    public void setButtons(ArrayList<Card> hcards) {
        //cards.removeAll();
        card1.setText(hcards.get(0).toString());
        card2.setText(hcards.get(1).toString());
        card3.setText(hcards.get(2).toString());
        card4.setText(hcards.get(3).toString()); 
        card5.setText(hcards.get(4).toString());
        card6.setText(hcards.get(5).toString());
//        card1 = new JButton(hcards.get(0).toString());
//        cards.add(card1);
//        card2 = new JButton(hcards.get(1).toString());
//        cards.add(card2);
//        card3 = new JButton(hcards.get(2).toString());
//        cards.add(card3);
//        card4 = new JButton(hcards.get(3).toString());
//        cards.add(card4);
//        card5 = new JButton(hcards.get(4).toString());
//        cards.add(card5);
//        card6 = new JButton(hcards.get(5).toString());
//        cards.add(card6);
        repaint();

    }
}
