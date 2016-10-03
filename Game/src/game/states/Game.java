package game.states;

import java.awt.Graphics;

import game.Handler;
import game.entities.creatures.Player;
import game.worlds.World;

public class Game extends State{
	
	private Player player;
	private World world;
	
	public Game(Handler handler) {
		
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, world.getSpawnX(), world.getSpawnY());

	}
	
	public void update() {
		world.update();
		player.update();
		
	}
	
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
}
