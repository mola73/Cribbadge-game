/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import cribbadgegui.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author muham
 */
public class guiGameBoard extends JComponent {// mae the 121 pegs for bothe players as a comp.

    private JPanel bp;
    private guiPeg tracks;

    public guiPeg getTracks() {
        return tracks;
    }
    // private ArrayList <guiCircle> pegsh= new ArrayList();
    // private ArrayList <guiCircle> pegscpu= new ArrayList();

    public guiGameBoard() {
        tracks = new guiPeg();
//         for(guiCircle a: tracks.getHumanPeg()){
//             pegsh.add(a);
//         }
//          for(guiCircle b: tracks.getCpuPeg()){
//             pegscpu.add(b);
//         }
    }

    //how to peaint a specific circle fromt eh outside.
    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        for (guiCircle a : this.tracks.getCpuPeg()) {
            g2.setColor(Color.GRAY);

            if (a.ruColored()) {
                g2.setColor(Color.green);
                g2.fill(a.getShape());
            } else {
                g2.draw(a.getShape());
            }
        }

        for (guiCircle b : this.tracks.getHumanPeg()) {
            g2.setColor(Color.GRAY);

            if (b.ruColored()) {
                g2.setColor(Color.green);
                g2.fill(b.getShape());
            } else {
                g2.draw(b.getShape());
            }
        }
    }

//    public void pegFillCpu(Player x, int x){
//        if(x==cpu){
//           
//            
//        }
//    }
    public void cpucolor(int x) {
        this.tracks.getCpuPeg().get(x).fillCircle();
        repaint();
    }

    public void humancolor(int x) {

        this.tracks.getHumanPeg().get(x).fillCircle();
        repaint();
        System.out.println("human Circle filled");
    }

    public JPanel getBoard() {
        return bp;
    }

}
