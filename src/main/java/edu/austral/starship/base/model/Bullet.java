package edu.austral.starship.base.model;

import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;

public abstract class Bullet {

    private Image image;
    private int width;
    private int height;
    private int strength;

    public Bullet(Image image, int width, int height, int strength) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.strength = strength;
    }

    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStrength() {
        return strength;
    }

    public abstract void shot(Player player, Vector2 position, Vector2 direction);
}
