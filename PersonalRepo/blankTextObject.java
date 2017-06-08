import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;  
public class blankTextObject extends Actor
{      
    private boolean clicked;
    public void setNewText(String newText)
    {
        setImage(new GreenfootImage(newText, 25, Color.WHITE, Color.BLACK));
    }
    public void act(){
        if(Greenfoot.mouseClicked(this)) clicked = true;
    }
    public boolean gotClicked()
    {
        boolean wasClicked = clicked;
        clicked = false;
        return wasClicked;
    }
}
