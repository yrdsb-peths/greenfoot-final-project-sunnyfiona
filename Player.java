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
    public boolean collectedHeart = false;
    public boolean deliveredHeart;
    public static boolean canMoveVertical;

    private int xSpeed = 3;
    private int ySpeed = 3;

    private static int numLives;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
        deliveredHeart = false;
    }

    public void act()
    {

        if(canMove)
        {
            walk(); 
            animate();
        }
        //pickUpHeart();
        if(collectedHeart && Greenfoot.mouseClicked(Friend.class)){
            deliveredHeart = true;
        }
        /*
        if(isTouching(Heart.class)){
        removeTouching(Heart.class);
        FallingHeartGame world = (FallingHeartGame) getWorld();
        world.increaseScore();
        }
         */
    }

    public void pickUpHeart()
    {
        if(isTouching(Heart.class))
        {
            removeTouching(Heart.class);
            collectedHeart = true;
            
        }
    }

    public void collectFallingHeart(){
        FallingHeartGame world = (FallingHeartGame) getWorld();
        if(isTouching(Wall.class)){
            //world.decreaseScore();
            setLocation(0, 400);
        }
    }

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

    int curIndex = 0;
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
