import greenfoot.*;

public class HealthBar extends Actor
{
    private int screen;
    
    // Konstruktor für den HealthBar
    public HealthBar(int breite, int höhe, int a, String image)
    {
        // Setze das Bild für den HealthBar
        screen = a;
        GreenfootImage bild = new GreenfootImage(image);
        bild.scale(breite, höhe); // Passe die Größe des Bildes an
        setImage(bild);
    }
    
    
    
    // Methode, um zu überprüfen, ob der HealthBar geklickt wurde
    public void klicke(int a)
    {
        Level3 level3 = new Level3();
        if (Greenfoot.mouseClicked(this))
        {
             level3.snowballHit();
        }
    }
    
    // Die Methode act wird jeden Aktualisierungszyklus aufgerufen
    public void act()
    {
        // Überprüfe, ob der HealthBar geklickt wurde
        klicke(screen);
    }
}
