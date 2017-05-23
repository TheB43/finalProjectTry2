import greenfoot.*;  
public class War extends World
{
    public War()
    {    
        super(900, 550, 1); 
    }
    public void startWar() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    }
}
