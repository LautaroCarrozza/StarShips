package edu.austral.starship.base.view.model;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.model.StarShip;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.GameView;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;

public class StarShipDrawable implements Drawable {

    private final StarShip starShip;

    public StarShipDrawable(StarShip starShip) {
        this.starShip = starShip;
    }

    @Override
    public Shape getShape() {
        return this.starShip.getShape();
    }

    @Override
    public void updatePosition(PGraphics graphics) {
        PImage image = GameView.getPImage(getIMAGE());
        graphics.image(image, getPosition().getX(), getPosition().getY(), Configs.STARSHIP_WIDTH, Configs.STARSHIP_HEIGHT);

    }

    @Override
    public Image getIMAGE() {
        return Image.STARSHIP;
    }

    public Vector2 getPosition() {
        return this.starShip.getPosition();
    }

    @Override
    public Vector2 getDirection() {
        return this.starShip.getDirection();
    }

    @Override
    public Float getSpeed() {
        return this.starShip.getSpeed();
    }

    @Override
    public void removeEntity() {
        GameController.removeCollisionable(this.starShip);
    }
}