import greenfoot.*;
public class IntroScreen extends World
{
    public IntroScreen()
    {    
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
