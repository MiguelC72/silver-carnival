package game.states;

import java.awt.Graphics;

import game.Handler;
import game.worlds.World;

/**
 * The game state contains the main world object and is able to 
 * update that object.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Game extends State{
	
	/**
	 * The world that the game will use
	 */
	private World world;
	
	/**
	 * Constructs the game object, creates a new world object using
	 * a predetermined file path, and sets it in the handler
	 * @param handler
	 * 	The main handler
	 */
	public Game(Handler handler) {
		
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		//world = new World(handler, "res/worlds/world2.txt");
		handler.setWorld(world);

	}
	
	/**
	 * Calls the world object's update method.
	 */
	public void update() {
		world.update();
		
		
	}
	
	/**
	 * Calls the world object's render method.
	 */
	public void render(Graphics g) {
		world.render(g);
		
	}
}
