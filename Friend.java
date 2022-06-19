import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Friend here.
 * 
 * @author Finny
 * @version June 17, 2022
 */
public class Friend extends Actor
{
    // instance variables for animation
    GreenfootImage[] frontAnim = new GreenfootImage[4];
    SimpleTimer animTimer;
    
    //instance variable for obtaining file name
    private String name;
    
    
    //private boolean isFacingRight = true;
    //public boolean exit = false;
    /**
     * Constructor for the class. Sets the images of the NPCs 
     * and sets the animations.
     */
    public Friend(String name){
        this.name = name;
        for(int i = 0; i < frontAnim.length; i++){
            frontAnim[i] = new GreenfootImage("images/" + name + "/" + name + "-" + i + ".png");
        }
        setImage(frontAnim[0]);
        animTimer = new SimpleTimer();
        animTimer.mark();
    }
    /**
     * Act - do whatever the Friend wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animate();
        
    }
    
    /**
     * Moves friend around world
     * 
     * @param world which world friend is in
     * @param x desired horizontal position in coordinates
     * @param y desired vertical position in coordinates
     */
    public void walk(World world, int x, int y){
        if(getX() > x)
        {
            this.setLocation(getX() - 2, getY());
        } 
        else if(getX() < x)
        {
            this.setLocation(getX() + 2, getY());
        }else
        {
        //nothing happens
        }
        if(getY() > y)
        {
            this.setLocation(getX(), getY() - 2);
        } 
        else if(getY() < y){
            this.setLocation(getX(), getY() + 2);
        }else{}
    }
    /**
     * Scales images smaller (divides the image size of the friend by the factor)
     * 
     * @param factor the number the friend image will be divided by
     */
    public void scaleSmaller(int factor)
    {
        
       for(int i = 0; i < frontAnim.length; i++){
           frontAnim[i].scale(frontAnim[i].getWidth() / factor, frontAnim[i].getHeight() / factor);
       }
       setImage(frontAnim[0]);
    }

    int curIndex = 0;
    /**
     * Animates the image of friend
     */
    public void animate()
    {
        
       if(animTimer.millisElapsed() > 150){
           setImage(frontAnim[curIndex]);
           curIndex++;
           curIndex %= 4;
           animTimer.mark();
       }
    }
}
