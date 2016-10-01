package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.Display;

public class MainGame implements Runnable {

	private Display display;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public int width, height;
	public String title;
	
	public MainGame(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		
	}
	
	public void run() {
		
		init();
		
		while(running) {
			update();
			render();
		}
		
		stop();
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
	
	private void init() {
		
		display = new Display(title, width, height);
	}
	
	private void update() {
		
	}
	
	private void render() {
		
	}
}
