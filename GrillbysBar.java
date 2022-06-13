import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heartsfall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrillbysBar extends World
{
    /**
     *  Instance variables
     */
    private GreenfootImage bar;
    private SimpleTimer delay;
    public Label scoreLabel = new Label(0, 70);
    public static int score = 0;
    public boolean win = false;
    //GreenfootSound ambient = new GreenfootSound("sounds/grillbys-bar-ambient.mp3");
    //GreenfootSound inGame = new GreenfootSound("sounds/grillbys-bar-game.mp3");
    public Player frisk;
    Grillby grillby;
    /**
     * Constructor for objects of class Heartsfall.
     * 
     */
    public GrillbysBar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(600, 400, 1, false); 
        GreenfootImage bar = new GreenfootImage("images/bg/grillbys.png");
        bar.scale(600, 400);
        setBackground(bar);
        //addObject("images/grillby/00.png", 300, 300);
        grillby = new Grillby();
        grillby.scaleSmaller(3);
        addObject(grillby, 300, 270);
        frisk = new Player(false);
        addObject(frisk, 20, 50);
        delay = new SimpleTimer();
        delay.mark();
        //ambient.playLoop();
    }

    public void act(){
        boolean soundStarted = false;
        /*if(!soundStarted && !gameIntroInitiated){
        ambient.playLoop();
        soundStarted = true;
        }*/

        if(frisk.getX() > 20 && !greetInitiated && Player.canMove){
            Player.canMove = false;
            greetInitiated = true;
            showGreet();
        }

        if(frisk.getX() > 200 && !gameIntroInitiated && Player.canMove){
            //ambient.stop();
            soundStarted = false;

            Player.canMove = false;
            gameIntroInitiated = true;
            showGameIntro();
        }
        boolean grillbyRightWalk = true;
        if(gameIntroInitiated && !win){
            if(Greenfoot.isKeyDown("space")){
                frisk.dropHeart();
            }
            /*if(!soundStarted){
            inGame.playLoop();
            soundStarted = true;
            }*/
            addObject(scoreLabel, 550, 50);
            if(grillbyRightWalk){
                grillby.walk(this, 450, grillby.getY());
            }
            else{
                grillby.walk(this, 150, grillby.getY());
            }
            if(grillby.getX() == 450){
                grillbyRightWalk = false;
            }
            if(grillby.getX() == 150){
                grillbyRightWalk = true;
            }
        }

        if(score >= 1000 && Player.canMove && !finishInitiated){
            Player.canMove = false;
            win = true;
            finishInitiated = true;
            showFinished();
            removeObject(scoreLabel);
            //inGame.stop();
        }

        if(frisk.getX() >= 580 && finishInitiated){

        }
    }
    boolean greetInitiated = false;
    public void showGreet(){
        String[] greet = new String[10];
        greet[0] = new String("Oh boy, I sure love my bar.");
        greet[1] = new String("Grill 'em up boyz. Haha, get it?");
        greet[2] = new String("...cuz my name's Grillby, haha--");
        greet[3] = new String("!!!!");
        greet[4] = new String("Whoa! Kiddo! Whatcha doing up there?");
        greet[5] = new String("Are... are you..? Floating?");
        greet[6] = new String("Or, could it be... the FORBIDDEN...");
        greet[7] = new String("DEVELOPPERS' BUG???!!?");
        greet[8] = new String("...");
        greet[9] = new String("..nah.");

        Dialogue greeting = new Dialogue(greet, Color.WHITE);
        addObject(greeting, 0, 0);
    }
    boolean gameIntroInitiated = false;
    public void showGameIntro(){
        String[] intro = new String[12];
        intro[0] = new String("So, uh, you getting down anytime soon, or..?");
        intro[1] = new String("...");
        intro[2] = new String("What? You want to make friends?");
        intro[3] = new String("Temmie said you need to give FRIENDS hearts?");
        intro[4] = new String("You do know that's not how you actually make friends, right?");
        intro[5] = new String("Alright, how 'bout this.");
        intro[6] = new String("You can DROP hearts to me with the SPACE BAR.");
        intro[7] = new String("Hm? DROP how many? Until when?");
        intro[8] = new String("Until I FEEL LOVED, OKAY?!?!?!?");
        intro[9] = new String("...");
        intro[10] = new String("But don't think it'll be easy kiddo.");
        intro[11] = new String("I still need to serve my bar.");

        Dialogue gameIntro = new Dialogue(intro, Color.WHITE);
        addObject(gameIntro, 0, 0);
    }
    boolean finishInitiated = false;
    public void showFinished(){
        String[] finished = new String[7];
        finished[0] = new String("Wow.");
        finished[1] = new String("I have " + score + " HEARTS now, huh?");
        finished[2] = new String("...");
        finished[3] = new String("This kinda... feels...");
        finished[4] = new String("feels...");
        finished[5] = new String("...nice. This feels nice.");
        finished[6] = new String("I'm glad we're FRIENDS now, kiddo.");

        Dialogue gameFinished = new Dialogue(finished, Color.WHITE);
        addObject(gameFinished, 0, 0);
    }

    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
    }
}
