package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;
import com.github.hanyaeger.tutorial.entities.bubbles.PoisonBubble;
import javafx.scene.input.KeyCode;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Hanny
        extends DynamicSpriteEntity
        implements KeyListener, SceneBorderCrossingWatcher, Newtonian, Collided, Collider {

    private int health;
    private int bubblesPopped = 0;
    private HealthText healthText;
    public ScoreText scoreText;
    private YaegerGame parentGame;

    private final Map<KeyCode, Direction> directions = Map.ofEntries(
            new AbstractMap.SimpleEntry(KeyCode.LEFT, Direction.LEFT),
            new AbstractMap.SimpleEntry(KeyCode.RIGHT, Direction.RIGHT),
            new AbstractMap.SimpleEntry(KeyCode.UP, Direction.UP),
            new AbstractMap.SimpleEntry(KeyCode.DOWN, Direction.DOWN)
    );

    public Hanny(Coordinate2D initialLocation, HealthText healthText, ScoreText scoreText, int maxHealth, YaegerGame parentGame) {
        super("sprites/hanny.png", initialLocation, new Size(20, 40), 1, 2);
        setGravityConstant(0.005);
        setFrictionConstant(0.04);

        this.health = maxHealth;
        this.healthText = healthText;
        this.healthText.setHealthText(this.health);

        this.scoreText = scoreText;
        this.scoreText.setScoreText(0);
        this.parentGame = parentGame;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.isEmpty()) {
            return;
        }

        var firstKeyCode = pressedKeys.iterator().next();

        if (!directions.containsKey(firstKeyCode)) {
            return;
        }

        setCurrentFrameIndex(firstKeyCode);
        setMotion(2, directions.get(firstKeyCode));
    }

    private void setCurrentFrameIndex(KeyCode keyCode) {
        if (keyCode == KeyCode.LEFT) {
            setCurrentFrameIndex(0);
        } else if (keyCode == KeyCode.RIGHT) {
            setCurrentFrameIndex(1);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        doDamage(1);
        respawn();
        handleBubbleCollision(collider);
        this.healthText.setHealthText(this.health);
    }

    private void handleBubbleCollision(Collider collider) {
        if (collider instanceof PoisonBubble) {
            doDamage(1);
        }
        if (collider instanceof AirBubble) {
            this.bubblesPopped++;
            this.scoreText.setScoreText(bubblesPopped);
        }
    }

    private void respawn() {
        var randomX = new Random().nextInt((int) (getSceneWidth() - getWidth()));
        var randomY = new Random().nextInt((int) (getSceneHeight() - getHeight()));
        setAnchorLocation(new Coordinate2D(randomX, randomY));
    }

    public void doDamage(int amount) {
        this.health -= amount;
        if (this.health < 1) {
            this.die();
            return;
        }
    }

    private void die() {
        parentGame.setActiveScene(2);
    }

}
