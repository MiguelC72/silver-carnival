package game.states;

import java.awt.Graphics;

import game.Handler;
import game.Tiles.Tile;
import game.entities.creatures.Player;
import game.entities.creatures.Slime;
import game.worlds.World;

public class Game extends State{
	
	private Player player;
	private World world;
	private Slime slime;
	
	public Game(Handler handler) {
		
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		slime = new Slime(handler, (Tile.TILEWIDTH * 15), (Tile.TILEHEIGHT * 9));
		player = new Player(handler, world.getSpawnX(), world.getSpawnY());
		
		

	}
	
	public void update() {
		world.update();
		player.update();
		slime.update();
		
	}
	
	public void render(Graphics g) {
		world.render(g);
		slime.render(g);
		player.render(g);
		
	}
}
