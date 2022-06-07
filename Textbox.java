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
    //private GreenfootImage[] textbox;
    private int curTextIndex = 0;
    private String[] texts;
    Label messageLabel;
    Color color;

    public Textbox(String[] texts, Color color){
        //this.textbox = new GreenfootImage(texts, 30, Color.BLACK, color);
        //setImage(this.text);
        this.texts = texts;
        this.color = color;
        /*
        for(int i = 0; i < texts.length; i++){
            this.textbox[i] = new GreenfootImage(texts[i], 30, Color.BLACK, color);
        }
        */

    }

    protected void addedToWorld(World world){
        messageLabel = new Label(texts[curTextIndex], 30);
        //messageLabel.setImage(texts[curTextIndex], 30, Color.WHITE, Color.CYAN);
        //world.addObject(messageLabel, 300, 350);
        
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(null)){
            if(curTextIndex < texts.length) {
                messageLabel.setValue(texts[curTextIndex]);
                curTextIndex++;
            } else {
                Player.canMove = true;
                getWorld().removeObject(this);
            }
            if(curTextIndex >= texts.length){
                getWorld().removeObject(this);
                Player.canMove = true;
            }
        }
    }

    public void add(Textbox textbox, World world)
    {
        world.addObject(textbox, 300, 350);

    }

    public void remove(Textbox textbox, World world)
    {
        world.removeObject(textbox);

    }

}
