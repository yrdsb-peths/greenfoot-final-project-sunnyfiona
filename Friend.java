import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Friend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Friend extends Actor
{
    GreenfootImage[] idle;
    GreenfootImage[] walkLeft;
    GreenfootImage[] walkRight;
    SimpleTimer animTimer;
    /**
     * Constructor for the class. Sets the images of the NPCs 
     * and sets the animations.
     */
    public Friend(String name)
    {
        idle = new GreenfootImage[4];
        walkRight = new GreenfootImage[4];
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/" + name + "/" + name + "-idle-" + i + ".png");
            walkRight[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            walkLeft[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            walkLeft[i].mirrorHorizontally();
        }
        setImage(idle[0]);
    }
    /**
     * Act - do whatever the Friend wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    /**
     * WalkX - moves the Friend horizontally
     */
    public void walkX(int steps)
    {
        
    }
}
