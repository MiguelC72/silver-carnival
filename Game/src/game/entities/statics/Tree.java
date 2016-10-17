package game.entities.statics;

import java.awt.Graphics;

import game.Handler;
import game.Tiles.Tile;
import game.gfx.Assets;

/**
 * The Tree static entity class creates a tree object that 
 * is the size of a standard tile
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Tree extends StaticEntity {

	/**
	 * Creates a static tree entity at the given x and y position in tixels
	 * @param handler
	 * 	The main handler
	 * @param x
	 * 	This entity's x position in tixels
	 * @param y
	 * 	This entity's y position in tixels
	 */
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
	}
	
	/**
	 * Renders this entity on the screen based on where the camera
	 * is currently
	 * uses the tree asset
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), null);
	}

	
	/**
	 * Updates the tree, currently the tree doesn't do anything
	 */
	@Override
	public void update() {
		
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
