package edu.austral.starship.base.model;

public class PlayerStats {

    private Player player;
    private int lives;
    private int score;
    private int asteroidKills;

    public PlayerStats(Player player) {
        this.player = player;
        lives = player.getLives();
        score = 0;
        asteroidKills = 0;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public int getAsteroidKills() {
        return asteroidKills;
    }

    public void sumScore(int points) {
        score += points;
        asteroidKills ++;
    }

    public void updateLives() {
        this.lives = player.getLives();
    }
}
