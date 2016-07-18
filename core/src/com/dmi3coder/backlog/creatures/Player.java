package com.dmi3coder.backlog.creatures;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite{

    private final Texture texture;
    private final Camera camera;
    private double deltaTime;
    private Vector2 position;

    public Player(Texture texture, Camera camera) {
        super(texture,30,30);
        this.texture = texture;
        this.camera = camera;
        this.deltaTime = Gdx.graphics.getDeltaTime();
    }

}
