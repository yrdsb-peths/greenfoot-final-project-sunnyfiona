import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameP extends Actor
{
    public boolean collectedHeart = false;
    public static boolean canMove = true;
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
        restart();
        if(canMove){
            walk();
        }
        pickUpHeart();
    }

    public void restart()
    {
        Maze w = (Maze) getWorld();
        if(isTouching(Obstacle.class))
        {
            setLocation(20, 384);
        }
    }

    public void pickUpHeart()
    {
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            collectedHeart = true;
        }
    }

    public void walk()
    {
        Tutorial world = new Tutorial();
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            setLocation(getX() + 3, getY());
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() - 3, getY());
            }

        }
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            setLocation(getX() - 3, getY());
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() + 3, getY());
            }
        }

        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - 3);
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() + 3);
            }
        }

        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + 3);
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() - 3);
            }

        }

    }
}
