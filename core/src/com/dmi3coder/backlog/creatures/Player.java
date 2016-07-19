package com.dmi3coder.backlog.creatures;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends CollisionCreature{

    private final Texture texture;
    private double deltaTime;
    private Vector2 position;

    public Player(Texture texture, TiledMapTileLayer layer) {
        super(texture,layer);
        this.texture = texture;
        this.deltaTime = Gdx.graphics.getDeltaTime();
    }

    @Override
    protected boolean handleInput(float deltaTime) {
        setPreviousPosition(new Vector2(getX(),getY()));
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setPosition(getX() + (-200 * deltaTime), getY());
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setPosition(getX() + (200 * deltaTime), getY());

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            setPosition(getX(), getY() + (200 * deltaTime));

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            setPosition(getX(),getY()+(-200*deltaTime));
        }
        return super.handleInput(deltaTime);
    }
}
