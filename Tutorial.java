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
    private Player frisk = new Player();
    
    private Textbox textbox = new Textbox();
    private boolean dialoguePause = false;
    private Label[] text = new Label[3];
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
        
        
    }
    public void act()
    {
        if(frisk.getX() >= 599)
        {
            Maze world = new Maze();
            Greenfoot.setWorld(world);
        }
        
        if(frisk.getX() >= 50)
        {
            addObject(textbox, 300, 320);
            dialoguePause = true;
            addObject(text[0], 300, 320);
            int curIndex = 0;
            if(Greenfoot.mouseClicked(Textbox.class))
            {
                curIndex++;
                removeObject(text[curIndex - 1]);
                addObject(text[curIndex], 300, 320);
            }
        }
        
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
    
    //needs to be copied accross worlds
    public void setTextbox()
    {
        textbox.setDialogue("hOIIIII!!!!! Hey there!");
        textbox.setDialogue("Over here!");
        textbox.setDialogue("I'm Temmie! I'm Temmie the Tem from TEM VILLAGE!!!!!");
        
    }
    public boolean getDialoguePause()
    {
        return dialoguePause;
    }
    public void initiateDialogueString()
    {
        text = new Label[3];
        for(int i = 0; i < text.length; i++)
        {
            text[i] = new Label (textbox.getDialogue(i), 20);
        }
    }
}
