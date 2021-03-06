import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player begins in this world after passing the title screen and learns how to navigate the world and collect hearts.
 * 
 * @author Finny 
 * @version June 16, 2022
 */
public class Tutorial extends World
{
    // used for images in world
    private GreenfootImage bg;
    private Wall[] tree;
    private Textbox[] greet;
    
    // used for gameplay
    private int delay;
    
    // list of actors
    private Friend temmie = new Friend("temmie");
    private Player frisk = new Player(true);
    private Heart heart = new Heart(20, 20);
    
    // sounds
    GreenfootSound ambient = new GreenfootSound("sounds/tutorial-ambient.mp3");
    /**
     * Constructor for objects of class Tutorial.
     */
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        bg = new GreenfootImage("images/bg/snow.jpg");
        bg.scale(getWidth()*2, getHeight()*2); 
        setBackground(bg);

        addObject(frisk, 0, 200);
        addObject(temmie, 500, 200);
        temmie.scaleSmaller(5);
        buildTrees();
        setPaintOrder(Dialogue.class);
        delay = 250;
        //setDialogues();
    }
    
    /**
     * This method plays the Temmie's background music.
     */
    public void started(){
        ambient.playLoop();
    }
    //instance variable that helps move along events in act()
    boolean greetInitiated = false;
    public void act()
    {
        if(frisk.getX() >= 599)
        {
            Maze world = new Maze();
            ambient.stop();
            Greenfoot.setWorld(world);
        }

        if(frisk.getX() >= 50 && Player.canMove && !greetInitiated)
        {
            Player.canMove = false;
            greetInitiated = true;
            showGreet();
        }
        
        if(greetInitiated && !frisk.collectedHeart){
            addObject(heart, 20, 20);
        }

        if(frisk.collectedHeart && frisk.getX() == 420 && Player.canMove && !byeInitiated){
            Player.canMove = false;
            byeInitiated = true;
            showBye();
            byeFinished = true;
        }
        
        if(byeInitiated && byeFinished){
            delay--;
            if(delay <= 0){
            temmie.walk(this, temmie.getX(), 400);
            }
        }
    }

    /**
     * This method sets the dialogue for Temmie's greeting.
     */
    public void showGreet()
    {
        // Show Text
        //String[] phrases = {"Hello", "How are you?", "Bye!"};
        String[] greet = new String[4];
        greet[0] = new String("hOIIII!! Over here!");
        greet[1] = new String("I'm Temmie the temmie from Tem Village!");
        greet[2] = new String("Let's be FRIENDS! See that heart up there?");
        greet[3] = new String("gimmegimmegimme");

        Dialogue greeting = new Dialogue(greet);//, Color.WHITE);
        addObject(greeting, 0, 0);

    }
    boolean byeInitiated = false;
    boolean byeFinished = false;
    /**
     *  This method sets the dialogue for Temmie's goodbye.
     */
    public void showBye(){
        //if(frisk.deliveredHeart){
        ambient.stop();
        String[] bye = new String[6];
        bye[0] = new String(".....");
        bye[1] = new String("...!!!!!!!!!!");
        bye[2] = new String("That's how you make FRIENDS!");
        bye[3] = new String("gj");
        bye[4] = new String("aaand that was the tutorial.");
        bye[5] = new String("some-tem-body needs tem nap now. byEE");
        Dialogue goodbye = new Dialogue(bye);//, Color.WHITE);
        addObject(goodbye, 0, 0);
    }

    /**
     * This method uses the image of a tree to function as a part of the Wall class, and adds the object to the world.
     */
    public void buildTrees()
    {
        tree = new Wall[8];
        int xCoord = 0;
        for(int i = 0; i < 4; i++)
        {
            tree[i] = new Wall("tree-group", 100);

            xCoord += 150;
            addObject(tree[i], xCoord, 400);

        }
        xCoord = 0;
        for(int i = 0; i < 4; i++)
        {
            tree[i] = new Wall("tree-group", 100);

            xCoord += 150;
            addObject(tree[i], xCoord, 0);

        }
    }

}
