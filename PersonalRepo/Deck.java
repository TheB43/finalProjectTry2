import greenfoot.*;
import java.util.ArrayList; 
public class Deck 
{
    public void fillDeck(ArrayList<Card> deck) {//fills the deck with carsd in form (rank,suit) in card constructer
        String[] Rank = new String[]{"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};//ranks used for the card constructor
        String[] Suit = new String[]{"Heart","Spade","Club","Diamond"}; //suits used for the card constructor
        int index = 0; 
        for (String s: Suit){ //goes through the Suit array
            for (String r: Rank){ //goes through the rank array for every suit
               Card cd = new Card(s,r); // creates a card with the current suit & rank combo
               deck.add(cd); //adds the card the the deck
               deck.get(index).setRankValue(index); //sets a value to the card
               index++;
            }
        }
    }
}