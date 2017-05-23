import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class War extends World
{
  public War() 
  {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 550, 1); 
  }
   public void startWar() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
  }
}

