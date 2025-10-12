import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashSet;
/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private boolean gameStarted = false;
    Player_ant3 p3 = new Player_ant3();
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(425, 425, 1); 
        if (!gameStarted && Greenfoot.getKey() != null)
        {
            startGame();
            gameStarted = true;
        }
    }
    
    private void startGame()
    {
        // clear all text lines (use same Y positions as the start screen)
        addObject(p3, 36, 37); // player starting position

        int cellSize = 25;
        HashSet<String> usedPositions = new HashSet<>();

        // Reserve area around player (a small 3x3 grid zone to keep clear)
        for (int dx = -25; dx <= 25; dx += 25) {
            for (int dy = -25; dy <= 25; dy += 25) {
                int safeX = 36 + dx;
                int safeY = 37 + dy;
                usedPositions.add(safeX + "," + safeY);
            }
        }

        // --- Spawn 10 cookies ---
        for (int i = 0; i < 15; i++)
        {
            int x, y;
            do {
                x = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
                y = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
            } while (usedPositions.contains(x + "," + y));

            usedPositions.add(x + "," + y);
            addObject(new Cookie(), x, y);
        }

        // --- Spawn 5 water tiles ---
        for (int i = 0; i < 10; i++)
        {
            int x, y;
            do {
                x = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
                y = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
            } while (usedPositions.contains(x + "," + y));

            usedPositions.add(x + "," + y);
            addObject(new Water(), x, y);
        }
        
        // --- Spawn 3 salt tiles ---
        for (int i = 0; i < 3; i++)
        {
            int x, y;
            do {
                x = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
                y = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
            } while (usedPositions.contains(x + "," + y));

            usedPositions.add(x + "," + y);
            addObject(new Salt(), x, y);
        }
        
        // --- Spawn 2 Lavender tiles ---
        for (int i = 0; i < 2; i++)
        {
            int x, y;
            do {
                x = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
                y = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
            } while (usedPositions.contains(x + "," + y));

            usedPositions.add(x + "," + y);
            addObject(new Water(), x, y);
        }
    }
    
    
}
