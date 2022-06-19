import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingHeartGame here.
 * 
 * @author Finny
 * @version June 17, 2022
 */
public class FallingHeartGame extends World
{
    //instance variables
    public Label scoreLabel;
    public DropHeart heart;
    public static int score = 0;
    
    /**
     * Constructor for objects of class FallingHeartGame.
     * 
     */
    public FallingHeartGame(boolean worldBoundary)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, worldBoundary); 
        heart = new DropHeart(30, 30);
        scoreLabel = new Label(0, 70);
    }
    
}
