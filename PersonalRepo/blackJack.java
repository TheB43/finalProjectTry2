import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;

public class blackJack extends World //just a placeholder until time is available to complete
{
    public blackJack()
    {    
        super(900, 550, 1); //constructs 900 by 550 world
        addObject(mainMenu.scoreKeeper, 60, 20); //adds a scorecounter
    }
    public void startBJ(){//begins blackjack
        Greenfoot.start();
        boolean playAgain = true; //holds variable for playAgain method that will come later
        int userBalance = mainMenu.scoreKeeper.Startcash;//sets palyercash
        int dealerBalance = 400;//sets dealler balance
    }
}
