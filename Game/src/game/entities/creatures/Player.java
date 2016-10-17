package game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.gfx.Assets;

/**
 * The Player class is the class that contains all the important 
 * functions regarding the controllable player character.
 * Including its update and render functions.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Player extends Creature {

	
	/**
	 * Creates the player creature and sets its position 
	 * based on the passed parameters.
	 * Also sets up the character's hitbox.
	 * @param handler
	 * 	The main handler
	 * @param x
	 * 	This entity's x position in tixels
	 * @param y
	 * 	This entity's y position in tixels
	 */
	public Player(Handler handler, float x, float y) {
		
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 20;
		bounds.height = 20;
	}

	/**
	 * Updates this entity by calling the getInput and move functions
	 * Also tells the camera object to center itself on this entity
	 */
	public void update() {
		
		getInput();
		move();
		
		handler.getGameCamera().centerOnEntity(this);
	}
	
	/**
	 * Uses the keyManager to determine where the user wants this
	 * entity to move and sets the corresponding variables
	 */
	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
		
	}
	
	/**
	 * Renders this entity onto the screen based on the gameCamera's position
	 * @param g
	 * 	The main graphics object that also this method to draw to the screen.
	 */
	public void render(Graphics g) {
		
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset())
				, (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		// draws a bounding box
		// g.setColor(Color.red);
		// g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset())
		// , (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	
	
}
