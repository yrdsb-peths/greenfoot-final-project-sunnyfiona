import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameP extends Actor
{
    
    public GameP(int x, int y)
    {
        GreenfootImage head = new GreenfootImage("images/frisk/head.png");
        head.scale(x, y);
        setImage(head);
    }
    
    /**
     * Act - do whatever the GameP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        walk();
        pickUpHeart();
    }
    
    public void pickUpHeart()
    {
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
        }
    }
    
    public void walk()
    {
        Tutorial world = new Tutorial();
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 3, getY());
        
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() - 3, getY());
            }
            
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 3, getY());
            
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() + 3, getY());
            }
        }
        
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 3);
           
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() + 3);
            }
        }
        
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 3);
            
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() - 3);
            }
            
        }
        
    }
}
