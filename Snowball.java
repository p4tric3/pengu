import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snowball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snowball extends Actor
{
    private int speed;
    private int gravity = -10;
    private int counter = 0;
    private int counterSteps = 3;
    
    public Snowball(int speedg)
    {
        // Setze das Bild für den Button
        GreenfootImage bild = new GreenfootImage("red-background.png");
        bild.scale(10, 10); // Passe die Größe des Bildes an
        setImage(bild);
        speed = speedg;
    }
    
    public void act() 
    {
        setLocation ( getX() + speed, getY() + gravity);
        
        if(getOneIntersectingObject(null) != null && getOneIntersectingObject(Pengu.class) == null)
        {
            World world1 = (World) getWorld();
            world1.removeObject(this);
        }
        
        if((double) counter/counterSteps == counter/counterSteps)
        {
            gravity++;
            //System.out.print((double)counter + ", " + counterSteps + "\n");
        }
        
        counter++;
    }
}
