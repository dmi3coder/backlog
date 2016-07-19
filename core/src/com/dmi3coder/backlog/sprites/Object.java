package com.dmi3coder.backlog.sprites;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Vector2;

public abstract class Object implements Actionable {
    private static final String OBJECT_TILES_NAME = "*";
    private int objectId = 0;

    public Object(int objectId){
        this.objectId = objectId;
    }

    public Object(TiledMapTile tiledMapTile){
        this.objectId = tiledMapTile.getId();
    }

}
