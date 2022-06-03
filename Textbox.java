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
    private String[] dialogue;
    
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
        
        
        
    }
    int curIndex = 0;
    public void setDialogue(String text)
    {
        dialogue[curIndex] = text;
        curIndex ++;
    }
    
    public String getDialogue(int index)
    {
        return dialogue[index];
    }
    public int getDialogueLength()
    {
        return dialogue.length;
    }
}
