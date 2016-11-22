package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.Input.KeyManager;
import game.Input.MouseManager;
import game.display.Display;
import game.gfx.Assets;
import game.gfx.GameCamera;
import game.states.Game;
import game.states.GameOver;
import game.states.Settings;
import game.states.State;
import game.states.Title;

/**
 * This is the Main class that's running everything.
 * Creates all the needed variables and settings as well as
 * calls all the update/render methods.
 * Contains the game's running loop
 * @author Miguel Cardenas Gustavo Chavez
 *
 */
public class MainGame implements Runnable {

	// Window Things
	/**
	 * The window's Display
	 */
	private Display display;
	/**
	 * The window's width/height in pixels
	 */
	private int width, height;	
	/**
	 * The window's title
	 */
	public String title;
	
	// Input 
	/**
	 * The main key manager
	 */
	private KeyManager keyManager;
	
	private MouseManager mouseManager;
	
	// Camera
	/**
	 * The game's camera
	 */
	private GameCamera gameCamera;
	
	// Handler
	/**
	 * The game's handler
	 */
	private Handler handler;
	
	// Threads
	/**
	 * The set frames per second
	 */
	private int fps;
	/**
	 * The main game thread
	 */
	private Thread thread;
	/**
	 * Determines whether or not the game is currently running
	 */
	private boolean running = false;
	
	// Graphic variables
	/**
	 * The main buffer strategy
	 */
	private BufferStrategy bs;
	/**
	 * The main graphics object
	 */
	private Graphics g;
	
	// States
	/**
	 * Contains the game's state
	 */
	private State gameState;
	/**
	 * Contains the setting's state
	 */
	private State settingsState;
	/**
	 * Contains the title's state
	 */
	private State titleState;
	/**
	 * Contains the game over state
	 */
	private State gameOverState;
	
	/**
	 * Constructs the MainGame object, and sets the default values of the window
	 * @param title
	 * 	The window's title bar
	 * @param width
	 * 	The window's width in pixels
	 * @param height
	 * 	The window's height in pixels
	 */
	public MainGame(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	/**
	 * The Main update method.
	 * Updates the keyManager, which will then determine what state
	 * the game is in. (Settings or Game)
	 * Doesn't call a state update if the variable isn't set.
	 */
	private void update() {
		keyManager.update();
		if (State.getState() == titleState){
			State.setState(titleState);
		} else {
			if (State.getState() == gameOverState)
				State.setState(gameOverState);
			else {
				if (keyManager.pause)
					State.setState(settingsState); 
				else
					State.setState(gameState);
			}
		}
		if (State.getState() != null) {
			State.getState().update();
		}
	}
	
	/**
	 * The Main render method.
	 * This grabs the canvas and clears its screen,
	 * then it calls the current state's render method.
	 * Finally it draws whatever was rendered onto the screen.
	 * 
	 * If there isn't a state in the variable, then it does nothing.
	 */
	private void render() {
		
		// gets the amount of buffers the canvas is going to use
		bs = display.getCanvas().getBufferStrategy();
		// if there isn't any buffers get 3 buffers
		if (bs == null)	{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// clear screen
		g.clearRect(0, 0, width, height);
		
		// start drawing
		
		if (State.getState() != null) {
			State.getState().render(g);
		}
		
		// finish drawing
		
		// Draws to the screen
		bs.show();
		g.dispose();
	}
	
	/**
	 * Initializes all the game/window variables and sets the defaults.
	 * Current default state is the Game state
	 */
	private void init() {
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		gameState = new Game(handler);
		settingsState = new Settings(handler);
		titleState = new Title(handler);
		gameOverState = new GameOver(handler);
		State.setState(titleState);
	}
	
	/**
	 * Starts the main game loop
	 */
	public synchronized void start() {
		
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Stops the main game loop
	 */
	public synchronized void stop() {
		
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The Run loop determines when to call the main update and render methods.
	 * It calls the MainGame's initialization method and uses a frames per second
	 * algorithm.
	 * Also displays the frames per second on the console and window title.
	 */
	public void run() {
		
		init();
		
		// Frames Per Second, the amount of times we want to call this method
		fps = 60; 
		
		// the max time in nanoseconds that we have to execute the update and render methods
		double timePerUpdate = 1000000000 / fps; 
		// 1 second == 1 billion nanoseconds
		// we're using nanoseconds because it is much more accurate than normal seconds
		
		// the amount of time we have until we have to call the update/renders methods again
		double delta = 0; 
		long now;	// the computer's current time (in nanoseconds)
		long lastTime = System.nanoTime(); // the last time we called this method
		
		long timer = 0; // times until we get to one seconds	
		int updates = 0; // how many times the update/render methods are called
		
		while(running) {
			now = System.nanoTime(); // set the current time
			
			// makes sure that delta is somewhere between 0 and 1
			delta += (now - lastTime) / timePerUpdate; 
			
			// adds the amount of nanoseconds that have passed since this 
			// method has been called
			timer += now - lastTime; 
			lastTime = now;
			
			// check if you need to render something
			if (delta >= 1) {
				update();
				render();
				updates++;
				delta--;
			}
			
			// checks if the timer has exceeded 1 second
			if (timer >= 1000000000) {
				//System.out.println("Updates/Frames: " + updates);
				display.getFrame().setTitle((title + " | FPS - " + updates));
				updates = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	// getters and setters
	
	/**
	 * Returns the MainGame keyManager
	 * @return
	 * 	The keyManager
	 */
	public KeyManager getKeyManager() {
		return keyManager;
	}
	/**
	 * Returns the MainGame mouseManager
	 * @return
	 * The mouseManager
	 */
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	/**
	 * Returns the MainGame camera
	 * @return
	 * 	The gameCamera
	 */
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	/**
	 * Returns the window's width in pixels
	 * @return
	 * 	The window's width
	 */
	public int getWidth() {
		return width;	
	}
	/**
	 * Returns the window's height in pixels
	 * @return
	 * 	The window's height.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Returns the game state
	 * @return
	 * 	The GameState
	 */
	public State getGameState() {
		return gameState;
	}
	/**
	 * Returns the setting state
	 * @return
	 * 	The SettingsState
	 */
	public State getSettingsState() {
		return settingsState;
	}
	/**
	 * Returns the game over state
	 * @return
	 * 	The gameOverState
	 */
	public State getGameOverState() {
		return gameOverState;
	}

	
}
