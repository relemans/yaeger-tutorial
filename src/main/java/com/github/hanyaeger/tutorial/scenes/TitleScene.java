package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.entities.ExitButton;
import com.github.hanyaeger.tutorial.entities.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private YaegerGame parentGame;

    public TitleScene(YaegerGame parentGame) {
        this.parentGame = parentGame;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background1.png");
    }

    @Override
    public void setupEntities() {
        var screenCenterX = getWidth() / 2;
        var screenCenterY = getHeight() / 2;

        var waterWorldText = createTextEntity(
                "Waterworld",
                new Coordinate2D(screenCenterX, screenCenterY),
                AnchorPoint.CENTER_CENTER,
                Color.DARKBLUE,
                Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        StartButton startButton = new StartButton(
                "Start game",
                new Coordinate2D(screenCenterX, screenCenterY + 90),
                AnchorPoint.CENTER_CENTER,
                Color.PURPLE,
                Font.font("Roboto", FontWeight.SEMI_BOLD, 30),
                parentGame);

        ExitButton exitButton = new ExitButton(
                "Exit game",
                new Coordinate2D(screenCenterX, screenCenterY + 150),
                AnchorPoint.CENTER_CENTER,
                Color.RED,
                Font.font("Roboto", FontWeight.SEMI_BOLD, 30),
                parentGame);

        addEntity(waterWorldText);
        addEntity(startButton);
        addEntity(exitButton);
    }

    private TextEntity createTextEntity(String text, Coordinate2D coordinates, AnchorPoint anchorPoint, Color color, Font font) {
        var textEntity = new TextEntity(coordinates, text);
        textEntity.setAnchorPoint(anchorPoint);
        textEntity.setFill(color);
        textEntity.setFont(font);
        return textEntity;
    }
}
