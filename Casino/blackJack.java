import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class blackJack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blackJack extends World
{

    /**
     * Constructor for objects of class blackJack.
     * 
     */
    public blackJack()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 550, 1); 
    }
    public void startBJ() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    }
    
}
