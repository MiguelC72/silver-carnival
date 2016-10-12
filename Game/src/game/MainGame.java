package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.Input.KeyManager;
import game.display.Display;
import game.gfx.Assets;
import game.gfx.GameCamera;
import game.states.Game;
import game.states.Settings;
import game.states.State;
import game.states.Title;

public class MainGame implements Runnable {

	// Window Things
	private Display display;
	private int width, height;
	public String title;
	
	// Input
	private KeyManager keyManager;
	
	// Camera
	private GameCamera gameCamera;
	
	// Handler
	private Handler handler;
	
	// Threads
	private int fps;
	private Thread thread;
	private boolean running = false;
	
	// Graphic variables
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	private State gameState;
	private State settingsState;
	private State titleState;
	
	public MainGame(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		keyManager = new KeyManager();
		
	}
	
	private void update() {
		keyManager.update();
		if (keyManager.pause)
			State.setState(settingsState);
		else
			State.setState(gameState);
		
		if (State.getState() != null) {
			State.getState().update();
		}
	}
	
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
	
	private void init() {
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		gameState = new Game(handler);
		settingsState = new Settings(handler);
		titleState = new Title(handler);
		State.setState(gameState);
	}
	
	public synchronized void start() {
		
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
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
				System.out.println("Updates/Frames: " + updates);
				display.getFrame().setTitle((title + " | FPS - " + updates));
				updates = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	// getters and setters
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;	
	}
	
	public int getHeight() {
		return height;
	}

	public State getGameState() {
		return gameState;
	}

	public State getSettingsState() {
		return settingsState;
	}

	
}
