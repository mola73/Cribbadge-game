
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class guiCpuCrib {

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
    public guiCpuCrib() {
        boolean visible = true;
        cards = new JPanel(new GridLayout(3, 2));
        card1 = new JButton(); //realcards.get(0).toString()
        cards.add(card1);
        card2 = new JButton();//(realcards.get(1).toString()
        cards.add(card2);
        card3 = new JButton();//realcards.get(2).toString()
        cards.add(card3);
        card4 = new JButton();//realcards.get(3).toString()
        cards.add(card4);

    }

    public void setButtons(ArrayList<Card> hcards) {
        cards.removeAll();
        card1 = new JButton(hcards.get(0).toString());
        cards.add(card1);
        card2 = new JButton(hcards.get(1).toString());
        cards.add(card2);
        card3 = new JButton(hcards.get(2).toString());
        cards.add(card3);
        card4 = new JButton(hcards.get(3).toString());
        cards.add(card4);

    }

    public JPanel getbuttons() {
        return this.cards;
    }
}
