import java.awt.*;


public abstract class Level extends LevelBase
{
	
	public static Level current;
	
	public static Level[] level = new Level[10];
	
	NinjaFrog frog;
	TileMap map;
	
	boolean wPressedLast = false;
	
	public Level(String filename, NinjaFrog frog)
	{
		this.map = new TileMap(filename, 16, 16);
	
		this.frog = frog;
	}
	
	public void handleInput(boolean[] pressing)
	{
		if(pressing[_W] && !wPressedLast) {
			frog.jump();
		}
		
		wPressedLast = pressing[_W];
		
		if(pressing[_A]) {
			frog.moveLT(4);
			//Maybe use scrolling

		}
		if(pressing[_D]) {
			frog.moveRT(4);
			//Maybe use scrolling
			
		}
		
		
		frog.move();
			
			
	}
	
	public abstract void handleCollisions();
	
	
	public void draw(Graphics g)
	{
		map.draw(g);
		frog.draw(g);		
	}

}