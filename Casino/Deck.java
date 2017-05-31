import greenfoot.*;
import java.util.ArrayList; 
public class Deck 
{
    String[] Rank = new String[]{"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    String[] Suit = new String[]{"Heart","Spade","Club","Diamond"};
    
    public static ArrayList<Card> Deck;
    public Deck() {
        int index = 0; 
        for (String s: Suit){
            for (String r: Rank){
               Deck.add(new Card(s,r));
               Deck.get(index).setRankValue(index);
               index++;
            }
        }
    }
    public ArrayList<Card> getDeck() {
        return Deck;
    }
}