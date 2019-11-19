package edu.austral.starship;

import edu.austral.starship.base.controller.GameController;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.view.GameView;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.*;

public class CustomGameFramework implements GameFramework{

    private GameController gameController = new GameController();
    private GameView gameView = new GameView();


    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(Configs.WINDOW_WIDTH, Configs.WINDOW_HEIGHT);

        //gameView.addPImage(Image.STARSHIP, imageLoader.load("images/Spaceship-PNG-File.png"));
        gameView.addPImage(Image.STARSHIP, imageLoader.load("images/starShip.png"));
        gameView.addPImage(Image.ASTEROID, imageLoader.load("src/main/resources/images/asteroid2.png"));
        gameView.addPImage(Image.LASER_BULLET, imageLoader.load("images/laser_sprite.png"));
        gameView.addPImage(Image.MISSILE_BULLET, imageLoader.load("images/missile_sprite.png"));
        gameView.addPImage(Image.GAME_OVER, imageLoader.load("images/gameOver.png"));

        gameController.createPlayer();
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        if (gameController.playerAlive()) {
            keySet.forEach(key -> {
                gameController.onKeyPressedEvent(key);
            });

            gameController.updateGame();
            gameView.render(graphics);
        }
        else {
            gameOver(graphics);
        }

    }

    private void gameOver(PGraphics graphics) {
        gameController.gameOver();
        gameView.gameOver(graphics);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        //gameController.onKeyPressedEvent(event.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent event) {
        gameController.onReleased(event);
    }

}
