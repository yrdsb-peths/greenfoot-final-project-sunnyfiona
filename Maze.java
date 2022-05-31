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
        
        //1st h wall
        int x1 = 0;
        int limit = 7;
        for(int i = 0; i < limit; i++)
        {
            addObject(mazeWall[i], x1, 350);
            x1 += 50;
        }
        int x2 = 600;
        limit = 12;
        for(int i = 8; i < limit; i++)
        {
            addObject(mazeWall[i], x2, 350);
            x2 -= 50;
        }
        
        //2nd h wall
        int x3 = 0;
        limit = 18;
        for(int i = 13; i < limit; i++)
        {
            addObject(mazeWall[i], x3, 275);
            x1 += 50;
        }
    }
}
