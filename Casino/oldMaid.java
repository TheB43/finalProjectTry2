import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class oldMaid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class oldMaid extends World
{

    /**
     * Constructor for objects of class oldMaid.
     * 
     */
    public oldMaid()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 550, 1); 
    }
    public void startOM() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    }   
}
