import greenfoot.*;
public class bet extends Actor
{
    static int bet = 0;
    int userCash = mainMenu.scoreKeeper.Startcash;
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
           this.getWorld().removeObject(betSetter);
           this.getWorld().removeObject(addBet);
           this.getWorld().removeObject(subBet);
           this.getWorld().removeObject(stopBet);
           finalBet.setNewText("Bet: " + bet);
       }
    }    
}
