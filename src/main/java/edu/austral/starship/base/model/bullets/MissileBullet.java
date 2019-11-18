package edu.austral.starship.base.model.bullets;

import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.constants.Image;

public class MissileBullet extends Bullet {
    private static final int strength = 120;
    public MissileBullet(Image image, int width, int height) {
        super(image, width, height, strength);
    }
}
