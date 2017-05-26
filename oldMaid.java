import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) test
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

/**
 * Old Maid game
 * 
 * @author Brian G 
 * @version 25May17
 */
public class oldMaid extends World {
    
    public oldMaid() {    
        // Create a new world with 900x550 cells with a cell size of 1x1 pixels.
        super(900, 550, 1);
        setBackground("Casino-playtable.png");
    
        //Determine whether the user wants to play again upon completion of the game.
        boolean playAgain = true;
        
        int userBalance = 300; //<- Placeholder for now until figure out how to carry the balance from game to game.
        int dealerBalance = 500; //<-Starts at $500.
        
        while(playAgain == true) {
            //Prompt user to place bet
            GreenfootImage balanceInfo = new GreenfootImage("Your Balance is: " + userBalance 
                        + "\nPlace your bet (Minimum of $50): ", 12, Color.WHITE, Color.BLACK);
            
            int userAdd = click("bet");
            int userBet = 50 + userAdd;
            int dealerBet = userBet;
        
            //Instantiate one full deck
            ArrayList<Card> deck = new ArrayList<Card>(52);
            Deck OGdeck = new Deck();
            for(int i = 0; i < deck.size(); i++) {
                deck.add(OGdeck.getDeck().get(i)); //<-This is fucky but it basically transfers the cards to a more workable ArrayList
            } //I also added a method getDeck() to the Deck class to make it easier to fit within this code.
            
            //Select one random card from the deck and remove it.
            int randomIndex = (int)Math.random() * 52; //Now the deck is more malleable because it's an ArrayList
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
            
            while(playerHand.size() != 0 && dealerHand.size() != 0) {
                //Prompt user to choose one of the dealer's cards
                GreenfootImage pickCard = new GreenfootImage("Pick a card, any card...", 12, Color.RED, Color.WHITE);
            
                //User chooses card through mouse click:
                int userChoice = click("cards");
            
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
            }   else  { //If something unforseen goes on, in which case they both win.
                userWin = true;
                dealerWin = true;
            }
            
            //Add/Subtract the bet amounts from the winner and loser
            dealerBalance = changeToBalance(dealerBalance, dealerBet, dealerWin);
            userBalance = changeToBalance(userBalance, userBet, userWin);
            
            GreenfootImage again = new GreenfootImage("Play again?\nYes\tNo", 18, Color.WHITE, Color.BLACK); //<- At some point this will be changed to a simple mouse click
            int userResponse = click("play again");
        
            if(userResponse == 1) {
                playAgain = true;
            } else if (userResponse == 2) {
                playAgain = false;
            } else {
                playAgain = false;
            }
        }//Exits the game
        //Place some sort of way to return to the main menu screen here.
    }
            
    public static ArrayList<Card> sort(ArrayList<Card> hand) { // Got code from http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
        //Puts ArrayList into easy format for searching through
        Card temp;
        for (int i = 1; i < hand.size(); i++) { // 'i' is in front
            for(int j = i ; j > 0 ; j--) { // 'j' is behind
                if(hand.get(j).getRankValue() < hand.get(j-1).getRankValue()) { // <- Compare both cards values
                    temp = hand.get(i);
                    hand.set(j, hand.get(j-1));
                    hand.set(j-1, temp);
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
            if(hand.get(i).getRankValue() == hand.get(j).getRankValue()) { // <-Compare Values here
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
    
    public int click(String situation) {
        int returnNum = 0;
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            int x = mouse.getX();
            int y = mouse.getY();
        
            if(Greenfoot.mouseClicked(null)) {
                if(situation.equals("cards")) {
                    if (y > 0 && y < 94) {
                        if(x > (600 / 23) - 74 && x < 600 / 23) {
                                returnNum = 900 / 23;
                        }
                    }
                }
                if(situation.equals("play again")) { //Splits the screen in half into 'Yes" on the left, and 'No' on the right
                    if(x > 0 && x < 450) {
                        returnNum = 1;
                    } else if(x > 450 && x < 900){
                        returnNum = 2;
                    }
                }
                if(situation.equals("bet")) {
                    if(mouse.getButton() == 1) {
                        returnNum = 10;
                    }
                    if(mouse.getButton() == 3) {
                        returnNum = -10;
                    }
                }
            }
        }
        return returnNum;
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