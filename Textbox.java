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
    Label messagelabel;

    public Textbox(String[] texts, Color color){
        //this.text = new GreenfootImage(text, 30, Color.BLACK, color);
        //setImage(this.text);
        this.texts = texts;
        messagelabel = new Label(texts[curTextIndex], 30);

    }

    protected void addedToWorld(World world){
        messagelabel = new Label(texts[curTextIndex], 30);
        world.addObject(messagelabel, world.getWidth()/2, world.getHeight()/2);
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            if(curTextIndex < texts.length) {
                curTextIndex++;
                messagelabel.setValue(texts[curTextIndex]);
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
