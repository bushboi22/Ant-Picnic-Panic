import greenfoot.*;
import java.util.HashSet;

public class Background extends World
{
    private boolean gameStarted = false;
    Player_ant pa = new Player_ant();
    
    public Background()
    {    
        super(425, 425, 1);
        Greenfoot.setWorld(new InfoScreen());
        if (!gameStarted)
        {
            startGame();
            gameStarted = true;
        }
    }

    private void startGame()
    {
        // clear all text lines (use same Y positions as the start screen)
        addObject(pa, 36, 37); // player starting position
        int[] textY = {100, 150, 180, 210, 240, 300};
        for (int y : textY)
            showText("", 212, y);

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
        for (int i = 0; i < 5; i++)
        {
            int x, y;
            do {
                x = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
                y = (Greenfoot.getRandomNumber(16) + 1) * cellSize + 11;
            } while (usedPositions.contains(x + "," + y));

            usedPositions.add(x + "," + y);
            addObject(new Cookie(), x, y);
        }

        // --- Spawn 3 water tiles ---
        for (int i = 0; i < 3; i++)
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
