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
    private String name;
    GreenfootImage idle;
    SimpleTimer animTimer;
    private boolean isFacingRight = true;
    public boolean exit = false;
    /**
     * Constructor for the class. Sets the images of the NPCs 
     * and sets the animations.
     */
    public Friend(String name)
    {
        this.name = name;
        /*
        //rightWalk = new GreenfootImage[4];
        //leftWalk = new GreenfootImage[4];
        for(int i = 0; i < rightWalk.length; i++)
        {
            //idle[i] = new GreenfootImage("images/" + name + "/" + name + "-idle-" + i + ".png");
            leftWalk[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            rightWalk[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            rightWalk[i].mirrorHorizontally();
        }
        GreenfootImage idle = new GreenfootImage("images/" + name + "/" + name + "-idle-0.png");
        setImage(idle);
        animTimer = new SimpleTimer();
        */
        
        //GreenfootImage image = new GreenfootImage("images/elephant_idle/idle0.png");
        rightWalk = new GreenfootImage[4];
        leftWalk = new GreenfootImage[4];
        for(int i = 0; i < rightWalk.length; i++){
            leftWalk[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            leftWalk[i].scale(100,100);
            rightWalk[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            rightWalk[i].mirrorHorizontally();
            rightWalk[i].scale(100,100);
        }
        GreenfootImage idle = new GreenfootImage("images/" + name + "/" + name + "-idle-0.png");
        setImage(idle);
        animTimer = new SimpleTimer();
        animTimer.mark();
    }
    
    /**
     * Act - do whatever the Friend wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        /*
        Tutorial world = (Tutorial) getWorld();
        int x = world.frisk.getX();
        walkX(x);
        */
    }
    public void exit(World world, int x, int y){
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
        for(int i = 0; i < rightWalk.length; i++)
        {
            leftWalk[i].scale(leftWalk[i].getWidth() / factor, leftWalk[i].getHeight() / factor);
            rightWalk[i].scale(rightWalk[i].getWidth() / factor, rightWalk[i].getHeight() / factor);
        }
        GreenfootImage idle = new GreenfootImage("images/" + name + "/" + name + "-idle-0.png");
        idle.scale(idle.getWidth() / factor, idle.getHeight() / factor);
        setImage(idle);
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
    
    /**
     * WalkX - moves the Friend horizontally towards an x coordinate
     */
    public void walkX(int toX)
    {
        
        if(toX > getX())
        {
            setLocation(getX() + 2, getY());
            animate(true, false);
        }
        else{
            setLocation(getX() - 2, getY());
            animate(false, false);
        }

    }

    int curIndex = 0;
    public void animate(boolean goRight, boolean stopped)
    {
        /*
        if(animTimer.millisElapsed() > 110)
        {
            if(stopped == true){

            }
            else if (goRight == true)
            {
                setImage(rightWalk[curIndex]);
            }
            else
            {
                setImage(leftWalk[curIndex]);
            }
            curIndex++;
            curIndex %= 3;
            animTimer.mark();
        }
        */
        if(animTimer.millisElapsed() > 100){
            if(isFacingRight){
                setImage(rightWalk[curIndex]);
            } else {
                setImage(leftWalk[curIndex]);
            }
            curIndex++;
            curIndex %= 4;
            animTimer.mark();
        }
    }
}
