package edu.austral.starship.base.view;

import edu.austral.starship.base.model.PlayerStats;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.model.StatsDrawable;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameView {

    private static List<DrawableEntity> drawables = new ArrayList<>();
    private static List<DrawableEntity> drawablesToRemoveFromGame = new ArrayList<>();
    private static StatsDrawable statsDrawable = new StatsDrawable();

    private static Map<Image, PImage> pImageMap = new HashMap<>();

    public GameView() {

    }

    public static void addDrawable(DrawableEntity drawable){drawables.add(drawable);}

    public static void addDrawableToRemove(DrawableEntity drawable){drawablesToRemoveFromGame.add(drawable);}

    public static void addPlayerStats(PlayerStats playerStats){statsDrawable.addPlayerStats(playerStats);}

    public static void removeDrawable(DrawableEntity drawable){drawables.remove(drawable);}

    public void addPImage(Image imageType, PImage pImage){
        pImageMap.put(imageType, pImage);
    }

    public static PImage getPImage(Image image){
        return pImageMap.get(image);
    }

    public Map<Image, PImage> getPImageMap() {
        return pImageMap;
    }

    public void render(PGraphics graphics) {
        for (DrawableEntity drawable : drawables) {
            drawable.updateView(graphics);
            checkDrawableOutOfWindow(drawable);
        }
        removeDrawables();
        renderStats(graphics);
    }

    private void renderStats(PGraphics graphics) {
        statsDrawable.updateView(graphics);
    }

    private void removeDrawables() {
        for (DrawableEntity drawable : drawablesToRemoveFromGame) {
            drawables.remove(drawable);
            drawable.removeEntity();
        }
        drawablesToRemoveFromGame.clear();
    }

    private void checkDrawableOutOfWindow(DrawableEntity drawable) {
        Vector2 futurePosition = drawable.getPosition().add(drawable.getDirection().multiply(drawable.getSpeed()));
        boolean x = futurePosition.getX() <= 0 - Configs.ASTEROID_WIDTH || futurePosition.getY() >= Configs.WINDOW_WIDTH + Configs.ASTEROID_WIDTH;
        boolean y = futurePosition.getY() <= 0 - Configs.ASTEROID_HEIGHT || futurePosition.getY() >= Configs.WINDOW_HEIGHT + Configs.ASTEROID_HEIGHT;
        if (x || y)
            drawablesToRemoveFromGame.add(drawable);
    }


    public void gameOver(PGraphics graphics) {
        drawables.clear();
        graphics.image(pImageMap.get(Image.GAME_OVER), Configs.WINDOW_WIDTH >> 2, Configs.WINDOW_HEIGHT >> 2,
                Configs.GAME_OVER_WIDTH, Configs.GAME_OVER_HEIGHT);
        statsDrawable.gameOver(graphics);
    }
}
