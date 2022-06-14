import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slider extends Wall
{
    boolean movingRight = true;
    int speed = 2;
    
    public Slider()
    {
        
    }
    
    /**
     * Act - do whatever the Slider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(movingRight){
            setLocation(getX() + speed, getY());
        } else {
            setLocation(getX() - speed, getY());
        }
        
        if(getX() >= getWorld().getWidth() - 100){
            movingRight = false;
        }
        if(getX() <= 100){
            movingRight = true;
        }
        
        if(isTouching(Heart.class)){
            removeTouching(Heart.class);
            FinalMaze world = (FinalMaze) getWorld();
            //world.increaseScore();
        }
    }
}
