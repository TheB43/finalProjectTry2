import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;  
public class blankTextObject extends Actor
{
    public void setNewText(String newText)
    {
        setImage(new GreenfootImage(newText, 25, Color.WHITE, Color.BLACK));
    }
}
