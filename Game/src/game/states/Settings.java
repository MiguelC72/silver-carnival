package game.states;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;

public class Settings extends State{

	public Settings(Handler handler) {
		
		super(handler);
	}

	public void update() {
		if (!(handler.getKeyManager().pause)) {
			State.setState(handler.getGame().getGameState());
		}
		
	}
	

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		
	}
	
}
