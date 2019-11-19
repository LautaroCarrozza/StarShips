package edu.austral.starship.base.controller;

import edu.austral.starship.base.model.Player;
import edu.austral.starship.base.model.StarShip;
import edu.austral.starship.base.model.constants.Action;
import edu.austral.starship.base.validator.ActionValidator;
import processing.event.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerController {

    private Player player;
    private Map<Integer, Action> keyConfiguration = new HashMap<>();

    public PlayerController() {
        this.keyConfiguration.put(87, Action.FORWARD);
        this.keyConfiguration.put(83, Action.BACKWARDS);
        this.keyConfiguration.put(68, Action.MOVE_RIGHT);
        this.keyConfiguration.put(65, Action.MOVE_LEFT);
        this.keyConfiguration.put(32, Action.SHOOT);
        this.keyConfiguration.put(81, Action.CHANGE_WEAPON);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void onKeyPressed(int keyCode) {
        if (keyConfiguration.containsKey(keyCode)){
            eventAction(keyConfiguration.get(keyCode));
        }
    }

    private void eventAction(Action action) {
        StarShip ship = player.getStarship();

        switch (action){
            case FORWARD: {
                if (ActionValidator.validateMoveForward(ship)){
                    player.getStarship().moveForward();
                }
                break;
            }
            case BACKWARDS: {
                if (ActionValidator.validateBackwards(ship)) {
                    ship.moveBackwards();
                }
                break;
            }
            case SHOOT:
                ship.shoot(player);
                break;

            case MOVE_LEFT:
                if (ActionValidator.validateLeft(ship))
                ship.moveLeft();
                break;
            case MOVE_RIGHT: {
                if (ActionValidator.validateRight(ship))
                ship.moveRight();
                break;
            }

            case ROTATE_LEFT :
            case ROTATE_RIGHT: {
                ship.rotate(action);
                break;
            }
            case CHANGE_WEAPON:
                //ship.changeWeapon();
                break;

            default:
                break;
        }
    }

    public void onReleased(KeyEvent event) {
        player.getStarship().resetSpeed();

        if(keyConfiguration.containsKey(event.getKeyCode())){
            Action action = keyConfiguration.get(event.getKeyCode());
            if (action == Action.CHANGE_WEAPON)
                player.getStarship().changeWeapon();
        }

    }

    public boolean playerIsAlive(){
        return this.player.isAlive();
    }
}
