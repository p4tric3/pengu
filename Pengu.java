import greenfoot.*;

/**
 * A little penguin that wants to get to the other side.
 */
public class Pengu extends Mover
{
    private static final int jumpStrength = 24;
    private int jumpCount = 0;

    private Live leben1;
    private Live leben2;
    private Live leben3; 
    private int anzahlLive = 0;

    private int timer = 0;
    
    public Level1 uebergeben()
    {
        Level1 level1 = (Level1) getWorld();
        return level1;
    }
    
    public void act() 
    {
        checkKeys();        
        checkFall();
        checkPosition();
        //checkGegner();
        onGround();
        checkOnGround();
    }
    
    private void checkKeys()
    {
        int moveSpeed = 5; // Adjust this value as needed
        int bounceOffset = moveSpeed * 15; // Adjust this value for the bounce distance
        
        if (Greenfoot.isKeyDown("a")) {
            setImage("pengu-left.png");
            if (!isTouchingWall(-moveSpeed, 0)) {
                setLocation(getX() - moveSpeed, getY()); // Manually adjust position
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            setImage("pengu-right.png");
            if (!isTouchingWall(moveSpeed, 0)) {
                setLocation(getX() + moveSpeed, getY()); // Manually adjust position
            }
        }
        if (Greenfoot.isKeyDown("space") )
        {
            if (onGround())
                jump();
            if(!onGround() && getVSpeed() > 0 && jumpCount == 0)
            {
                jump();
                jumpCount++;
            }
            if (onGround() && !isTouchingWall(0, -getImage().getHeight() / 2)) {
                jump();
            } else if (isTouchingWall(-moveSpeed, 0) && Greenfoot.isKeyDown("space")) {
                smoothWallJump(bounceOffset, -jumpStrength); 
            } else if (isTouchingWall(moveSpeed, 0) && Greenfoot.isKeyDown("space")) {
                smoothWallJump(-bounceOffset, -jumpStrength);
            } else if (isTouchingWall(-moveSpeed, 0) && !onGround() && Greenfoot.isKeyDown("space")) {
                smoothWallJump(bounceOffset, -jumpStrength); 
            } else if (isTouchingWall(moveSpeed, 0) && !onGround() && Greenfoot.isKeyDown("space")) {
                smoothWallJump(-bounceOffset, -jumpStrength);
            }
        }
        if (Greenfoot.isKeyDown("shift"))
        {
            snowball(15, 100);
        }
    }    
    
    private void smoothWallJump(int xOffset, int ySpeed) {
        for (int i = 0; i < 5; i++) { // Adjust the number of frames for smoother motion
            setLocation(getX() + xOffset / 4, getY()); // Move gradually
            Greenfoot.delay(1); // Delay for smoother animation
        }
        setVSpeed(ySpeed); // Set the vertical speed
        fall(); // Trigger falling motion
    }

    private boolean isTouchingWall(int dx, int dy) {
        Actor actor = getOneObjectAtOffset(dx, dy, null); // Check for any object
        return actor != null;
    }

    public void checkPosition() 
    {
        if (getX() > 1400) 
        {
            Level1 level1 = (Level1) getWorld();
            level1.goRight(this);
        }
    }
    
    private void jump()
    {
        if (onGround() && !isTouchingWall(0, -getImage().getHeight() / 2)) {
            setVSpeed(-jumpStrength);
            fall();
        }
    }
    
    private void checkFall()
    {
        if (onGround()) {
            setVSpeed(0);
        }
        else {
            fall();
            fallDamage();
        }
    }
    
    public void snowball(int sSpeed, int range)
    {
        Level1 level1 = (Level1) getWorld();
        level1.snowball(sSpeed, range, getY(), getX());
    }
    
    public void checkOnGround()
    {        
        if(onGround())
        {
            jumpCount = 0;
        }
    }
    
    private boolean fallDamage()
    {
        if(getY()>800){
            removeLeben();
            setLocation(66,640);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
    * Diese Methode erstellt bis zu drei Leben 
    */
    public void addLeben()
    {
        World welt1;
        welt1 = getWorld();
        if(anzahlLive == 0){
            leben1= new Live();
            welt1.addObject(leben1, 1450, 30);
        }
        else if(anzahlLive == 1){
            leben2= new Live();
            welt1.addObject(leben2, 1395, 30);
        }
        else if(anzahlLive == 2){
            leben3= new Live();
            welt1.addObject(leben3, 1340, 30);
        }
        if(anzahlLive <= 2){
                anzahlLive = anzahlLive + 1;    
            }
        else if (anzahlLive == 3 ){
                anzahlLive = anzahlLive;
        }
    }
    
    /**
    * Diese Methode lässt einen die erstellten Leben wieder löschen 
    */
    public void removeLeben()
    {
        World welt1;
        welt1 = getWorld();
        if(anzahlLive == 3){
            welt1.removeObject(leben3);
        }
        else if(anzahlLive == 2){
            welt1.removeObject(leben2);
        }
        else if(anzahlLive == 1){
            welt1.removeObject(leben1);
        }
        if(anzahlLive >= 1){
            anzahlLive = anzahlLive - 1;    
        }
        else if (anzahlLive == 0 ){
            anzahlLive = anzahlLive; 
        }
    }
    
    public void startLeben()
    {
        addLeben();
        addLeben();
        addLeben();
    }

    /*public void checkGegner(){
        if(isTouching(Enemy.class)){
            removeLeben();
            timer = 3;
        }
    }*/
} 


  