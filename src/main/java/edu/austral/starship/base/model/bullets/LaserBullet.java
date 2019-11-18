package edu.austral.starship.base.model.bullets;

import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.constants.Image;

public class LaserBullet extends Bullet {
    private static final int strength = 40;
    public LaserBullet(Image image, int width, int height) {
        super(image, width, height, strength);
    }
}
