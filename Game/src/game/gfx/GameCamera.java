package game.gfx;

import game.Handler;
import game.Tiles.Tile;
import game.entities.Entity;

public class GameCamera {
	//X and Y offset is the amount of pixels that every sprite is drawn away from its original location 
	private float xOffset, yOffset;
	private Handler handler;
	//Constructor that is called from the mainGame file
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	//Checks for empty map space and prevents camera from moving beyond map bounds
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
	
	//Checks for empty map space and prevents camera from moving beyond camera tile bounds
	public void checkCameraSpace() {
			
	}
	
	//Checks for camera tile collision with camera size
	protected boolean collisionWithCamera(int x, int y){
		return handler.getWorld().getTile(x, y).isCamera();
	}
	
	//Moves the camera so that the window is always centered on the character
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth();
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight();
		checkBlankSpace();
	}
	//Moves Camera by character movement 
	public void move(float xAmt, float yAmt) {
		yOffset += yAmt;
		xOffset += xAmt;
		//checkBlankSpace();
	}

	//Getters and setters below
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
		//checkBlankSpace();
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
		//checkBlankSpace();
	}
}
