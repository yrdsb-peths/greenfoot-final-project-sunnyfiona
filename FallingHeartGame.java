import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingHeartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingHeartGame extends World
{
    public Label scoreLabel;
    public static int score = 0;
    DropHeart heart;
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
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
    public void decreaseScore(){
        score--;
        scoreLabel.setValue(score);
    }
}
