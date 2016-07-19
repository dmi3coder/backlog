package com.dmi3coder.backlog.sprites.creatures;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class MovementCreature extends CollisionCreature {


    public MovementCreature(Texture texture, TiledMapTileLayer tileLayer) {
        super(texture, tileLayer);
    }

    @Override
    protected boolean handleInput(float deltaTime) {
        setPreviousPosition(new Vector2(getX(),getY()));
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setPosition(getX() + (-200 * deltaTime), getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setPosition(getX() + (200 * deltaTime), getY());

        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            setPosition(getX(), getY() + (200 * deltaTime));

        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            setPosition(getX(),getY()+(-200*deltaTime));
        }
        return super.handleInput(deltaTime);
    }

}
