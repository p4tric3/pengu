import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{

    private int y = 1100;
    private int part = 1;
    
    Pengu pinguin = new Pengu();
    HealthBar HealthBar = new HealthBar(100, 500, 30);
    
    public Level3()
    {    
        super(1488, 837, 1);    // define size and resolution
        pinguin.worldLevel = 3;
        addCliff(false, 50, y-325);
        addCloud(200, 400, 7, y-300);
        addCliff(false, 550, y);
        addCloud(700, 800, 3, y-300);
        addCliff(false, 950, y);
        addCloud(1100, 1300, 6, y-300);
        addCliff(false, 1450, y-325);
        
        //addObject( HealthBar, 1488/2 , 30);
        addObject(HealthBar, 1488/2, 30);
        
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

        //pinguin.setLocation(66,640);
        //removeObjects(getObjects(Cliff.class));
        //removeObjects(getObjects(HugeCliff.class));
        //removeObjects(getObjects(Cloud.class));
        //Load next world
        //loadNextWorld();
        //part++;
    }
    //Load next part
    /*public void loadNextWorld(){
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
    }*/
    
    public void snowball(int sSpeed, int range, int yPos, int xPos)
    {
        addObject ( new Snowball(sSpeed), xPos, yPos);
    }
    
    public void snowballHit(){
        HealthBar.updateHealth(-1);
        if(HealthBar.health <= 0){
            System.out.print("Gewonnen");
        }
    }
}

