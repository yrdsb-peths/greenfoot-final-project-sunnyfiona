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
    Wall[] tree;
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
        
        addObject(frisk, 20, 200);
        addObject(temmie, 500, 200);
        temmie.scaleSmaller(5);
        buildTrees();
    }
    public void act()
    {
        if(frisk.getX() >= 599)
        {
            Maze world = new Maze();
            Greenfoot.setWorld(world);
        }
       
    }
    public void buildTrees()
    {
        tree = new Wall[10];
        int x1 = 0;
        int limit = 4;
        for(int i = 0; i < tree.length; i++)
        {
            tree[i] = new Wall("tree-group", 100);
            
        }
        addObject(tree[0], 300, 400);
    }
}
