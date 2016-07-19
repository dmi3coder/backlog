package com.dmi3coder.backlog.creatures;


import com.badlogic.gdx.Gdx;
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

}
