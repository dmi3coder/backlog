package com.dmi3coder.backlog.creatures;


import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;

public class Player extends CollisionCreature {

    private final Texture texture;
    private final Camera camera;

    public Player(Texture texture, Camera camera) {
        super(texture);
        this.texture = texture;
        this.camera = camera;

    }



}
