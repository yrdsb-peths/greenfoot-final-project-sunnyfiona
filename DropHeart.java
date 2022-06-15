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
    Final world = (Final) getWorld();
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
        
        setLocation(getX(), getY() + 2);
        if(getY() >= 399 || isTouching(Wall.class))
        {
            setLocation(getX() - 30, 30);
            FallingHeartGame.decreaseScore();
        }
        
        if(isTouching(Player.class))
        {
            setLocation(getX() - 30, 30);
            FallingHeartGame.increaseScore();
        }
        
    }
    /*
    public void dropHeart(){
        getWorld().addObject(this, getX(), 100);
    }
    */
}
