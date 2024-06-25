import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class HugeCliff extends Actor
{
    public HugeCliff()
    {
        GreenfootImage bild = new GreenfootImage("hugecliff.png");
        setImage(bild);
    }
    
    public HugeCliff(boolean flip)
    {
        GreenfootImage bild = new GreenfootImage("hugecliff.png");
        setImage(bild);
        if (flip) {
            getImage().mirrorHorizontally();
        }
    }
    
    public void act() 
    {
        // No action required - the cliff doesn't do anything
    }    
}
