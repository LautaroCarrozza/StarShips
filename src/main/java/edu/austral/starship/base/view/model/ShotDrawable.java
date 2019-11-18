package edu.austral.starship.base.view.model;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.model.Shot;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.GameView;
import processing.core.PGraphics;

import java.awt.*;

public class ShotDrawable implements Drawable {

    private final Shot shot;
    private final Image image;
    private final int bulletWidth;
    private final int bulletHeight;

    public ShotDrawable(Shot shot, Image image, int bulletWidth, int bulletHeight) {
        this.shot = shot;
        this.image = image;
        this.bulletWidth = bulletWidth;
        this.bulletHeight = bulletHeight;
    }

    @Override
    public Shape getShape() {
        return shot.getShape();
    }

    @Override
    public void updatePosition(PGraphics graphics) {
        if (!shot.isAlive()) {
            GameView.addDrawableToRemove(this);
            removeEntity();
        }
        else {
            shot.updatePosition();
            graphics.image(GameView.getPImage(getIMAGE()),
                    getPosition().getX() + ((Configs.STARSHIP_WIDTH - bulletWidth) >> 1),
                    getPosition().getY(), bulletWidth, bulletHeight);
        }
    }

    @Override
    public Image getIMAGE() {
        return this.image;
    }

    @Override
    public Vector2 getPosition() {
        return shot.getPosition();
    }

    @Override
    public Vector2 getDirection() {
        return shot.getDirection();
    }

    @Override
    public Float getSpeed() {
        return shot.getSpeed();
    }

    @Override
    public void removeEntity() {
        GameController.removeCollisionable(this.shot);
    }
}
