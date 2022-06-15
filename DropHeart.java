import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dropHeart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropHeart extends Heart
{
    //public static boolean onScreen;
    public DropHeart(int x, int y){
        super(x, y);
        //onScreen = true;
    }
    /**
     * Act - do whatever the dropHeart wants to do. This method is called whenever
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
    /*
    public void dropHeart(){
        getWorld().addObject(this, getX(), 100);
    }
    */
}
