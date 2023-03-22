
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
    private Player pone;// pone always switches
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
public void poneWinner(){
     if (human.ruDealer() == true) {
            if (human.getScore() >= 121) {
                System.out.printf("THE %S HAS WON THE GAME!!!!!!!!", human.getStatus());
                System.out.printf("%s  %n %n %s", this.human, this.cpu);
                this.endGame();
            }
        } else if (cpu.ruDealer() == true) {
            if (cpu.getScore() >= 121) {
                System.out.printf("THE %S HAS WON THE GAME!!!!!!!!", cpu.getStatus());
                System.out.printf("%s  %n %n %s", this.cpu, this.dealer);
                this.endGame();
            }
        }
}
     public void dealerWinner(){
          if (human.ruDealer() == false) {
            if (human.getScore() >= 121) {
                System.out.printf("THE %S HAS WON THE GAME!!!!!!!!", human.getStatus());
                System.out.printf("%s  %n %n %s", this.human, this.cpu);
                this.endGame();
            }
        } else if (cpu.ruDealer() == false) {
            if (cpu.getScore() >= 121) {
                System.out.printf("THE %S HAS WON THE GAME!!!!!!!! %n", cpu.getStatus());
                System.out.printf("%s  %n %n %s%n", this.cpu, this.human);
                this.endGame();
            }
        }
     }

    public void anouncement() {
        this.poneWinner();
        this.dealerWinner();
    }

    public void displayBoard() {

    }
}
