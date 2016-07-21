/* Copyright (c) 2014 PixelScientists
 * 
 * The MIT License (MIT)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.dmi3coder.backlog.inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.dmi3coder.backlog.Backlog;

/**
 * @author Daniel Holderbaum
 */
public class InventoryScreen implements Screen {

	private InventoryActor inventoryActor;

	public static Stage stage;

	@Override
	public void show() {
		stage = new Stage();
		Skin skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
		DragAndDrop dragAndDrop = new DragAndDrop();
		inventoryActor = new InventoryActor(new Inventory(), dragAndDrop, skin);
		stage.addActor(inventoryActor);
	}

	@Override
	public void resume() {
		Backlog.assets.finishLoading();
	}

	@Override
	public void render(float delta) {

		if (Gdx.input.isKeyPressed(Input.Keys.I)) {
			Gdx.input.setInputProcessor(stage);
			inventoryActor.setVisible(true);
		}

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// NOOP
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
		dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
