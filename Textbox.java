import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Textbox that accompanies dialogue
 * 
 * @author Finny
 * @version June 16th, 2022
 */
public class Textbox extends Actor
{
    /**
     * constructor for textbox
     */
    public Textbox(){
        GreenfootImage box = new GreenfootImage("images/misc/textbox.png");
        box.scale(box.getWidth(), box.getHeight() / 2);
        setImage(box);
        
    
    }
    /**
     * Act - do whatever the Textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}


