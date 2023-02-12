/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
import java.util.ArrayList;
public class Game {
    private ArrayList<Card> crib =new ArrayList();
   
    
    
    public static void round(Player x, Player y){
        if(x.getDealer()==y.getDealer()){
            y.setDealer();
        }
        
    }
    
    public static void main(String[]args){
        Player a=new Player();
        Player b=new Player();
        System.out.println(a);
        System.out.println(b);
    }
}
