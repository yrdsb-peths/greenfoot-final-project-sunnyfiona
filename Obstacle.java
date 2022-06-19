import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Wall that will reset Player location
 * 
 * @author Finny
 * @version June 17, 2022
 */
public class Obstacle extends Wall
{
    /**
     * Constructor for an obstacle (the spikes) that sets and scales
     * the image
     * 
     * @param scaleX the desired scaled width of the image
     * @param scaleY the desired scaled height of the image
     */
    public Obstacle(int scaleX, int scaleY)
    {
        super("spike", scaleX, scaleY);
    }
    
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
}
