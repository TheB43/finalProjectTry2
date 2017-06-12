 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 *@SCL
 */
public class Deck extends Actor
{
    // Strings used to form filenames for the card images.
    private static final String[] NUMBERS = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private static final String[] SUITS = {"Club","Diamond","Heart","Spade"};
    
    
    private List<Card> cards; // holds playing cards
    
    
    
    
    public Deck()
    {
        cards = new ArrayList<Card>();
        for (int n = 0; n < NUMBERS.length; n++)
        {
            for(int s = 0; s < SUITS.length; s++)
            {
                String cardImage = NUMBERS[n] + SUITS[s] + ".png";
                Card c = new Card(cardImage);
                cards.add(c);
            }
        }
    }
    
    
    
    
    public Card deal()
    {
        int randCard = Greenfoot.getRandomNumber(cards.size());
        Card c = cards.remove(randCard);
        //System.out.print(c.getCardImage());
        
        return c;
        
    }
   /* private Counter counter;
    public int Card(Counter pointCounter)
    {
        counter = pointCounter;
        return pointCounter;
    }
    */
    
  /*
   public void Collect()
    {
        if ( NUMBERS[0].length() > NUMBERS[1].length()) 
        {
            Counter.add(10);
        
    }
        if ( NUMBERS[1].length() > NUMBERS[0].length()) 
        {
            Counter.add(-10);
        
    }
}
*/
    
    
    
    public void act()
    {
    //nothing
}
}