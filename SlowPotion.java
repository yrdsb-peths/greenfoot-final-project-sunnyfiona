import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Potion that makes player (GameP) speed slower
 * 
 * @author Finny 
 * @version June 17, 2022
 */
public class SlowPotion extends Actor
{
    /**
     * Sets image of the Slow Potion and scales it to a smaller size
     */
    public SlowPotion()
    {
        GreenfootImage image = new GreenfootImage("images/misc/slow_potion.png");
        image.scale(25,25);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Potion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
