import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player_ant2 extends Actor
{
    private int currentDirection = 0; 
    private int stepSize = 25;  // grid movement similar to snake game
    private int Lives = 1;
    private int Points = 0;

    public Player_ant2()
    {
        GreenfootImage image = getImage();
        image.scale(25, 25); // make the ant 25x25 pixels
        setImage(image);
    }

    public void showStatus()
    {
        getWorld().showText("Points"+Points,50,10);
    }
    
    public void act()
    {
        moveWithKeys();
        showStatus();
        hitCookie();
        hitWater();
        hitSalt();
        hitLavender();
        testWinGame();
        TestLoser();
    }

    public void moveWithKeys()
    {
        if (Lives > 0 && isAtEdge() == false)
        {
            if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
                currentDirection = 180;
            } 
            else if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
                currentDirection = 0;
            } 
            else if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
                currentDirection = 270;
            } 
            else if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
                currentDirection = 90;
            }
            // Offset rotation by +90 degrees because image faces up
            setRotation(currentDirection + 90);
            
            // Move in 25-pixel steps continuously to act as grids
            if (currentDirection == 0) {
                setLocation(getX() + stepSize, getY());
            } 
            else if (currentDirection == 180) {
                setLocation(getX() - stepSize, getY());
            } 
            else if (currentDirection == 270) {
                setLocation(getX(), getY() - stepSize);
            } 
            else if (currentDirection == 90) {
                setLocation(getX(), getY() + stepSize);
            }

            Greenfoot.delay(6); // slows movement to make it playable
        }
    }
    
    public void addPoints()
    {
        Points = Points + 1;
    }
    public void hitCookie()
    {
        if (isTouching(Cookie.class) )
        {
            removeTouching(Cookie.class);
            addPoints();
        }
    }
    
    public void loseLife()
    {
        Lives = Lives - 1;
    }
    public void hitWater()
    {
        if(isTouching(Water.class)){
            removeTouching(Water.class);
            loseLife();
        }
    }
    public void hitSalt()
    {
        if(isTouching(Salt.class)){
            removeTouching(Salt.class);
            loseLife();
        }
    }
    public void hitLavender()
    {
        if(isTouching(Lavender.class)){
            removeTouching(Lavender.class);
            loseLife();
        }
    }
    public void testWinGame()
    {
        if (Points == 2){
            Greenfoot.setWorld(new Level3());
        }
    }
    public void TestLoser()
    {
        if (Lives <= 0 || isAtEdge())
        {
            Greenfoot.setWorld(new LoseScreen());
        }
    }
    
}
