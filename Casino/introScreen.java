import greenfoot.*;
public class introScreen extends World
{
    public void main(){
        
    }
    public introScreen()
    {    
        super(900, 550, 1); 
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
