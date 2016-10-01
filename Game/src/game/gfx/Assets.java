package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 20, height = 20;
	
	public static BufferedImage player, grass, stone, lava, tree;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/testSheet.png"));
		
		player = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width *2, 0, width, height);
		lava = sheet.crop(width *3, 0, width, height);
		tree = sheet.crop(width *4, 0, width, height);
	}
}
