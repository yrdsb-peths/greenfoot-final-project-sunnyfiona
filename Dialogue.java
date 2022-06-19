import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class adds a cycle of dialogue with a textbox and removes
 * after the player finishes.
 * 
 * @author Finny
 * @version June 16th, 2022
 */
public class Dialogue extends Actor
{
    
    //instance variables for cycling through dialogue messages
    private int curTextIndex = 0;
    private String[] texts;
    
    //instance variables for creating the textbox
    Label messageLabel;
    Textbox box; 
    
    /**
     * Constructor for the Dialogue box
     */
    public Dialogue(String[] texts){
    
        this.texts = texts;
        
    }
    /**
     * Method that adds the text with a textbox into a world
     */
    protected void addedToWorld(World world){
        box = new Textbox();
        world.addObject(box, 300, 330);
        
        messageLabel = new Label(texts[curTextIndex], 23);
        messageLabel.setLineColor(Color.GRAY);
        messageLabel.setFillColor(Color.BLACK);
        
        world.addObject(messageLabel, 300, 330);
    }
    /**
     * Act - allows the Dialogue to cycle through. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        if(Greenfoot.mouseClicked(box)){
            if(curTextIndex + 1 < texts.length) {
                Player.canMove = false;
                GameP.canMove = false;
                curTextIndex++;
                messageLabel.setValue(texts[curTextIndex]);
            } 
            else {
                Player.canMove = true;
                //getWorld().removeObject(this);
                messageLabel.setValue("");
                getWorld().removeObject(box);
            }
        }
        
    }
    
}