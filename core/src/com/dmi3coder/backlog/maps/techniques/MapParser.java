package com.dmi3coder.backlog.maps.techniques;


import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;

class MapParser {
    protected enum MapLayers{
        FLOOR("floor"),ACTION("action"),TOP("top"),OBJECT("object");

        private String layerName;
        MapLayers(String layerName){
            this.layerName = layerName;
        }
    }

    private TiledMap map;

    MapParser(TiledMap map) {
        this.map = map;
    }
    private void initMap(TiledMap map){
        initMapTextureLayer(map.getLayers().get(MapLayers.FLOOR.layerName));
        initMapActionLayer(map.getLayers().get(MapLayers.ACTION.layerName));
    }

    private void initMapTextureLayer(MapLayer mapLayer) {

    }

    private void initMapActionLayer(MapLayer action) {

    }

}
