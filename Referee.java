
import static javafx.application.Platform.exit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author muham
 */
public class Referee {
    
    private boolean winner;
    private Player pone;
    private Player dealer;
    private Human human;
    private Cpu cpu;
    
    public Referee(Human human, Cpu cpu) {
        this.winner = false;
        this.human = human;
        this.cpu = cpu;
        if (human.getPone()) {
            this.pone = human;
        } else {
            this.dealer = human;
        }
        if (cpu.getDealer()) {
            this.dealer = cpu;
        } else {
            this.pone = cpu;
        }
        
    }
    
    public void restartGame() {
        System.out.println("RESTART GAME!!!!!!!");
        this.human.playerreset();
        this.cpu.playerreset();
        this.cpu.setScore(0);
        this.human.setScore(0);
    }
    
    public void endGame() {
        System.out.println("END GAME!!!!!!!");
        exit();
    }
    
    public void anouncement() {
        if (pone.getScore() >= 121) {
            System.out.printf("THE %S HAS WON THE GAME!!!!!!!!", pone.getStatus());
            System.out.printf("%s  %n %n %s", this.pone, this.dealer);
            this.endGame();
        } else if (dealer.getScore() >= 121) {
            System.out.printf("THE %S HAS WON THE GAME!!!!!!!!", dealer.getStatus());
             System.out.printf("%s  %n %n %s",  this.dealer, this.pone);
            this.endGame();
            this.endGame();
        }
    }
    
    public void displayBoard() {
        
    }
}
