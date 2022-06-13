import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    public boolean isFalling;
    public Heart(String filename,int x, int y, boolean isFalling)
    {
        GreenfootImage heart = new GreenfootImage("images/misc/" + filename + ".png");
        heart.scale(x, y);
        setImage(heart);
        this.isFalling = isFalling;
    }

    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isFalling){
            setLocation(getX(), getY() + 1);
        }
        if(getY() >= 370){
            getWorld().removeObject(this);
        }
    }
}
