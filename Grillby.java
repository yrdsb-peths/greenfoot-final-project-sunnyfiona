import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grillby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grillby extends Friend
{
    boolean movingRight = true;
    int speed = 2;

    public Grillby(){
        super("grillby");    
    }

    
    /**
     * Act - do whatever the Grillby wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animate();// Add your action code here.
        if(movingRight){
            setLocation(getX() + speed, getY());
        } else {
            setLocation(getX() - speed, getY());
        }
        
        if(getX() >= getWorld().getWidth() - 150){
            movingRight = false;
        }
        if(getX() <= 150){
            movingRight = true;
        }
        
        if(isTouching(Heart.class)){
            removeTouching(Heart.class);
            FallingHeartGame world = (FallingHeartGame) getWorld();
            world.increaseScore();
        }
    }
}
