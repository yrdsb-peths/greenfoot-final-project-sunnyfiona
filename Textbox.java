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
    private int curTextIndex = 0;
    private String[] texts;
    Label messageLabel;

    public Textbox(String[] texts, Color color){
        //this.text = new GreenfootImage(text, 30, Color.BLACK, color);
        //setImage(this.text);
        this.texts = texts;


    }

    protected void addedToWorld(World world){
        messageLabel = new Label(texts[curTextIndex], 30);
        world.addObject(messageLabel, world.getWidth()/2, world.getHeight()/2);
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
