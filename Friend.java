import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Friend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Friend extends Actor
{
    GreenfootImage[] leftWalk;
    GreenfootImage[] rightWalk;
    SimpleTimer animTimer;
    /**
     * Constructor for the class. Sets the images of the NPCs 
     * and sets the animations.
     */
    public Friend(String name)
    {
        rightWalk = new GreenfootImage[4];
        leftWalk = new GreenfootImage[4];
        for(int i = 0; i < rightWalk.length; i++)
        {
            //idle[i] = new GreenfootImage("images/" + name + "/" + name + "-idle-" + i + ".png");
            rightWalk[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            leftWalk[i] = new GreenfootImage("images/" + name + "/" + name + "-walk-" + i + ".png");
            leftWalk[i].mirrorHorizontally();
        }
        setImage("images/" + name + "/" + name + "-idle-0.png");
        animTimer = new SimpleTimer();
        setImage("images/" + name + "/" + name + "-idle-0.png");
    }
    /**
     * Act - do whatever the Friend wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    /**
     * WalkX - moves the Friend horizontally towards an x coordinate
     */
    public void walkX(int toX)
    {
        setLocation(getX() + 2, getY());
        boolean goRight = toX < 0;
        animate(goRight, false);
        if(toX > getX())
        {
            setLocation(getX() + 2, getY());
        }
        if(getX() == toX)
        {
            animate(false, true);
        }
    }
    int curIndex = 0;
    public void animate(boolean goRight, boolean stopped)
    {
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
    }
}
