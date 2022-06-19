import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the ending screen that the player enters when the game is 
 * over. The player does not have the choice to return to the game.
 * 
 * @author Finny 
 * @version June 17th, 2022
 */
public class EndScreen extends World
{

    // used for images in world
    private GreenfootImage[] endScreen;
    
    // used for gameplay
    private SimpleTimer animTimer;
    private SimpleTimer textTimer;
    private SimpleTimer clickLabelTimer;
    private Label narration;
    private Label clickToPlay;
    
    // sounds
    GreenfootSound loaded = new GreenfootSound("sounds/title-screen-loaded.mp3");
    GreenfootSound ambient = new GreenfootSound("sounds/title-screen-ambient.mp3");
        
    /**
     * Constructor for objects of class endScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        endScreen = new GreenfootImage[3];
        for(int i = 0; i < endScreen.length; i++)
        {
            endScreen[i] = new GreenfootImage("images/bg/title-screen/title-screen-" + i + ".png");
            endScreen[i].scale(endScreen[i].getWidth() / 3, endScreen[i].getHeight() / 3);
        }
        setBackground(endScreen[0]);
        animTimer = new SimpleTimer();
        animTimer.mark();
        
        narration = new Label("after a long day, you look upon the horizon \n left with nothing but your own thoughts", 25);
        narration.setLineColor(Color.GRAY);
        narration.setFillColor(Color.WHITE);
        addObject(narration, 300, 200);
        textTimer = new SimpleTimer();
        clickLabelTimer = new SimpleTimer();
        clickLabelTimer.mark();
        textTimer.mark();
        
        clickToPlay = new Label("[FIN]", 25);
        addObject(clickToPlay, 300, 350);
        
        
    }
    /**
     * Method that starts looping the backgroun music.
     */
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
        
    }
    
    int curIndex = 0;
    /**
     * Animates the background image.
     */
    public void animateBG()
    {
        if(animTimer.millisElapsed() > 250)
        {
            setBackground(endScreen[curIndex]);
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
   
    }

}
