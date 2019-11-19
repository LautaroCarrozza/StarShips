package edu.austral.starship.base.view;

import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PGraphics;

import java.awt.*;


public interface DrawableEntity extends Drawable{

    void updateView(PGraphics graphics);

    Image getIMAGE();

    Vector2 getPosition();

    Vector2 getDirection();

    Float getSpeed();

    void removeEntity();

}
