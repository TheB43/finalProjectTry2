import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoFish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class goFish extends World
{
    boolean executeGame = false;
    /**
     * Constructor for objects of class GoFish.
     * 
     */
    public goFish()
    {    
        super(900, 550, 1);
        
    }
    
    public void startGF() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
        executeGame = true;
    }
    public void act() {
        if (executeGame = true) {
            
        }
    }
}
