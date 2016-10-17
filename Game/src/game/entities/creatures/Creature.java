package game.entities.creatures;

import game.Handler;
import game.Tiles.Tile;
import game.entities.Entity;

/**
 * The Creature class is an abstract class that is the foundation
 * for each living being in the game overworld. It sets each 
 * creature's health, speed, width and height. It also prevents
 * each creature from moving out of bounds by checking the solidity
 * of each tile around it.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public abstract class Creature extends Entity{

	/**
	 * Default health
	 */
	public static final int DEFAULT_HEALTH = 10;
	/**
	 * Default speed
	 */
	public static final float DEFAULT_SPEED = 3.0f; //6.0f;
	/**
	 * Default size in width and height in tixels
	 */
	public static final int DEFAULT_CREATURE_WIDTH = 40,
							DEFAULT_CREATURE_HEIGHT = 40;
	/**
	 * The health of any respective creature
	 */
	protected int health;
	/**
	 * The speed at which the creature move on the overworld
	 */
	protected float speed;
	/**
	 * The current size in tixels a creature is moving
	 */
	protected float xMove, yMove;
	
	/**
	 * Constructs a creature object setting its health
	 * speed, direction of movement, size and is extended by
	 * any other class to create a unique creature.
	 * @param handler
	 * The main handler object.
	 * @param x
	 * This creature's x position in tixels
	 * @param y
	 * This creature's y position in tixels
	 * @param width
	 * The width of the creature.
	 * @param height
	 * the height of the creature.
	 */
	public Creature(Handler handler, float x, float y, int width, int height) {
		
		super(handler, x, y, width, height); // passes these variables to the Entity constructor
		
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	/**
	 * Checks for collision before allowing the creature to move
	 * left, right, up, down. If there are none, it calls for moveX
	 * or moveY.
	 */
	public void move() {
		if (!checkEntityCollisions(xMove, 0f))
			moveX();
		if (!checkEntityCollisions(0f, yMove))
			moveY();
	}
	/**
	 * Allows the creature to move left or right depending on the xMove
	 * value. 
	 */
	public void moveX() {
		if (xMove > 0) { // moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		} else if (xMove < 0) { // moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
		
	}
	/**
	 * Allows the creature to move up or down depending on the yMove value.
	 */
	public void moveY() {
		if (yMove < 0) { // moving up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		} else if (yMove > 0) { // moving down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	} 
	/**
	 * Checks for collision with solid tiles by finding the tile at the
	 * passed in coordinates
	 * @param x
	 * The x coordinate in tixels.
	 * @param y
	 * The y coordinate in tixels.
	 * @return
	 * Returns true if the tixel coordinates are in a solid tile or false
	 * if not.
	 */
	// passed in x and y are coordinates with 1 unit of space being the width of a tile
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	// getters and setters below
	/**
	 * Returns the x tixel count for the creatures movement
	 * @return
	 * The tixel movement in the x-axis.
	 */
	public float getxMove() {
		return xMove;
	}
	/**
	 * Sets the tixel value for xMove.
	 * @param xMove
	 * The new tixel value for xMove.
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	/**
	 * Returns the y tixel count for the creatures movement.
	 * @return
	 * The tixel movement in the y-axis.
	 */
	public float getyMove() {
		return yMove;
	}
	/**
	 * Sets the tixel value for yMove.
	 * @param yMove
	 * The new tixel value for yMovee.
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	/**
	 * Returns the current health of the creature.
	 * @return
	 * The health in integers
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Sets the creatures health.
	 * @param health
	 * The health in integers.
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * Returns the current speed of the creature.
	 * @return
	 * The speed in long float.
	 */
	public float getSpeed() {
		return speed;
	}
	/**
	 * Sets the speed of the creature 
	 * @param speed
	 * The speed in long float
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
}
