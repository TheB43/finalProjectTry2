import greenfoot.*;
public class War extends World
{
    public War()
    {    
        super(900, 550, 1); 
        addObject(mainMenu.scoreKeeper, 60, 20);
        mainMenu.scoreKeeper.modifyCash(0);//enter a negative for subtraction and a reg for addition
    }
    public void startWar(){};
}
