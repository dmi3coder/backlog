package com.dmi3coder.backlog.sprites.creatures;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.dmi3coder.backlog.maps.techniques.MapHandler;

public abstract class CollisionCreature extends Sprite{
    Vector2 previousPosition;
    private MapHandler handler;

    public CollisionCreature(Texture texture, MapHandler handler){
        super(texture,30,30);
        this.handler = handler;
        previousPosition = new Vector2(getX(),getY());
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        handleInput(Gdx.graphics.getDeltaTime());
    }

    protected boolean handleInput (float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (handler.isCellSolidByRealPos(getX(), getY()) ||
                    handler.isCellSolidByRealPos(getX(), getY() + getHeight())) {
                returnToPreviousPosition();
                return false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (handler.isCellSolidByRealPos(getX() + getWidth(), getY()) ||
                    handler.isCellSolidByRealPos(getX() + getWidth(), getY() + getHeight())) {
                returnToPreviousPosition();
                return false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (handler.isCellSolidByRealPos(getX(), getY() + getHeight()) ||
                    handler.isCellSolidByRealPos(getX() + getWidth(), getY() + getHeight())) {
                returnToPreviousPosition();
                return false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (handler.isCellSolidByRealPos(getX(), getY()) ||
                    handler.isCellSolidByRealPos(getX() + getWidth(), getY())) {
                returnToPreviousPosition();
                return false;
            }
        }
        return true;
    }

    private void returnToPreviousPosition(){
        setPosition(getPreviousPosition().x,getPreviousPosition().y);
    }

    public static int cellPos(float i){
            return ((int) (i / 32));
        }

    public Vector2 getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(Vector2 previousPosition) {
        this.previousPosition = previousPosition;
    }
}
