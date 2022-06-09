import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heartsfall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrillbysBar extends World
{
    /**
     *  Instance variables
     */
    private GreenfootImage bar;
    private SimpleTimer animTimer;
    /**
     * Constructor for objects of class Heartsfall.
     * 
     */
    public GrillbysBar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1); 
        GreenfootImage bar = new GreenfootImage("images/bg/grillbys.png");
        bar.scale(600, 400);
        setBackground(bar);
        //addObject("images/grillby/00.png", 300, 300);
        Friend grillby = new Friend("grillby");
        grillby.scaleSmaller(3);
        addObject(grillby, 300, 270);
        Player frisk = new Player(false);
        addObject(frisk, 20, 50);
    }
    public void act(){
        //animateBG();
    }
    int curIndex = 0;
    /**
     * Animates the background image.
     */
    
}
