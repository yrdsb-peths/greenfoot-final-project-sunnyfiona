import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Object Player cannot walk through
 * 
 * @author Finny
 * @version June 17, 2022
 */

public class Wall extends Actor
{
    GreenfootImage image;
    
    /**
     * Default constructor (sets the image)
     * 
     * @param imageName name of the png file in Walls folder from Images
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
     * 
     * @param imageName name of the png file in Walls folder from Images
     * @param scale the number added to the width and height of the image
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
     * 
     * @param imageName name of the png file in Walls folder from Images
     * @param scaleX the number added to the width of the image
     * @param scaleY the number added to the height of the image
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
}
