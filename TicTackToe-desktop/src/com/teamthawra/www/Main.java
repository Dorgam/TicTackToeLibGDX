package com.teamthawra.www;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Tic Tack Toe";
		cfg.useGL20 = true;
		cfg.width = 380;
		cfg.height = 630;
		
		new LwjglApplication(new XO(), cfg);
	}
}
