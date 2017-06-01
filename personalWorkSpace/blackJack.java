import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;

public class blackJack extends World
{
    public blackJack()
    {    
        super(900, 550, 1); 
        addObject(mainMenu.scoreKeeper, 60, 20);
    }
    public void startBJ(){
        Greenfoot.start();
        
        boolean playAgain = true;
        
        int userBalance = mainMenu.scoreKeeper.Startcash;
        int dealerBalance = 400;
    }
}
