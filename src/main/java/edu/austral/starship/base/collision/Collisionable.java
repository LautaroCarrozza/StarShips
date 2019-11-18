package edu.austral.starship.base.collision;

import edu.austral.starship.base.model.CollisionableType;

import java.awt.*;

public interface Collisionable<T extends Collisionable<T>> {
    Shape getShape();

    void collisionedWith(T collisionable);

    CollisionableType getType();

}
