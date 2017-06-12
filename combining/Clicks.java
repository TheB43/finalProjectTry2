import greenfoot.*;
/**
 * This is the method I used in Old Maid to track the clicks. It's a little bit ridiculous 
 * and possibly wrong, but it's a good start. Also, some of the code is quite specific to Old Maid, so
 * maybe consider changing some things around.
 */
public class Clicks {
    public int click(String situation) {//Input each situation, whther it be choosing a card, placing a bet, or playing again.
        int bet = 0;
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
                        if(x < 340 && x > 260) {// Just making the spot in the center of the screen. Move the image "Place" accordingly.
                            returnNum = -100; //<-This triggers the code above to stop prompting user to place a bet
                        }
                    }
                }
            }
        }
        return returnNum;
    }
    /*
     * This is how the "cards" situation is used in the main code:
     * while(playerHand.size() != 0 && dealerHand.size() != 0) {
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
            
     * This is how the "play again" scenario is used in the main code:
     * GreenfootImage again = new GreenfootImage("Play again?\nYes\tNo", 18, Color.WHITE, Color.BLACK); //<- At some point this will be changed to a simple mouse click
            int userResponse = click("play again");
        
            if(userResponse == 1) {
                playAgain = true;
            } else if (userResponse == 2) {
                playAgain = false;
            } else {
                playAgain = false;
            }
            
     * This is how the "bet" scenario is used in the main code:
     * //Place bet
            boolean bet = false;
            int userBet = 50;
            while(bet == false && userBet < 50 ) { //Allows user to constantly update bet until they hit "BET" setting their amount
                int userAdd = click("bet");
                if(userAdd == -100) { //-100 is just some arbitrary number that cannot be reachde by any other means
                    bet = true;
                }
                userBet += userAdd;
                GreenfootImage showBet = new GreenfootImage(userBet + "\nPlace", 12, Color.WHITE, Color.BLACK);
            }
            int dealerBet = userBet;
     */
}