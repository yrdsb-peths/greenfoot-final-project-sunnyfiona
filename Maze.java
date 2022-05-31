import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze extends World
{
    Wall[] mazeWall;
    /**
     * Constructor for objects of class Maze.
     * 
     */
    public Maze()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        buildMaze();
        //add frisk
        //add grillby
    }
    public void buildMaze()
    {
        mazeWall = new Wall[100];
        for(int i = 0; i < mazeWall.length; i++)
        {
            mazeWall[i] = new Wall("maze-wall");
        }
        
        for(int i = 0; i < 20; i++)
        {
            for(int x = 0; i < 60; x+= 10)
            {
                addObject(mazeWall[i], x, 300);
            }
            
        }
    }
}
