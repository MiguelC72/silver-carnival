package game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.MainGame;

/**
 * The Entity class is an abstract class that is the basis
 * for all of the game's entities, which could be the player, enemies
 * or static things like trees.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public abstract class Entity {
	
	/**
	 * The main handler
	 */
	protected Handler handler;
	/**
	 * The entity's x and y position in pixels
	 */
	protected float x, y;
	/**
	 * The entity's width and height in pixels
	 */
	protected int width, height;
	/**
	 * The entity's hitbox
	 */
	protected Rectangle bounds;
	
	/**
	 * Constructs an entity object setting its variables and 
	 * creating its bounding box (using some simple defaults)
	 * 
	 * @param handler
	 * 	The main handler object
	 * @param x
	 * 	The entity's x position in tixels (tile pixels)
	 * @param y
	 * 	The entity's y position in tixels (tile pixels)
	 * @param width
	 * 	The entity's width in pixels
	 * @param height
	 * 	The entity's height in pixels
	 */
	public Entity(Handler handler, float x, float y, int width, int height) {
		
		this.handler = handler;
		this.x = x;				// Entity's x position
		this.y = y;				// Entity's y position
		this.width = width;		// Entity's width
		this.height = height;	// Entity's height
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	/**
	 * The entity's update method, differs between entities
	 */
	public abstract void update();
	
	/**
	 * The entity's render method, differs between entities
	 * @param g
	 * 	The graphics object needed to be able to draw to the screen
	 */
	public abstract void render(Graphics g);
	
	/**
	 * Goes through every entity and checks if there is an 
	 * intersection between an entity and this entity's next x/y move location
	 * @param xOffset
	 * 	This entity's next move location on the x axis
	 * @param yOffset
	 * 	This entity's next move location on the y axis
	 * @return
	 * 	Whether or not any entity collides with the given coordinates
	 */
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) // the entity is obviously going to collide with itself, ignore it
				continue;
			
			// check if the current entity e's hitbox intersects with this entity's next x/y move location
			if (e.getCollisionBounds(0f,  0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	/**
	 * Takes the entity that called it, and returns a 
	 * rectangle object that represents its hitbox
	 * @param xOffset
	 * 	Represents any future movement that the entity might have 
	 * 	on the x axis
	 * 	(can be 0, representing no movement)
	 * @param yOffset
	 * 	Represents any future movement that the entity might have
	 *  on the y axis
	 *  (can be 0, representing no movement)
	 * @return
	 * 	A Rectangle that represents the entity's hitbox
	 *  (can also represents the entity's at a displaced location
	 *  based off of the given parameters)
	 */
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset)
				, (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	// Getters and Setters
	
	/**
	 * Returns the entity's x position in tixels
	 * @return
	 * 	Entity's x position in tixels
	 */
	public float getX() {
		return x;
	}
	/**
	 * Sets the entity's x position to the given tixel amount
	 * @param x
	 * 	The new x position in tixels
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * Returns the entity's y position in tixels
	 * @return
	 * 	Entity's y position in tixels
	 */
	public float getY() {
		return y;
	}
	/**
	 * Sets the entity's y position to the given tixel amount
	 * @param y
	 * 	The new y position in tixels
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * Returns the width of the entity in pixels
	 * @return
	 * 	Width of the entity in pixels
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Sets the entity's width value to the given pixel amount
	 * @param width
	 * 	The new width in pixels
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * Returns the height of the entity in pixels
	 * @return
	 * 	Height of the entity in pixels
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Sets the entity's height value to the given pixel amount
	 * @param height
	 * 	The new height in pixels
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
