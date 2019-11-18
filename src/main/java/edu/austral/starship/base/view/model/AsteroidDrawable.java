package edu.austral.starship.base.view.model;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.model.Asteroid;
import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.GameView;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;

public class AsteroidDrawable implements Drawable {

    private final Asteroid asteroid;

    public AsteroidDrawable(Asteroid asteroid) {
        this.asteroid = asteroid;
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void updatePosition(PGraphics graphics) {
        if (asteroid.getLife() <= 0) {
            GameView.addDrawableToRemove(this);
            removeEntity();
        }
        else {
            PImage image = GameView.getPImage(getIMAGE());
            asteroid.updatePosition();

            graphics.image(image, getPosition().getX(), getPosition().getY(), asteroid.getWidth(), asteroid.getHeight());
        }
    }

    @Override
    public Image getIMAGE() {
        return Image.ASTEROID;
    }

    @Override
    public Vector2 getPosition() {
        return this.asteroid.getPosition();
    }

    @Override
    public Vector2 getDirection() {
        return this.asteroid.getDirection();
    }

    @Override
    public Float getSpeed() {
        return this.asteroid.getSpeed();
    }

    @Override
    public void removeEntity() {
        GameController.removeCollisionable(this.asteroid);
    }
}
