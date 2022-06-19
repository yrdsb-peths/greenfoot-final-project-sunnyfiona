import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Potion that resets player (GameP) speed 
 * 
 * @author Finny
 * @version June 17, 2022
 */
public class ResetPotion extends Actor
{
    /**
     * Sets image of the Reset Potion and scales it to a smaller size
     */
    public ResetPotion(){
        GreenfootImage image = new GreenfootImage("images/misc/reset_potion.png");
        image.scale(25,25);
        setImage(image);
    }
    /**
     * Act - do whatever the ResetPotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
