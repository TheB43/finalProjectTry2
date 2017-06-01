import greenfoot.*;
import java.util.ArrayList;
public class goFish extends World
{
    public goFish()
    {    
        super(900, 550, 1); 
        addObject(mainMenu.scoreKeeper, 60, 20);
        mainMenu.scoreKeeper.modifyCash(0);//enter a negative for subtraction and a reg for addition
    }
    ArrayList<Card> omDeck = Deck.getDeck();
    public void startGF() {
        int randomIndex = (int)Math.random() * 52;
        omDeck.remove(randomIndex);
    }
}
