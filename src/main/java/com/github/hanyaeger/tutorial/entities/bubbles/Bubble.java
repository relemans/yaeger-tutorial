package com.github.hanyaeger.tutorial.entities.bubbles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public abstract class Bubble
        extends DynamicCircleEntity
        implements Collided, SceneBorderCrossingWatcher {

    protected Bubble(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        System.out.println(this.getClass().getName());
        setRadius(10);
        setMotion(randomSpeed(speed), Direction.UP);
    }

    private double randomSpeed(int speed) {
        //Random r = new Random();
        double randomDouble = speed; //r.nextDouble();
        return randomDouble;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.TOP) {
            remove();
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        remove();
    }
}
