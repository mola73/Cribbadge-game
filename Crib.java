/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author mpereira
 */
public class Crib {

    private ArrayList<Card> crib = new ArrayList();
    private guiGameFrame gui;

    public Crib(Player human, Player cpu, guiGameFrame gui) {//method called by dealer to create crib(2 from pone in parmater and 2 from dealerattributes)
        this.gui = gui;
        ArrayList<Card> pick1 = human.getcribPick();
        ArrayList<Card> pick2 = cpu.getcribPick();
        for (Card y : pick1) {
            this.crib.add(y);
        }

        for (Card x : pick2) {
            this.crib.add(x);
        }

    }

    public void assignCrib(Player human, Player cpu) {
        ArrayList<Card> copy = new ArrayList();
        for (Card x : this.crib) {
            copy.add(x);
        }
        if (human.ruDealer()==true) { 
            human.setCrib(this.crib);
//            gui.setCPUCribVisibility(false);
//            gui.setPCribvisibility(true);
            gui.guisetPbuttonscrib(copy, human.ruDealer());
        }
        if (cpu.ruDealer()==true) {
             cpu.setCrib(this.crib);
//            gui.setPCribvisibility(true);
//             gui.setCPUCribVisibility(false);
//           
           
            gui.guisetCpubuttonscrib(copy, cpu.ruDealer());
        }
    }

    public void resetCrib(Player human, Player cpu) {
        ArrayList<Card> pick1 = human.getcribPick();
        ArrayList<Card> pick2 = cpu.getcribPick();
        for (Card y : pick1) {
            this.crib.add(y);
        }

        for (Card x : pick2) {
            this.crib.add(x);
        }
    }
}
