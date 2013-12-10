package com.teamthawra.www.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class End implements Screen {
	
	
	static int winner = 0;
	SpriteBatch batch;
	static Stage stage;
	//Screen going to
	MainMenu main;
	//Screen coming from
	PlayGround playground;
	Label label;
	Label label2;
	LabelStyle labelStyle;
	
	//Constructor for screen coming from
	public End (PlayGround playground) {	
		this.playground = playground;
	}

	@Override
	public void render(float delta) {
		
		//Clears the old screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		//Drawing the results
		if (winner == 1){
			label.setText("X WON!");
		}
		else if (winner == 2){
			label.setText("O WON!");
		}
		else {
			label.setText("It's a tie!"); }
		
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		
		//Creating the objects
		batch = new SpriteBatch();
		main = new MainMenu(this);
		stage = new Stage(380, 630 , true);
		Gdx.input.setInputProcessor(stage);
		labelStyle = new LabelStyle();
		labelStyle.font = MainMenu.title;
		label = new Label ("", labelStyle);
		label2 = new Label("Press to continue", labelStyle);
		label.setPosition(132, 550);
		label2.setPosition(77, 259);
		stage.addActor(label);
		stage.addActor(label2);
		//Creating a stage listenner
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
		
		stage.dispose();
		batch.dispose();
		
	}
	
	//Setters and Getters
	public static void setWinner(int winner) {
		End.winner = winner;
	}

	public static int getWinner() {
		return winner;
	}
}
