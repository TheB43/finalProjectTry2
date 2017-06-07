import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;

public class War extends World
{
    public War()
    { 
        super(900, 550, 1); 
        addObject(mainMenu.scoreKeeper, 60, 20);
        mainMenu.scoreKeeper.modifyCash(0);//enter a negative for subtraction and a reg for addition
    }
    public void startWar(){//begins blackjack
        Greenfoot.start();
        boolean playAgain = true; //holds variable for playAgain method that will come later
        int userBalance = mainMenu.scoreKeeper.Startcash;//sets palyercash
        int dealerBalance = mainMenu.scoreKeeper.dealerCash;//sets dealler balance
    }
}