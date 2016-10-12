package game.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * The Display class.
 * Creates the main canvas and the main JFrame that will be used in the program.
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
public class Display {
	
	/**
	 * The Window itself
	 */
	private JFrame frame;
	
	/**
	 * What allows the window to be drawn on
	 */
	private Canvas canvas;
	
	/**
	 * The Window's Title Bar
	 */
	private String title; 
	
	/**
	 * The Window's width and height in pixels
	 */
	private int width, height;
	
	/**
	 * Constructs a Display setting the window's default title, width, and height
	 * @param title
	 * 		Title of the Window
	 * @param width
	 * 		Window's width in pixels
	 * @param height
	 * 		Window's height in pixels
	 */
	public Display(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	/**
	 * Actually creates the window itself setting all default variables
	 * and boolean settings
	 */
	private void createDisplay() {
		
		// Make a JFrame object
		frame = new JFrame(title);
		
		// Set the window's size using the width and height
		frame.setSize(width, height);
		
		// Allows the "X" window button to close the entire program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Prohibits the user from changing the window's size
		frame.setResizable(false);
		
		// Makes the window appear in the center of the user's screen
		frame.setLocationRelativeTo(null);
		
		// Allows the JFrame to be seen
		frame.setVisible(true);
		
		// Creates the Frame's canvas and sets the size to that of 
		// the window and add it to the frame
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	/**
	 * Returns the window's canvas
	 * @return
	 * 	The Window's canvas
	 */
	public Canvas getCanvas() {
		return canvas;
		
	}
	
	/**
	 * Returns the window's JFrame 
	 * @return
	 * 	The Window's frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}
