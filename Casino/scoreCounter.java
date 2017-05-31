import greenfoot.*;
import java.awt.Color;  
public class scoreCounter extends Actor
{
    public int Startcash = 200;
    public int dealerCash = 400; 
    //scoreCounter scoreKeeper = new scoreCounter();//issue
    private String userCash() {
        return "$" + Startcash;
    }
    public scoreCounter(){
        setImage(new GreenfootImage( "Score: " + userCash(), 25, Color.YELLOW, Color.BLACK));
    }
    public void modifyCash(int modNum) {
        Startcash += modNum;
        dealerCash -= modNum;
        setImage(new GreenfootImage( "Score: " + userCash(), 25, Color.YELLOW, Color.BLACK));
    }
}
