package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {
    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GREEN);
    }

    public void setScoreText(int score) {
        setText("Bubbles popped: " + score);
    }
}
