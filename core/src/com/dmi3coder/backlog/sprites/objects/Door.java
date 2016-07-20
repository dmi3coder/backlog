package com.dmi3coder.backlog.sprites.objects;


import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.dmi3coder.backlog.maps.techniques.MapHandler;
import com.dmi3coder.backlog.sprites.Object;

public class Door extends Object{
    public static final int DOOR_CLOSED_TILE_ID = 5;
    public static final int DOOR_OPEN_TILE_ID = 6;
    public boolean isDoorClosed = true;


    public Door(int objectId, TiledMapTileLayer.Cell objectCell, MapHandler handler, int x, int y) {
        super(objectId, objectCell, handler, x, y);
    }

    public Door(TiledMapTile tiledMapTile, TiledMapTileLayer.Cell objectCell, MapHandler handler, int x, int y) {
        super(tiledMapTile, objectCell, handler, x, y);
    }

    @Override
    public void doOnClickAction() {
        handleDoor();
    }

    private void handleDoor(){
        TiledMapTileLayer.Cell cell = getCell();
        cell.setTile(getHandler().getTileSet().getTile(!isDoorClosed ? DOOR_CLOSED_TILE_ID : DOOR_OPEN_TILE_ID));
        setCell(cell);
        isDoorClosed = !isDoorClosed;
        callOnChangeListener(this);
    }

    @Override
    public void doOnTouchAction() {
    }

    /**
     * Sets status of the door
     * @param isDoorOpen true = open, false = closed
     */
    private void setDoorClosed(boolean isDoorOpen){
        this.isDoorClosed = isDoorOpen;
    }
}
