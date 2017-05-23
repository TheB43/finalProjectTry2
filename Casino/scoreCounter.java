import greenfoot.*;
import java.awt.Color;  

public class scoreCounter extends Actor
{
    int Startcash = 200;
    public String userCash() {
        String output = new String();
        output = "$" + Startcash;
        return output;
    }
    public scoreCounter(){
        setImage(new GreenfootImage( "Score: " + userCash(), 25, Color.YELLOW, Color.BLACK));
    }
}
