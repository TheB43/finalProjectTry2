import greenfoot.*;
public class bet extends Actor
{
    static int bet = 0;
    int userCash = mainMenu.scoreKeeper.Startcash;
    blankTextObject betInstructions = new blankTextObject();
    blankTextObject betSetter = new  blankTextObject();
    blankTextObject addBet = new  blankTextObject();
    blankTextObject subBet = new  blankTextObject();
    blankTextObject stopBet = new  blankTextObject();
    blankTextObject finalBet = new  blankTextObject();
    public bet(){
        betSetter.setNewText("Current bet: " + bet);
        addBet.setNewText("Add by 5");
        subBet.setNewText("Subtract 5");
        stopBet.setNewText("Stop Betting");
        finalBet.setNewText("Bet: tbd");
        betInstructions.setNewText("Your Balance is: " + userCash + "\nPress up to increse by five, press down to decrease by five. Press enter to finalize bet (min of 50)");
    }
    public void act() 
    {
       if(Greenfoot.isKeyDown("up")){
            bet += 5;
            betSetter.setNewText("Current bet: " + bet);
        }
       if(Greenfoot.isKeyDown("down")) {
            bet -= 5;
            betSetter.setNewText("Current bet: " + bet);
        }                   
       if (Greenfoot.isKeyDown("enter") && bet >= 50 && bet <= userCash){
           mainMenu MAIN = new mainMenu(); //creates a main menu object
           Greenfoot.setWorld(MAIN); //sets the background to main menu
           MAIN.startMenu(); // calls main menu start method
           mainMenu.scoreKeeper.modifyCash(bet);
       }
    }    
}
