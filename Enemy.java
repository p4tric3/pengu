import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Mover
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemy()
    {
        GreenfootImage bild = new GreenfootImage("red-background.png");
        bild.scale(100, 200); // Passe die Größe des Bildes an
        setImage(bild);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void damage(){
    
    }
}
