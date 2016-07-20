package com.dmi3coder.backlog.maps.techniques;


import com.badlogic.gdx.maps.tiled.TiledMap;
import com.dmi3coder.backlog.sprites.Object;

public class WrappedMap {

    private TiledMap map;
    private Object[][] actionObjects;
    private Boolean[][] solidBlocks;


    public WrappedMap(TiledMap map) {
        this.map = map;
    }


    public TiledMap getMap() {
        return map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public Object[][] getActionObjects() {
        return actionObjects;
    }

    public void setActionObjects(Object[][] actionObjects) {
        this.actionObjects = actionObjects;
    }

    public Boolean[][] getSolidBlocks() {
        return solidBlocks;
    }

    public void setSolidBlocks(Boolean[][] solidBlocks) {
        this.solidBlocks = solidBlocks;
    }

    public enum MapLayers{
        FLOOR("floor"),ACTION("action"),SOLID("solid"),TOP("top"),OBJECT("object");

        private String layerName;
        MapLayers(String layerName){
            this.layerName = layerName;
        }

        public String getLayerName(){
            return layerName;
        }

    }
}
