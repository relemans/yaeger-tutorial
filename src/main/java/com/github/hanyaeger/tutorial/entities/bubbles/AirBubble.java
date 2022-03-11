package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.paint.Color;

public class AirBubble extends Bubble implements Collider {

    public AirBubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation, speed);

        this.setStrokeColor(Color.BLACK);
        this.setFill(Color.LIGHTBLUE);
        this.setOpacity(0.5);
    }
}
