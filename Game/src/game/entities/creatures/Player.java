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
		
		isPlayer = true;
	}

	/**
	 * Updates this entity by calling the getInput and move functions
	 * Also tells the camera object to center itself on this entity
	 */
	public void update() {
		
		getInput();
		move();
		
		handler.getGameCamera().centerOnEntity(this);
		
		if (handler.getKeyManager().space) {
			attk();
		}
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
		
	}
	
	public void attk() {
		Rectangle c = getCollisionBounds(0, 0);
		Rectangle attackBox = new Rectangle();
		int sz = 20;
		attackBox.width = sz;
		attackBox.height = sz;
		
		if (lastDirection == 'u') {
			attackBox.x = c.x + c.width / 2 - sz / 2;
			attackBox.y = c.y - sz;
		} else if (lastDirection == 'd') {
			attackBox.x = c.x + c.width / 2 - sz / 2;
			attackBox.y = c.y + c.height;
		} else if (lastDirection == 'l') {
			attackBox.x = c.x - sz;
			attackBox.y = c.y + c.height / 2 - sz / 2;
		} else if (lastDirection == 'r') {
			attackBox.x = c.x + c.width;
			attackBox.y = c.y + c.height / 2 - sz / 2;
		} else {
			return;
		}

		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			
			if (e.getCollisionBounds(0, 0).intersects(attackBox)) {
				e.hurt();
			}
		}
	}
	
	/**
	 * Renders this entity onto the screen based on the gameCamera's position
	 * @param g
	 * 	The main graphics object that also this method to draw to the screen.
	 */
	public void render(Graphics g) {
		
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset())
				, (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		// draws a border box and health box
		g.setColor(Color.black);
		g.fillRect((int) (handler.getWidth() - 255)
				, (int) (handler.getHeight() - 75), (10 * this.DEFAULT_HEALTH) + 10, 40);
		g.setColor(Color.red);
		g.fillRect((int) (handler.getWidth() - 250)
				, (int) (handler.getHeight() - 70), (10 * this.health), 30);
	}

	@Override
	public void die() {
		State.setState(handler.getGame().getGameOverState());
		
	}
	
	@Override
	public void hurt() {
		System.out.println("You took 1 damage.");
		health--;
		if  (health <= 0) {
			alive = false;
			System.out.println("You Died.");
			die();
		}
	}

	
}
