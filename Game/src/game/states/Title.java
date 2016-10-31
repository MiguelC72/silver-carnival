package game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import game.gfx.ImageLoader;

/**
 * The Title state is controls the Title Screen of the game and
 * should be the screen the user sees on game launch and whenever they
 * want to leave the game correctly. (They still have the option to exit
 * by clicking the exit button on the window)
 * Right now since there isn't a title screen created, this class doesn't do anything
 * @author Miguel Cardenas Gustavo Chavez
 *
 */

public class Title extends State{

	//public BufferedImage img;
	/**
	 * Constructs a title state object and passes the handler to the main state object.
	 * @param handler
	 * 	The main handler
	 */
	public Title(Handler handler) {
		super(handler);
		//img = ImageLoader.loadImage("/textures/testTitle.png");
		//create hitboxes for options
		//TODO hitbox here
		
	}
	
	/**
	 * The update method, currently does nothing
	 */
	public void update() {
		
		
	}

	/**
	 * The render method, currently does nothing
	 */
	public void render(Graphics g) {
		/*g.setColor(Color.BLUE);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.drawImage(img, 0, 0, handler.getWidth(), handler.getHeight(), null);*/
	}
	
}
