package com.teamthawra.www.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
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
import com.teamthawra.www.Zone;

public class MainMenu implements Screen{
	
	//Play Button
	TextButton playButton; 
	TextButton.TextButtonStyle playButtonStyle;
	//Exit Button
	TextButton exitButton;
	TextButtonStyle exitButtonStyle;
	//Fonts
	public static BitmapFont title;
	public static BitmapFont defaultFont;
	//Default Initializing
	Skin skin;
	TextureAtlas atlas;
	Stage stage;
	SpriteBatch batch;
	//Screen Switching
	public static XO game;
	PlayGround playGround;
	End game2;
	
	
	public MainMenu (XO game) {
		
		this.game = game;
		
	}
	
	public MainMenu (End game2){
		this.game2 = game2;
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		//Stage Drawing
		batch.begin();
		stage.draw();
		batch.end();
		//Text Drawing
		batch.begin();
		title.draw(batch, "Tick-Tack-Thawra", 60 , 510);
		batch.end();
		
		
	}
	

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
		//Restarting
		End.setWinner(0);
		Zone.counter = 1;
		
		//Creating the defaults
		playGround = new PlayGround(this);
		batch = new SpriteBatch();
		defaultFont = new BitmapFont(Gdx.files.internal("fonts/default.fnt"), false);
		title = new BitmapFont(Gdx.files.internal("fonts/default.fnt"), false);
		title.setScale(1.2f);
		atlas = new TextureAtlas("images/mainmenu/mainmenu.atlas");
		skin = new Skin(atlas);
		//Play Button Creation
		playButtonStyle = new TextButtonStyle();
		playButtonStyle.font = defaultFont;
		playButtonStyle.up = skin.getDrawable("button");
		playButtonStyle.down = skin.getDrawable("button");
		playButton = new TextButton("Play Game", playButtonStyle);
		playButton.setX(70);
		playButton.setY(200);
		//Exit Button Creation
		exitButtonStyle = new TextButtonStyle();
		exitButtonStyle.font = defaultFont;
		exitButtonStyle.up = skin.getDrawable("button");
		exitButtonStyle.down = skin.getDrawable("button");
		exitButton = new TextButton("Exit", exitButtonStyle);
		exitButton.setX(70);
		exitButton.setY(74);
		
		//Stage default listening
		stage = new Stage(380, 630, true);
		Gdx.input.setInputProcessor(stage);
		
		
		//Play Button Listener
		stage.addActor(playButton);
		playButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				stage.clear();
				game.setScreen(playGround);
				return true;
			}
			
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				
			}
		});
		
		//Exit Button Listener
		stage.addActor(exitButton);
		exitButton.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.exit();
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
