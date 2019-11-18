package edu.austral.starship.base.model.constants;

import edu.austral.starship.base.model.Weapon;
import edu.austral.starship.base.model.weapons.Laser;
import edu.austral.starship.base.model.weapons.Missile;
import edu.austral.starship.base.vector.Vector2;

import java.util.Arrays;
import java.util.List;

public class Configs {

    public static final int WINDOW_WIDTH = 1500;
    public static final int WINDOW_HEIGHT = 1000;

    public static final int STARSHIP_WIDTH = 100;
    public static final int STARSHIP_HEIGHT = 150;

    public static final int ASTEROID_HEIGHT = 150;
    public static final int ASTEROID_WIDTH = 150;

    public static final int MISSILE_SPRITE_WIDTH = 100;
    public static final int MISSILE_SPRITE_HEIGHT = 100;

    public static final int LASER_SPRITE_WIDTH = 25;
    public static final int LASER_SPRITE_HEIGHT = 50;

    public static final int INITIAL_LIVES = 1;
    public static final int DEFAULT_SPEED = 10;
    public static final float SHOT_SPEED = 15;

    private static Weapon MISSILE = new Missile();
    private static Weapon LASER = new Laser();

    public static List<Weapon> GAME_WEAPONS = Arrays.asList(
            LASER, MISSILE
    );

    public static final float ASTEROID_MAX_SPEED = 15;
    public static final float ASTEROID_MIN_SPEED = 8;

    public static final Vector2 FORWARD_VECTOR = new Vector2(0, -1);
    public static final Vector2 BACKWARD_VECTOR = new Vector2(0, 1);
    public static final Vector2 LEFT_VECTOR = new Vector2(-1, 0);
    public static final Vector2 RIGHT_VECTOR = new Vector2(1, 0);

}
