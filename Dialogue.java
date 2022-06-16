import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialogue extends Actor
{
    
    //private GreenfootImage text;
    private int curTextIndex = 0;
    private String[] texts;
    //private Color color;
    Label messageLabel;
    
    Textbox box; 

    public Dialogue(String[] texts){
        //this.text = new GreenfootImage(text, 30, Color.BLACK, color);
        //setImage(this.text);

            
        this.texts = texts;
        //this.color = color;
    }
    
    protected void addedToWorld(World world){
        box = new Textbox();
        world.addObject(box, 300, 330);
        
        messageLabel = new Label(texts[curTextIndex], 23);
        messageLabel.setLineColor(Color.GRAY);
        messageLabel.setFillColor(Color.BLACK);
        //setImage(messageLabel);
        world.addObject(messageLabel, 300, 330);
    }

    public void act()
    {
        
        if(Greenfoot.mouseClicked(box)){
            if(curTextIndex + 1 < texts.length) {
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
        if(Player.canMove){

        }
    }

    public void add(Dialogue text, World world)
    {
        world.addObject(text, 300, 350);

    }

    public void remove(Dialogue text, World world)
    {
        world.removeObject(text);

    }

}