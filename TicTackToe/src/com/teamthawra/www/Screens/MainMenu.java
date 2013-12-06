package com.teamthawra.www.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.teamthawra.www.XO;

public class MainMenu implements Screen{
	
	BitmapFont defaultFont;
	TextButton playButton; 
	TextButton.TextButtonStyle playButtonStyle;
	Skin skin;
	TextureAtlas atlas;
	Stage stage;
	SpriteBatch batch;
	XO game;
	PlayGround playGround;
	
	
	public MainMenu (XO game) {
		
		this.game = game;
		
	}

	@Override
	public void render(float delta) {
	
		stage.act(delta);
		batch.begin();
		stage.draw();
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		playGround = new PlayGround(this);
		batch = new SpriteBatch();
		defaultFont = new BitmapFont(Gdx.files.internal("fonts/default.fnt"), false);
		atlas = new TextureAtlas("images/mainmenu/mainmenu.atlas");
		skin = new Skin(atlas);
		playButtonStyle = new TextButtonStyle();
		playButtonStyle.font = defaultFont;
		playButtonStyle.up = skin.getDrawable("button");
		playButtonStyle.down = skin.getDrawable("button");
		playButton = new TextButton("Play Game", playButtonStyle);
		playButton.setX(70);
		playButton.setY(200);
		stage = new Stage(380, 630, true);
		Gdx.input.setInputProcessor(stage);
		stage.addActor(playButton);
		playButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(playGround);
				System.out.println("switch to play ground");
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
	
	

}
