import greenfoot.*;
import java.util.ArrayList;


public class gameTemplate extends World //just a placeholder until time is available to complete
{
    int userBalance = mainMenu.scoreKeeper.Startcash;//sets palyercash
    int dealerBalance = 400;//sets dealler balance
    bet Better = new bet();
    blankTextObject pressToBet = new  blankTextObject();
    blankTextObject betInstructions = new blankTextObject();
    public gameTemplate()
    {    
        super(900, 550, 1); //constructs 900 by 550 world
        addObject(mainMenu.scoreKeeper, 60, 20); //adds a scorecounter
        betInstructions.setNewText("Your Balance is: " + userBalance + "\nPress up to increse by five, press down to decrease by five. Press enter to finalize bet (min of 50)");
        addObject(betInstructions, 450, 100);
        Better.finalBet.setNewText("Bet: tbd");
        addObject(Better.finalBet, 700, 50);
    }
    public void startBJ(){//begins blackjack
        startBet();
    }
    public void startBet(){
        addObject(Better.betSetter, 450, 200);
        addObject(Better.addBet, 350, 300);
        addObject(Better.subBet, 550, 300);
        addObject(Better.stopBet, 450, 500);
        addObject(Better,0,0);
    }
}
