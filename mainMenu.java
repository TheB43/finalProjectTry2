import greenfoot.*;  
public class mainMenu extends World
{
    static scoreCounter scoreKeeper = new scoreCounter();
    public mainMenu()
    {
        super(900, 550, 1);
    }
    public void startMenu() {
        addObject(scoreKeeper, 60, 20);// issue
        Greenfoot.start();
    }
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int x = mouse.getX();
            int y = mouse.getY();
        if (Greenfoot.mouseClicked(null)) {
            if (x > 50 && x < 193) {
                if (y > 150 && y < 310) {
                    blackJack BLACKJACK = new blackJack();
                    Greenfoot.setWorld(BLACKJACK);
                    BLACKJACK.startBJ();
                }
                else if (y > 330 && y < 490) {
                    oldMaid OLDMAID = new oldMaid();
                    Greenfoot.setWorld(OLDMAID);
                    OLDMAID.startOM();
                }
            }
            else if (x > 240 && x < 384) {
                if (y > 150 && y < 310) {
                    goFish GOFISH = new goFish();
                    Greenfoot.setWorld(GOFISH);
                    GOFISH.startGF();
                }
                else if (y > 330 && y < 490) {
                    War WAR = new War();
                    Greenfoot.setWorld(WAR);
                    WAR.startWar();
                }
            }
        }
       }
    }
}