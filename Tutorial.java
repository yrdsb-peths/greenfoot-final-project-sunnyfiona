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

        setDialogues();
    }

    public void act()
    {
        if(frisk.getX() >= 599)
        {
            Maze world = new Maze();
            Greenfoot.setWorld(world);
        }

        if(frisk.getX() >= 50 && Player.canMove)
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
    public void showDialogue()
    {
        // Show textbox
        String[] phrases = {"Hello", "How are you?", "Bye!"};
        Textbox tb = new Textbox(phrases, Color.BLUE);
        addObject(tb, getWidth()/2, getHeight()/2);
    }

    public void setDialogues()
    {
        // greet = new Textbox[4];
        // greet[0] = new Textbox("hOIIII!! Over here!", Color.CYAN);
        // greet[1] = new Textbox("I'm Temmie the temmie from Tem Village!", Color.CYAN);
        // greet[2] = new Textbox("Let's be FRIENDS! See that heart up there?", Color.CYAN);
        // greet[3] = new Textbox("gimmegimmegimme", Color.CYAN);
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
