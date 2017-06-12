 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.ArrayList; 
/*
 * 
 * @SCL
 */
public class War extends World
{
    private int userBalance = mainMenu.scoreKeeper.Startcash;//sets palyercash
    private int dealerBalance = 400;//sets dealler balance
    private bet Better = new bet();
    private ArrayList<Card> warDeck = new ArrayList<Card>();
    private Card[] board;  // holds cards for the game
    private Deck deck; // the deck from which the cards are dealt.
    private int numOver; //total number of cards face-up.
    private int numShowing; // number of cards showing for the current play
    private Card[] cardsShowing; // holds the cards showing for the current play
    private static final int BOARD_SIZE = 52; // Number of cards on the MatchBoard
    private boolean isTurnedUp = false;
    private int bet = 0;
  
    public War()
    {
       // Create a new world with 400 x 500 cells with a cell size of 1x1 pixels.
       super(1120, 700, 1);      
       //keeps track of cards on board
       board = new Card[BOARD_SIZE];
       addObject(mainMenu.scoreKeeper, 60, 20); //adds a scorecounter
       //keeps track of Cards for current play
       cardsShowing = new Card[2];
       
       numOver = 0; // total number of cards face-up.
       numShowing = 0; // number of cards showing for the current play
       deck = new Deck();
       deck.fillDeck(warDeck);
       fillArray();       
    }    
    
    public void startWar(){
        setup();
    }
    
    public void fillArray()
    {
        for(int i = 0; i < BOARD_SIZE/2; i++)
        {
            Card randomCard = deck.deal(warDeck);
            Card cardCopy = randomCard;
            board[getRandomPosition()] = randomCard;
            board[getRandomPosition()] = cardCopy;
        }
    }    
    
    public void setup()
    {
        //final int SQUARE_SIZE = 4;  //number of rows and columns
        final int DIM_HEIGHT = 1;
        final int DIM_WIDTH = 13;
        int x = 80;
        int y = 150;
        int index = 0;
        for(int row = 0; row < DIM_HEIGHT;row++)
        {
            x = 80;
            for(int col = 0; col < DIM_WIDTH; col++)
            {
                board[index].setCardImage(isTurnedUp);   //comment if you want cards to be face-up
                //board[index].showFace(); //uncomment if you want cards to show
                addObject(board[index], x, y);
                index++;
                x +=80;
            }
            y += 110;
        }
        
        final int DIM_HEIGHT1 = 1;
        final int DIM_WIDTH1 = 13;
        for(int row = 0; row < DIM_HEIGHT1;row++)
        {
            x = 80;
            for(int col = 0; col < DIM_WIDTH1; col++)
            {
                board[index].setCardImage(isTurnedUp);   //comment if you want cards to be face-up
                //board[index].showFace(); //uncomment if you want cards to show
                addObject(board[index], x, y);
                index++;
                x +=80;
            }
            y += 150;
        }
        
        
        final int DIM_HEIGHT2 = 1;
        final int DIM_WIDTH2 = 13;
        for(int row = 0; row < DIM_HEIGHT2;row++)
        {
            x = 80;
            for(int col = 0; col < DIM_WIDTH2; col++)
            {
                board[index].setCardImage(isTurnedUp); //comment if you want cards to be face-up
                //board[index].showFace(); //uncomment if you want cards to show
                addObject(board[index], x, y);
                index++;
                x +=80;
            }
            y += 110;
        }
        
        
        final int DIM_HEIGHT3 = 1;
        final int DIM_WIDTH3 = 13;
        for(int row = 0; row < DIM_HEIGHT;row++)
        {
            x = 80;
            for(int col = 0; col < DIM_WIDTH; col++)
            {
                board[index].setCardImage(isTurnedUp);//comment if you want cards to be face-up
                //board[index].showFace(); //uncomment if you want cards to show
                addObject(board[index], x, y);
                index++;
                x +=80;
            }
            y += 110;
        }       
    }
    
    
    
    
    
    public int getRandomPosition()
    {
        int randPlace = Greenfoot.getRandomNumber(BOARD_SIZE);
        while (board[randPlace] != null)
        {
            randPlace = Greenfoot.getRandomNumber(BOARD_SIZE);
        }
        //System.out.print(randPLace + " ");
        return randPlace;
    }
    
    
    
    
    public void recordCardShowing(Card c)
    {
        cardsShowing[numShowing] = c;
        numShowing++;
    } 
       
    public boolean checkMatch()
    {
        return cardsShowing[0].equals(cardsShowing[1]);
    }
       
    public void act()
    {
        if (numShowing == 2)
        {
            Greenfoot.delay(50);
            
            if (checkMatch())
            {
                //Greenfoot.playSound("cowbell.wav");
                Greenfoot.delay(10);
                numOver +=2;
            }
            else
            {
                //Greenfoot.playSound("no.wav");
                isTurnedUp = false;
                cardsShowing[0].setCardImage(isTurnedUp);
                cardsShowing[1].setCardImage(isTurnedUp);;
            }
            cardsShowing[0]=null;
            cardsShowing[1]=null;;
            numShowing = 0;
        }
        
        //check win
        if(numOver == BOARD_SIZE)
        {
            //Greenfoot.playSound("tada.wav");
            //.setText("You Win!");
            mainMenu.scoreKeeper.Startcash += bet;
            Greenfoot.stop();
        }
               
    }
}
