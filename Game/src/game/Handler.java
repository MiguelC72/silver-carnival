package game;

import game.Input.KeyManager;
import game.Input.MouseManager;
import game.gfx.GameCamera;
import game.worlds.World;

/**
 * This handler class is only used to make getting specific
 * variables from other classes easier. 
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Handler {

	/**
	 * The Main mainGame object
	 */
	private MainGame mainGame;
	/**
	 * The Main world object
	 */
	private World world;
	
	/**
	 * Constructs the handler object and sets its mainGame 
	 * variable to whatever is passed in.
	 * @param game
	 * 	The MainGame variable
	 */
	public Handler(MainGame game) {
		this.mainGame = game;
	}
	/**
	 * Returns the window's width in pixels
	 * @return
	 * 	The Window's width in pixels
	 */
	public int getWidth() {
		return mainGame.getWidth();
	}
	/**
	 * Returns the window's height in pixels
	 * @return
	 * 	The Window's height in pixels
	 */
	public int getHeight() {
		return mainGame.getHeight();
	}
	/**
	 * Returns the mainGame keyManager
	 * @return
	 * 	The mainGame keyManager
	 */
	public KeyManager getKeyManager() {
		return mainGame.getKeyManager();
	}
	/**
	 * Returns the mainGame mouseManager
	 * @return
	 * The mainGame mouseManager
	 */
	public MouseManager getMouseManager() {
		return mainGame.getMouseManager();
	}
	/**
	 * Return the mainGame camera
	 * @return
	 * 	The mainGame camera
	 */
	public GameCamera getGameCamera() {
		return mainGame.getGameCamera();
	}
	/**
	 * Returns the MainGame object itself
	 * @return
	 * 	The MainGame object
	 */
	public MainGame getGame() {
		return mainGame;
	}
	/**
	 * Sets the MainGame object to whatever is passed in
	 * @param game
	 * 	The new MainGame object
	 */
	public void setGame(MainGame game) {
		this.mainGame = game;
	}
	/**
	 * Returns the main world object
	 * @return
	 * 	The main world object
	 */
	public World getWorld() {
		return world;
	}
	/**
	 * Sets the main world object
	 * @param world
	 * 	The new world object
	 */
	public void setWorld(World world) {
		this.world = world;
	}
}
