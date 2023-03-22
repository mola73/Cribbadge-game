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
public class guiPersonCrib extends JComponent { //make a comp with 4 buttons for crib ( dealer has 4)(poen has 4 nulls

    private ArrayList<Card> hcards = new ArrayList();
    private JButton card1;
    private JButton card2;
    private JButton card3;
    private JButton card4;
    private boolean visible;
    private JPanel cards;

    /*  behaviors:
              1.Card can be picked witha button
              after it ispicked it goes null.
              2. card is is sent to the play
              3. play checks combinations
              
              
     */
    public guiPersonCrib() {
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

    }
    public boolean getVisible(){
        return this.visible;
    }

    public void setButtons(ArrayList<Card> hcards,boolean rudealer) {
     //   cards.removeAll();
     
     this.cards.setVisible(this.getVisible());
     card1.setText(hcards.get(0).toString());
     card2.setText(hcards.get(1).toString());
     card3.setText(hcards.get(2).toString());
     card4.setText(hcards.get(3).toString());
    
         this.getbuttons().setVisible(rudealer);
//        card1 = new JButton(hcards.get(0).toString());
//        cards.add(card1);
//        card2 = new JButton(hcards.get(1).toString());
//        cards.add(card2);
//        card3 = new JButton(hcards.get(2).toString());
//        cards.add(card3);
//        card4 = new JButton(hcards.get(3).toString());
//        cards.add(card4);
        repaint();

    }
    
    @Override
      public void setVisible(boolean x){
    this.visible= x;
}

    public JPanel getbuttons() {
        return this.cards;
    }
}
