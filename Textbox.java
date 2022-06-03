import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textbox extends Actor
{
    private static GreenfootImage box = new GreenfootImage("images/misc/textbox.png");
    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Textbox()
    {
        box.scale(500, 150);
        setImage(box);
        
    }
    public void act()
    {
        // Add your action code here.
    }
}
