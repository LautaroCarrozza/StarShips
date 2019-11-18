package edu.austral.starship.base.view;

import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.model.constants.Image;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PGraphics;
import processing.core.PImage;
import sun.security.krb5.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameView {

    private static List<Drawable> drawables = new ArrayList<>();
    private static List<Drawable> drawablesToRemoveFromGame = new ArrayList<>();

    private static Map<Image, PImage> pImageMap = new HashMap<>();

    public GameView() {

    }

    public static void addDrawable(Drawable drawable){drawables.add(drawable);}

    public static void addDrawableToRemove(Drawable drawable){drawablesToRemoveFromGame.add(drawable);}

    public static void removeDrawable(Drawable drawable){drawables.remove(drawable);}

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
        for (Drawable drawable : drawables) {
            drawable.updatePosition(graphics);
            checkDrawableOutOfWindow(drawable);
        }
        removeDrawables();
    }

    private void removeDrawables() {
        for (Drawable drawable : drawablesToRemoveFromGame) {
            drawables.remove(drawable);
            drawable.removeEntity();
        }
        drawablesToRemoveFromGame.clear();
    }

    private void checkDrawableOutOfWindow(Drawable drawable) {
        Vector2 futurePosition = drawable.getPosition().add(drawable.getDirection().multiply(drawable.getSpeed()));
        boolean x = futurePosition.getX() <= 0 - Configs.ASTEROID_WIDTH || futurePosition.getY() >= Configs.WINDOW_WIDTH + Configs.ASTEROID_WIDTH;
        boolean y = futurePosition.getY() <= 0 - Configs.ASTEROID_HEIGHT || futurePosition.getY() >= Configs.WINDOW_HEIGHT + Configs.ASTEROID_HEIGHT;
        if (x || y)
            drawablesToRemoveFromGame.add(drawable);
    }


    public void gameOver(PGraphics graphics) {
        drawables.clear();
        graphics.image(pImageMap.get(Image.GAME_OVER), Configs.WINDOW_WIDTH >> 2, Configs.WINDOW_HEIGHT >> 2,
                Configs.WINDOW_WIDTH >> 1, Configs.WINDOW_HEIGHT >> 1);
    }
}
