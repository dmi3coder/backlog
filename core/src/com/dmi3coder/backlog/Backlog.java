package com.dmi3coder.backlog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.dmi3coder.backlog.creatures.Player;

public class Backlog extends ApplicationAdapter {
	TiledMap tiledMap;
	TiledMapTileLayer tileLayer;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	SpriteBatch batch;
	Player player;
	float deltaTime;
	int mapWidth;
	int mapHeight;
	private Vector2 previousPosition;


	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		deltaTime = Gdx.graphics.getDeltaTime();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.setToOrtho(false,w,h);
		camera.update();
		tiledMap = new TmxMapLoader().load("office.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
		batch = new SpriteBatch();
		player = new Player(new Texture("player.png"),tileLayer);
		player.setPosition(40,40);
		camera.position.set(player.getX(),player.getY(),0);
		mapWidth = tiledMap.getProperties().get("width",Integer.class);
		mapHeight = tiledMap.getProperties().get("height",Integer.class);
		previousPosition = new Vector2();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		tiledMapRenderer.setView(camera);
		int[] layers = new int[]{0};
		tiledMapRenderer.render(layers);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.draw(batch);
		batch.end();
		layers = new int[]{1};
		tiledMapRenderer.render(layers);
		camera.position.x = player.getX() +player.getWidth()/2;
		camera.position.y = player.getY() +player.getHeight()/2;
		Gdx.app.log("position",player.getX()+player.getOriginX()+" "+player.getY()+player.getOriginY());
	}


	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		camera = new OrthographicCamera(width,height);

	}

}
