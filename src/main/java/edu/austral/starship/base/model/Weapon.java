package edu.austral.starship.base.model;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.GameView;
import edu.austral.starship.base.view.model.ShotDrawable;

public abstract class Weapon {

    private Bullet bullet;
    private Vector2 position;
    private Vector2 direction;

    public Weapon(Bullet bullet) {
        this.bullet = bullet;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void shoot() {
        Shot shot = new Shot(bullet, position, direction);
        GameView.addDrawable(new ShotDrawable(shot, bullet.getImage(), bullet.getWidth(), bullet.getHeight()));
        GameController.addCollisionable(shot);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

}
