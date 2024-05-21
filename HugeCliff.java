import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class HugeCliff extends Actor
{
    public HugeCliff()
    {
    }
    
    public HugeCliff(boolean flip)
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
