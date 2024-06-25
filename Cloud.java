import greenfoot.*; 

/**
 * A cloud that moves back and forth between two defined points.
 */
public class Cloud extends Actor
{
    private int speed;
    private int leftTurn;
    private int rightTurn;

    /**
     * Move in the direction we are currently moving in. Turn if we reach a turning point.
     */
    public Cloud(int leftTurng, int rightTurng, int speedg)
    {
        GreenfootImage bild = new GreenfootImage("ice-floe.png");
        bild.scale(200, 40);
        setImage(bild);
        speed = speedg;
        leftTurn = leftTurng;
        rightTurn = rightTurng;
    }
    
    public void act() 
    {
        setLocation ( getX() + speed, getY() );
        
        Actor actor = getOneIntersectingObject(null);
    
        
        if(actor != null) {
            actor.setLocation ( actor.getX() + speed, actor.getY() );
        }
        
        if (atTurningPoint()) {
            speed = -speed;
        }
    }
    
    /**
     * Test if we are at one of the turning points.
     */
    public boolean atTurningPoint()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
    
    
}
