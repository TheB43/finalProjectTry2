import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
import java.util.List;
public class Card extends Actor
{
    private String rank;
    private String suit;
    
    private int pointRank;
    private int player;
    private boolean visible;
    GreenfootImage cardImage;
    GreenfootImage cardBackground;
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        pointRank = getPointRank(rank);
        cardImage = new GreenfootImage(rank + suit + ".png");
        cardbackground = new GreenfootImage("Casino_CardBackground.png");
        changeImage(cardBackground);
    }
    public Card(String suit, String rank, boolean visible) {
        this.suit = suit;
        this.rank = rank;
        this.visible = visible;
        pointValue = getPointRank(rank);
        cardImage = new GreenfootImage(rank + suit + ".png");
        cardbackground = new GreenfootImage(/*insert backgroundcard .png*/);
        if (visible) {
            changeImage(cardImage);
        } else {
            changeImage(cardBackground);
        }
    } 
    public int getPointRank() {
        return pointRank;
    }
}
