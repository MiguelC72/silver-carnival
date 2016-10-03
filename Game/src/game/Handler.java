package game;

import game.Input.KeyManager;
import game.gfx.GameCamera;
import game.worlds.World;

public class Handler {

	private MainGame game;
	private World world;
	
	public Handler(MainGame game) {
		this.game = game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public MainGame getGame() {
		return game;
	}

	public void setGame(MainGame game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
