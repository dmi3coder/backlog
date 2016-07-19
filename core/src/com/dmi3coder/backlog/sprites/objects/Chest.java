package com.dmi3coder.backlog.sprites.objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.dmi3coder.backlog.sprites.Object;

public class Chest extends Object {


    public Chest(int objectId) {
        super(objectId);
    }

    public Chest(TiledMapTile tiledMapTile) {
        super(tiledMapTile);
    }

    @Override
    public void doOnClickAction() {
        Gdx.app.log("chest","hello, sir");
    }

    @Override
    public void doOnTouchAction() {
        Gdx.app.log("chest","ouch, sorry, sir");
    }
}
