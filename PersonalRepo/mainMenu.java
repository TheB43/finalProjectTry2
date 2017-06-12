import greenfoot.*;  
public class mainMenu extends World
{
    static scoreCounter scoreKeeper = new scoreCounter(); //creating a scorecounter to be used from the other worlds
    public mainMenu()
    {
        super(900, 550, 1); //constructing a world of 900 by 550
        addObject(betScreen.Better.betSetter, 800, 40);
        betScreen.Better.betSetter.setNewText("Current bet: " + betScreen.Better.bet);
    }
    public void startMenu() {
        addObject(scoreKeeper, 60, 20); //adding a score keeping text
        Greenfoot.start();
    }
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo(); //initializes the mouse as an object
        if (Greenfoot.mouseClicked(null)) { //checks when the mouse is clicked
            if (mouse.getX() > 50 && mouse.getX() < 193) {//checks where the mouse is clicked
                if (mouse.getY() > 150 && mouse.getY() < 310) {
                    blackJack BLACKJACK = new blackJack(); //initiates blackjack
                    Greenfoot.setWorld(BLACKJACK); //changes the background
                    BLACKJACK.startBJ(); //calls the blackjack starter method
                }
                else if (mouse.getY() > 330 && mouse.getY() < 490) {
                    oldMaid OLDMAID = new oldMaid(); //initiates oldMaid
                    Greenfoot.setWorld(OLDMAID); //changes the background  
                    OLDMAID.startOM(); //calls the oldmaid starter method
                }
            }
            else if (mouse.getX() > 240 && mouse.getX() < 384) {
                if (mouse.getY() > 150 && mouse.getY() < 310) {
                    goFish GOFISH = new goFish(); //initiates go fish
                    Greenfoot.setWorld(GOFISH); //changes background
                    GOFISH.startGF(); //calls the go fish starter method
                }
                else if (mouse.getY() > 330 && mouse.getY() < 490) {
                    War WAR = new War(); //initiates war
                    Greenfoot.setWorld(WAR); //changes background
                    WAR.startWar(); //calls the war starter method
                }
            }
        }
    }
}