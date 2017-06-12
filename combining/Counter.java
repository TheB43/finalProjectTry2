 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Counter extends Actor
{
    int score = 0;
    public void act()
    {
        setImage(new GreenfootImage ("Score: " + score, 24, Color.WHITE, Color.RED));
    }
    public void addScore ()
    {
     score++;

    }
}
