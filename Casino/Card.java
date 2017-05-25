import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
import java.util.List;
public class Card extends Actor
{
    private String rank;
    private String suit;
    private int rankValue;
    private boolean isTurnedUp = false;
    GreenfootImage cardImage;
    GreenfootImage cardBackground;
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        cardImage = new GreenfootImage(rank + suit + ".png");
        cardBackground = new GreenfootImage("Casino_CardBackground.png");
        setImage(cardBackground);
    }
    public void setCardImage(boolean isTurnedUp) {
        this.isTurnedUp = isTurnedUp;
        if (this.isTurnedUp) {
            setImage(cardImage);
        } else {
            setImage(cardBackground);
        }
    } 
    public void setRankValue(int rank) {
        rankValue = rank % 13 + 1;
    }
    public int getRankValue() {
        return rankValue;
    }
}
