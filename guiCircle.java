
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class guiCircle {

    private boolean colored;
    private Shape circle;

    public guiCircle(int xorigin, int yorigin) {
        colored = false;
        circle = new Ellipse2D.Double(xorigin, yorigin, 10, 10);
    }

    public guiCircle getCircle() {
        return this;
    }

    public boolean ruColored() {
        return this.colored;
    }

    public Shape getShape() {
        return this.circle;
    }

    public void fillCircle() {
        this.colored = true;
        System.out.println("Circle filled");
    }
}
