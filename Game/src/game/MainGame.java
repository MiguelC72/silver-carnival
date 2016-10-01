package game;

import game.display.Display;

public class MainGame {

	private Display display;
	
	public MainGame(String title, int width, int height) {
		
		display = new Display(title, width, height);
		
		
	}
}
