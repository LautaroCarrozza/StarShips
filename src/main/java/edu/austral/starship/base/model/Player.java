package edu.austral.starship.base.model;

public class Player {

    private StarShip starship;

    public Player(StarShip starship) {
        this.starship = starship;
    }

    public StarShip getStarship() {
        return starship;
    }

    public boolean isAlive(){
        return this.starship.isAlive();
    }

    public int getLives(){
        return this.starship.getLives();
    }

}