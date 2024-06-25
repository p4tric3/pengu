import greenfoot.*;

/**
 * A little penguin that wants to get to the other side.
 */
public class Pengu extends Mover
{
    private int jumpStrength = 16;
    private int jumpCount = 0;
    private int rutschCount = 0;
    public int moveSpeed = 7;
    public static boolean changeWorld = false;

    private Live leben1;
    private Live leben2;
    private Live leben3; 
    private int anzahlLive = 0;
    
    private GreenfootImage penguRight = new GreenfootImage("pengu-right.png");
    private GreenfootImage penguLeft = new GreenfootImage("pengu-left.png");
    private GreenfootImage penguSlideLeft = new GreenfootImage("pengu-slide-left-3.png");
    private GreenfootImage penguSlideRight = new GreenfootImage("pengu-slide-right-3.png");
    private GreenfootImage hiddenImage = null;

    private int timerDamage = 0;
    private int counterImage = 0;
    private int counterImageSteps = 3;
    private int blinkPhase = 0;
    
    public int worldLevel = 1;
    
    public void act() 
    {
        if (!changeWorld){
            checkKeys();        
            checkFall();
            checkPosition();
            checkGegner();
            if(timerDamage >= 0)
            {
                timerDamage--;
            }
            onGround();
            checkOnGround();
            countdownDamage();
            manageImages();
        }
    }
    public void checkKeys()
    {
        int moveSpeed = 7; // Adjust this value as needed
        int bounceOffset = moveSpeed * 15; // Adjust this value for the bounce distance

        if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(new Hauptmenue());
        }
        if (Greenfoot.isKeyDown("a") && timerDamage < 0) {
            if (!isTouchingWall(-moveSpeed, 0)) {
                setLocation(getX() - moveSpeed, getY()); // Manually adjust position
            }
        }
        if (Greenfoot.isKeyDown("a") && timerDamage > 0) {
            if (!isTouchingWall(-moveSpeed, 0)) {
                setLocation(getX() - moveSpeed, getY()); // Manually adjust position
            }
        }
        if (Greenfoot.isKeyDown("d") && timerDamage < 0) {
            if (!isTouchingWall(moveSpeed, 0)) {
                setLocation(getX() + moveSpeed, getY()); // Manually adjust position
            }
        }
        if (Greenfoot.isKeyDown("d") && timerDamage > 0) {
            if (!isTouchingWall(moveSpeed, 0)) {
                setLocation(getX() + moveSpeed, getY()); // Manually adjust position
            }
        }
        if (Greenfoot.isKeyDown("d") && timerDamage > 0) {
            setImage("wounded-pengu-right.png");
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
            }
            /* else if (isTouchingWall(-moveSpeed, 0) && Greenfoot.isKeyDown("space")) {
                smoothWallJump(bounceOffset, -jumpStrength); 
            } else if (isTouchingWall(moveSpeed, 0) && Greenfoot.isKeyDown("space")) {
                smoothWallJump(-bounceOffset, -jumpStrength);
            } else if (isTouchingWall(-moveSpeed, 0) && !onGround() && Greenfoot.isKeyDown("space")) {
                smoothWallJump(bounceOffset, -jumpStrength); 
            } else if (isTouchingWall(moveSpeed, 0) && !onGround() && Greenfoot.isKeyDown("space")) {
                smoothWallJump(-bounceOffset, -jumpStrength);
            }*/
        }
    }
    
    private int moveSpeed()
    {
        return moveSpeed;
    }
    
    private int rutschCount()
    {
        return rutschCount;
    }
    
    public void manageImages()
    {
        int a = 13;
        
        
        if(timerDamage > 0)
        {
            if((double) counterImage/counterImageSteps == counterImage/counterImageSteps)
            {
                blinkPhase++;
                //System.out.print((double)counter + ", " + counterSteps + "\n");
            }
            if((double) blinkPhase/a == (int) blinkPhase/a && Greenfoot.isKeyDown("a"))
            {
                setImage("wounded-pengu-left.png");
            }
            else if((double) blinkPhase/a == (int) blinkPhase/a && Greenfoot.isKeyDown("d"))
            {
                setImage("wounded-pengu-right.png");
            }
            else if((double) blinkPhase/a != (int) blinkPhase/a && Greenfoot.isKeyDown("a"))
            {
                setImage("pengu-left.png");
            }
            else if((double) blinkPhase/a != (int) blinkPhase/a && Greenfoot.isKeyDown("d"))
            {
                setImage("pengu-right.png");
            }
        }
        else
        {
            if(Greenfoot.isKeyDown("a"))
            {
                setImage("pengu-left.png");
            }
            else if(Greenfoot.isKeyDown("d"))
            {
                setImage("pengu-right.png");
            }
             if (Greenfoot.isKeyDown("control") && Greenfoot.isKeyDown("d"))
            {
                penguSlideRight.scale(120, 120);
                setImage(penguSlideRight);
                if(rutschCount() > 0)
                {
                    moveSpeed = 14;
                }
                rutschCount++;
            }
             if (Greenfoot.isKeyDown("control") && Greenfoot.isKeyDown("a"))
            {
                penguSlideLeft.scale(120, 120);
                setImage(penguSlideLeft);
            }
             if(rutschCount() > 0)
            {
                moveSpeed = 14;
            }
            rutschCount++;
        }
        if (rutschCount() > 0)
        {
            moveSpeed = moveSpeed - 1;
            if(moveSpeed() > 8)
            {
                rutschCount = -60;
            }
        }
        if (moveSpeed() > 8)
        {
            moveSpeed = moveSpeed - 1;
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
        if (getX() > 1400 && this.worldLevel == 1) 
        {
            Level1 level1 = (Level1) getWorld();
            level1.goRight(this);
        }
    }
    
    private void jump()
    {
        if (!isTouchingWall(0, -getImage().getHeight() / 2)) {
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
        if(this.worldLevel == 1){
            Level1 level1 = (Level1) getWorld();
            level1.snowball(sSpeed, range, getY(), getX());
        }else if(this.worldLevel == 3){
            Level3 level3 = (Level3) getWorld();
            level3.snowball(sSpeed, range, getY(), getX());
            level3.snowballHit();
        }
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
            Greenfoot.setWorld(new TodMenue());
        }
    }
    
    public void startLeben()
    {
        addLeben();
        addLeben();
        addLeben();
    }

    public void checkGegner(){
        
        
        if (isTouching(Bullet.class)){
            if (timerDamage<=0){
                removeLeben();
                if (this.worldLevel == 1) 
                {
                    Level1 level1 = (Level1) getWorld();
                    level1.removeObject(getOneIntersectingObject(Bullet.class));
                }
                else if (this.worldLevel == 3) 
                {
                    Level3 level3 = (Level3) getWorld();
                    level3.removeObject(getOneIntersectingObject(Bullet.class));
                }
                timerDamage = 100;
            }
        }
    }
    
    public void countdownDamage(){
        timerDamage = timerDamage - 1;
    }
}


  