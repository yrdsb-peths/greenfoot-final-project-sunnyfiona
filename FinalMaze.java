import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalMaze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalMaze extends World
{
    Slider[] walls;
    /**
     * Constructor for objects of class FinalMaze.
     * 
     */
    public FinalMaze()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        buildWalls();
    }
    
    public void buildWalls()
    {
        walls = new Slider[10];
        for(int i = 0; i < walls.length; i++) {
            walls[i] = new Slider("maze-wall");
        }
        
        //slider 1
        addObject(walls[0], 57, 315);
        
        //slider 2
        addObject(walls[1], 171, 8);
        
        //slider 3
        //addObject(walls[2], 285, 145);
        
        //slider 4
        //addObject(walls[3], 399, 60);
        
        //slider 5
        //addObject(walls[4], x, 550);
    }
}
