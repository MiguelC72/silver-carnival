package game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The ImageLoader uses a given file path to load in an image for 
 * later use by other classes.
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class ImageLoader {
	
	/**
	 * Takes in a file path and attempts to read in an image and return it.
	 * If it fails, the program exits and an error message is printed.
	 * @param path
	 * 	The file path of the image.
	 * @return
	 * 	The read image or a system exit.
	 */
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
