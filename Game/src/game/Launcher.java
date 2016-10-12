package game;

/**
 * This Class contains the main method and calls the constructor of the MainGame class
 * passing the default values for the window's title bar, width and height.
 * 
 * This game program uses two types of unit representation on its display
 * pixels - standard screen pixel 
 * 			usually represented using an int type
 * tixels - a pixel value that is calculated using 
 * 			the tile's width and height values 
 * 			usually represented using a float type
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class Launcher {

	/**
	 * Starts the program.
	 * Calls the start method in MainGame.
	 * @param args
	 * 	Any console arguments are ignored
	 */
	public static void main(String[] args) {

		MainGame game = new MainGame("Test Title", 600, 600);
		
		game.start();
	}

}
