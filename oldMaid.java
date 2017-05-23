import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class oldMaid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class oldMaid extends World
{

    /**
     * Constructor for objects of class oldMaid.
     * 
     */
    public oldMaid()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //Prompt user to place bet
        System.out.println("Place your bet (Minimum of $50): ");
        Scanner keyboard = new Scanner(System.in);
        
        int userBet = keyboard.nextInt();
        int dealerBet = userBet;
        
        //Instantiate one full deck
        ArrayList<Card> deck = new ArrayList<Card>(52);
        
        //Select one random card from the deck and remove it.
        int randomIndex = (int)Math.random() * 52;
        deck.remove(randomIndex);
        
        //Sort the remaining deck into two hands, one for the player, one for the house.
        ArrayList<Card> playerHand = new ArrayList<Card>();
        ArrayList<Card> dealerHand = new ArrayList<Card>();
        
        //Fill Player's hand
        int index = deck.size() - 1;
        while(index > 0) {
            int randomCard = (int)Math.random() * 51;
            playerHand.add(deck.get(randomCard));
            deck.remove(randomCard);
            index--;
        }
        
        //Fill Dealer's hand
        int index2 = deck.size() - 1;
        while(index2 > 0) {
            int randomCard = (int)Math.random() * 51;
            playerHand.add(deck.get(randomCard));
            deck.remove(randomCard);
            index2--;
        }
    }
    
    public static ArrayList<Card> sort(ArrayList<Card> hand) { // Got code from http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
        Card temp;
        for (int i = 1; i < hand.size(); i++) { // 'i' is in front
            for(int j = i ; j > 0 ; j--) { // 'j' is behind
                if(hand.get(j) < hand.get(j-1)) { // <- Compare both cards values
                    temp = hand.get(i);
                    hand.get(j) = hand.get(j-1);
                    hand.get(j-1) = temp;
                }
            }
        }
        return hand;
    }
    
    public void checkForPair(ArrayList<Card> hand) {
        sort(hand);
        int i = hand.size() - 2; //Variable in front
        int j = hand.size() - 1; //Variable behind
        while (i >= 0) {
            if(hand.get(i) == hand.get(j)) { // <-Compare Values here
                if(hand.get(i).equals("Clubs") && hand.get(j).equals("Spades") || 
                   hand.get(i).equals("Spades") && hand.get(j).equals("Clubs") || 
                   hand.get(i).equals("Hearts") && hand.get(j).equals("Diamonds") || 
                   hand.get(i).equals("Diamonds") && hand.get(j).equals("Hearts")) { // <-Compare Suits here
                    hand.remove(i);
                    hand.remove(j);
                }
            }
            j--;
            i--;
        }
    }
    
    public int changeToBalance(int betAmount, boolean win) {
        
    }
    
    public void startOM() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    } 
}