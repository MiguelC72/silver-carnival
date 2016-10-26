package game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import game.Handler;
import game.Tiles.Tile;
import game.gfx.Assets;

/**
 * The Slime class is a basic enemy class that has the ability to move
 * around the map at random.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Slime extends Creature{
	
	/**
	 * The Random variable that determines if the slime will move around
	 */
	private Random random;

	/**
	 * This constructor creates a slime creature at the given 
	 * x and y position in tixels, and sets its hitbox and speed
	 * @param handler
	 * 	The main handler
	 * @param x
	 * 	This entity's x position in tixels
	 * @param y
	 * 	This entity's y position in tixels
	 */
	public Slime(Handler handler, float x, float y) {
		
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 8;
		bounds.y = 15;
		bounds.width = 25;
		bounds.height = 20;
		random = new Random();
		this.speed = 2.0f; //20.0f;
	}

	/**
	 * Updates the slime by calling the getInput() function
	 * and moves it around the map accordingly.
	 */
	public void update() {
		
		getInput();
		move();
		
		handler.getGameCamera();
	}

	/**
	 * Sets the random variable and determines what direction the 
	 * slime will move
	 */
	public void getInput() {
		
		xMove = 0;
		yMove = 0;
		
		float playerX = handler.getWorld().getEntityManager().getPlayer().getX();
		float playerY = handler.getWorld().getEntityManager().getPlayer().getY();
		
		double distance = Math.hypot(x - playerX , y - playerY);
		
		if (distance <= 4 * Tile.TILEWIDTH) 
		{
			System.out.println("noticed");
			if (x < playerX)
			    xMove = speed;
			else if (x > playerX)
			    xMove = -speed;

			if (y < playerY)
			    yMove = speed;
			else if (y > playerY)
			    yMove = -speed;
		} else {
			int i = random.nextInt(700) + 1;
		
			if (i <= 100) {
				if (i >= 0 && i <= 24)
					yMove = -speed;
				if (i >= 25 && i <= 49)
					yMove = speed;
				if (i >= 50 && i <= 74)
					xMove = -speed;
				if (i >= 75 && i <= 100)
					xMove = speed;
			}
		}
		
	}
	
	/**
	 * Renders the slime onto the screen uses the gameCamera's position to
	 * determine where to draw the creature.
	 * @param g
	 * 	The graphics object that is used to draw the creature
	 */
	public void render(Graphics g) {
		
		int posX = (int) (x - handler.getGameCamera().getxOffset());
		int posY = (int) (y - handler.getGameCamera().getyOffset());
		
		g.drawImage(Assets.slime, posX, posY, width, height, null);
		
		// draws a bounding box
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset())
		//		, (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	@Override
	public void die() {
		System.out.println("Slime Slain");
		
	}

}
