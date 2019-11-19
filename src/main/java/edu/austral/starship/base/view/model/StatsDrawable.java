package edu.austral.starship.base.view.model;

import edu.austral.starship.base.model.PlayerStats;
import edu.austral.starship.base.model.constants.Configs;
import edu.austral.starship.base.view.Drawable;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;

public class StatsDrawable implements Drawable {

    //to use in case of more players
    private List<PlayerStats> playersStats;

    public StatsDrawable() {
        playersStats = new ArrayList<>();
    }

    @Override
    public void updateView(PGraphics graphics) {
        playersStats.forEach(
                playerStats -> {
                    graphics.text("Lives: " + playerStats.getLives(), 10, 10);
                }
        );
    }

    public void addPlayerStats(PlayerStats playerStats){
        playersStats.add(playerStats);
    }

    public void gameOver(PGraphics graphics){
        playersStats.forEach(
                playerStats -> {
                    graphics.text("Asteroid kills: " + playerStats.getAsteroidKills() + "\n Score: " + playerStats.getScore()
                            , (Configs.WINDOW_WIDTH >> 1) - 40, (Configs.WINDOW_HEIGHT >>1) + 40);
                }
        );
    }

}
