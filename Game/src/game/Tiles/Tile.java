package game.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	// STATIC VARS
	
	public static Tile[] mTiles = new Tile[256]; // master tiles
	public static Tile grassTile = new GrassTile(0);
	public static Tile brickTile = new BrickTile(1);
	public static Tile lavaTile = new LavaTile(2);
	public static Tile treeTile = new TreeTile(3);
	public static Tile caveEnt = new CaveEnterTile(4);
	public static Tile caveFloor = new CaveFloorTile(5);
	
	// CLASS
	
	protected BufferedImage texture;
	protected final int id;	// this shouldn't be changed once it's set
	
	public static int TILEWIDTH = 40,
					  TILEHEIGHT = 40;
	
	public Tile(BufferedImage texture, int id) {
		
		this.texture = texture;
		this.id = id;
		
		mTiles[id] = this;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public boolean isCamera() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
