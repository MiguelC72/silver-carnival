package game.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import game.Handler;
import game.entities.creatures.Player;

/**
 * This class contains an ArrayList that will be used to manage all of the 
 * entities in the game. This Class can also update and render all entities that
 * are in it's ArrayList.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class EntityManager {
	
	/**
	 * The main handler
	 */
	private Handler handler;
	/**
	 * The Controllable Player Entity
	 */
	private Player player;
	/**
	 * An ArrayList containing all entities in the game, including the player entity
	 */
	private ArrayList<Entity> entities;
	
	/**
	 * The renderSorter allows us to sort each entity in the ArrayList based 
	 * off of their location on the Y axis. The higher they are the sooner they're rendered.
	 */
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	/**
	 * The Constructor for the EntityManager. Sets the classes main variables and 
	 * puts the player entity into the ArrayList it creates
	 * @param handler
	 * 	The Main handler
	 * @param player
	 * 	The controllable player entity
	 */
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	/**
	 * Goes through every entity in the ArrayList of entities and call their update methods
	 * Also sorts the ArrayList using the renderSorter
	 */
	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.update();
			if (!e.isAlive())
				entities.remove(e);
		}
		entities.sort(renderSorter);
	}
	
	/**
	 * Goes through every entity in the ArrayList of entities and calls their render methods.
	 * Since the update method is always called before the render method is, the ArrayList is 
	 * already sorted and will correctly render all entities to the screen.
	 * @param g
	 * 	The graphics object that will allow this method and any called render methods to draw to the screen.
	 */
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	/**
	 * Adds an entity to the ArrayList.
	 * @param e
	 * 	The new entity that will be added to the ArrayList
	 */
	public void addEntity(Entity e) {
		entities.add(e);
	}

	// getters and setters
	
	/**
	 * Returns the main handler
	 * @return
	 * 	The main handler
	 */
	public Handler getHandler() {
		return handler;
	}
	/**
	 * Sets the main handler of this object
	 * @param handler
	 * 	The new main handler for this object
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	/**
	 * Returns the controllable player entity
	 * @return
	 * 	The controllable player entity
	 */
	public Player getPlayer() {
		return player;
	}
	/**
	 * Sets the controllable player entity of this object
	 * @param player
	 * 	The new controllable player entity
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	/**
	 * Returns the ArrayList containing all entities in the game
	 * @return
	 * 	The ArrayList containing all entities
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	/**
	 * Sets a new ArrayList that will contain another set of entities
	 * @param entities
	 * 	The new ArrayList containing another set of entities
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	

}
