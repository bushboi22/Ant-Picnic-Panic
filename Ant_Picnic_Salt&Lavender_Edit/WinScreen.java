import greenfoot.*;

public class WinScreen extends World
{
    public WinScreen()
    {
        super(425, 425, 1);
        // reminder to make a new lose screen 
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new Background()); // restart the game
        }
    }
}
