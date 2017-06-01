import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class War extends World
{   
    Deck warDeck = mainDeck; //rank, suit, front or back
     public static void main(String[] args) {
   	 	System.out.println("minimum bet starts at $100, dealer has $200");
	 
   		 Random card = new Random();
   		 Scanner reader = new Scanner(System.in);
	 
   		 ArrayList<String> deck = new ArrayList<String>();
   		 ArrayList<String> user = new ArrayList<String>();
   		 ArrayList<String> dealer = new ArrayList<String>();
	 
	 
   		 //fill rand #
   		 ArrayList<Integer> numbers = new ArrayList<Integer>();   
   		 Random randomGenerator = new Random();
   		 while (numbers.size() < 52) {
	 
   		 	int random = randomGenerator .nextInt(52);
   		 	if (!numbers.contains(random)) {
   		     	numbers.add(random);
   		 	}
   		 }
	 
   		 //deck of cards in arraylist, don't know if referenced
   		 deck.add("AceOfHearts");
   		 deck.add("AceOfClubs");
   		 deck.add("AceOfSpades");
   		 deck.add("AceOfDiamonds");
   		 deck.add("2ofHearts");
   		 deck.add("3ofHearts");
   		 deck.add("4ofHearts");
   		 deck.add("5ofHearts");
   		 deck.add("6ofHearts");
   		 deck.add("7ofHearts");
   		 deck.add("8ofHearts");
   		 deck.add("9ofHearts");
   		 deck.add("10ofHearts");
   		 deck.add("JackofHearts");
   		 deck.add("QueenofHearts");
   		 deck.add("KingofHearts");
   		 deck.add("2ofDiamonds");
   		 deck.add("3ofDiamonds");
   		 deck.add("4ofDiamonds");
   		 deck.add("5ofDiamonds");
   		 deck.add("6ofDiamonds");
   		 deck.add("7ofDiamonds");
   		 deck.add("8ofDiamonds");
   		 deck.add("9ofDiamonds");
   		 deck.add("10ofDiamonds");
   		 deck.add("JackofDiamonds");
   		 deck.add("QueenofDiamonds");
   		 deck.add("KingofDiamonds");
   		 deck.add("2ofClubs");
   		 deck.add("3ofClubs");
   		 deck.add("4ofClubs");
   		 deck.add("5ofClubs");
   		 deck.add("6ofClubs");
   		 deck.add("7ofClubs");
   		 deck.add("8ofClubs");
   		 deck.add("9ofClubs");
   		 deck.add("10ofClubs");
   		 deck.add("JackofClubs");
   		 deck.add("QueenofClubs");
   		 deck.add("KingofClubs");
   		 deck.add("2ofSpades");
   		 deck.add("3ofSpades");
   		 deck.add("4ofSpades");
   		 deck.add("5ofSpades");
   		 deck.add("6ofSpades");
   		 deck.add("7ofSpades");
   		 deck.add("8ofSpades");
   		 deck.add("9ofSpades");
   		 deck.add("10ofSpades");
   		 deck.add("JackofSpades");
   		 deck.add("QueenofSpades");
   		 deck.add("KingofSpades");
	 
   		 // user cards
   		 for(int i = 0; i<deck.size()/2; i++){
   			 int firstnumber = numbers.get(i);
   			 String set = deck.get(firstnumber);
   			 user.add(set);
   			 }
	 
   		 //dealer cards
   				 for(int a = 0; a<deck.size(); a++){
   					 String checkword = deck.get(a);
   					 if(user.contains(checkword) == false)
   						 dealer.add(checkword);
   			 }
	 
	 
   		 //play game
   		 while(user.size()>0 && dealer.size()>0){
	 
   			 int u = card.nextInt(user.size()+1);
   			 int d = card.nextInt(dealer.size()+1);
   			 String cardone = user.get(u);
   			 String cardtwo = dealer.get(d);
	 
   			 System.out.println("----------------------------------------------------------------------------------------------------------");
   			 System.out.println("User Card is: " + cardone);
   			 System.out.println("Dealer Card is: " + cardtwo);
   			 System.out.println("");
   			 System.out.println("User has " + user.size() + " cards.");
   			 System.out.println("Dealer has " + dealer.size() + " cards.");
   			 System.out.println("");
	 
   			 System.out.println("If user card is greater than dealer card enter 1.");
   			 System.out.println("If dealer card is greater than dealer card enter 2.");
   			 System.out.println("If it's a tie enter 3.");
	 
   			 System.out.print("WINNER: ");
   			 int winner = reader.nextInt();
	 
   			 if(winner == 1){
   				 user.add(cardtwo);
   				 dealer.remove(d);
   			 }
	 
   			 if(winner == 2){
   				 dealer.add(cardone);
   				 user.remove(u);
   			 }
	 
   		 }
	 
   	 if(user.size() == 0){
   			 System.out.println("You lost, better luck next time! -$100 of user cash");
   				 }
   	 if(dealer.size() == 0){
   		 System.out.println("You won!!! +$200 dealer cash");
	 
   			 }
	 
   	 }
	 
	}

    
    public War()
    {    
        super(900, 550, 1);
        System.out.println("Each player starts with half of the shuffled deck. Players may not look at the cards in their hands. Each player pulls one card from the deck and puts it on the table. The higher card wins; the player who played it takes both cards and places them on the bottom of his stack. Aces are always higher than Kings in war, but they are often lower than Jokers (if used). A 'war' occurs when the two players play the same rank (ex: two 9s), making a tie. Each player then deals three cards facedown (the spoils are given to the winner) and a face-up card. The player with the higher face-up card takes all the cards from the war into his stack. The player who accumulates all the cards wins the game."); 
//instructions from http://www.grandparents.com/grandkids/activities-games-and-crafts/war
        
    }
    public void startWar() {
        getBackground().drawImage(new GreenfootImage("Casino-playtable.png"), 0, 0);
        Greenfoot.start();
    }
}
