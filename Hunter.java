import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hunter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hunter extends Mover
{
    /**
     * Act - do whatever the Hunter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Hunter()
    {
        GreenfootImage bild = new GreenfootImage("hunter-3.png");
        bild.scale(130, 200); // Passe die Größe des Bildes an
        setImage(bild);
    }
    
    public void act()
    {
        shoot();
    }
    
    public void damage()
    {
        
    }
    
    public void shoot()
    {
        Level1 level1 = (Level1) getWorld();
        level1.bullet(getX() - 55, getY() - 15);
        sleepFor(60);
        //level1.calcDistanceEnemyToPlayer();
    }
}