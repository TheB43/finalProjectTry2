import greenfoot.*;
public class blackJack extends World
{
    public blackJack()
    {    
        super(900, 550, 1); 
    }
    public void startBJ() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    }
}
