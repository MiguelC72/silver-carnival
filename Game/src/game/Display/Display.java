package game.Display;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	
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
		
	}
}
