package game.entities.statics;

import java.awt.Rectangle;

import game.Handler;
import game.entities.Entity;

/**
 * A static entity is an entity that doesn't move but contains a hitbox
 * , and can possibly be interacted with by the player.
 * Examples include trees, chests, etc.
 * @author Miguel Cardenas Gustavo
 *
 */
public abstract class StaticEntity extends Entity {

	// this class is reserved for entities that are not moving
	
	/**
	 * Creates a Static Entity and passes variables to the Entity class
	 * @param handler
	 * 	The main handler
	 * @param x
	 * 	This entity's x position in tixels
	 * @param y
	 * 	This entity's y position in tixels
	 * @param width
	 * 	The width of this entity
	 * @param height
	 * 	The height of this entity
	 */
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}
	
}
