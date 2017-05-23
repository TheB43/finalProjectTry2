import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainMenu extends World
{

    /**
     * Constructor for objects of class mainMenu.
     * 
     */
    public mainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 550, 1); 
    }   
    public void startMenu() {
        getBackground().drawImage(new GreenfootImage("Main Menu.png"), 0, 0);
        Greenfoot.start();
    }
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int x = mouse.getX();
            int y = mouse.getY();
        if (Greenfoot.mouseClicked(null)) {
            if (x > 50 && x < 193) {
                if (y > 150 && y < 310) {
                    blackJack BLACKJACK = new blackJack();
                    Greenfoot.setWorld(BLACKJACK);
                    BLACKJACK.startBJ();
                }
                else if (y > 330 && y < 490) {
                    oldMaid OLDMAID = new oldMaid();
                    Greenfoot.setWorld(OLDMAID);
                    OLDMAID.startOM();
                }
            }
            else if (x > 240 && x < 384) {
                if (y > 150 && y < 310) {
                    goFish GOFISH = new goFish();
                    Greenfoot.setWorld(GOFISH);
                    GOFISH.startGF();
                }
                else if (y > 330 && y < 490) {
                    War WAR = new War();
                    Greenfoot.setWorld(WAR);
                    WAR.startWar();
                }
            }
        }
       }
    }
}
