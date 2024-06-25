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
        //shoot();
    }
    
    public void damage(){
    
    }
    
    /**public void shoot()
    {
        int bSpeed = 15;
        Level1 level1 = (Level1) getWorld();
        level1.bullet(bSpeed, getY(), getX());
    }*/
}
