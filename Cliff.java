import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Cliff extends Actor
{
    public Cliff()
    {
    }
    
    public Cliff(boolean flip)
    {
        if (flip) {
            getImage().mirrorHorizontally();
        }
    }
    
    public void act() 
    {
        // No action required - the cliff doesn't do anything
    }    
}
