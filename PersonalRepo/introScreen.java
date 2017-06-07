import greenfoot.*;
public class introScreen extends World
{
    public introScreen()
    {    
        super(900, 550, 1); //constructs the world
        Greenfoot.start();
    }
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo(); //initiates mouse object
        if(Greenfoot.mouseClicked(null)) { //checks whether or not mouse is clicked
            mainMenu MAIN = new mainMenu(); //creates a main menu object
            Greenfoot.setWorld(MAIN); //sets the background to main menu
            MAIN.startMenu(); // calls main menu start method
        }
    }
}
