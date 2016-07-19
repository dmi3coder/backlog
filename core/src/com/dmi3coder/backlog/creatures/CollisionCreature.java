package com.dmi3coder.backlog.creatures;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class CollisionCreature extends Sprite{
    private final Texture texture;
    private final TiledMapTileLayer tileLayer;
    Vector2 previousPosition;

    public CollisionCreature(Texture texture, TiledMapTileLayer tileLayer){
        super(texture);
        this.texture = texture;
        this.tileLayer = tileLayer;
        previousPosition = new Vector2(getX(),getY());
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        handleInput(Gdx.graphics.getDeltaTime());
    }

    private boolean handleInput (float deltaTime) {
        previousPosition.set(getX(), getY());

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setPosition(getX() + (-200 * deltaTime), getY());
            if (tileLayer.getCell(cellPos(getX()), cellPos(getY())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid")) {
                returnToPreviousPosition();
                return false;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setPosition(getX() + (200 * deltaTime), getY());
            if (tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid")) {
                returnToPreviousPosition();
                return false;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            setPosition(getX(), getY() + (200 * deltaTime));
            if (tileLayer.getCell(cellPos(getX()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid")) {
                returnToPreviousPosition();
                return false;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            setPosition(getX(), getY() + (-200 * deltaTime));
            if (tileLayer.getCell(cellPos(getX()), cellPos(getY())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY())).getTile().getProperties().containsKey("solid")) {
                returnToPreviousPosition();
                return false;
            }
        }
        return true;
    }

        private void returnToPreviousPosition(){
            setPosition(previousPosition.x,previousPosition.y);
        }

        public static int cellPos(float i){
            return ((int) (i / 32));
        }
}
