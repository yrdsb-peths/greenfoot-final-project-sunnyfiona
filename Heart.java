import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    
    /**
     * Constructor for the class Heart, setting the images of the complete heart
     * and allowing it to be scaled
     * 
     * @param x the desired scaled width of the image
     * @param y the desired scaled height of the image
     */
    public Heart(int x, int y)
    {
        GreenfootImage heart = new GreenfootImage("images/misc/fullheart.png");
        heart.scale(x, y);
        setImage(heart);
    }

    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
