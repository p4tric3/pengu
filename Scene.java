import greenfoot.*; 

/**
 * This is the whole scene. It creates and contains the objects that are in it.
 */
public class Scene extends World
{
    private int y = 1100;
    private int part = 1;

    private Pengu pengu;
    
    public Scene()
    {    
        super(1488, 837, 1);    // define size and resolution
        addCliff(false, 85, y);
        addCliff(true, 665, y);
        addCliff(true, 730, y-330);
        addCliff(true, 730, y-400);
        addCliff(true, 730, y-470);
        addCliff(false, 830, y);
        addCliff(true, 1300, y);
        addCliff(false, 1465, y);
        
        addCloud(270, 480, 4, 369, y-300);
        addCloud(1000, 1100, 4, 1069, y-300);
        
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
         part++;
    }
    //Load next part
    public void loadNextWorld(){
        //Each Case is a new part of map        
        switch (part) {
            case 1:
                addCliff(false, 85, y);
                addHugeCliff(false, 665, y);
                addCliff(false, 1285, y);
                break;
            case 2:
                addCliff(false, 85, y);
                addHugeCliff(false, 665, y);
                addHugeCliff(true, 1465, y);
                break;
            default:
                addCliff(false, 85, y);
                System.out.println("Welt Abgeschlossen");
                //Go back to world selection
        }
        addObject ( new Pengu(), 66, y-340 );
    }
}