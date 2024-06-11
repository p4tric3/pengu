import greenfoot.*;

public class Button extends Actor
{
    private int screen;
    
    // Konstruktor für den Button
    public Button(int breite, int höhe, int a, String image)
    {
        // Setze das Bild für den Button
        screen = a;
        GreenfootImage bild = new GreenfootImage(image);
        bild.scale(breite, höhe); // Passe die Größe des Bildes an
        setImage(bild);
    }
    
    // Methode, um zu überprüfen, ob der Button geklickt wurde
    public void klicke(int a)
    {
        if (Greenfoot.mouseClicked(this))
        {
            switch(a)
            {
                case 1: 
                    Greenfoot.setWorld(new Level1());
                    break;
                case 2: 
                    Greenfoot.setWorld(new Weltenauswahl());
                    break;
                case 3: 
                    Greenfoot.setWorld(new Level1());
                    break;
            }
        }
    }
    
    // Die Methode act wird jeden Aktualisierungszyklus aufgerufen
    public void act()
    {
        // Überprüfe, ob der Button geklickt wurde
        klicke(screen);
    }
}
