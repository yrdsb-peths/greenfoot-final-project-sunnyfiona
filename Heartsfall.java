import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heartsfall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heartsfall extends World
{
    /**
     *  Instance variables
     */
    private GreenfootImage[] waterfall;
    private SimpleTimer animTimer;
    /**
     * Constructor for objects of class Heartsfall.
     * 
     */
    public Heartsfall()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1); 
        GreenfootImage[] waterfall= new GreenfootImage[6];
        for(int i = 0; i < waterfall.length; i++)
        {
            waterfall[i] = new GreenfootImage("images/bg/heartsfall/waterfall-" + i + ".png");
            waterfall[i].scale(600, 400);
        }
        setBackground(waterfall[0]);
        animTimer = new SimpleTimer();
        animTimer.mark();
    }
    public void act(){
        animateBG();
    }
    int curIndex = 0;
    /**
     * Animates the background image.
     */
    public void animateBG()
    {
        if(animTimer.millisElapsed() > 100)
        {
            setBackground(waterfall[curIndex]);
            curIndex++;
            curIndex %= 5;
            animTimer.mark();
        }
    }
}
