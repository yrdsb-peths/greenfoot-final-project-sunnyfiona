import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    /**
     * Default constructor - sets the image.
     */
    public Wall(String imageName)
    {
        GreenfootImage image = new GreenfootImage("images/" + imageName + ".png");
        setImage(image);
    }
    /**
     * Constructor - sets the image and scales it.
     * when the scale is negative, image is shrunk.
     * when the scale is positive, image is enlarged.
     */
    public Wall(String imageName, int scale)
    {
        GreenfootImage image = new GreenfootImage("images/" + imageName + ".png");
        setImage(image);
        
        image.scale(image.getWidth() + scale, image.getHeight() + scale);
    }
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
