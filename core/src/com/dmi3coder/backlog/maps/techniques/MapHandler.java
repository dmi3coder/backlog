package com.dmi3coder.backlog.maps.techniques;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;

public class MapHandler {
    private TiledMap map;
    int mapWidth;
    int mapHeight;
    MapParser parser;
    private TiledMapTileSet tileSet;

    public MapHandler(TiledMap map) {
        this.map = map;
        this.mapWidth = map.getProperties().get("width",Integer.class);
        this.mapHeight = map.getProperties().get("height",Integer.class);
        parser = new MapParser(this);
        tileSet = map.getTileSets().getTileSet("tiles");
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
        parser.getActionObject(tilePositionX, tilePositionY).doOnClickAction();
    }

    public static int cellPos(float i){
        return ((int) (i / 32));
    }

    public TiledMapTileSet getTileSet() {
        return tileSet;
    }

    public void setTileSet(TiledMapTileSet tileSet) {
        this.tileSet = tileSet;
    }

    public MapParser getParser() {
        return parser;
    }

    public void setParser(MapParser parser) {
        this.parser = parser;
    }

    public boolean isCellSolidByRealPos(float x, float y){
        return parser.getSolidBlocks()[cellPos(y)][cellPos(x)] != null && parser.getSolidBlocks()[cellPos(y)][cellPos(x)];
    }
}
