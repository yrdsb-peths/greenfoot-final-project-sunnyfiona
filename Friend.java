import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Friend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Friend extends Actor
{
    GreenfootImage[] leftWalk = new GreenfootImage[4];
    GreenfootImage[] rightWalk = new GreenfootImage[4];
    GreenfootImage[] frontAnim = new GreenfootImage[4];
    private String name;
    GreenfootImage idle;
    SimpleTimer animTimer;
    private boolean isFacingRight = true;
    public boolean exit = false;
    /**
     * Constructor for the class. Sets the images of the NPCs 
     * and sets the animations.
     */
    public Friend(String name){
        this.name = name;
        for(int i = 0; i < frontAnim.length; i++){
            frontAnim[i] = new GreenfootImage("images/" + name + "/" + name + "-" + i + ".png");
        }
        setImage(frontAnim[0]);
        animTimer = new SimpleTimer();
        animTimer.mark();
    }
    /**
     * Act - do whatever the Friend wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animate();
        if(isTouching(Heart.class)){
            removeTouching(Heart.class);
            GrillbysBar world = (GrillbysBar) getWorld();
            world.increaseScore();
        }
    }
    /* public void slide(int leftBoundary, int rightBoundary){
        walk(getWorld(), leftBoundary, getY());
        walk(getWorld(), rightBoundary, getY());
    } */
    public void walk(World world, int x, int y){
        if(getX() > x)
        {
            this.setLocation(getX() - 2, getY());
        } 
        else if(getX() < x)
        {
            this.setLocation(getX() + 2, getY());
        }else
        {
        //nothing happens
        }
        if(getY() > y)
        {
            this.setLocation(getX(), getY() - 2);
        } 
        else if(getY() < y){
            this.setLocation(getX(), getY() + 2);
        }
    }
    /**
     * scale smaller - divides the image size of the friend by the factor
     */
    public void scaleSmaller(int factor)
    {
        /*
        for(int i = 0; i < rightWalk.length; i++)
        {
            leftWalk[i].scale(leftWalk[i].getWidth() / factor, leftWalk[i].getHeight() / factor);
            rightWalk[i].scale(rightWalk[i].getWidth() / factor, rightWalk[i].getHeight() / factor);
        }
        GreenfootImage idle = new GreenfootImage("images/" + name + "/" + name + "-idle-0.png");
        idle.scale(idle.getWidth() / factor, idle.getHeight() / factor);
        setImage(idle);
        */
       for(int i = 0; i < frontAnim.length; i++){
           frontAnim[i].scale(frontAnim[i].getWidth() / factor, frontAnim[i].getHeight() / factor);
       }
       setImage(frontAnim[0]);
    }
    
    /**
     * scale bigger - multiplies the image size of the friend by the factor
     */
    
    /*
    public void scaleBigger(String name, int factor)
    {
        for(int i = 0; i < rightWalk.length; i++)
        {
            leftWalk[i].scale(leftWalk[i].getWidth() * factor, leftWalk[i].getHeight() * factor);
            rightWalk[i].scale(rightWalk[i].getWidth() * factor, rightWalk[i].getHeight() * factor);
        }
        GreenfootImage idle = new GreenfootImage("images/" + name + "/" + name + "-idle-0.png");
        idle.scale(idle.getWidth() * factor, idle.getHeight() * factor);
    
    }
    */

    int curIndex = 0;
    public void animate()//(boolean goRight, boolean stopped)
    {
        
       if(animTimer.millisElapsed() > 150){
           setImage(frontAnim[curIndex]);
           curIndex++;
           curIndex %= 4;
           animTimer.mark();
       }
    }
}
