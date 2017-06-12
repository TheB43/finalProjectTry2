 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @SCL
 * 
 */
public class Card extends Actor
{
    private String cardImage;  // the filename of the card image
    private String cardImageOver;  // the file name of the back of the card
    private boolean faceUp; // keeps track of whether the card is face-up or not
    
    
    
    
    public Card(String im)
    {
        cardImage = im;
        cardImageOver = "Casino_CardBackground.png";
        faceUp = false;
    }
    
    
    public String getCardImage()
    {
        return cardImage;
    }
    
    
    public void turnOver()
    {
        setImage(cardImageOver);
        faceUp = false;
    }
    
    
    public void showFace()
    {
        setImage(cardImage);
        faceUp = true;
        
    }
  
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (!faceUp)
            {
                showFace();
                War w = (War) (getWorld());
                w.recordCardShowing(this); //tells the world the card is face-up.
            }
        }
    }
}
    