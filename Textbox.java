import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textbox extends Actor
{
    //private static GreenfootImage box = new GreenfootImage("images/misc/textbox.png");
    private GreenfootImage text;
    private static boolean pause = false;
    
    public Textbox(String text, Color color){
        this.text = new GreenfootImage(text, 30, Color.BLACK, color);
        setImage(this.text);
        pause = false;
    }
    
    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        
    }
    
    public void add(Textbox textbox, World world)
    {
        world.addObject(textbox, 300, 350);
        pause = true;
    }
    public void remove(Textbox textbox, World world)
    {
        world.removeObject(textbox);
        pause = false;
    }
    
    public static boolean getPause()
    {
        return pause;
    }
}
