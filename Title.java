import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    public Title(int breite, int höhe)
    {
        // Setze das Bild für den Button
        GreenfootImage bild = new GreenfootImage("logo.png");
        bild.scale(breite, höhe); // Passe die Größe des Bildes an
        setImage(bild);
    }
}
