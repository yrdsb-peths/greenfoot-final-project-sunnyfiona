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
    Obstacle[] spikeWall;
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
        GameP frisk = new GameP(37, 30);
        addObject(frisk, 20, 384);
        
        //add muffet
        
        //add heart
        Heart heart = new Heart(25, 25);
        addObject(heart, 430, 313);
        
        //add potions
        
        
        //add spikes
        buildSpikes();
    }
    
    public void buildSpikes()
    {
        Obstacle spike = new Obstacle();
        
        spikeWall = new Obstacle[50];
        for(int i = 0; i < spikeWall.length; i++)
        {
            spikeWall[i] = new Obstacle();
        }
        
        //1st section
        spikeWall[0].setRotation(180);
        addObject(spikeWall[0], 147, 97);
    
        //2nd section
        spikeWall[1].setRotation(180);
        addObject(spikeWall[1], 312, 97);
        
        //3rd section
        spikeWall[2].setRotation(180);
        addObject(spikeWall[2], 555, 97);
    }
    
    /**
     * Builds maze
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
        limit = 17;
        for(int i = 14; i < limit; i++)
        {
            addObject(mazeWall[i], x3, 275);
            x3 += 50;
        }
        addObject(mazeWall[18], 205, 275);
        int x4 = 517;
        limit = 22;
        for(int i = 19; i < limit; i++)
        {
            addObject(mazeWall[i], x4, 275);
            x4 -= 50;
        }
        
        //1st v wall
        int y1 = 339;
        limit = 27;
        for(int i = 24; i < limit; i++)
        {
            mazeWall[i].setRotation(90);
            addObject(mazeWall[i], 311, y1);
            y1 -= 50;
        }
        mazeWall[46].setRotation(90);
        addObject(mazeWall[46], 311, 211);
        mazeWall[47].setRotation(90);
        addObject(mazeWall[47], 311, 170);
        
        // 2nd v wall
        int y2 = 339;
        limit = 30;
        for(int i = 27; i < limit; i++)
        {
            mazeWall[i].setRotation(90);
            addObject(mazeWall[i], 395, y2);
            y2 -= 50;
        }
        
        // 3rd v wall
        int y3 = 264;
        limit = 34;
        for(int i = 30; i < limit; i++)
        {
            mazeWall[i].setRotation(90);
            addObject(mazeWall[i], 64, y3);
            y3 -= 50;
        }
        
        //4th h wall
        int x5 = 75;
        limit = 46;
        for(int i = 35; i < limit; i++)
        {
            addObject(mazeWall[i], x5, 70);
            x5 += 50;
        }
        
        /*
        //3rd h wall
        int x6 = 170;
        limit = 51;
        for(int i = 48; i < limit; i++)
        {
            addObject(mazeWall[i], x6, 180);
            x6 += 50;
        }
        addObject(mazeWall[52], 300, 180);
        */
        
        // 4th v wall
        int y4 = 264;
        limit = 55;
        for(int i = 53; i < limit; i++)
        {
            mazeWall[i].setRotation(90);
            addObject(mazeWall[i], 545, y4);
            y4 -= 50;
        }
        mazeWall[56].setRotation(90);
        addObject(mazeWall[56], 545, 170);
        
        // 6th v wall
        mazeWall[58].setRotation(90);
        addObject(mazeWall[58], 395, 115);
        
        // 5th v wall
        int y5 = 165;
        limit = 61;
        for(int i = 59; i < limit; i++)
        {
            mazeWall[i].setRotation(90);
            addObject(mazeWall[i], 470, y5);
            y5 -= 50;
        }
        
        //3rd h wall
        int x6 = 165;
        limit = 51;
        for(int i = 48; i < limit; i++)
        {
            addObject(mazeWall[i], x6, 200);
            x6 += 50;
        }
       
        // 7th v wall
        mazeWall[62].setRotation(90);
        addObject(mazeWall[62], 154, 170);
        mazeWall[63].setRotation(90);
        addObject(mazeWall[63], 230, 115);
    }
}
