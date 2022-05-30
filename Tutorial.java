import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{
    GreenfootImage bg;
    GreenfootImage tree;
    Friend temmie = new Friend("temmie");
    Player frisk = new Player();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        bg = new GreenfootImage("images/bg/snow.jpg");
        bg.scale(getWidth()*2, getHeight()*2); 
        setBackground(bg);
        
        addObject(frisk, 100, 200);
        Wall tree = new Wall("tree-group");
        addObject(tree, 300, 400);
        /*
        Wall[] trees = new Wall[8];
        for(int i = 0; i < trees.length; i++)
        {
            trees[i] = new Wall("tree-group");
        }
        for(int i = 0; i < 8; i++)
        {
            int prevPos = 0;
            addObject(trees[i], prevPos + 50, 400);
            prevPos += 50;
        }
        */
        
        
        addObject(temmie, 400, 200);
        
    }
    public void act()
    {
        if(frisk.getX() >= 599)
        {
            Maze world = new Maze();
            Greenfoot.setWorld(world);
        }
    }
}
