package game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.ImageLoader;

/**
 * The settings/pause state, stops the entire game state from updating
 * and rendering, and instead displays an image of a settings screen.
 * Future plans include allowing the user to set variables through use
 * of the mouse on the selected image.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Settings extends State{
	
	/**
	 * The image to be displayed
	 */
	private BufferedImage img;

	/**
	 * The constructor for the settings object, uses a predetermined file
	 * path to load an image to the img variable
	 * @param handler
	 */
	public Settings(Handler handler) {
		super(handler);
		img = ImageLoader.loadImage("/textures/testSettings.png");
		
	}

	/**
	 * Right now it only checks to see if the pause key has been pressed
	 * again to switch back to the game state.
	 * Future plans include putting the mouse controls here
	 */
	public void update() {
		if (!(handler.getKeyManager().pause)) {
			State.setState(handler.getGame().getGameState());
		}
		
	}
	
	/**
	 * Renders the image onto the window, since the image has a white
	 * background the window is also colored white to avoid having an
	 * image that doesn't look like it failed to cover the entire window.
	 */
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.drawImage(img, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
		
	}
	
}
