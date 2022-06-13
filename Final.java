import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Final extends World
{
    private Friend doggo = new Friend("annoying-dog");
    private Player frisk = new Player(false);
    private Friend scaryDog = new Friend("scary-dog");
    private GreenfootImage[] scaryScreen; 
    private SimpleTimer animTimer;
    private Wall[] mazeWall;
    private GreenfootSound ambient = new GreenfootSound("sounds/final-ambient.mp3");
    /**
     * Constructor for objects of class Final.
     * 
     */
    public Final()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //Player.canMoveVertical = t;
        addObject(doggo, 300, 150);
        doggo.scaleSmaller(3);
        addObject(frisk, 0, 380);
        scaryScreen = new GreenfootImage[4];
        for(int i = 0; i < scaryScreen.length; i++)
        {
            scaryScreen[i] = new GreenfootImage("images/bg/scary-screen/scary-dog-" + i + ".png");
            scaryScreen[i].scale(scaryScreen[i].getWidth() * 2, scaryScreen[i].getHeight() * 2);
        }
        
        animTimer = new SimpleTimer();
        animTimer.mark();
        buildMaze();
    }
    boolean greetInitiated = false;
    boolean revealInitiated = false;
    public void act(){
        if(frisk.getX() >= 50 && Player.canMove && !greetInitiated){
            Player.canMove = false;
            showGreet();
            greetInitiated = true; 
        }
        if(frisk.getX() >= 60 && greetInitiated && !revealInitiated && Player.canMove){
            Player.canMove = false;
            showReveal();
            revealInitiated = true;
            removeObject(doggo);
            setBackground(scaryScreen[0]);
        }
        if(revealInitiated){
            animate();
            ambient.playLoop();
        }
    }
    int curIndex = 1;
    public void animate()
    {
        if(animTimer.millisElapsed() > 50)
        {
            setBackground(scaryScreen[curIndex]);
            curIndex++;
            curIndex %= 3;
            animTimer.mark();
        }
    }
    public void showGreet(){
        String[] greet = new String[3];
        greet[0] = new String("heywro.");
        greet[1] = new String("You've been making FRIENDS, ay?");
        greet[2] = new String("Well... guess what --");
        
        Dialogue greeting = new Dialogue(greet, Color.WHITE);
        addObject(greeting, 0, 0);
    }
    public void showReveal(){
        String[] reveal = new String[1];
        reveal[0] = new String("I DONT WANNA BE YOUR FWRIEND >;(");
        
        Dialogue dramaticReveal = new Dialogue(reveal, Color.BLACK);
        addObject(dramaticReveal, 0, 0);
    }
    public void buildMaze(){
        mazeWall = new Wall[13];
        for(int i = 0; i < mazeWall.length; i++)
        {
            mazeWall[i] = new Wall("maze-wall");
        }
        int x1 = 0;
        int limit = 7;
        for(int i = 0; i < limit; i++)
        {
            addObject(mazeWall[i], x1, 300);
            x1 += 50;
        }
        int x2 = 615;
        limit = 13;
        for(int i = 8; i < limit; i++)
        {
            addObject(mazeWall[i], x2, 200);
            x2 -= 50;
        }
    }
}
