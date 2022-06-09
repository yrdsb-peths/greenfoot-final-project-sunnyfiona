import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{
    private GreenfootImage bg;
    private Wall[] tree;
    private Friend temmie = new Friend("temmie");
    private Player frisk = new Player(true);
    private Heart heart = new Heart(20, 20);
    private Textbox[] greet;
    /**
     * Constructor for objects of class MyWorld.
     * 
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
        //setDialogues();
    }
    boolean greetInitiated = false;
    public void act()
    {
        if(frisk.getX() >= 599)
        {
            Maze world = new Maze();
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
            temmie.exit(this, temmie.getX(), 400);
        }
    }

    public void showGreet()
    {
        // Show Text
        //String[] phrases = {"Hello", "How are you?", "Bye!"};
        String[] greet = new String[4];
        greet[0] = new String("hOIIII!! Over here!");
        greet[1] = new String("I'm Temmie the temmie from Tem Village!");
        greet[2] = new String("Let's be FRIENDS! See that heart up there?");
        greet[3] = new String("gimmegimmegimme");

        Dialogue greeting = new Dialogue(greet, Color.WHITE);

        addObject(greeting, 0, 0);

    }
    boolean byeInitiated = false;
    boolean byeFinished = false;
    public void showBye(){
        //if(frisk.deliveredHeart){
        String[] bye = new String[6];
        bye[0] = new String(".....");
        bye[1] = new String("...!!!!!!!!!!");
        bye[2] = new String("That's how you make FRIENDS!");
        bye[3] = new String("gj");
        bye[4] = new String("aaand that was the tutorial.");
        bye[5] = new String("some-tem-body needs tem nap now. byEE");
        Dialogue goodbye = new Dialogue(bye, Color.WHITE);
        addObject(goodbye, 0, 0);
        //}
        
    }

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
