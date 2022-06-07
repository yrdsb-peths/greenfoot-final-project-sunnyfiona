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
    public Player frisk = new Player(); 
    private String[] greet;

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

        setDialogues();
    }

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
            showDialogue();
            // for(int i = 0; i < greet.length; i += 0)
            // {
            // greet[i].add(greet[i], this);
            // if(Greenfoot.mouseClicked(frisk.getWorld())){
            // greet[i].remove(greet[i], frisk.getWorld());
            // i++;
            // }
            // }
        }

    }
    boolean greetInitiated = false;
    public void showDialogue()
    {
        // Show textbox
        greetInitiated = true;
        String[] phrases = {"Hello", "How are you?", "Bye!"};
        Textbox tb = new Textbox(greet, Color.BLUE);
        addObject(tb, 300, 350);
    }

    public void setDialogues()
    {
        greet = new String[4];
        greet[0] = new String("hOIIII!! Over here!");
        greet[1] = new String("I'm Temmie the temmie from Tem Village!");
        greet[2] = new String("Let's be FRIENDS! See that heart up there?");
        greet[3] = new String("gimmegimmegimme");
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
