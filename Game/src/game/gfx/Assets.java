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
	//World 1 images
	public static BufferedImage grass, stone, lava, tree, cE1, rock, stonegrass, water, sand;
	//World 2 images
	public static BufferedImage cFloor, cRock, cMushroom, cSlime, cExit, cWall;
	//Player images
	public static BufferedImage player;
	//Enemy Images
	public static BufferedImage slime, mouse, skeleton, snake;
	//Static Images
	public static BufferedImage chest;
	//Weapon Images
	public static BufferedImage[] dagger = new BufferedImage[5];
	public static BufferedImage[] longSword = new BufferedImage[5];
	public static BufferedImage[] axe = new BufferedImage[5];
	public static BufferedImage[] ballNChain = new BufferedImage[2];
	public static BufferedImage[] spear = new BufferedImage[5];
	public static BufferedImage katana;
	/**
	 * This function loads and crops out sprites from the /res/textures folder
	 * and places the images in their respective bufferedImage variable
	 */
	public static void init() {
		//Finds a tile sheet from resources folder
		SpriteSheet world1 = new SpriteSheet(ImageLoader.loadImage("/textures/world1tileSheet.png"));
		//Grab each sprite from sheet and apply info to each tile variable
		rock = world1.crop(0, 0, width, height);
		grass = world1.crop(width, 0, width, height);
		stone = world1.crop(width *2, 0, width, height);
		lava = world1.crop(width *3, 0, width, height);
		tree = world1.crop(width *4, 0, width, height);
		cE1 = world1.crop(0, height, width, height);
		stonegrass = world1.crop(width, height, width, height);
		water = world1.crop(width *2, height, width, height);
		sand = world1.crop(width *3, height, width, height);
		//Sprites for world2 tilesheet
		SpriteSheet world2 = new SpriteSheet(ImageLoader.loadImage("/textures/world2tileSheet.png"));
		cFloor = world2.crop(0, 0, width, height);
		cRock = world2.crop(width, 0, width, height);
		cRock = world2.crop(width, 0, width, height);
		cMushroom = world2.crop(width*2, 0, width, height);
		cSlime = world2.crop(width *3, 0, width, height);
		cExit = world2.crop(width *4, 0, width, height);
		cWall = world2.crop(0, height, width, height);
		//Finds a creature sheet from resources folder
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/creatureSheet.png"));
		//Grab each sprite from the sheet and apply to each creature variable
		slime = sheet2.crop(0, 0, width, height);
		mouse = sheet2.crop(width, 0, width, height);
		skeleton = sheet2.crop(width*2, 0, width, height);
		snake = sheet2.crop(width*3, 0, width, height);
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/characterSheet.png"));
		player = sheet3.crop(0, 0, width, height);
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/objectSheet.png"));
		chest = sheet4.crop(0, 0, width, height);
		//Finds a weapon sheet from resources folder
		SpriteSheet weapon = new SpriteSheet(ImageLoader.loadImage("/textures/weaponTiles.png"));
		//Grab each sprite from the sheet and apply to each creature variable
		for(int i = 0; i < 5; i++) {
			dagger[i] = weapon.crop(0, (height*2)*i, (width*2), (height*2));
			longSword[i] = weapon.crop((width*2), (height*2)*i, (width*2), (height*2));
			axe[i] = weapon.crop((width*4), (height*2)*i, (width*2), (height*2));
			spear[i] = weapon.crop((width*6), (height*2)*i, (width*2), (height*2));
		}
		ballNChain[0] = weapon.crop((width*8), 0, (width*2), (height*2));
		ballNChain[1] = weapon.crop((width*8), (height*2), (width*2), (height*2));
		katana = weapon.crop(0, (height*10), (width*2), (height*2));
	}
}
