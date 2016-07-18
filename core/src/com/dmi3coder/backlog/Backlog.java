package com.dmi3coder.backlog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.dmi3coder.backlog.creatures.Player;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.cell;

public class Backlog extends ApplicationAdapter {
	Texture img;
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
		batch = new SpriteBatch();
		player = new Player(new Texture("player.png"),camera);
		camera.position.set(player.getX(),player.getY(),0);
		mapWidth = tiledMap.getProperties().get("width",Integer.class);
		mapHeight = tiledMap.getProperties().get("height",Integer.class);
		tileLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
		previousPosition = new Vector2();
	}

	@Override
	public void render () {
		float deltaTime = Gdx.graphics.getDeltaTime();
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
		handleInput(deltaTime);
		camera.position.x = player.getX() +player.getWidth()/2;
		camera.position.y = player.getY() +player.getHeight()/2;
		Gdx.app.log("position",player.getX()+player.getOriginX()+" "+player.getY()+player.getOriginY());
	}

		private void handleInput(float deltaTime) {

			float x = player.getX();
			float y = player.getY();
			previousPosition.set(player.getX(),player.getY());
			if(player != null){
				if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
					player.setPosition(player.getX() + (-200* deltaTime), player.getY());
					if(tileLayer.getCell(cellPos(player.getX()),cellPos(player.getY())).getTile().getProperties().containsKey("solid")||
							tileLayer.getCell(cellPos(player.getX()),cellPos(player.getY()+player.getHeight())).getTile().getProperties().containsKey("solid"))
						returnToPreviousPosition(player,previousPosition);
				}else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
					player.setPosition(player.getX() + (200* deltaTime), player.getY());
					if(tileLayer.getCell(cellPos(player.getX()+player.getWidth()),cellPos(player.getY())).getTile().getProperties().containsKey("solid")||
							tileLayer.getCell(cellPos(player.getX()+player.getWidth()),cellPos(player.getY()+player.getHeight())).getTile().getProperties().containsKey("solid"))
						returnToPreviousPosition(player,previousPosition);
				}else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
					player.setPosition(player.getX(), player.getY() + (200 * deltaTime));
					if(tileLayer.getCell(cellPos(player.getX()),cellPos(player.getY()+player.getHeight())).getTile().getProperties().containsKey("solid")||
							tileLayer.getCell(cellPos(player.getX()+player.getWidth()),cellPos(player.getY()+player.getHeight())).getTile().getProperties().containsKey("solid"))
						returnToPreviousPosition(player,previousPosition);
				}else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
					player.setPosition(player.getX(), player.getY() + (-200 * deltaTime));
					if(tileLayer.getCell(cellPos(player.getX()),cellPos(player.getY())).getTile().getProperties().containsKey("solid")||
							tileLayer.getCell(cellPos(player.getX()+player.getWidth()),cellPos(player.getY())).getTile().getProperties().containsKey("solid"))
						returnToPreviousPosition(player,previousPosition);
				}

			}

	}

	private void returnToPreviousPosition(Sprite sprite,Vector2 previousPosition){
		sprite.setPosition(previousPosition.x,previousPosition.y);
	}

	private int cellPos(float i){
		return ((int) (i / 32));
	}
}
