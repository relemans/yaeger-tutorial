package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.HealthText;
import com.github.hanyaeger.tutorial.entities.ScoreText;
import com.github.hanyaeger.tutorial.entities.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.spawners.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private final Waterworld parentGame;

    public GameLevel(Waterworld parentGame) {
        this.parentGame = parentGame;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.png");
    }

    @Override
    public void setupEntities() {
        var swordFish = new Swordfish(new Coordinate2D(10, 400));
        var healthText = new HealthText(new Coordinate2D(10, getHeight() - 40));
        var scoreText = new ScoreText(new Coordinate2D(10, 10));
        var hanny = new Hanny(new Coordinate2D(10, 10), healthText, scoreText, 2, this.parentGame);
        double width = getScene().getWidth();
        var sharky = new Sharky(new Coordinate2D(width, 100));

        addEntity(swordFish);
        addEntity(sharky);
        addEntity(healthText);
        addEntity(hanny);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(
                new BubbleSpawner(100, this.parentGame.windowSize));
    }
}
