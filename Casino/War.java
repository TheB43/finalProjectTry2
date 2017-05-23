import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;  

public class War extends World
{   
    Deck warDeck = mainDeck; //rank, suit, front or back
    public War()
    {    
        super(900, 550, 1);
        System.out.println("Each player starts with half of the shuffled deck." +
        "Players may not look at the cards in their hands. " +
        "Each player pulls one card from the deck and puts it on the table. " +
        "The higher card wins; the player who played it takes both cards and places them on the bottom of his stack." + 
        "Aces are always higher than Kings in war, but they are often lower than Jokers (if used)." +
        "A 'war' occurs when the two players play the same rank (ex: two 9s), making a tie." +
        "Each player then deals three cards facedown (the spoils are given to the winner) and a face-up card. "+
        "The player with the higher face-up card takes all the cards from the war into his stack. " + 
        "The player who accumulates all the cards wins the game."); 
        //instructions from http://www.grandparents.com/grandkids/activities-games-and-crafts/war
        
    }
    public void startWar() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    }
}
