package game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.ImageLoader;

public class Settings extends State{
	
	
	private BufferedImage img;

	public Settings(Handler handler) {
		super(handler);
		img = ImageLoader.loadImage("/textures/testSettings.png");
		
	}

	public void update() {
		if (!(handler.getKeyManager().pause)) {
			State.setState(handler.getGame().getGameState());
		}
		
	}
	

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.drawImage(img, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
		
	}
	
}
