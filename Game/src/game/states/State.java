package game.states;

import java.awt.Graphics;

import game.Handler;

/**
 * The State class acts as a basis for any future state classes.
 * This class also determines what the current state of the game is
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public abstract class State {
	
	/**
	 * The current state the game is in
	 */
	private static State currentState = null;
	
	/**
	 * The Main handler
	 */
	protected Handler handler;
	
	/**
	 * Constructs the main state object, setting its handler variable
	 * @param handler
	 * 	The main handler
	 */
	public State(Handler handler) {
		
		this.handler = handler;
	}
	
	/**
	 * Sets the current state that the game is in
	 * @param state
	 * 	The new state of the game
	 */
	public static void setState(State state) {
		
		currentState = state;
	}
	
	/**
	 * Returns the current state the game is in
	 * @return
	 * 	The current state of the game
	 */
	public static State getState() {
		
		return currentState;
	}
	
	/**
	 * The game has many different states it can be in, 
	 * leaving this abstracted allows for each state to update the game
	 * as it needs to
	 */
	public abstract void update();
	
	/**
	 * The game has many different states it can be in,
	 * leaving this abstracted allows for each state to render the game
	 * as it needs to
	 * @param g
	 * 	The graphics object that allows the other render methods
	 * 	to drawn on the screen
	 */
	public abstract void render(Graphics g);
}
