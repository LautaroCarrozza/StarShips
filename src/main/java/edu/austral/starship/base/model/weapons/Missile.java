package edu.austral.starship.base.model.weapons;

import edu.austral.starship.base.model.Weapon;
import edu.austral.starship.base.model.bullets.MissileBullet;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.model.constants.Image;

public class Missile extends Weapon {

    public Missile() {
        super(new MissileBullet(Image.MISSILE_BULLET, Configs.MISSILE_SPRITE_WIDTH, Configs.MISSILE_SPRITE_HEIGHT));
    }

}
