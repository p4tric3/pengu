import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    private int y = 1100;
    private int part = 1;
    
    private Pengu pengu;
    
    public Level1()
    {    
        super(1488, 837, 1);    // define size and resolution
        addCliff(false, 85, y);
        addCliff(true, 665, y);
        addCliff(false, 830, y);
        addCliff(false, 830, 600);
        addCliff(true, 1300, y);
        addCliff(false, 1465, y);
        
        addCloud(270, 480, 4, 369, y-300);
        addCloud(1000, 1100, 4, 1069, y-300);
        
        screenshot();
        
        //addPengu(66, y-340);
        Pengu pinguin = new Pengu();
        addObject (pinguin, 766, 440 );
        pinguin.startLeben();
    }
    
    //All Map parts to add
    public void addCliff(Boolean flip, int x, int y){
        addObject ( new Cliff(flip), x, y);
    }
    
    public void addHugeCliff(Boolean flip, int x, int y){
        addObject ( new HugeCliff(flip), x, y);
    }
    
    public void addCloud(int minX, int maxX, int speed, int x, int y){
        addObject ( new Cloud(minX, maxX, speed), x, y);
    }
    
    public void addPengu(int x, int y){
        addObject ( new Pengu(), x, y);
    }
    
    //When Pengu is on the right the method is executed
    public void goRight(Pengu pengu)
    {
         //Unload all Objects
         removeObject(pengu);
         removeObjects(getObjects(Cliff.class));
         removeObjects(getObjects(HugeCliff.class));
         removeObjects(getObjects(Cloud.class));
         //Load next world
         loadNextWorld();
         screenshot();
         part++;
    }
    //Load next part
    public void loadNextWorld(){
        //Each Case is a new part of map        
        switch (part) {
            case 1:
                addObject ( new Cliff(false), 85, y);
                addObject ( new HugeCliff(false), 665, y);
                addObject ( new Cliff(false), 1285, y);
                break;
            case 2:
                addObject ( new Cliff(false), 85, y);
                addObject ( new HugeCliff(false), 665, y);
                addObject ( new HugeCliff(true), 1465, y);
                break;
            default:
                addCliff(false, 85, y);
                System.out.println("Welt Abgeschlossen");
                //Greenfoot.setWorld(new Weltenauswahl());
                //Go back to world selection
        }
        addObject ( new Pengu(), 66, y-340 );
    }
    
    public GreenfootImage screenshot()
    {
        GreenfootImage screenshot = getBackground();
        
        for (int x = 0; x < screenshot.getWidth(); x++) {
            for (int y = 0; y < screenshot.getHeight(); y++) {
                Color pixelFarbe = getColorAt(x, y);
                screenshot.setColorAt(x, y, new Color(pixelFarbe.getRed()-5, pixelFarbe.getGreen()-5, pixelFarbe.getBlue()-5, 255));
            }
        }
        
        setBackground(screenshot);
        
        return screenshot;
    }
    
    public void snowball(int sSpeed, int range, int yPos, int xPos)
    {
        addObject ( new Snowball(sSpeed), xPos, yPos);
        
    }
}
