package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Asteroid implements Collisionable {

    private Vector2 position;
    private Vector2 direction;
    private float speed;
    private int width;
    private int height;
    private int life;
    private Shape shape;

    public Asteroid(Vector2 position, Vector2 direction, float speed, int width) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.width = width;
        this.height = this.width;
        this.life = width * 2;
        this.shape = new Ellipse2D.Float(position.getX() , position.getY(), width, height);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public Float getSpeed() {
        return this.speed;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void updatePosition() {
        this.position = position.add(direction.multiply(speed));
        moveShape();
    }

    private void moveShape() {
        this.shape = new Ellipse2D.Float(position.getX(), position.getY(), width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    public int getLife() {
        return life;
    }

    @Override
    public void collisionedWith(Collisionable collisionable) {
        CollisionableType collisionableType = collisionable.getType();
        if (collisionableType.equals(CollisionableType.SHOT)){
            Shot shoot = (Shot) collisionable;
            this.life -= shoot.getBullet().getStrength();
        }
        else if (collisionableType.equals(CollisionableType.ASTEROID)) {
            //do nothing
        }

        else this.life = 0;

    }

    @Override
    public CollisionableType getType() {
        return CollisionableType.ASTEROID;
    }
}
