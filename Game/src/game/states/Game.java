package game.states;

import java.awt.Graphics;

import game.Handler;
import game.Tiles.Tile;
import game.entities.creatures.Player;
import game.entities.creatures.Slime;
import game.worlds.World;

public class Game extends State{
	
	private World world;
	
	public Game(Handler handler) {
		
		super(handler);
		//world = new World(handler, "res/worlds/world1.txt");
		world = new World(handler, "res/worlds/world2.txt");
		handler.setWorld(world);

	}
	
	public void update() {
		world.update();
		
		
	}
	
	public void render(Graphics g) {
		world.render(g);
		
	}
}
