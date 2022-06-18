import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final here.
 * 
 * @author Finny
 * @version June 17, 2022
 */
public class Final extends FallingHeartGame
{
    // used for images in world
    private GreenfootImage[] scaryScreen; 

    // used for gameplay
    private SimpleTimer animTimer;
    public static int score = 0;
    private Slider[] walls;

    // list of actors
    private Friend doggo = new Friend("annoying-dog");
    private Player frisk = new Player(true);
    private Friend scaryDog = new Friend("scary-dog");
    public Label scoreLabel = new Label(0, 70);
    public DropHeart heart = new DropHeart(30, 30);

    // sounds
    private GreenfootSound ambient = new GreenfootSound("sounds/final-ambient.mp3");
    /**
     * Constructor for objects of class Final.
     */
    public Final()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(true); 

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
        buildWalls();
    }
    boolean greetInitiated = false;
    boolean revealInitiated = false;
    boolean win = false;
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
        if(revealInitiated && !win){
            animate();
            ambient.playLoop();

            addObject(scoreLabel, 550, 50);
            if(frisk.getX() >= 300){
                addObject(heart, frisk.getX() - 150, 0);
            }else{
                addObject(heart, frisk.getX() + 150, 0);
            }
            //addObject(heart, 300, 0);
            frisk.collectFallingHeart();

        }
        boolean byeInitiated = false;
        if(score == 15 && Player.canMove && !win){
            win = true;
            Player.canMove = false;
            showBye();
            
            setBackground(scaryScreen[1]);
        }

        if(win && frisk.getX() >= 390){
            EndScreen world = new EndScreen();
            Greenfoot.setWorld(world);
        }

    }

    /**
     * Sets the sliders into world
     */
    public void buildWalls()
    {
        walls = new Slider[5];
        for(int i = 0; i < walls.length; i++) {
            walls[i] = new Slider("slider");
        }

        //slider 1
        addObject(walls[0], 50, 315);

        //slider 2
        addObject(walls[1], 200, 230);

        //slider 3
        addObject(walls[2], 350, 145);

        //slider 4
        addObject(walls[3], 500, 60);
    }

    /**
     * Increases score with heart collection
     */
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        if(frisk.getX() > 300){
            addObject(heart, frisk.getX() - 150, 0);
        } else{
            addObject(heart, frisk.getX() + 150, 0);
        }
    }

    int curIndex = 1;
    /**
     * Animates Annoying Dog bg
     */
    public void animate()
    {
        if(animTimer.millisElapsed() > 200)
        {
            setBackground(scaryScreen[curIndex]);
            curIndex++;
            curIndex %= 3;
            animTimer.mark();
        }
    }

    /**
     * Sets Annoying Dog greeting dialogue
     */
    public void showGreet(){
        String[] greet = new String[4];
        greet[0] = new String("heywro.");
        greet[1] = new String("You've been making FRIENDS, ay?");
        greet[2] = new String("Well... guess what");
        greet[3] = new String("owo");

        Dialogue greeting = new Dialogue(greet);//, Color.WHITE);
        addObject(greeting, 0, 0);
    }

    /** 
     * Continues dialogue after bg change
     */
    public void showReveal(){
        String[] reveal = new String[2];
        reveal[0] = new String("I DONT WANNA BE YOUR FWRIEND >;(");
        reveal[1] = new String("[Annoying Dog will get wary \n if humans move too much.]");

        Dialogue dramaticReveal = new Dialogue(reveal);//, Color.BLACK);
        addObject(dramaticReveal, 0, 0);
    }

    /**
     * Sets Annoying Dog goodbye dialogue
     */
    public void showBye(){
        String[] bye = new String[17];
        bye[0] = new String("...");
        bye[1] = new String("you...");
        bye[2] = new String("...you...");
        bye[3] = new String("You think ???? \n YOU THINK THIS IS HOW IT WORKS??????");
        bye[4] = new String("YOU THINK YOU CAN JUST KEEP TRYING?? I \n SAID I DIDN'T WANT TO BE FRIENDS!!");
        bye[5] = new String("What did you think the spikes were for? \n Just a little bit of CHALLENGE?");
        bye[6] = new String("no.");
        bye[7] = new String("I said I didn't want to be friends >:(");
        bye[8] = new String("you don't get to keep trying.");
        bye[9] = new String("you don't get to bully me into doing what you want.");
        bye[10] = new String("and you don't get to be my friend \n until you learn to respect that.");
        bye[11] = new String("owo");
        bye[12] = new String("maybe you'll learn that someday. \n if you keep trying.");
        bye[13] = new String("and if you keep learning.");
        bye[14] = new String("but i don't think that's today.");
        bye[15] = new String("...");
        bye[16] = new String("Goodbye.");
        
        Dialogue goodBye = new Dialogue(bye);
        addObject(goodBye, 0, 0);
        
        
    }

}
