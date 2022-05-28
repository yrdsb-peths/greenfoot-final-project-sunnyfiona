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
        Player frisk = new Player();
        addObject(frisk, 100, 200);
        
        Wall treeOne= new Wall("tree-group", 100);
        Wall treeTwo= new Wall("tree-group", 100);
        Wall treeThree= new Wall("tree-group", 100);
        //treeGroup.scale(tree.getWidth() * 2, tree.getHeight() * 2);
        //treeGroup.setImage(tree);
        addObject(treeOne, 200, 400);
        addObject(treeTwo, 400, 400);
        addObject(treeThree, 600, 400);
        /*
        Friend temmie = new Friend("temmie");
        addObject(temmie, 400, 200);
        */
    }
}
