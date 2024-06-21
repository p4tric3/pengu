import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Write a description of class Robbe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robbe extends Enemy
{
    private int speed;
    private int leftTurn;
    private int rightTurn;
    
    private int timer = 0;
    private int image = 1;
    private int umdrehungsgeschwindigkeit = 0;
    
    public Robbe(int leftTurng, int rightTurng, int speedg)
    {
        speed = speedg;
        leftTurn = leftTurng;
        rightTurn = rightTurng;
    }
    /**
     * Act - do whatever the Robbe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation ( getX() + speed, getY() );
        
        Actor actor = getOneIntersectingObject(null);
        
        countdown();
    
        
        if(actor != null) {
            setLocation ( getX() + speed, getY() );
        }
        
        if (atTurningPoint()) {
            speed = -speed;
            //timer = 0;
        }
        drehen();
    }
    /**
     * Test if we are at one of the turning points.
     */
    public boolean atTurningPoint()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
    
    public void drehen()
    {   
        umdrehungsgeschwindigkeit = 32 / Math.abs(speed);
        
        if (speed < 0 && timer <= 0 && image == 7) {
            setImage("robbe7.png");
            timer = umdrehungsgeschwindigkeit;
            image = 6;
        }
        if (speed < 0 && timer <= 0 && image == 6) {
            setImage("robbe6.png");
            timer = umdrehungsgeschwindigkeit;
            image = 5;
        }
        if (speed < 0 && timer <= 0 && image == 5) {
            setImage("robbe5.png");
            timer = umdrehungsgeschwindigkeit;
            image = 4;
        }
        if (speed < 0 && timer <= 0 && image == 4) {
            setImage("robbe4.png");
            timer = umdrehungsgeschwindigkeit;
            image = 3;
        }
        if (speed < 0 && timer <= 0 && image == 3) {
            setImage("robbe3.png");
            timer = umdrehungsgeschwindigkeit;
            image = 2;
        }
        if (speed < 0 && timer <= 0 && image == 2) {
            setImage("robbe2.png");
            timer = umdrehungsgeschwindigkeit;
            image = 1;
        }
        if (speed < 0 && timer <= 0 && image == 1) {
            setImage("robbe1.png");
            timer = umdrehungsgeschwindigkeit;
            image = 0;
        }
        if (speed < 0 && timer <= 0 && image == 0) {
            setImage("robbe0.png");
            timer = umdrehungsgeschwindigkeit;
            image = 7;
        }
        
        if (speed > 0 && timer <= 0 && image == 1) {
            setImage("robbe1.png");
            timer = umdrehungsgeschwindigkeit;
            image = 2;
        }
        if (speed > 0 && timer <= 0 && image == 2) {
            setImage("robbe2.png");
            timer = umdrehungsgeschwindigkeit;
            image = 3;
        }
        if (speed > 0 && timer <= 0 && image == 3) {
            setImage("robbe3.png");
            timer = umdrehungsgeschwindigkeit;
            image = 4;
        }
        if (speed > 0 && timer <= 0 && image == 4) {
            setImage("robbe4.png");
            timer = umdrehungsgeschwindigkeit;
            image = 5;
        }
        if (speed > 0 && timer <= 0 && image == 5) {
            setImage("robbe5.png");
            timer = umdrehungsgeschwindigkeit;
            image = 6;
        }
        if (speed > 0 && timer <= 0 && image == 6) {
            setImage("robbe6.png");
            timer = umdrehungsgeschwindigkeit;
            image = 7;
        }
        if (speed > 0 && timer <= 0 && image == 7) {
            setImage("robbe7.png");
            timer = umdrehungsgeschwindigkeit;
            image = 0;
        }
        if (speed > 0 && timer <= 0 && image == 0) {
            setImage("robbe0.png");
            timer = umdrehungsgeschwindigkeit;
            image = 1;
        }
    }
    
    public void countdown(){
        timer = timer - 1;
    }
}
