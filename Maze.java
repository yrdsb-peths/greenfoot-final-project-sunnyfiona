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
        //testing frisk
        Player frisk = new Player();
        addObject(frisk, 100, 200);
        
        //add frisk
        //add grillby
    }
    
    /*
     * 
     */
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
        int x2 = 615;
        limit = 13;
        for(int i = 8; i < limit; i++)
        {
            addObject(mazeWall[i], x2, 350);
            x2 -= 50;
        }
        
        //2nd h wall
        int x3 = 75;
        limit = 19;
        for(int i = 14; i < limit; i++)
        {
            addObject(mazeWall[i], x3, 275);
            x3 += 50;
        }
        addObject(mazeWall[19], 300, 275);
        int x4 = 565;
        limit = 23;
        for(int i = 19; i < limit; i++)
        {
            addObject(mazeWall[i], x4, 275);
            x4 -= 50;
        }
       
        // 1st v wall
        int y1 = 339;
        limit = 27;
        for(int i = 24; i < limit; i++)
        {
            mazeWall[i].setRotation(90);
            addObject(mazeWall[i], 315, y1);
            y1 -= 50;
        }
        mazeWall[27].setRotation(90);
        addObject(mazeWall[27], 315, 265);
    }
}
