package edu.austral.starship.base.model.bullets;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.model.Bullet;
import edu.austral.starship.base.model.Player;
import edu.austral.starship.base.model.Shot;
import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.GameView;
import edu.austral.starship.base.view.model.ShotDrawable;

public class MissileBullet extends Bullet {
    private long loadingTime = System.currentTimeMillis();

    private static final int strength = 500;
    public MissileBullet(Image image, int width, int height) {
        super(image, width, height, strength);
    }

    @Override
    public void shot(Player player, Vector2 position, Vector2 direction) {
        long time = System.currentTimeMillis() - loadingTime;
        if (time >= 1000){
            Shot shot = new Shot(this, position, direction, player);
            GameView.addDrawable(new ShotDrawable(shot, getImage(), getWidth(), getHeight()));
            GameController.addCollisionable(shot);
            loadingTime = System.currentTimeMillis();
        }
    }
}
