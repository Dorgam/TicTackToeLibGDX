package com.teamthawra.www;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Zone {
	
	double x;
	double y;
	int player;
	public static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/playground/playGround.pack"));
	public static int counter = 1;
	Image image;
	boolean isClicked;
	

	public Zone (double x, double y ) {
		
		//Creating the zone
		isClicked = false;
		this.x = x;
		this.y = y;
		player = 0;
		image = new Image(atlas.findRegion("empty"));
		image.setWidth(80);
		image.setHeight(115);
		image.setBounds((float)x, (float)y, image.getWidth(), image.getHeight());
		
		//Creating the listeners
		image.setTouchable(Touchable.enabled);
		image.addListener(new InputListener() {
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	                if(!isClicked)
	                {
	                	if(counter%2 == 0){
	                		player = 2;
	                		image.setDrawable(new TextureRegionDrawable(atlas.findRegion("o")));
	                	}
	                	else
	                	{
	                		player = 1;
	                		image.setDrawable(new TextureRegionDrawable(atlas.findRegion("x")));
	                		
	                	}
	                	counter++;
	                	isClicked = true;
	                }
	                return true;
	        }
	        
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	                
	        }
			});
		
	}
	
	//Getting the image so we can add it on the stage later
	public Image getImage() {
		return image;
	}
	
	

	public int getPlayer() {
		// TODO Auto-generated method stub
		return player ;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	
	
	
	
	}
