package edu.austral.starship.base.model;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.model.constants.Action;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StarShip implements Collisionable {

    private Queue<Weapon> weapons;
    private Weapon activeWeapon;
    private int lives;
    private Shape shape;
    private Vector2 position;
    private Vector2 direction;
    private float speed;
    private static final float ROTATION_ANGLE = 5;

    public StarShip(Vector2 position, Vector2 direction, List<Weapon> weapons) {
        this.weapons = new LinkedList<>(weapons);
        activeWeapon = this.weapons.poll();
        this.weapons.add(activeWeapon);

        this.lives = Configs.INITIAL_LIVES;
        this.shape = new Ellipse2D.Float(position.getX(), position.getY(), Configs.STARSHIP_WIDTH, Configs.STARSHIP_HEIGHT);

        this.position = position;
        this.direction = direction;
        this.speed = Configs.DEFAULT_SPEED;
        this.activeWeapon.setPosition(position);
        this.activeWeapon.setDirection(Configs.FORWARD_VECTOR);
    }

    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void collisionedWith(Collisionable collisionable) {
        if (!collisionable.getType().equals(CollisionableType.SHOT)) {
            lives--;
            GameController.playerCollision();
        }
    }

    @Override
    public CollisionableType getType() {
        return CollisionableType.STARSHIP;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    private void move(Vector2 direction) {
        this.position = position.add(direction.multiply(speed));
        moveShape();
        this.activeWeapon.setPosition(position);
        //this.activeWeapon.setDirection(direction);
    }

    private void moveShape() {
        shape = new Ellipse2D.Float(position.getX(), position.getY(), Configs.STARSHIP_WIDTH, Configs.STARSHIP_HEIGHT);
    }

    public void moveForward() {
        this.direction = Configs.FORWARD_VECTOR;
        move(direction);
        //this.speed = speed + 1;
    }

    public void moveBackwards() {
        this.direction = Configs.BACKWARD_VECTOR;
        move(direction);
        //this.speed = speed + 1;
    }

    public void shoot(Player player) {
        activeWeapon.shoot(player);
    }

    public void rotate(Action action) {
        switch (action){
            case ROTATE_RIGHT: this.direction = direction.rotate(-1 *ROTATION_ANGLE); break;
            case ROTATE_LEFT: this.direction = direction.rotate(ROTATION_ANGLE); break;
        }
    }

    public void resetSpeed() {
        this.speed = Configs.DEFAULT_SPEED;
    }


    public void moveLeft() {
        this.direction = Configs.LEFT_VECTOR;
        move(direction);
        //this.speed = speed + 1;
    }

    public void moveRight() {
        this.direction = Configs.RIGHT_VECTOR;
        move(direction);
        //this.speed = speed + 1;
    }

    public Float getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return this.lives > 0;
    }

    public void changeWeapon() {
        weapons.add(activeWeapon);
        activeWeapon = weapons.poll();
        activeWeapon.setPosition(position);
        this.activeWeapon.setDirection(Configs.FORWARD_VECTOR);
        //activeWeapon.setDirection(direction);
    }

    public int getLives() {
        return this.lives;
    }

}
