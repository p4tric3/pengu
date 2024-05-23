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
        
        setBackground("Blackscreen.jpg");
        
        addObject ( new Button(buttonBreite, buttonHoehe, 1), 1488/2 - (buttonBreite + 50), 560);
        addObject ( new Button(buttonBreite, buttonHoehe, 2), 1488/2, 560);
        addObject ( new Button(buttonBreite, buttonHoehe, 3), 1488/2 + (buttonBreite + 50), 560);
        
        addObject ( new Title(450, 160), 1488/2, 250);
    }
}
