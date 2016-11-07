package game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.gfx.Assets;
import game.states.State;
import game.weapons.Dagger;
import game.weapons.Weapon;

/**
 * The Player class is the class that contains all the important 
 * functions regarding the controllable player character.
 * Including its update and render functions.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Player extends Creature {

	
	private int iFrames = 0;
	private Weapon currWeap;
	
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
		currWeap = new Dagger(handler, 20, 20);
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
			setLastDirection('u');
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
			setLastDirection('d');
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
			setLastDirection('l');
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
			setLastDirection('r');
		} 
		
	}
	
	public void attk() {
		currWeap.attk(this);
		
	}
	
	/**
	 * Renders this entity onto the screen based on the gameCamera's position
	 * @param g
	 * 	The main graphics object that also this method to draw to the screen.
	 */
	public void render(Graphics g) {
		
		if ((iFrames % 2) == 0) {
			g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset())
					, (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
		else
			iFrames++;
		
		currWeap.render(g);
		
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
		if (iFrames < 15)
			iFrames++;
		else {
			System.out.println("You took 1 damage.");
			health--;
			if  (health <= 0) {
				alive = false;
				System.out.println("You Died.");
				die();
			}
			iFrames = 0;
		}
	}
	

	
}
