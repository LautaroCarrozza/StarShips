package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Shot implements Collisionable {

    private Player player;
    private Bullet bullet;
    private Vector2 position;
    private Vector2 direction;
    private float speed = Configs.SHOT_SPEED;
    private boolean alive;
    private Shape shape;

    public Shot(Bullet bullet, Vector2 position, Vector2 direction, Player player) {
        this.player = player;
        this.bullet = bullet;
        this.position = position;
        this.direction = direction;
        this.alive = true;
        this.shape = new Rectangle2D.Float((position.getX() + Configs.STARSHIP_WIDTH),
                position.getY(), bullet.getWidth(), bullet.getHeight());
    }

    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void collisionedWith(Collisionable collisionable) {
        if (collisionable.getType().equals(CollisionableType.ASTEROID)) {
            this.alive = false;
        }
    }

    @Override
    public CollisionableType getType() {
        return CollisionableType.SHOT;
    }

    public void updatePosition() {
        this.position = position.add(direction.multiply(speed));
        moveShape();
    }

    private void moveShape() {
        shape = new Rectangle2D.Float((position.getX() + (Configs.STARSHIP_WIDTH - bullet.getWidth() >>1)),
                position.getY(), bullet.getWidth(), bullet.getHeight());
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public Float getSpeed() {
        return speed;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public boolean isAlive() {
        return alive;
    }

    public Player getPlayer() {
        return player;
    }
}
