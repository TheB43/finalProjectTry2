import greenfoot.*;
public class introScreen extends World
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    public introScreen()
    {    
        super(900, 550, 1); //constructs the world
        Greenfoot.start();
    }
    public void act() {
         //initiates mouse object
        if(Greenfoot.mouseClicked(null)) { //checks whether or not mouse is clicked
            betScreen BS = new betScreen(); //creates a main menu object
            Greenfoot.setWorld(BS); //sets the background to main menu
            BS.startBet(); // calls main menu start method
        }
    }
}
