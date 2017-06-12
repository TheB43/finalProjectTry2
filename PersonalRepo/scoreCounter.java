import greenfoot.*;
import java.awt.Color;  
public class scoreCounter extends Actor
{
    public int Startcash = 200;
    public int dealerCash = 400; 
    public int bet = 0;
    private String userCash() {//allows for a changing amount within the text
        return "$" + Startcash;
    }
    public scoreCounter(){ //creates a score counter
        setImage(new GreenfootImage( "Score: " + userCash(), 25, Color.WHITE, Color.BLACK));
    }
    public void modifyCash(int modNum) {//adds cash to the user. if the user loses input negative number
        Startcash += modNum;
        dealerCash -= modNum;
        setImage(new GreenfootImage( "Score: " + userCash(), 25, Color.YELLOW, Color.BLACK));//updates the score
    }
     public void modifyBet(int modNum) {//adds cash to the user. if the user loses input negative number
        bet += modNum;
        setImage(new GreenfootImage( "Score: " + userCash(), 25, Color.YELLOW, Color.BLACK));//updates the score
    }
}
