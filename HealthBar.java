import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor {
    public int health;
    private int maxHealth;
    private int width;
    private int height;

    public HealthBar(int maxHealth, int width, int height) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;  // Initialisiere die Gesundheit auf das Maximum
        this.width = width;
        this.height = height;
        updateImage();
    }

    public void act() {
        // Füge hier Code hinzu, der jedes Frame ausgeführt werden soll
    }

    public void updateHealth(int change) {
        health += change;
        if (health < 0) {
            health = 0;
        } else if (health > maxHealth) {
            health = maxHealth;
        }
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, width, height);

        int healthWidth = (int) ((double) health / maxHealth * width);
        image.setColor(Color.GREEN);
        image.fillRect(0, 0, healthWidth, height);

        setImage(image);
    }
}
