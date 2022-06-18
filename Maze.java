import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawns player in a maze minigame.
 * 
 * @author Finny
 * @version June 16, 2022
 */
public class Maze extends World
{
    // used for images in world
    private GreenfootImage bg;
    Wall[] mazeWall;
    Obstacle[] spikeWall;
    
    // used for gameplay
    public boolean greetInitiated;
    public boolean byeInitiated;
    private boolean spawnReset;
    private boolean muffetExit = false;
    private int waitFirst;
    private int delay;
    
    // list of actors
    private Friend muffet = new Friend("muffet");
    GameP frisk = new GameP(37, 30);
    
    // sounds
    GreenfootSound sad = new GreenfootSound("sounds/maze-sad.mp3");
    GreenfootSound hopeful = new GreenfootSound("sounds/maze-hopeful.mp3");
    /**
     * Constructor for objects of class Maze.
     * 
     */
    public Maze()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        bg = new GreenfootImage("images/bg/web.jpg");
        bg.scale(getWidth()*1, getHeight()*1); 
        setBackground(bg);
        buildMaze();
        sad.playLoop();
        //add frisk
        addObject(frisk, 20, 384);
        
        //add muffet
        //addObject(muffet, 575, 25);
        addObject(muffet, 80, 400);
        muffet.scaleSmaller(25);
        waitFirst = 800;
        
        //add heart
        Heart heart = new Heart(25, 25);
        addObject(heart, 430, 313);
        /*
        if(frisk.collectedHeart){
            Heart newHeart = new Heart("emptyheart", 25, 25, false);
            addObject(newHeart, 430, 313);
        }
        */
        //add spikes
        buildSpikes();
        
        //add potions
        SlowPotion p1 = new SlowPotion();
        addObject(p1, 585, 383);
        
        //give heart
        greetInitiated = false;
        byeInitiated = false;
        //byeFinished = false;
        delay = 300;
    }
    
    public void act()
    {
        //say hi
        if(frisk.getX() >= 20 && frisk.getY() <= 384 && GameP.canMove && !greetInitiated){
            GameP.canMove = false;
            hiMuffet();
            greetInitiated = true;
        }
        if(greetInitiated && GameP.canMove) {
            waitFirst--;
            if(waitFirst <= 0 && !byeInitiated) {
            muffet.walk(this, 575, muffet.getY());
            muffet.walk(this, muffet.getX(), 25);
            }
        }

        
        //spawn reset potion
        if(frisk.collectedHeart && frisk.spawnReset) {
            ResetPotion p2 = new ResetPotion();
            addObject(p2, 433, 105);
            frisk.spawnReset = false;
        }
        
        //say bye
        if(frisk.collectedHeart && frisk.getX() >= 525 && frisk.getY() <= 100 && GameP.canMove && !byeInitiated){
            sad.stop();
            hopeful.playLoop();
            GameP.canMove = false;
            byeInitiated = true;
            byeMuffet();
        }
        GameP.canMove = true;
        
        //makes muffet move after finished talking, can move to GrillbysBar
        if(byeInitiated) {
            delay--;
            if(delay <= 0 && !muffetExit) {
                muffet.walk(this, 0, muffet.getY());
                if(muffet.getX() <= 0) {
                    removeObject(muffet);
                    muffetExit = true;
                }
            }
        }
        if(byeInitiated && frisk.getX() >= 590){
            GrillbysBar world = new GrillbysBar();
            Greenfoot.setWorld(world);
            hopeful.stop();
            sad.stop();
        }
    }
    
    /**
     * Sets dialogue for greeting Muffet
     */
    public void hiMuffet()
    {
        String[] greet = new String[18];
        greet[0] = new String("boohoo :'(");
        greet[1] = new String("boo :''''((((( hoo");
        greet[2] = new String("!!");
        greet[3] = new String("Oh hello.");
        greet[4] = new String("Move along now, this isn't \n a place you want to be.");
        greet[5] = new String("Why am I sad?");
        greet[6] = new String("I just want to make friends \n and share my spider bake sale.");
        greet[7] = new String("But instead people always just think \n that I'm some mean guy,");
        greet[8] = new String("and the next thing I know \n I'm being thrown onto some bad spikes.");
        greet[9] = new String("That HURTS, you know >:(");
        greet[10] = new String("It's not my fault I'm a spider");
        greet[11] = new String("Just because I'm spooky \n doesn't mean I'm mean!");
        greet[12] = new String("And here I thought video \n game society was evolving :(");
        greet[13] = new String("..");
        greet[14] = new String("What's that??");
        greet[15] = new String("YOU want to be my friend :0");
        greet[16] = new String("A lot of people say that, you know.");
        greet[17] = new String("So I guess we'll see.");

        Dialogue greeting = new Dialogue(greet);//, Color.WHITE);
        addObject(greeting, 0, 0);
    }
    
    /**
     * Sets dialogue for leaving Muffet
     */
    public void byeMuffet()
    {        
        String[] bye = new String[11];
        bye[0] = new String("!!");
        bye[1] = new String("Oh");
        bye[2] = new String("A heart");
        bye[3] = new String("I've never received one before");
        bye[4] = new String("Okay bestie");
        bye[5] = new String("I suppose we can be");
        bye[6] = new String("...");
        bye[7] = new String("Friends.");
        bye[8] = new String(":)");
        bye[9] = new String("Proceed now, I guess.");
        bye[10] = new String("I'm glad we met.");

        Dialogue greeting = new Dialogue(bye);//, Color.WHITE);
        addObject(greeting, 0, 0);
    }
    
    /**
     * Sets images for the spikes on maze walls
     */
    public void buildSpikes()
    {
        //Obstacle spike = new Obstacle();
        
        spikeWall = new Obstacle[50];
        for(int i = 0; i < spikeWall.length; i++)
        {
            spikeWall[i] = new Obstacle(-275, -230);
        }
        
        //1st section
        spikeWall[0].setRotation(180);
        addObject(spikeWall[0], 147, 92);
    
        //2nd section
        spikeWall[1].setRotation(180);
        addObject(spikeWall[1], 312, 92);
        
        //3rd section
        spikeWall[2].setRotation(180);
        addObject(spikeWall[2], 555, 92);
        
        //4th section
        spikeWall[3].setRotation(270);
        addObject(spikeWall[3], 290, 275);
        
        //5th section
        addObject(spikeWall[4], 470, 255);
    }
    
    /**
     * Sets images for the maze walls
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
