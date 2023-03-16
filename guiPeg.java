/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import cribbadgegui.*;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author muham
 */
public class guiPeg  {
   // private ArrayList<JComponent> pegs=new ArrayList();
    private ArrayList <guiCircle>  pegscpu=new ArrayList();
     private ArrayList <guiCircle>  pegsh=new ArrayList();
     //update tracks top have 122 pegs for a zeor spot.
     //make a peg clss that has a boolean for peg or nto peg. this is how the paint component nwos if it is supposed to be colered or ot.
    public guiPeg(){
    for(int i=1; i<=1220; i+=10){
          pegscpu.add(new guiCircle(i,1));
          //  pegscpu.add(new Ellipse2D.Double(i,1,10,10));
           
              pegsh.add(new guiCircle(i,20));
            //  pegsh.add(new Ellipse2D.Double(i,20,10,10));
        }
        // peg1 =new Ellipse2D.Double( x,y,10,10);// so that each circle has space horizontally and each peg list has space.
    
        
    }

public  ArrayList<guiCircle> getCpuPeg(){
    return this.pegscpu;
}
public  ArrayList<guiCircle> getHumanPeg(){
    return this.pegsh;
}

public void updatePeg(Player x, int y){
    if(x.ruHumanb()){
        this.pegsh.get(y).fillCircle();
        
    }
    if(!x.ruHumanb()){
         this.pegscpu.get(y).fillCircle();
    }
}
        
        }