import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Scanner;

public class blackJack extends World //just a placeholder until time is available to complete
{
    int userBalance = mainMenu.scoreKeeper.Startcash;//sets palyercash
    int dealerBalance = 400;//sets dealler balance
    int bet = 0;
    public blackJack()
    {    
        super(900, 550, 1); //constructs 900 by 550 world
        addObject(mainMenu.scoreKeeper, 60, 20); //adds a scorecounter
        blankTextObject betInstructions = new blankTextObject();
        betInstructions.setNewText("Your Balance is: " + userBalance + "\nPlace your bet by right clicking to increase by ten and left clicking to decrease by 10 (Minimum of $50): ");
        addObject(betInstructions, 450, 100);
        blankTextObject clickToBet = new blankTextObject();
        clickToBet.setNewText("Left click to increse by ten, right click to decrease by ten. Click on \"BET\" to bet");
    }
    public void startBJ(){//begins blackjack
        boolean playAgain = true;
        Greenfoot.start();
        this.bet();
    }
    
    public void bet() {
        int bet = 0;
        int returnNum = 0;
        boolean clicked = false;
        blankTextObject betSetter = new  blankTextObject();
        betSetter.setNewText("Current bet: " + bet);
        addObject(betSetter, 450, 200);
        
        blankTextObject addBet = new  blankTextObject();
        addBet.setNewText("Add by 10");
        addObject(addBet, 350, 300);
        
        blankTextObject subBet = new  blankTextObject();
        subBet.setNewText("Subtract 10");
        addObject(subBet, 550, 300);
        
        blankTextObject stopBet = new  blankTextObject();
        stopBet.setNewText("Stop Betting");
        addObject(stopBet, 450, 500);
                
        if(addBet.getWorld() != null && addBet.gotClicked()){
            bet += 10;
            betSetter.setNewText("Current bet: " + bet);
            System.out.println(bet + " 1 " + returnNum);
        }
        if(subBet.getWorld() != null && subBet.gotClicked()) {
            bet -= 10;
            betSetter.setNewText("Current bet: " + bet);
            System.out.println(bet + " 2 " + returnNum);
        }                   
        if (stopBet.getWorld() != null && stopBet.gotClicked()) {
            bet = 0;
            betSetter.setNewText("Current bet: " + bet);
            System.out.println(bet + " 3 " + returnNum);
        }                                   
    }
}
