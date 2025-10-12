import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lavender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lavender extends Actor
{
    public Lavender()
    {
        GreenfootImage image = getImage();
        image.scale(23, 23); // make the cookie 23x23 pixels 
        setImage(image);     // so ant cant grab it running next to it
    }
    public void act()
    {
        // Add your action code here.
    }
}
