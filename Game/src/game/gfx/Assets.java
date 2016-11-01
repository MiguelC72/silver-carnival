package game.gfx;

import java.awt.image.BufferedImage;

/**
 * The Assets class is responsible for loading in the various 
 * texture pictures and creating usable sprites.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Assets {
	
	/**
	 * The width/height of the textures in the given images (pixel values)
	 */
	private static final int width = 20, height = 20;
	
	/**
	 * These are the various sprites used.
	 */
	public static BufferedImage player, slime, grass, stone, lava, tree, cE1, cFloor, mouse,
		camera, rock;
	
	/**
	 * This function loads and crops out sprites from the /res/textures folder
	 * and places the images in their respective bufferedImage variable
	 */
	public static void init() {
		//Finds a tile sheet from resources folder
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tileSheet.png"));
		//Grab each sprite from sheet and apply info to each tile variable
		rock = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width *2, 0, width, height);
		lava = sheet.crop(width *3, 0, width, height);
		tree = sheet.crop(width *4, 0, width, height);
		cE1 = sheet.crop(0, height, width, height);
		cFloor = sheet.crop(width, height, width, height);
		camera = sheet.crop(width * 4, 0, width, height);
		//Finds a creature shweet from resources folder
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/creatureSheet.png"));
		//Grab each sprite from the sheet and apply to each creature variable
		slime = sheet2.crop(0, 0, width, height);
		mouse = sheet2.crop(width, 0, width, height);
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/characterSheet.png"));
		player = sheet3.crop(0, 0, width, height);
		
	}
}
