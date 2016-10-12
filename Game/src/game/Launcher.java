package game;

/**
 * This Class contains the main method and calls the constructor of the MainGame class
 * passing the default values for the window's title bar, width and height.
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
