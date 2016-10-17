package game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.entities.Entity;
import game.gfx.Assets;
import game.states.State;

/**
 * The Player class is the class that contains all the important 
 * functions regarding the controllable player character.
 * Including its update and render functions.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Player extends Creature {

	public char lastDirection;
	
	/**
	 * The player's attackBox
	 */
	public Rectangle attackBox;
	
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
		
		attackBox = new Rectangle();
		
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
		
		if (handler.getKeyManager().up) {
			yMove = -speed;
			lastDirection = 'u';
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
			lastDirection = 'd';
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
			lastDirection = 'l';
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
			lastDirection = 'r';
		} 
		
		if (handler.getKeyManager().space) {
			attackBox = new Rectangle();
			System.out.println("lmao");
			attk();
		}
	}
	
	public void attk() {
		if (lastDirection == 'u') {
			attackBox.x = bounds.x;
			attackBox.y = -bounds.y;
			attackBox.width = 20;
			attackBox.height = 25;
		} else if (lastDirection == 'd') {
			attackBox.x = bounds.x;
			attackBox.y = bounds.height + bounds.y;
			attackBox.width = 20;
			attackBox.height = 25;
		} else if (lastDirection == 'l') {
			attackBox.x = -bounds.x;
			attackBox.y = bounds.y;
			attackBox.width = 25;
			attackBox.height = 20;
		} else if (lastDirection == 'r') {
			attackBox.x = bounds.width + bounds.x;
			attackBox.y = bounds.y;
			attackBox.width = 25;
			attackBox.height = 20;
		} else {
			return;
		}
		checkAttackCollisions();
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
		g.setColor(Color.red);
		g.fillRect((int) (x + attackBox.x - handler.getGameCamera().getxOffset())
		 , (int) (y + attackBox.y - handler.getGameCamera().getyOffset()), attackBox.width, attackBox.height);
	}

	@Override
	public void die() {
		State.setState(handler.getGame().getGameOverState());
		
	}
	
	@Override
	public void hurt() {
		System.out.println("lmfao");
	}
	
	public void checkAttackCollisions() {
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) // the entity is obviously going to collide with itself, ignore it
				continue;
			
			
			// check if the current entity e's hitbox intersects with this entity's next x/y move location
			if (attackBox.intersects(e.getCollisionBounds(0f,  0f))) {
				System.out.println("attacked");
				e.hurt();
			}
		}
	}

	
	
}
