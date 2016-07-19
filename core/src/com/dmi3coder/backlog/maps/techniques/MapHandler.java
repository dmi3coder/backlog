package com.dmi3coder.backlog.maps.techniques;


import com.badlogic.gdx.maps.tiled.TiledMap;

public class MapHandler {
    private TiledMap map;
    int mapWidth;
    int mapHeight;

    public MapHandler(TiledMap map) {
        this.map = map;
        this.mapWidth = map.getProperties().get("width",Integer.class);
        this.mapHeight = map.getProperties().get("height",Integer.class);
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
}
