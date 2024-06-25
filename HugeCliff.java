import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class HugeCliff extends Actor
{
    public HugeCliff()
    {
        GreenfootImage bild = new GreenfootImage("ice-cliff.png");
        bild.scale(550, 400);
        setImage(bild);
    }
    
    public HugeCliff(boolean flip)
    {
        GreenfootImage bild = new GreenfootImage("ice-cliff.png");
        bild.scale(550, 400);
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
