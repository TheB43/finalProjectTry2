import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

/**
 * Old Maid game
 * 
 * @author Brian G 
 * @version 23May17
 */
public class oldMaid extends World {
    
    public oldMaid() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //Determine whether the user wants to play again upon completion of the game.
        boolean playAgain = true;
        
        int userBalance = 300; //<- Placeholder for now until we figure out how to carry the balance from game to game.
        int dealerBalance = 500; //<-Starts at $500.
        
        while(playAgain == true) {
            //Prompt user to place bet
            GreenfootImage balanceInfo = new GreenfootImage("Your Balance is: " + userBalance 
                        + "\nPlace your bet (Minimum of $50): ", 12, Color.WHITE, Color.BLACK);
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
        
            //Commence the playing
            checkForPair(playerHand);
            checkForPair(dealerHand);
            
            while(playerHand.size() + dealerHand.size() > 1 && playerHand.sixe() != 0 && dealerHand.size() != 0) {
                //Prompt user to choose one of the dealer's cards
                GreenfootImage pickCard = new GreenfootImage("Pick a card, any card...", 12, Color.RED, Color.WHITE);
            
                //*Implement here a way for user to choose a card through clicking...but for now this:
                int userChoice = keyboard.nextInt() - 1;
                while(userChoice > dealerHand.size() - 1) { //If the player chooses an incorrect choice
                    GreenfootImage tryAgain = new GreenfootImage("That was not a choice...Try again: ", 14, Color.RED, Color.RED);
                    
                    userChoice = keyboard.nextInt() - 1;
                }
            
                //Add the player's chosen card to their hand
                playerHand.add(dealerHand.get(userChoice));
                dealerHand.remove(userChoice);
                
                checkForPair(playerHand);
                
                //Time for the dealer...
                int dealerChoice = (int)Math.random() * playerHand.size();
                
                //Add the dealer's chosen card
                dealerHand.add(playerHand.get(dealerChoice));
                playerHand.remove(dealerChoice);
                
                checkForPair(dealerHand);
            }
            
            //Determine the winner
            boolean userWin; //Is true when the player wins
            boolean dealerWin; //Is true when the dealer wins
        
            if(dealerHand.size() == 1) {
                userWin = true;
                dealerWin = false;
            } else if (playerHand.size() == 1) {
                userWin = false;
                dealerWin = true;
            }   else  { //If something unforseen goes on.
                userWin = null;
                dealerWin = null;
            }
            
            //Add/Subtract the bet amounts from the winner and loser
            dealerBalance = changeToBalance(dealerBalance, dealerBet, dealerWin);
            userBalance = changeToBalance(userBalance, userBet, userWin);
            
            GreenfootImage playAgain = new GreenfootImage("Play again? (Y for yes, N for no): ", 18, Color.WHITE, Color.BLACK); //<- At some point this will be changed to a simple mouse click
            char userResponse = keyboard.nextLine().charAt(0);
        
            if(userResponse == 'Y') {
                playAgain = true;
            } else if (userResponse == 'N') {
                playAgain = false;
            } else {
                GreenfootImage chastise = new GreenfootImage("You don't seem to take this seriously, so I guess you don't want to play anymore", 14, Color.RED, Color.WHITE);
                playAgain = false;
            }
        }//Exits the game
        //Place some sort of way to return to the main menu screen here.
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
        } //Cards are finally sorted
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
    
    public int changeToBalance(int initialAmount, int betAmount, boolean win) {
        if(win == true) {
            return initialAmount + betAmount;
        } else if (win == false) {
            return initialAmount - betAmount;
        } else {
            return initialAmount;
        }
    }
    
    public void startOM() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    } 
}