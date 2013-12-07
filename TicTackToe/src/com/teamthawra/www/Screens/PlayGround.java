package com.teamthawra.www.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.teamthawra.www.Zone;

public class PlayGround implements Screen {
	
	MainMenu game;
	Texture gridTex;
	SpriteBatch batch;
	Zone[] zones = new Zone[9];
	Stage stage;
	Image gridImage ;

	public PlayGround(MainMenu game){
		this.game = game;
	}
	
	

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		
		//Draw Grid
		gridTex = new Texture("images/playground/grid.png");
		gridImage = new Image(gridTex);
		batch = new SpriteBatch();
		gridImage.setPosition(40, 100);
		
		//Create the Zones
		zones[0] = new Zone(50, 378);
		zones[1] = new Zone(151, 378);
		zones[2] = new Zone(251, 378);
		zones[3] = new Zone(50, 242);
		zones[4] = new Zone(151, 242);
		zones[5] = new Zone(251, 242);
		zones[6] = new Zone(50, 108);
		zones[7] = new Zone(151, 108);
		zones[8] = new Zone(251, 108);
		
		//Creating the stage and adding actors
		stage = new Stage(380, 630, true);
		stage.addActor(gridImage);
		for(int i = 0 ; i< zones.length ; i++)
			stage.addActor(zones[i].getImage());
		Gdx.input.setInputProcessor(stage);
		
		
	
	}
	
	@Override
	public void render(float delta) {
		
		//It clears the older screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//Drawing the stage and it's childrens
		batch.begin();
		stage.draw();
		batch.end();
		
		//Fires the listeners
		stage.act(delta);
		
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
