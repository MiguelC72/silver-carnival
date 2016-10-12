package game.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	
	private Canvas canvas;
	
	private String title; 		// Window title
	private int width, height;	// Window width and height in pixels
	
	// Sets the variables of this Display class when called by the launcher
	public Display(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	// Actually creates the window
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
	
	public Canvas getCanvas() {
		return canvas;
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
