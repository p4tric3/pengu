import greenfoot.*; 

/**
 * This is the whole scene. It creates and contains the objects that are in it.
 */
public class Hauptmenue extends World
{
    private int y = 1100;
    private int part = 1;
    private int buttonBreite = 200;
    private int buttonHoehe = 50;

    public Hauptmenue()
    {    
        super(1488, 837, 1);    // define size and resolution

        addObject ( new Button(buttonBreite, buttonHoehe, 1), 1488/2, 450);
        addObject ( new Button(buttonBreite, buttonHoehe, 2), 1488/2, 520);
        addObject ( new Button(buttonBreite, buttonHoehe, 3), 1488/2, 590);
        addObject ( new Title(450, 160), 1488/2, 250);

        setBackground("Blackscreen.jpg");
        checkKeys();
        prepare();
        
        GreenfootSound titlescreen = new GreenfootSound("Title.mp3");
        titlescreen.playLoop();
        titlescreen.setVolume(0);
    }

    private void checkKeys()
    {
        if (Greenfoot.mouseClicked(this) )
        {
            wechsleZuLevel1();
        }
        if (part == 2)
        {
            wechsleZuLevel1();
        }
    }    

    public void wechsleZuLevel1() {
        Greenfoot.setWorld(new Level1());
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}