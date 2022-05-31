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
        //buildMaze();
    }
    public void buildMaze()
    {
        mazeWall = new Wall[20];
        Wall wall1 = new Wall("maze-wall-dark");
        Wall wall2 = new Wall("maze-wall-dark");
    }
}
