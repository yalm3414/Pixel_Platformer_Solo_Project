import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class PixelPlatformer extends GameBase
{	

	
	//TileMap map = new TileMap("tilemap2.map", 16, 16);
	
	NinjaFrog frog = new NinjaFrog("Ninja_Frog", 50, 350, 32, 32, NinjaFrog.RT);
	
	
	public void initialize() 
	{
		Level.level[1] = new Level1(frog);
	    Level.level[2] = new Level2(frog);
	    
		Level.current = Level.level[1];
	}
	
	public void inGameLoop()
	{
		
		
		Level.current.handleInput(pressing);
		Level.current.handleCollisions();
		

		
		

	}
	
	
	
	public void paint(Graphics g)
	{	
		
	
		Level.current.draw(g);
		
	}
	
	
}
