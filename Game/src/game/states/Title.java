package game.states;

import java.awt.Graphics;

import game.Handler;
import game.MainGame;

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

	/**
	 * Constructs a title state object and passes the handler to the main state object.
	 * @param handler
	 * 	The main handler
	 */
	public Title(Handler handler) {
		
		super(handler);
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
		
		
	}
	
}
