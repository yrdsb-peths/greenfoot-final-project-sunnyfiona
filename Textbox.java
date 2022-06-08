import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Textbox extends Actor
{
    public Textbox(){
        GreenfootImage box = new GreenfootImage("images/misc/textbox.png");
        setImage("images/misc/textbox.png");
    
    }
    /**
     * Act - do whatever the Texbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!Player.canMove){
            
        }// Add your action code here.
    }
}


