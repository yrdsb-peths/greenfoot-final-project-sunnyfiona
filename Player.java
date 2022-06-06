import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{

    
    private GreenfootImage[] rightWalk;
    private GreenfootImage[] leftWalk;
    private GreenfootImage[] fwdWalk;
    private GreenfootImage[] bwdWalk;
    private SimpleTimer animTimer;

    private boolean facingRight;
    private boolean facingUp;
    private boolean facingLeft;
    private boolean facingDown;
    public static boolean canMove = true;

    private static int numLives;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player()
    {
        rightWalk = new GreenfootImage[4];
        leftWalk = new GreenfootImage[4];
        fwdWalk = new GreenfootImage[4];
        bwdWalk = new GreenfootImage[4];
        for(int i = 0; i < rightWalk.length; i++)
        {
            rightWalk[i] = new GreenfootImage("images/frisk/frisk-walk/frisk-walk-" + i + ".png");
            rightWalk[i].scale(rightWalk[i].getWidth() / 6, rightWalk[i].getHeight() / 6);
            leftWalk[i] = new GreenfootImage("images/frisk/frisk-walk/frisk-walk-" + i + ".png");
            leftWalk[i].mirrorHorizontally();
            leftWalk[i].scale(rightWalk[i].getWidth(), rightWalk[i].getHeight());

            fwdWalk[i] = new GreenfootImage("images/frisk/frisk-walk/frisk-walk-fwd-" + i + ".png");
            fwdWalk[i].scale(rightWalk[i].getWidth(), rightWalk[i].getHeight());

            bwdWalk[i] = new GreenfootImage("images/frisk/frisk-walk/frisk-walk-bwd-" + i + ".png");
            bwdWalk[i].scale(rightWalk[i].getWidth(), rightWalk[i].getHeight());
        }
        setImage(rightWalk[2]);
        animTimer = new SimpleTimer();
    }

    public void act()
    {
        if(canMove){
            walk(); 
            animate();
        }
        

        pickUpHeart();
    }
    
    

    public void pickUpHeart()
    {
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            MyWorld world = (MyWorld) getWorld();
            //need to increase score
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
    /*
    public void resetDirection()
    {
    facingUp = false;
    facingRight = false;
    facingDown = false;
    facingLeft = false;
     */
    int curIndex = 0;
    public void animate()
    {
        if(animTimer.millisElapsed() > 110)
        {
            if(Greenfoot.isKeyDown("d"))
            {
                setImage(rightWalk[curIndex]);
            }
            else if(Greenfoot.isKeyDown("a"))
            {
                setImage(leftWalk[curIndex]);
            }
            else if(Greenfoot.isKeyDown("s")){
                setImage(fwdWalk[curIndex]);
            }
            else if(Greenfoot.isKeyDown("w")){
                setImage(bwdWalk[curIndex]);
            }
            else{}
            curIndex++;
            curIndex %= 3;
            animTimer.mark();
        }

    }
}

