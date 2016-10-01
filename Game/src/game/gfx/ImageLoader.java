package game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path) {
		
		try {
			// returns the image
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			// exit if the image wasn't found
			System.exit(1);
		}
		return null;
	}
}
