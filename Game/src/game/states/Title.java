package game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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

	public BufferedImage img;
	/**
	 * Constructs a title state object and passes the handler to the main state object.
	 * @param handler
	 * 	The main handler
	 */
	Rectangle start = new Rectangle();
	Rectangle cursor = new Rectangle();
	public Title(Handler handler) {
		super(handler);
		img = ImageLoader.loadImage("/textures/titleScreen.png");
		//create hitboxes for options
		//TODO hitbox here
		start.width = 150;
		start.height = 100;
		start.x = 205;
		start.y = 420;
	}
	
	/**
	 * The update method, currently does nothing
	 */
	public void update() {
		if (checkClick(start)){
			State.setState(handler.getGame().getGameState());
		}
	}
	
	public boolean checkClick(Rectangle check){
		Rectangle cursor = new Rectangle();
		//cursor.x = 1;
		//cursor.y = 1;
		cursor.x = handler.getMouseManager().getX();
		cursor.y = handler.getMouseManager().getY();
		cursor.width = 1;
		cursor.height = 1;
		if (cursor.intersects(check) && handler.getMouseManager().left){
			return true;
		}
		else
			return false;
	}

	/**
	 * The render method, currently does nothing
	 */
	public void render(Graphics g) {
		//Draw title screen background WOW
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.drawImage(img, 0, 0, handler.getWidth(), handler.getHeight(), null);
		//Draw start rectangle
		//g.setColor(Color.BLUE);
		//g.fillRect(start.x, start.y, start.width, start.height);
	}
	
}
