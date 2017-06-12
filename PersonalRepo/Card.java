import greenfoot.*;
public class Card extends Actor
{
    private String rank;
    private String suit;
    private int rankValue;
    private boolean isTurnedUp = false;
    private String cardImage;
    public Card(String suit, String rank) { //constructer 
        this.suit = suit;
        this.rank = rank;
    }
    public void setCardImage(boolean isTurnedUp) { //changing the image based on boolean value
        this.isTurnedUp = isTurnedUp;
        if (this.isTurnedUp) {
            setImage(new GreenfootImage(rank + suit + ".png"));
        } else {
            setImage(new GreenfootImage("Casino_CardBackground.png"));
        }
    } 
    public void setRankValue(int rank) { //calculating rank based on index
        rankValue = rank % 13 + 1;
    }
    public int getRankValue() { //returning value of card for math within games
        return rankValue;
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (!isTurnedUp)
            {
                isTurnedUp = true;
                setCardImage(isTurnedUp);
                War w = (War) (getWorld());
                w.recordCardShowing(this);//tells the world the card is face-up.
            }
        }
    }
}
