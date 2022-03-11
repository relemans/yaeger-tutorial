package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ExitButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private YaegerGame parentGame;
    private Color color;

    public ExitButton(String caption,
                      Coordinate2D initialLocation,
                      AnchorPoint anchorPoint,
                      Color color,
                      Font font,
                      YaegerGame parentGame) {
        super(initialLocation, caption);
        this.parentGame = parentGame;
        this.color = color;

        setFill(color);
        setFont(font);
        setAnchorPoint(anchorPoint);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        parentGame.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(this.color);
        setCursor(Cursor.DEFAULT);
    }
}
