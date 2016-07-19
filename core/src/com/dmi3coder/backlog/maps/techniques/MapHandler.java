package com.dmi3coder.backlog.maps.techniques;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MapHandler {
    private TiledMap map;
    int mapWidth;
    int mapHeight;
    MapParser parser;

    public MapHandler(TiledMap map) {
        this.map = map;
        this.mapWidth = map.getProperties().get("width",Integer.class);
        this.mapHeight = map.getProperties().get("height",Integer.class);
        parser = new MapParser(this);
    }


    public TiledMap getMap() {
        return map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }


    public void doActionOnCellByRealPos(float x,float y){
        int tilePositionX = cellPos(x);
        int tilePositionY = cellPos(y);
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get("action")).getCell(tilePositionX,tilePositionY);
        Gdx.app.log("action","it's me on "+tilePositionX+" "+tilePositionY);
    }

    public static int cellPos(float i){
        return ((int) (i / 32));
    }
}
