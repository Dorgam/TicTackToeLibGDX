package com.teamthawra.www.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamthawra.www.*;

public class PlayGround implements Screen {
	
	XO game;
	private Texture gridTex;
	private Sprite grid;
	private SpriteBatch batch;

	public PlayGround(XO game){
		this.game = game;
	}
	
	

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		
		gridTex = new Texture("images/playground/grid.png");
		grid = new Sprite(gridTex);
		batch = new SpriteBatch();
		grid.setPosition(40, 100);
		System.out.println("Hi");
		
	}
	
	@Override
	public void render(float delta) {
		
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		grid.draw(batch);
		batch.end();
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

}
