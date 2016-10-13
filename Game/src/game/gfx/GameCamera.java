package game.gfx;

import game.Handler;
import game.Tiles.Tile;
import game.entities.Entity;

/**
 * The GameCamera class is what allows the player to see
 * the entire world they are spawned in by moving the sprites 
 * around using offsets
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class GameCamera {
	/**
	 *  The entities offset in pixels 
	 */
	private float xOffset, yOffset;
	/**
	 * The main handler
	 */
	private Handler handler;
	//Constructor that is called from the mainGame file
	/**
	 * Constructs a GameCamera object setting its variables and
	 * draws the screen dependent on the pixel location given when called
	 * @param handler
	 * The main handler object
	 * @param xOffset
	 * The number of pixels a sprite is drawn away from it's original location on a x axis
	 * @param yOffset
	 * The number of pixels a sprite is drawn away from it's original location on a y axis
	 */
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**
	 * Checks for empty map space (beyond bounds) and prevents camera from moving past that 
	 */
	public void checkBlankSpace() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	/**
	 * Checks for empty map space and prevents camera from moving beyond camera tile bounds
	 */
	public void checkCameraSpace() {
			
	}
	
	/**
	 * Checks for camera tile collision with camera size
	 * @param x
	 * X location of tile
	 * @param y
	 * Y location of tile
	 * @return
	 * Truth value for collision
	 */
	protected boolean collisionWithCamera(int x, int y){
		return handler.getWorld().getTile(x, y).isCamera();
	}
	
	/**
	 * Moves the camera so that the window is always centered on the character
	 * @param e
	 * The entity which the camera centers on
	 */
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth();
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight();
		checkBlankSpace();
	}
	/**
	 * Moves camera by x and y parameters in pixels 
	 * @param xAmt
	 * x amount of pixels
	 * @param yAmt
	 * y amount of pixels
	 */
	public void move(float xAmt, float yAmt) {
		yOffset += yAmt;
		xOffset += xAmt;
		checkBlankSpace();
	}

	//Getters and setters below
	
	/**
	 * Returns the xOffset in number of pixels
	 * @return
	 * xOffset of pixels for each sprite's pixels on canvas
	 */
	public float getxOffset() {
		return xOffset;
	}
	/**
	 * Sets the xOffset value to the given pixel amount
	 * @param xOffset
	 * The new number of pixels that a sprite is drawn away from it's original x location
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
		checkBlankSpace();
	}
	/**
	 * Returns the yOffset in number of pixels
	 * @return
	 * yOffset of pixels for each sprite's pixels on canvas
	 */
	public float getyOffset() {
		return yOffset;
	}
	/**
	 * Sets the yOffset value to the given pixel amount
	 * @param yOffset
	 * The new number of pixels that a sprite is drawn away from it's original y location
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
		checkBlankSpace();
	}
}
