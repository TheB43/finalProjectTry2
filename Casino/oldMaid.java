import greenfoot.*;
public class oldMaid extends World
{
    public oldMaid()
    {    
        super(900, 550, 1); 
        addObject(mainMenu.scoreKeeper, 60, 20);
        mainMenu.scoreKeeper.modifyCash(0); //insert a negative for subtraction
    }
    public void startOM(){};
}
