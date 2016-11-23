package game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.ImageLoader;

public class Win extends State{
	
	public BufferedImage img;
	
	public Win(Handler handler) {
		super(handler);
		img = ImageLoader.loadImage("/textures/winScreen.png");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.drawImage(img, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
	}

	
}
