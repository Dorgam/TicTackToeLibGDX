package com.teamthawra.www;
import com.badlogic.gdx.Game;
import com.teamthawra.www.Screens.MainMenu;
import com.teamthawra.www.Screens.PlayGround;

public class XO extends Game {
	
	MainMenu main;

	@Override
	public void create() {
	
	main = new MainMenu(this);
		
	setScreen(main);
		
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