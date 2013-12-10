package com.teamthawra.www;
import com.badlogic.gdx.Game;
import com.teamthawra.www.Screens.MainMenu;

public class XO extends Game {
	
	//Screen going to
	MainMenu main;

	@Override
	public void create() {
	
	//Taking the certain screen through the screen you are going to consstructor
	main = new MainMenu(this);
		
	//Setting the screen
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