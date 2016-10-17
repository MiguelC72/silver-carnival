package game.gfx;

import java.awt.image.BufferedImage;

/**
 * The SpriteSheet class takes in an image and crops out the various 
 * texture (sprites) that will be used in other classes
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class SpriteSheet {

	/**
	 * The sprite sheet being cropped 
	 */
	private BufferedImage sheet;
	
	/**
	 * Takes in a BufferedImage and sets this class's sheet variable to it.
	 * @param sheet
	 * 	The image being cropped
	 */
	public SpriteSheet(BufferedImage sheet) {
		
		this.sheet = sheet;
	}
	
	/**
	 * Takes in various coordinates and crops out the image
	 * at that location and returns it.
	 * @param x
	 * 	The x position of the sprite in pixels
	 * @param y
	 * 	The y position of the sprite in pixels
	 * @param width
	 * 	The width of the sprite in pixels
	 * @param height
	 * 	The height of the the sprite in pixels
	 * @return
	 * 	The cropped out sprite
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		
		return sheet.getSubimage(x, y, width, height);
	}
}
