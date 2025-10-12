import greenfoot.*;

public class LoseScreen extends World
{
    public LoseScreen()
    {
        super(425, 425, 1);
        // reminder to make a new lose screen 
        showText("Press R to Restart", 213, 213);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new Background()); // restart the game
        }
    }
}
