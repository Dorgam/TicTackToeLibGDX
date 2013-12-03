package com.teamthawra.www;
import com.badlogic.gdx.Game;
import com.teamthawra.www.Screens.PlayGround;

public class XO extends Game {
	
	PlayGround playground;

	@Override
	public void create() {
		
		playground = new PlayGround(this);
		
		setScreen(playground);
		
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void render() {
		
		super.render();
		
		
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