package com.teamthawra.www;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Zone {
	
	double x;
	double y;
	int player;
	static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/playground/playGround.pack"));
	static int counter = 0;
	Image image;
	

	public Zone (double x, double y ) {
		
		//Creating the zone
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
	                System.out.println("down");
	                return true;
	        }
	        
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
	                System.out.println("up");
	        }
			});
		
	}
	
	//Getting the image so we can add it on the stage later
	public Image getImage() {
		return image;
	}
	
	
	}
