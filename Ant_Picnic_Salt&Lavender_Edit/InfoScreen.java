import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InfoScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoScreen extends World
{
    private boolean gameStarted = false;
    NPC_ant na = new NPC_ant();
    /**
     * Constructor for objects of class InfoScreen.
     * 
     */
    public InfoScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(425, 425, 1); 
        drawStartScreen();
    }
    
    private void drawStartScreen()
    {
        addObject(na, 36, 37);
        showText("🐜 ANT PICNIC 🐜", 212, 100);
        showText("You are the little ant in the top left!", 212, 150);
        showText("Use Arrow Keys or WASD to move", 212, 180);
        showText("Collect all the COOKIES 🍪", 212, 210);
        showText("Avoid touching WATER 💧 or screen edges!", 212, 240);
        showText("Ps:Ant and color levels will change", 212, 270);
        showText("Pps:There are 3 levels and they will get harder", 212, 300);
        
        showText("Press ANY KEY to start!", 212, 360);
    }

    public void act()
    {
        if (!gameStarted && Greenfoot.getKey() != null)
        {
            Greenfoot.setWorld(new Background());
            gameStarted = true;
        }
    }
}
