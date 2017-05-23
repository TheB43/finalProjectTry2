import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroScreen extends World
{

    /**
     * Constructor for objects of class IntroScreen.
     * 
     */
    public IntroScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 550, 1); 
        getBackground().drawImage(new GreenfootImage("Casino-introscreen.png"), 0, 0);
        Greenfoot.start();
    }
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int x = mouse.getX();
            int y = mouse.getY();
        }
        if(Greenfoot.mouseClicked(null)) {
            mainMenu MAIN = new mainMenu();
            Greenfoot.setWorld(MAIN);
            MAIN.startMenu();
        }
    }
}
