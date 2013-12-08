package com.teamthawra.www.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.teamthawra.www.XO;
import com.teamthawra.www.Zone;

public class End implements Screen {
	
	static int winner = 0;
	SpriteBatch batch;
	static Stage stage;
	MainMenu main;
	PlayGround playground;
	
	public End (PlayGround playground) {	
		this.playground = playground;
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		System.out.println("Rendering in end");
		if (winner == 1){
			batch.begin();
			MainMenu.title.draw(batch, "X WON!", 114, 570);
			batch.end();
		}
		else if (winner == 2){
			batch.begin();
			MainMenu.title.draw(batch, "O WON!", 114, 570);
			batch.end();
		}
		else {
			batch.begin();
			MainMenu.title.draw(batch, "It's a tie", 114, 570);
			batch.end(); }
		batch.begin();	
		MainMenu.title.draw(batch, "Press anywhere to continue",10, 300);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		main = new MainMenu(this);
		stage = new Stage(380, 630 , true);
		Gdx.input.setInputProcessor(stage);
		stage.addListener(new InputListener() {
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        	MainMenu.game.setScreen(main);
                return true;
        }
        
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                
        }
		});
		
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

	public static void setWinner(int winner) {
		End.winner = winner;
	}

	public static int getWinner() {
		return winner;
	}
}
