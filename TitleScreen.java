import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     *  Instance variables
     */
    private GreenfootImage[] titleScreen;
    private SimpleTimer animTimer;
    private SimpleTimer textTimer;
    private SimpleTimer clickLabelTimer;
    private Label narration;
    private Label clickToPlay;
    GreenfootSound loaded = new GreenfootSound("sounds/title-screen-loaded.mp3");
    GreenfootSound ambient = new GreenfootSound("sounds/title-screen-ambient.mp3");
        
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        titleScreen = new GreenfootImage[3];
        for(int i = 0; i < titleScreen.length; i++)
        {
            titleScreen[i] = new GreenfootImage("images/bg/title-screen/title-screen-" + i + ".png");
            titleScreen[i].scale(titleScreen[i].getWidth() / 3, titleScreen[i].getHeight() / 3);
        }
        setBackground(titleScreen[0]);
        animTimer = new SimpleTimer();
        animTimer.mark();
        
        narration = new Label("you gaze into the distance, \n longing for something to fill your void of loneliness...", 30);
        narration.setLineColor(Color.GRAY);
        narration.setFillColor(Color.WHITE);
        addObject(narration, 300, 100);
        textTimer = new SimpleTimer();
        clickLabelTimer = new SimpleTimer();
        clickLabelTimer.mark();
        textTimer.mark();
        
        clickToPlay = new Label("[CLICK TO MAKE FRIENDS]", 25);
        addObject(clickToPlay, 300, 350);
        
        
    }
    
    public void started()
    {
        ambient.playLoop();
    }
    
    /**
     * Method that executes the title screen mechanisms
     * (animations, click to play)
     */
    public void act()
    {
        
        animateBG();
        animateText();
        if(Greenfoot.mouseClicked(this))
        {
            double fade = 254;
            /*
            while(fade != 0.0)
            {
                this.getBackground().setTransparency((int)fade);
                clickToPlay.getImage().setTransparency((int)fade);
                narration.getImage().setTransparency((int)fade);
                fade = fade - 0.1;
            }
            */
            ambient.stop();
            loaded.stop();
            Tutorial world = new Tutorial();
            Greenfoot.setWorld(world);
        }
    }
    
    int curIndex = 0;
    /**
     * Animates the background image.
     */
    public void animateBG()
    {
        if(animTimer.millisElapsed() > 250)
        {
            setBackground(titleScreen[curIndex]);
            curIndex++;
            curIndex %= 2;
            animTimer.mark();
        }
    }
    /**
     * Animates the text on screen.
     */
    public void animateText()
    {
        
        if(clickToPlay.isTransparent() && clickLabelTimer.millisElapsed() > 50)
        {
           
                clickToPlay.makeOpaque();
                clickLabelTimer.mark();
            
        }
        else
        {
            if(clickLabelTimer.millisElapsed() > 1000)
            {
                clickToPlay.makeTransparent();
                clickLabelTimer.mark();
            }
        }
        
        if(textTimer.millisElapsed() > 10)
        {
            if(narration.isTransparent())
            {
                narration.makeOpaque();
            }
            else
            {
                narration.makeTransparent();
            }
            textTimer.mark();
            
        }
    /*        if(clickLabelTimer.millisElapsed() > 10)
        {
            if(clickToPlay.isTransparent())
            {
                clickToPlay.makeOpaque();
            }
            else
            {
                clickToPlay.makeTransparent();
            }
            textTimer.mark();
            
        }
        */
        
    }
}
