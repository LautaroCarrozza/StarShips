package edu.austral.starship.base.model;

public class Player {

    private StarShip starship;
    private int score;

    public Player(StarShip starship) {
        this.score = 0;
        this.starship = starship;
    }

    public StarShip getStarship() {
        return starship;
    }


    public int getScore() {
        return score;
    }

    public boolean isAlive(){
        return this.starship.isAlive();
    }
}