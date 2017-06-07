import greenfoot.*;
import java.util.ArrayList;
import java.awt.Color;

public class goFish extends World
{
    int userBet;
    public goFish()
    {    
        super(900, 550, 1); 
        setBackground("Casino-playtable.png");
        addObject(mainMenu.scoreKeeper, 60, 20);
        mainMenu.scoreKeeper.modifyCash(getBet());
    }
    ArrayList<Card> gfDeck = new ArrayList<Card>();
    Deck deckHolder = new Deck();
    public void startGF() {
        deckHolder.fillDeck(gfDeck);//filling the arraylist
        Greenfoot.start();
        
        boolean playAgain = true;
        
        int userBalance = 300; 
        int dealerBalance = 500;
        
        while (playAgain == true) {
            GreenfootImage balanceInfo = new GreenfootImage("Your Balance is: " + userBalance 
                        + "\nPlace your bet (Minimum of $50): ", 12, Color.WHITE, Color.BLACK);
            //Place bet
            boolean bet = false;
            int userBet = 50;
            while(bet == false && userBet <= 50 ) { //Allows user to constantly update bet until they hit "BET" setting their amount
                int userAdd = click("bet");
                if(userAdd == -100) { //-100 is just some arbitrary number that cannot be reached by any other means
                    bet = true;
                }
                userBet += userAdd;
                GreenfootImage showBet = new GreenfootImage(userBet + "\nPlace", 12, Color.WHITE, Color.BLACK);
            }
            int dealerBet = userBet;
            
            //Select one random card from the deck and remove it.
            int randomIndex = (int)Math.random() * 52; //Now the deck is more malleable because it's an ArrayList
            Deck OGdeck = new Deck();
            gfDeck.remove(randomIndex);
            
            //Sort the remaining deck into two hands, one for the player, one for the house.
            ArrayList<Card> playerHand = new ArrayList<Card>();
            ArrayList<Card> dealerHand = new ArrayList<Card>();
        
            //Fill Player's hand
            int index = gfDeck.size() - 1;
            while(index > 0) {
                int randomCard = (int)Math.random() * 51;
                playerHand.add(gfDeck.get(randomCard));
                gfDeck.remove(randomCard);
                index--;
            }
            
            //Fill Dealer's hand
            int index2 = gfDeck.size() - 1;
            while(index2 > 0) {
                int randomCard = (int)Math.random() * 51;
                dealerHand.add(gfDeck.get(randomCard));
                gfDeck.remove(randomCard);
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
        
            if(dealerHand.size() == 0 && playerHand.size() == 0) { // nested for loop to compare number of pairs between player and dealer
                if (checkForPair(dealerHand) > checkForPair(playerHand)) {
                    userWin = false;
                    dealerWin = true;
                    dealerBet = bet(dealerBet, dealerWin);
                    userBet = bet(userBet, userWin);
            
                }
                else if (checkForPair(dealerHand) < checkForPair(playerHand)) {
                    userWin = true;
                    dealerWin = false;
                    dealerBet = bet(dealerBet, dealerWin);
                    userBet = bet(userBet, userWin);
            
                }
            }   else  { //If something unforseen goes on, in which case they both win.
                userWin = true;
                dealerWin = true;
            }
            
            GreenfootImage again = new GreenfootImage("Play again?\nYes\tNo", 18, Color.WHITE, Color.BLACK); //<- At some point this will be changed to a simple mouse click
            int userResponse = click("play again");
        
            if(userResponse == 1) {
                playAgain = true;
            } else if (userResponse == 2) {
                playAgain = false;
            } else {
                playAgain = false;
            }
        }
    }
    public int click(String situation) {//Input each situation, whther it be choosing a card, placing a bet, or playing again.
        int bet = 0;
        int screenBet = 50 + bet;
        int returnNum = 0;
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            int x = mouse.getX();
            int y = mouse.getY();
        
            if(Greenfoot.mouseClicked(null)) {
                if(situation.equals("cards")) { //This code is for choosing cards
                    if (y > 456 && y < 550) { //The scenario here is the cards are displayed at the top of the screen
                        if(x > (600 / 23) - 74 && x < 600 / 23) { // Screen is not long enough to accomodate an entire hand,
                                returnNum = 900 / 23;             // so cards will overlap, but each is given equal space to be clicked
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
                if(situation.equals("bet")) { //This code is for placing a bet.
                    if(y > 233 && y < 550 || y < 217 && y > 0) {
                        if(x > 340 && x < 600 || x < 260 && x > 0) {
                            if(mouse.getButton() == 1) {
                                bet += 10;
                            }
                            if(mouse.getButton() == 3) {
                                bet += -10;
                            }
                        }
                        returnNum = bet;
                    } else if (y < 233 && y > 217) {
                        if(x < 340 && x > 260) { // Just making the spot in the center of the screen. Move the image "Place" accordingly.
                            returnNum = -100; //<-This triggers the code above to stop prompting user to place a bet.
                        }
                    }
                }
            }
        }
        return returnNum;
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
    public int checkForPair(ArrayList<Card> hand) {
        int pairCounter = 0;
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
                    pairCounter += 1;
                }
            }
            j--;
            i--;
        }
        return pairCounter;
    }
    public int bet(int betAmount, boolean win) {
        if (win == true) {
            return betAmount;
        } else {
            return -betAmount;
        }
    }
    public int getBet() {
        return userBet;
    }    
}
