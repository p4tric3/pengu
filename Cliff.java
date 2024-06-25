import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Cliff extends Actor
{
    public Cliff()
    {
        GreenfootImage bild = new GreenfootImage("ice-cliff.png");
        bild.scale(200, 40);
        setImage(bild);
    }
    
    public Cliff(boolean flip)
    {
        GreenfootImage bild = new GreenfootImage("ice-cliff.png");
        bild.scale(200, 40);
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
