package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    public Swordfish(Coordinate2D initialPosition) {
        super(initialPosition);
        setMotion(2, Direction.LEFT);
    }

    @Override
    protected void setupEntities() {
        double height = 80; //getHeight(); // getHeight == 0.0?

        SwordfishSprite swordfishNose = new SwordfishSprite(new Coordinate2D(0, 0));
        HitBox hitBox = new HitBox(new Coordinate2D(0, height / 2));

        addEntity(swordfishNose);
        addEntity(hitBox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
    }
}
