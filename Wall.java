import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Wall extends Actor
{
    GreenfootImage image;
    
    /**
     * Default constructor - sets the image.
     */
    public Wall(String imageName)
    {
        image = new GreenfootImage("images/walls/" + imageName + ".png");
        setImage(image);
    }
    /**
     * Constructor - sets the image and scales it.
     * when the scale is negative, image is shrunk.
     * when the scale is positive, image is enlarged.
     */
    public Wall(String imageName, int scale)
    {
        GreenfootImage image = new GreenfootImage("images/walls/" + imageName + ".png");
        setImage(image);
        
        image.scale(image.getWidth() + scale, image.getHeight() + scale);
    }
    
    /**
     * Constructor - sets the image and scales x and y differently.
     * when the scale is negative, image is shrunk.
     * when the scale is positive, image is enlarged.
     */
    public Wall(String imageName, int scaleX, int scaleY)
    {
        GreenfootImage image = new GreenfootImage("images/walls/" + imageName + ".png");
        setImage(image);
        
        image.scale(image.getWidth() + scaleX, image.getHeight() + scaleY);
    }
    
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    public void buildWall()
    {
        
        
    }
}
