import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
    Pengu pengu1 = new Pengu();
    //private int aim;
    //private int xStep;
    //private int yStep;
    
    /**public Bullet(int speedg, int dPos, int dX, int dY)
    {
        speed = speedg;
        
        int a = dPos/speedg;
        
        xStep = dX/a;
        
        yStep = dY/a;
        
        //aim = (int) Math.sqrt(Math.pow((getX() - pengu.getX()), 2) + Math.pow((getY() - pengu.getY()), 2));
    }*/
    
    public Bullet(int speedg)
    {
        GreenfootImage bild = new GreenfootImage("Blackscreen.png");
        bild.scale(15, 15);
        setImage(bild);
        speed = speedg;
    }
    
    public void act()
    {
        setLocation(getX() - speed, getY());
        Level1 level1 = (Level1) getWorld();
        
        if(getX() < 50)
        {
            level1.removeObject(this);
        }
    }
}