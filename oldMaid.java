import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo) test
import java.util.ArrayList;
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
        addObject(mainMenu.scoreKeeper, 60, 20); //Add user balance to upper-left corner
        mainMenu.scoreKeeper.dealerCash = 400; //In this game the delaer starts with $400
    }
    
    //Instantiate original deck
    ArrayList<Card> omDeck = new ArrayList<Card>(); //Creating an arraylist of cards
    Deck deckHolder = new Deck(); //Creating a deck by which to fill the cards
    public void startOM() {
        deckHolder.fillDeck(omDeck); //Filling arraylist
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
        
        //Determine whether the user wants to play again upon completion of the game.
        boolean playAgain = true;
        
        int userBalance = 300; //<- Placeholder for now until figure out how to carry the balance from game to game.
        int dealerBalance = 500; //<-Starts at $500.
        
        while(playAgain == true) {
            //Prompt user to place bet
            setImage(new GreenfootImage("Your Balance is: " + userBalance 
                        + "\nPlace your bet (Minimum of $50): ", 12, Color.WHITE, Color.BLACK));
            
            //Place bet
            boolean betAgain = true; //Used with for-loop to continually prompt user to change their bet until they click a box in the middle of the screen
            int userBet = 50; //The minimum bet is $50
            while(betAgain == true || userBet < 50 ) { //Allows user to constantly update bet until they hit "BET" setting their amount
                int userAdd = click("bet"); //Refer to the "click" method
                if(userAdd == 0) { //0 is just some arbitrary number that cannot be reachde by any other means
                    betAgain = false;
                }
                userBet += userAdd;
                setImage(new GreenfootImage(userBet + "\nPlace", 12, Color.WHITE, Color.BLACK)); //Continually update text with user bet amount
            }
            int dealerBet = userBet; //Dealer must match user's bet
                        
            //Select one random card from the omDeck and remove it.
            int randomIndex = (int)(Math.random() * 52);
            omDeck.remove(randomIndex);
            
            //Sort the remaining omDeck into two hands, one for the player, one for the house.
            ArrayList<Card> playerHand = new ArrayList<Card>();
            ArrayList<Card> dealerHand = new ArrayList<Card>();
                        
            //Fill Player's hand
            for(int index = 0; index < 26; index++) {
                int randomCard = (int)(Math.random() * omDeck.size());
                playerHand.add(omDeck.get(randomCard));
                omDeck.remove(randomCard);
            }
            
            //Fill Dealer's hand
            for(int index2 = 0; index2 < 25; index2++) {
                int randomCard2 = (int)(Math.random() * omDeck.size());
                dealerHand.add(omDeck.get(randomCard2));
                omDeck.remove(randomCard2);
            }
        
            //Commence the playing
            checkForPair(playerHand); //Refer to the "checkForPair" method
            checkForPair(dealerHand);
            
            while(true) { //New edit, this is changed to use a break to exit the while loop.
                //Prompt user to choose one of the dealer's cards
                GreenfootImage pickCard = new GreenfootImage("Pick a card, any card...", 12, Color.RED, Color.WHITE);
            
                //User chooses card through mouse click:
                int userChoice = click("cards"); //Refer to the "click" method
            
                //Add the player's chosen card to their hand
                playerHand.add(dealerHand.get(userChoice));
                dealerHand.remove(userChoice);
                
                checkForPair(playerHand);
                
                //Time for the dealer...
                int dealerChoice = (int)(Math.random() * playerHand.size());
                
                //Add the dealer's chosen card
                dealerHand.add(playerHand.get(dealerChoice));
                playerHand.remove(dealerChoice);
                
                checkForPair(dealerHand);
                
                if(playerHand.size() == 0 || dealerHand.size() == 0) { //When one player runs out of cards, the game ends
                    break; //End game
                }
            }
            
            //Determine the winner
            boolean userWin; //Is true when the player wins
            boolean dealerWin; //Is true when the dealer wins
        
            if(dealerHand.size() == 1) { //The player with the single, unmatched card, the "Old Maid", when the game ends loses.
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
            dealerBet = bet(dealerBet, dealerWin);
            userBet = bet(userBet, userWin);
            
            mainMenu.scoreKeeper.Startcash += userBet;
            mainMenu.scoreKeeper.dealerCash += dealerBet;
            
            GreenfootImage again = new GreenfootImage("Play again?\nYes\tNo", 18, Color.WHITE, Color.BLACK); //<- At some point this will be changed to a simple mouse click
            int userResponse = click("play again"); //Refer to the click method
        
            if(userResponse == 1) {
                playAgain = true; //When true the game begins anew
            } else if (userResponse == 2) {
                playAgain = false; //When false game is not played again
            } else { //If something unforseen were to happen
                playAgain = false;
            }
        }//Exits the game
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
    
    public static void checkForPair(ArrayList<Card> hand) {
        sort(hand);
        int i = hand.size() - 2; //Variable in front
        int j = hand.size() - 1; //Variable behind
        while (i >= 0) { //Traversing the ArrayList backwards to avoid problems with removals
            if(hand.get(i).getRankValue() == hand.get(j).getRankValue()) { // <-Compare Values here if they match...
                if(hand.get(i).getSuit().equals("Club") && hand.get(j).getSuit().equals("Spade") || 
                   hand.get(i).getSuit().equals("Spade") && hand.get(j).getSuit().equals("Club") || 
                   hand.get(i).getSuit().equals("Heart") && hand.get(j).equals("Diamond") || 
                   hand.get(i).getSuit().equals("Diamond") && hand.get(j).getSuit().equals("Heart")) { // <-...then we compare Suits here if they match...
                    hand.remove(i); //...then we remove both hands from the player's hand, like in Old Maid
                    hand.remove(i);
                }
            }
            j--;
            i--;
        }
    }
    
    public int click(String situation) {//Input each situation, whether it be choosing a card, placing a bet, or playing again.
        int bet = 0; //This is eing constantly updated so it is made separate from returnNum for simplicity, but ultimately returnNum will equal bet.
        int returnNum = 0; //A somewhat redundant way to manipulate numbers and return them at the end of the method
        
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
                    if(y > 233 && y < 550 || y < 217 && y > 0) { //Anywhere outside of the "Enter" box in the middle of the screen
                        if(x > 340 && x < 600 || x < 260 && x > 0) { 
                            if(mouse.getButton() == 1) { //A left-click increses the bet by 10
                                bet += 10;
                            }
                            if(mouse.getButton() == 3) { //A right-click decreses the bet by 10
                                bet += -10;
                            }
                        }
                        returnNum = bet;
                    } else if (y < 233 && y > 217) { //Finalizes the bet when the "Enter" box in the middle of the screen is clicked
                        if(x < 340 && x > 260) { // Just making the spot in the center of the screen. Move the image "Place" accordingly.
                            returnNum = 0; //<-This triggers the code above to stop prompting user to place a bet.
                        }
                    }
                }
            }
        }
        return returnNum;
    }
    
    public int bet(int betAmount, boolean win) { //Turns bet into a negative if player (dealer or user) loses.
        int outcome = betAmount;
        if(win == false) { //If the player is the loser...
            outcome = -outcome; //...the bet is subtracted
        }
        return outcome;
    }
}