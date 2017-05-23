import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
import java.util.List;

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        cardImage = new GreenfootImage(rank + suit + ".png");
        cardBackground = new GreenfootImage("Casino_CardBackground.png");
        setImage(cardBackground);
    }
    public Card(String suit, String rank, boolean visible) {
        this.suit = suit;
        this.rank = rank;
        this.visible = visible;
        cardImage = new GreenfootImage(rank + suit + ".png");
        cardBackground = new GreenfootImage("Casino_CardBackground.png");
        if (visible) {
            setImage(cardImage);
        } else {
            setImage(cardBackground);
        }
    } 
}
