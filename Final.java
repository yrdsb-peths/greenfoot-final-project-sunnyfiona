import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Final here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Final extends FallingHeartGame
{
    private Friend doggo = new Friend("annoying-dog");
    private Player frisk = new Player(true);
    private Friend scaryDog = new Friend("scary-dog");
    private GreenfootImage[] scaryScreen; 
    private SimpleTimer animTimer;
    public Label scoreLabel = new Label(0, 70);
    public static int score = 0;

    private Slider[] walls;
    public DropHeart heart = new DropHeart(30, 30);

    private GreenfootSound ambient = new GreenfootSound("sounds/final-ambient.mp3");
    /**
     * Constructor for objects of class Final.
     * 
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
            addObject(heart, 300, 0);
            frisk.collectFallingHeart();

        }
        boolean byeInitiated = false;
        if(score == 2 && Player.canMove && !win){
            win = true;
            Player.canMove = false;
            showBye();
            byeInitiated = true;
            setBackground(scaryScreen[1]);
        }
        if(byeInitiated && Player.canMove){
            TitleScreen world = new TitleScreen();
            Greenfoot.setWorld(world);
        }
    }

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

    public void showGreet(){
        String[] greet = new String[3];
        greet[0] = new String("heywro.");
        greet[1] = new String("You've been making FRIENDS, ay?");
        greet[2] = new String("Well... guess what --");

        Dialogue greeting = new Dialogue(greet);//, Color.WHITE);
        addObject(greeting, 0, 0);
    }

    public void showReveal(){
        String[] reveal = new String[3];
        reveal[0] = new String("I DONT WANNA BE YOUR FWRIEND >;(");
        reveal[1] = new String("[Annoying Dog will get wary");
        reveal[2] = new String("if humans move too much.]");

        Dialogue dramaticReveal = new Dialogue(reveal);//, Color.BLACK);
        addObject(dramaticReveal, 0, 0);
    }

    public void showBye(){
        String[] bye = new String[15];
        bye[0] = new String("...");
        bye[1] = new String("you...");
        bye[2] = new String("...you...");
        bye[3] = new String("YOU THINK THIS IS HOW IT WORKS?");
        bye[4] = new String("YOU THINK YOU CAN JUST KEEP TRYING?? I \n SAID I DIDN'T WANT TO BE FRIENDS!!");
        bye[5] = new String("What did you think the spikes were for? \n Just a little bit of CHALLENGE?");
        bye[6] = new String("no.");
        bye[7] = new String("I said I didn't want to be friends.");
        bye[8] = new String("You don't get a [make it up to Annoying-Dog] \n button. I just didn't want to be friends.");
        bye[9] = new String("And you don't get a redeeming ending. Because \n that's how life is.");
        bye[10] = new String("Icky, uncomfortable. Bittersweet.");
        bye[11] = new String("Maybe we can be friends one day.");
        bye[12] = new String("But not today.");
        bye[13] = new String("...");
        bye[14] = new String("Goodbye.");

        Dialogue goodBye = new Dialogue(bye);
        addObject(goodBye, 0, 0);
    }

}
