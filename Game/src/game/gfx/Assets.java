package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 20, height = 20;
	
	public static BufferedImage player, slime, grass, stone, lava, tree, cE1, cFloor, mouse;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tileSheet.png"));
		
		player = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width *2, 0, width, height);
		lava = sheet.crop(width *3, 0, width, height);
		tree = sheet.crop(width *4, 0, width, height);
		cE1 = sheet.crop(0, height, width, height);
		cFloor = sheet.crop(width, height, width, height);
		
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/creatureSheet.png"));
		
		slime = sheet2.crop(0, 0, width, height);
		mouse = sheet2.crop(width, 0, width, height);
		
	}
}
