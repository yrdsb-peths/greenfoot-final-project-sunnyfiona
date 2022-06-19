import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Allows objects in class Grillby
 * 
 * @author Finny 
 * @version June 17, 2022
 */
public class Grillby extends Friend
{
    //instance variables for allowing him to slide
    boolean movingRight = true;
    int speed = 2;

    /**
     * Constructor for the class Grillby, setting the images of the NPC
     */
    public Grillby(){
         super("grillby");    
    }
    
    /**
     * Act - Animates Grillby, allows him to slide, and allows him to collect hearts.
     * This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        animate();
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
            GrillbysBar world = (GrillbysBar) getWorld();
            world.increaseScore();
        }
    }
}
