import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weltenauswahl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weltenauswahl extends World
{
    private int buttonBreite = 380;
    private int buttonHoehe = 300;
    
    public Weltenauswahl()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1488, 837, 1);
        
        setBackground("titlebg.png");
        
        addObject ( new Button(buttonBreite, buttonHoehe, 1, "buttonWelt1.png"), 1488/2 - (buttonBreite + 50), 560);
        addObject ( new Button(buttonBreite, buttonHoehe, 2, "buttonWelt2.png"), 1488/2, 560);
        addObject ( new Button(buttonBreite, buttonHoehe, 3, "buttonWelt3.png"), 1488/2 + (buttonBreite + 50), 560);
        
        addObject ( new Title(519, 129), 1488/2, 250);
    }
}
