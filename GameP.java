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
    public int speed;
    public boolean drankPotion = false;
    public int pCount = 0;
    public GameP(int x, int y)
    {
        GreenfootImage head = new GreenfootImage("images/frisk/head.png");
        head.scale(x,y);
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
        drinkPotion();
    }

    public void restart()
    {
        Maze w = (Maze) getWorld();
        if(isTouching(Obstacle.class))
        {
            setLocation(20, 384);
        }
    }

    public void drinkPotion()
    {
        speed = 3;
        if(isTouching(Potion.class) && !drankPotion)
        {
            removeTouching(Potion.class);
            pCount++;
            if(pCount == 1) {
                speed = 1;
                drankPotion = false;
            }
            else {
                speed = 3;
            }
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
            setLocation(getX() + speed, getY());
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() - 3, getY());
            }

        }
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            setLocation(getX() - speed, getY());
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() + 3, getY());
            }
        }

        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - speed);
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() + 3);
            }
        }

        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + speed);
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() - 3);
            }

        }

    }
}
