package com.dmi3coder.backlog.creatures;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Player extends MovementCreature{

    public Player(Texture texture, TiledMapTileLayer layer) {
        super(texture,layer);
    }
}
