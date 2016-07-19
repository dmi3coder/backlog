package com.dmi3coder.backlog.maps.techniques;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.dmi3coder.backlog.sprites.Object;
import com.dmi3coder.backlog.sprites.objects.Chest;

import java.util.HashMap;

class MapParser {
    private MapHandler handler;
    private Object[][] actionObjects;

    protected enum MapLayers{
        FLOOR("floor"),ACTION("action"),TOP("top"),OBJECT("object");

        private String layerName;
        MapLayers(String layerName){
            this.layerName = layerName;
        }
    }


    MapParser(MapHandler handler) {
        this.handler = handler;
        initMap(handler.getMap());
    }
    private void initMap(TiledMap map){
        initMapTextureLayer((TiledMapTileLayer) map.getLayers().get(MapLayers.FLOOR.layerName));
        initMapActionLayer((TiledMapTileLayer) map.getLayers().get(MapLayers.ACTION.layerName));
    }

    private void initMapTextureLayer(TiledMapTileLayer mapLayer) {

    }

    private void initMapActionLayer(TiledMapTileLayer actionLayer) {

        actionObjects = new Object[actionLayer.getHeight()][actionLayer.getWidth()];
        for (int row = 0; row < actionObjects.length; row++) {
            for (int i = 0; i < actionObjects[0].length; i++) {
                TiledMapTileLayer.Cell cell = actionLayer.getCell(i,row);
                if(cell != null){
                    if (cell.getTile().getProperties().get("object").equals("door")){
                        Gdx.app.log("Parser: ","found tile");
                        actionObjects[row][i] = new Chest(cell.getTile());
                    }
                }
            }
        }
    }

    /**
     * Provides Objects from map of Action layer
     * @param x tile x position of object(width)
     * @param y tile y position of object(height)
     * @return game object
     */
    public Object getActionObject(int x,int y) {
        if(actionObjects[y][x] == null)
            throw new NullPointerException("No such tile at x:"+x+" ,y:"+y);
        return actionObjects[y][x];
    }
}
