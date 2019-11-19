package edu.austral.starship.base.controller;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.base.model.Player;
import edu.austral.starship.base.model.PlayerStats;
import edu.austral.starship.base.model.StarShip;
import edu.austral.starship.base.model.Weapon;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.util.Spawner;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.GameView;
import edu.austral.starship.base.view.model.StarShipDrawable;
import processing.event.KeyEvent;

import java.util.*;


public class GameController{

    private PlayerController playerController = new PlayerController();
    private List<Weapon> gameWeapons;
    private static Map<Player, PlayerStats> playersStats = new HashMap<>();
    private static List<Collisionable> collisionables = new ArrayList<>();
    private final CollisionEngine collisionEngine = new CollisionEngine();
    private static final Spawner spawner = new Spawner();
    private final static Random RANDOM = new Random();

    public GameController() {
        gameWeapons = Configs.GAME_WEAPONS;
    }

    public static void asteroidDestroyByPlayer(Player player, int points) {
        PlayerStats stats = playersStats.get(player);
        stats.sumScore(points);
    }

    public static void playerCollision(){
        playersStats.forEach((p, s)-> s.updateLives());
    }

    public void onKeyPressedEvent(int keyCode){
        playerController.onKeyPressed(keyCode);

    }

    public static void addCollisionable(Collisionable collisionable){
        collisionables.add(collisionable);
    }

    public static void removeCollisionable(Collisionable collisionable){
        collisionables.remove(collisionable);
    }

    public void onReleased(KeyEvent event) {
        playerController.onReleased(event);
    }


    public void createPlayer() {
        StarShip starship = new StarShip(new Vector2(500, 500), new Vector2(0, 1), gameWeapons);
        Player player = new Player(starship);
        playerController.setPlayer(player);
        PlayerStats pStats =  new PlayerStats(player);
        playersStats.put(player, pStats);

        GameView.addDrawable(new StarShipDrawable(starship));
        GameController.addCollisionable(starship);
        GameView.addPlayerStats(playersStats.get(player));
    }

    public void updateGame() {
        int r = RANDOM.nextInt(20);
        if (r == 1){
            spawner.spawnAsteroid();
        }
        collisionEngine.checkCollisions(collisionables);
    }

    public boolean playerAlive() {
        return playerController.playerIsAlive();
    }

    public void gameOver() {
        //todo show stats
        collisionables.clear();
    }
}
