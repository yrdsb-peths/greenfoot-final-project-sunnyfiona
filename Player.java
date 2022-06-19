import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Object the player controls
 * 
 * @author Finny
 * @version June 16th, 2022
 */
public class Player extends Actor
{
    //instance variables for walking animations
    private GreenfootImage[] rightWalk;
    private GreenfootImage[] leftWalk;
    private GreenfootImage[] fwdWalk;
    private GreenfootImage[] bwdWalk;
    private SimpleTimer animTimer;

    //for controlling movement and progressing events
    public static boolean canMove = true;
    public boolean collectedHeart = false;
    public static boolean canMoveVertical;
    
    //speed
    private int xSpeed = 3;
    private int ySpeed = 3;
    
    /**
     * Constructor for Player
     * 
     * @param canMoveVertical - indicates whether the Player is allowed to
     * move up and down.
     */
    
    public Player(boolean canMoveVertical)
    {
        this.canMoveVertical = canMoveVertical;
        if(!canMoveVertical){
            ySpeed = 0;
        }
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
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        if(canMove)
        {
            walk(); 
            animate();
        }
        pickUpHeart();
        
    }
    /**
     * pickUpHeart - removes Heart if Player is touching one,and stores it
     */
    public void pickUpHeart()
    {
        
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            collectedHeart = true;
            
        }
    }
    /**
     * collects falling hearts and sets score
     */
    public void collectFallingHeart(){
        Final world = (Final) getWorld();
        if(isTouching(Wall.class)){
            setLocation(0, 400);
        }
        if(isTouching(DropHeart.class)){
            world.increaseScore();
            
        }
    }
    /**
     * allows player's movement to be controlled
     */
    public void walk()
    {
        Tutorial world = new Tutorial();
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            setLocation(getX() + xSpeed, getY());

            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() - xSpeed, getY());
            }

        }
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            setLocation(getX() - xSpeed, getY());

            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX() + xSpeed, getY());
            }
        }

        if((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) && canMoveVertical){
            setLocation(getX(), getY() - ySpeed);

            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() + ySpeed);
            }
        }

        if((Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) && canMoveVertical){
            setLocation(getX(), getY() + ySpeed);

            if(isTouching(Wall.class) || isTouching(Friend.class))
            {
                setLocation(getX(), getY() - ySpeed);
            }

        }

        

    }
    //for animation index
    int curIndex = 0;
    /**
     * animates the player's walking animations
     */
    public void animate()
    {
        if(animTimer.millisElapsed() > 110)
        {
            if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
            {
                setImage(rightWalk[curIndex]);
            }
            else if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
            {
                setImage(leftWalk[curIndex]);
            }
            else if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")){
                setImage(fwdWalk[curIndex]);
            }
            else if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")){
                setImage(bwdWalk[curIndex]);
            }
            else{}
            curIndex++;
            curIndex %= 3;
            animTimer.mark();
        }

    }

    
}

