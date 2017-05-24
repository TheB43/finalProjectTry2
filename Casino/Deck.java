import greenfoot.*;  
public class Deck extends Actor
{
    public enum Rank
    {
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING;
    }
    public enum Suit
    {
        HEARTS,SPADES,CLUBS,DIAMONDS;
    }
    
    public static void main(){
        Card[] deck = new Card[52];
        int deckIndex = 0;
        for (Suit s: Suit.values()){
            for (Rank r: Rank.values()){
                //deck[deckIndex]; //to be continued 
                deckIndex++;
            }
        }
        }
}