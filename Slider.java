import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Moving Wall that resets player Position
 * 
 * @author Finny 
 * @version June 16th, 2022
 */
public class Slider extends Wall
{
    //instance variables
    boolean movingRight = true;
    int speed = 3;
    Obstacle[] spikes;
    
    /**
     * Constructor for a slider obstacle with a set scale
     * 
     * @param text the name of the png in the Walls folder from Images
     */
    public Slider(String text)
    {
        super("slider", -200, -140);
    }
    
    /**
     * Act - do whatever the Slider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        if(movingRight){
            setLocation(getX() + speed, getY());
        } else {
            setLocation(getX() - speed, getY());
        }
        
        if(getX() >= getWorld().getWidth() -10){
            movingRight = false;
        }
        if(getX() <= 10){
            movingRight = true;
        }
        
        if(isTouching(Heart.class)){
            removeTouching(Heart.class);
            Final world = (Final) getWorld();
            world.increaseScore();
        }
    }
}
