package edu.austral.starship.base.validator;

import edu.austral.starship.base.model.StarShip;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.vector.Vector2;

public class ActionValidator {

    private static final Vector2 FORWARD_DIRECTION = new Vector2(0,1);
    private static final Vector2 LEFT_DIRECTION = new Vector2(-1,0);
    private static final Vector2 RIGHT_DIRECTION = new Vector2(0,1);


    public static boolean validateMoveForward(StarShip ship) {
        Vector2 shipPosition = ship.getPosition();
        Vector2 newPosition = shipPosition.substract(FORWARD_DIRECTION.multiply(ship.getSpeed()/2));
        return !(newPosition.getY() <= 0);
    }

    public static boolean validateBackwards(StarShip ship) {
        Vector2 shipPosition = ship.getPosition();
        Vector2 newPosition = shipPosition.add(FORWARD_DIRECTION.multiply(ship.getSpeed()/2));
        return !(newPosition.getY() >= Configs.WINDOW_HEIGHT - Configs.STARSHIP_HEIGHT);
    }

    public static boolean validateLeft(StarShip ship) {
        Vector2 shipPosition = ship.getPosition();
        Vector2 newPosition = shipPosition.add(LEFT_DIRECTION.multiply(ship.getSpeed()));
        return !(newPosition.getX() <= 0);
    }

    public static boolean validateRight(StarShip ship) {
        Vector2 shipPosition = ship.getPosition();
        Vector2 newPosition = shipPosition.add(RIGHT_DIRECTION.multiply(ship.getSpeed()));
        return !(newPosition.getX() >= Configs.WINDOW_WIDTH - Configs.STARSHIP_WIDTH);
    }
}
