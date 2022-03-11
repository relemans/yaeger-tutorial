package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Sharky
        extends DynamicSpriteEntity
        implements SceneBorderCrossingWatcher, Collider {

    public Sharky(Coordinate2D initialLocation) {
        super(
                "sprites/sharky.png",
                initialLocation,
                new Size(200),
                1,
                19);

        setMotion(0.7, Direction.RIGHT);
        setAutoCycle(10);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(0);
    }
}
