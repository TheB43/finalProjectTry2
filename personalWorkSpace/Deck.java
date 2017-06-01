import greenfoot.*;
import java.util.ArrayList; 
public class Deck 
{
    String[] Rank = new String[]{"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    String[] Suit = new String[]{"Heart","Spade","Club","Diamond"};
    
    private static ArrayList<Card> deck;//creates a deck
    public Deck() {//fills the deck with carsd in form (rank,suit) in card constructer
        int index = 0; 
        for (String s: Suit){
            for (String r: Rank){
               Card cd = new Card(s,r);
               deck.add(cd);
               deck.get(index).setRankValue(index);
               index++;
            }
        }
    }
    public static ArrayList<Card> getDeck() {//returns the deck
        return deck;
    }
}