package com.teamthawra.www.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.teamthawra.www.XO;
import com.teamthawra.www.Zone;

public class PlayGround implements Screen {
	
	MainMenu game;
	Stage stage;
	Texture gridTex;
	Image gridImage ;
	TextButton restart ;
	TextButtonStyle style ;
	String turn ;
	//Image restart ;
	SpriteBatch batch;
	Zone[] zones = new Zone[9];
	End end;
	XO game1;
	
	
	

	public PlayGround(MainMenu game){
		this.game = game;
	}
	
	

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		
		game1 = new XO();
		end = new End(this);
		
		//Draw Grid
		gridTex = new Texture("images/playground/grid.png");
		gridImage = new Image(gridTex);
		batch = new SpriteBatch();
		gridImage.setPosition(40, 100);
		
		//Draw Restart
	
		style = new TextButtonStyle();
		style.font = MainMenu.defaultFont;
		TextureRegionDrawable drawable =new TextureRegionDrawable(Zone.atlas.findRegion("restart"));
		style.up  = drawable ;
		style.down = drawable ;
		restart = new TextButton("Restart",style);
		
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
		
		restart.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				for(int i = 0 ; i < zones.length ; i++)
				{
					zones[i].setPlayer(0) ;
					zones[i].setClicked(false);
					zones[i].getImage().setDrawable(new TextureRegionDrawable(Zone.atlas.findRegion("empty")));	
				}
				Zone.counter = 1 ;
				
				return true;
				
			}
			
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				
			}
		});
		
		
		//Creating the stage and adding actors
		stage = new Stage(380, 630, true);
		stage.addActor(gridImage);
		for(int i = 0 ; i< zones.length ; i++)
			stage.addActor(zones[i].getImage());
		stage.addActor(restart);
		Gdx.input.setInputProcessor(stage);
		
		
		
	
	}
	
	@Override
	public void render(float delta) {
		
		//It clears the older screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		System.out.println(Zone.counter);
		if(Zone.counter%2==0)
		{turn = "O's TURN";}
		else
		{turn = "X's TURN";}
		
		check();
		
		//Drawing the stage and it's children's
		batch.begin();
		stage.draw();
		batch.end();
		
		batch.begin();
		MainMenu.title.draw(batch,turn, 114 , 570);
		batch.end();
		
		//Fires the listeners
		stage.act(delta);
		
	}

	public void check()
	{
		//Horizontal
		for(int i = 0 ; i<7;i += 3)
		{
			if(zones[i].getPlayer()==1 && zones[i+1].getPlayer()==1 && zones[i+2].getPlayer()==1)
			{
				System.out.println("Player 1 wins");
				End.setWinner(1);
				stage.clear();
				MainMenu.game.setScreen(end);
				
			}
			else if(zones[i].getPlayer()==2 && zones[i+1].getPlayer()==2 && zones[i+2].getPlayer()==2)
			{
				System.out.println("Player 2 wins");
				End.setWinner(2);
				stage.clear();
				MainMenu.game.setScreen(end);
			}
			else if (Zone.counter == 10)
			{
				stage.clear();
				MainMenu.game.setScreen(end);
			}
		}
		//Vertical :
		for(int i = 0 ; i<3;i++)
		{
			if(zones[i].getPlayer()==1 && zones[i+3].getPlayer()==1 && zones[i+6].getPlayer()==1)
			{
				System.out.println("Player 1 wins");
				End.setWinner(1);
				stage.clear();
				MainMenu.game.setScreen(end);
			}
			else if(zones[i].getPlayer()==2 && zones[i+3].getPlayer()==2 && zones[i+6].getPlayer()==2)
			{
				System.out.println("Player 2 wins");
				End.setWinner(2);
				stage.clear();
				MainMenu.game.setScreen(end);
			}
			else if (Zone.counter == 10)
			{System.out.println("Tie");
			stage.clear();
			MainMenu.game.setScreen(end);
			}
		}
		//Diagonal LeftToRight
		if(zones[0].getPlayer()==1 && zones[4].getPlayer()==1 && zones[8].getPlayer()==1)
		{System.out.println("Player 1 wins");
		End.setWinner(1);
		stage.clear();
		MainMenu.game.setScreen(end);
		}
		if(zones[0].getPlayer()==2 && zones[4].getPlayer()==2 && zones[8].getPlayer()==2)
		{System.out.println("Player 2 wins");
		End.setWinner(2);
		stage.clear();
		MainMenu.game.setScreen(end);
		}
		
		//Diagonal RightToLeft
		if(zones[2].getPlayer()==1 && zones[4].getPlayer()==1 && zones[6].getPlayer()==1)
		{System.out.println("Player 1 wins");
		End.setWinner(1);
		stage.clear();
		MainMenu.game.setScreen(end);;
		}
		if(zones[2].getPlayer()==2 && zones[4].getPlayer()==2 && zones[6].getPlayer()==2)
		{System.out.println("Player 2 wins");
		End.setWinner(2);
		stage.clear();
		MainMenu.game.setScreen(end);
		}
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
