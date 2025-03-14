/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import cribbadgegui.*;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author muham
 */
//PUT A MOUSE LISTENER FOR CLICKS WHICH DOES REPAINT
//Do gui application for crib.
public class guiGameFrame extends JFrame {// make fram, panell, add components

    private guiGameBoard pegs;
    private guiPersonCard hc;
    private guiCpuCard cpuc;
    private guiPersonCrib hcrib;
    private guiCpuCrib cpucrib;
    private JPanel hpanel;
    private JPanel hcrpanel;
    private JPanel cpupanel;
    private JPanel cpucrcpanel;
    private JPanel framepanel;

    public guiGameFrame(ArrayList<Card> hcards, ArrayList<Card> cpucards) {
        JFrame frame = new JFrame("Pegs");
        hpanel = new JPanel();
        //  frame.setLayout();
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pegs = new guiGameBoard();
        frame.add(pegs, BorderLayout.CENTER);

        hcrib = new guiPersonCrib();
        hc = new guiPersonCard();
        hpanel.add(hc.getbuttons());
        hpanel.add(hcrib.getbuttons());
        frame.add(hpanel, BorderLayout.SOUTH);
        cpucrib = new guiCpuCrib();
        cpuc = new guiCpuCard();
        cpupanel = new JPanel();
        cpupanel.add(cpuc.getbuttons());
        cpupanel.add(cpucrib.getbuttons());
        frame.add(cpupanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public void guisetPbuttons(ArrayList<Card> hcards) {
     //   hpanel.remove(hc.getbuttons());
        this.hc.setButtons(hcards);
      //  hpanel.add(hc.getbuttons());
      //  hpanel.add(hc.getbuttons());
        repaint();

    }

    public void guisetPbuttonscrib(ArrayList<Card> hcards,boolean rudealer) {
        this.hcrib.setButtons(hcards,rudealer);
        this.cpucrib.getbuttons().setVisible(!rudealer);
        repaint();
    }

    public void guisetCpubuttonscrib(ArrayList<Card> cpucards,boolean rudealer) {
        this.cpucrib.setButtons(cpucards,rudealer);
        this.hcrib.getbuttons().setVisible(!rudealer);
        repaint();
    }

    public void guisetCpuButtons(ArrayList<Card> cpucards) {
        this.cpuc.setButtons(cpucards);
        repaint();
    }
    public void setPCribvisibility(boolean x){
        this.hcrib.getbuttons().setVisible(x);
     System.out.println("pc crib bool");
        repaint();
    }
    public void setCPUCribVisibility(boolean x){
        this.cpucrib.getbuttons().setVisible(x);
         System.out.println("cpu crib bool");
        
        repaint();
    }

    public guiGameBoard getGameBoard() {
        return this.pegs;
    }

    public static void main(String[] args) {
        //guiGameFrame a= new guiGameFrame();

    }
}
