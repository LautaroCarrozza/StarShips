package edu.austral.starship.base.util;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.GameView;
import edu.austral.starship.base.view.model.AsteroidDrawable;

import java.util.Random;

public class Spawner {

    private static final Random random = new Random();

    public void spawnAsteroid() {
        Asteroid asteroid = new Asteroid(getRandomPosition(),
                getRandomDirection(),
                getRandomSpeed(),
                getRandomWidth());
        GameController.addCollisionable(asteroid);
        GameView.addDrawable(new AsteroidDrawable(asteroid));
    }

    private int getRandomWidth() {
        return Configs.ASTEROID_WIDTH + random.nextInt(80);
    }

    private float getRandomSpeed() {
        return Configs.ASTEROID_MIN_SPEED + random.nextFloat() * (Configs.ASTEROID_MAX_SPEED - Configs.ASTEROID_MIN_SPEED);
    }

    private Vector2 getRandomPosition() {
        Vector2 position;
        int r = random.nextInt(4);
        if (r == 0 || r == 1){
            position = new Vector2(r == 0 ? 0 : Configs.WINDOW_WIDTH , random.nextInt(Configs.WINDOW_HEIGHT));
        }
        else {
            position = new Vector2(random.nextInt(Configs.WINDOW_WIDTH), r == 2 ? 0 : Configs.WINDOW_HEIGHT);
        }
        return position;
    }

    private Vector2 getRandomDirection() {
        float rx = random.nextFloat();
        float ry = random.nextFloat();
        float min = -1;
        float max = 1;

        return new Vector2(min + rx * (max - min), min + ry * (max - min));
    }
}
