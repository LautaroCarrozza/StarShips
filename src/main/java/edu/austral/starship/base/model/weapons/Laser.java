package edu.austral.starship.base.model.weapons;

import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Weapon;
import edu.austral.starship.base.model.bullets.LaserBullet;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.model.constants.Image;

public class Laser extends Weapon {

    public Laser() {
        super(new LaserBullet(Image.LASER_BULLET, Configs.LASER_SPRITE_WIDTH, Configs.LASER_SPRITE_HEIGHT));
    }

}
