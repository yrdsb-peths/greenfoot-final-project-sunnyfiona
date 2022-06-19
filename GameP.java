import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameP here.
 * 
 * @author Finny
 * @version June 17, 2022
 */
public class GameP extends Actor
{
    //instance variables
    public boolean collectedHeart = false;
    public static boolean canMove = true;
    private int speed = 4;
    public boolean drankPotion = false;
    public int pCount = 0;
    public boolean spawnReset;
    /**
     * Constructor for the class GameP, setting the image for an in-game
     * representation of the player with a scale
     */
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
        
        //pick up heart
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            collectedHeart = true;
            spawnReset = true;
        }
        
        //get potions
        if(isTouching(SlowPotion.class)){
            speed -= 2;   
            removeTouching(SlowPotion.class);
        }
        
        if(isTouching(ResetPotion.class)){
            speed += 2;
            removeTouching(ResetPotion.class);
        }

    }

    /**
     * Sends the player back to spawn point
     */
    public void restart()
    {
        Maze w = (Maze) getWorld();
        if(isTouching(Obstacle.class))
        {
            setLocation(20, 384);
        }
    }
    
    /**
     * Allows the player to navigate the world using 'WASD' or arrow keys
     */
    public void walk()
    {
        //Tutorial world = new Tutorial();
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            setLocation(getX() + speed, getY());
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() - speed, getY());
            }

        }
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            setLocation(getX() - speed, getY());
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() + speed, getY());
            }
        }

        if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - speed);
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() + speed);
            }
        }

        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + speed);
            restart();
            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() - speed);
            }

        }

    }
}
