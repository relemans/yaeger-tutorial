package com.github.hanyaeger.tutorial.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.bubbles.AirBubble;
import com.github.hanyaeger.tutorial.entities.bubbles.PoisonBubble;

import java.util.Random;

public class BubbleSpawner extends EntitySpawner {

    private final Size sceneSize;

    public BubbleSpawner(long intervalInMs, Size sceneSize) {
        super(intervalInMs);
        this.sceneSize = sceneSize;
    }

    public BubbleSpawner(long intervalInMs, double sceneWidth, double sceneHeight) {
        this(intervalInMs, new Size(sceneWidth, sceneHeight));
    }

    @Override
    protected void spawnEntities() {
        spawn(new Random().nextInt(10) < 4
                ? new PoisonBubble(randomLocation(), 2)
                : new AirBubble(randomLocation(), 2));
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt(sceneSize.width() > 0.0 ? (int) sceneSize.width() : 800);
        double height = sceneSize.height();
        return new Coordinate2D(x, height);
    }
}
