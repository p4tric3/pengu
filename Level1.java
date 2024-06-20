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
    
    Pengu pinguin = new Pengu();
    
    public Level1()
    {    
        super(1488, 837, 1);    // define size and resolution
        pinguin.worldLevel = 1;
        addHugeCliff(false, 85, y);
        addHugeCliff(false, 1200, y);
        
        addCloud(460, 830, 4, y-300);
        addEnemy(305, 670);

        addObject (pinguin, 85, 670 );
        pinguin.startLeben();
        
        setBackground(new GreenfootImage("images/bg.png"));
    }
    
    //All Map parts to add
    public void addCliff(Boolean flip, int x, int y){
        addObject ( new Cliff(flip), x, y);
    }
    
    public void addHugeCliff(Boolean flip, int x, int y){
        addObject ( new HugeCliff(flip), x, y);
    }
    
    public void addCloud(int minX, int maxX, int speed, int y){
        addObject ( new Cloud(minX, maxX, speed), minX, y);
    }
    
    public void addPengu(int x, int y){
        addObject ( new Pengu(), x, y);
    }
    
    public void addEnemy(int x, int y){
        addObject ( new Enemy(), x, y);
    }
    
    //When Pengu is on the right the method is executed
    public void goRight(Pengu pengu)
    {
        //Unload all Objects

        pinguin.setLocation(66,640);
        removeObjects(getObjects(Cliff.class));
        removeObjects(getObjects(HugeCliff.class));
        removeObjects(getObjects(Cloud.class));
        //Load next world
        loadNextWorld();
        part++;
    }
    //Load next part
    public void loadNextWorld(){
        //Each Case is a new part of map        
        switch (part) {
            case 1:
                addCliff(false, 40, y);
                addHugeCliff(false, 420, y);
                addHugeCliff(false, 1100, y-330);
                break;
            case 2:
                addCliff(false, 50, y);
                addHugeCliff(false, 360, y);
                addCloud(740, 1060, 4, y-300);
                addHugeCliff(false, 1465, y);
                break;
            default:
                addCliff(false, 85, y);
                System.out.println("Welt Abgeschlossen");
                //Greenfoot.setWorld(new Weltenauswahl());
                //Go back to world selection
        }
        //addPengu(60, y-400);//addObject ( new Pengu(), 60, y-400 );
    }
    
    public void snowball(int sSpeed, int range, int yPos, int xPos)
    {
        addObject ( new Snowball(sSpeed), xPos, yPos);
    }
}
