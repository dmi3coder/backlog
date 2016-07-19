package com.dmi3coder.backlog.sprites;


import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.dmi3coder.backlog.maps.techniques.MapHandler;

public abstract class Object implements Actionable {
    private TiledMapTileLayer.Cell objectCell;
    private static final String OBJECT_TILES_NAME = "*";
    private MapHandler handler;
    private int objectId = 0;
    private int cellX;
    private int cellY;
    public OnChangeListener onChangeListener;

    public Object(int objectId, TiledMapTileLayer.Cell objectCell, MapHandler handler, int cellX, int cellY){
        this.objectId = objectId;
        this.objectCell = objectCell;
        this.handler = handler;
        this.cellX = cellX;
        this.cellY = cellY;
    }

    public Object(TiledMapTile tiledMapTile, TiledMapTileLayer.Cell objectCell, MapHandler handler, int cellX, int cellY){
        this.objectId = tiledMapTile.getId();
        this.objectCell = objectCell;
        this.handler = handler;
        this.cellY = cellY;
    }

    public void setOnChangeListener(OnChangeListener onChangeListener){
        this.onChangeListener = onChangeListener;
    }

    public TiledMapTileLayer.Cell getCell() {
        return objectCell;
    }

    public void setCell(TiledMapTileLayer.Cell objectCell) {
        this.objectCell = objectCell;
    }

    public MapHandler getHandler() {
        return handler;
    }

    public void setHandler(MapHandler handler) {
        this.handler = handler;
    }

    public int getCellX() {
        return cellX;
    }

    public void setCellX(int cellX) {
        this.cellX = cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public void setCellY(int cellY) {
        this.cellY = cellY;
    }
    public void callOnChangeListener(Object object){
        onChangeListener.onTextureChanged(object);
    }
}
