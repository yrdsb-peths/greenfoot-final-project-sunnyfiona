import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Heart that falls down.
 * 
 * @author Finny
 * @version June 16th, 2022
 */
public class DropHeart extends Heart
{
    /**
     * Constructor for DropHeart
     * 
     * @param x the desired scaled width of the image
     * @param y the desired scaled height of the image
     */
    public DropHeart(int x, int y){
        super(x, y);
        
    }
    /**
     * Act - Makes DropHeart fall, and removes itself when touching something.
     * This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        FallingHeartGame world = (FallingHeartGame) getWorld();
        setLocation(getX(), getY() + 2);
        if(getY() >= 399 || isTouching(Wall.class))
        {
            world.removeObject(this);
            
        }
        
    }
}
