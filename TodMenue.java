import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TodMenue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TodMenue extends World
{

    private int buttonBreite = 300;
    private int buttonHoehe = 50;

    public TodMenue()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1488, 837, 1);
        
        addObject ( new Button(buttonBreite, buttonHoehe, 1, "buttonStart.png"), 1488/2, 450);
        addObject ( new Button(buttonBreite, buttonHoehe, 2, "buttonWelten.png"), 1488/2, 520);
        
        addObject ( new Title(519, 129), 1488/2, 250);
        
        //Pengu pengu = (Pengu) getActor();
        
        //Level1 level1 = pengu.uebergeben();
        
        GreenfootImage hintergrund = getBackground();
        //setBackground(Level1.screenshot());
    }
}
