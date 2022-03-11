package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.entities.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends StaticScene {
    YaegerGame parentGame;

    public GameOverScene(YaegerGame parentGame) {
        this.parentGame = parentGame;
    }

    @Override
    public void setupScene() {
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        var startButton = new StartButton(
                "New game",
                new Coordinate2D(getWidth() / 2, (getHeight() / 2 + 20.0)),
                AnchorPoint.CENTER_CENTER,
                Color.BLACK,
                Font.font("Roboto", FontWeight.NORMAL, 30),
                parentGame);
        addEntity(gameOverText);
        addEntity(startButton);
    }
}
