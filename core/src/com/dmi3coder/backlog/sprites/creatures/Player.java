package com.dmi3coder.backlog.sprites.creatures;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.dmi3coder.backlog.maps.techniques.MapHandler;
import com.dmi3coder.backlog.sprites.creatures.MovementCreature;

public class Player extends MovementCreature {

    public Player(Texture texture, MapHandler handler) {
        super(texture,handler);
    }
}
