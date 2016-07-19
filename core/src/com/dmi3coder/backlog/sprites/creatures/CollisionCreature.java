package com.dmi3coder.backlog.sprites.creatures;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public abstract class CollisionCreature extends Sprite{
    private final TiledMapTileLayer tileLayer;
    Vector2 previousPosition;

    public CollisionCreature(Texture texture, TiledMapTileLayer tileLayer){
        super(texture,30,30);
        this.tileLayer = tileLayer;
        previousPosition = new Vector2(getX(),getY());
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        handleInput(Gdx.graphics.getDeltaTime());
    }

    protected boolean handleInput (float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (tileLayer.getCell(cellPos(getX()), cellPos(getY())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid")) {
                returnToPreviousPosition();
                return false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid")) {
                returnToPreviousPosition();
                return false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (tileLayer.getCell(cellPos(getX()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY() + getHeight())).getTile().getProperties().containsKey("solid")) {
                returnToPreviousPosition();
                return false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (tileLayer.getCell(cellPos(getX()), cellPos(getY())).getTile().getProperties().containsKey("solid") ||
                    tileLayer.getCell(cellPos(getX() + getWidth()), cellPos(getY())).getTile().getProperties().containsKey("solid")) {
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
