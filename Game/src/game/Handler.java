package game;

import game.Input.KeyManager;
import game.gfx.GameCamera;
import game.worlds.World;

public class Handler {

	private MainGame mainGame;
	private World world;
	
	public Handler(MainGame game) {
		this.mainGame = game;
	}
	
	public int getWidth() {
		return mainGame.getWidth();
	}
	
	public int getHeight() {
		return mainGame.getHeight();
	}

	public KeyManager getKeyManager() {
		return mainGame.getKeyManager();
	}
	
	public GameCamera getGameCamera() {
		return mainGame.getGameCamera();
	}
	
	public MainGame getGame() {
		return mainGame;
	}

	public void setGame(MainGame game) {
		this.mainGame = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
