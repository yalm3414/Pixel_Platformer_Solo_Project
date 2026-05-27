public class Level1 extends Level
{
	public Level1(NinjaFrog frog)
	{
		super("level1.map", frog);
	}
	
	public void handleCollisions()
	{
	
		// Checks if all fruits are consumed 
	    if(map.items.isEmpty())
	    {
	    	current = level[2];
	    	
	    	frog.x = 750;
			frog.y = 250;
			frog.direction = NinjaFrog.LT;
	    }
	    
		// Collision handling for all animated tiles/items
	    for(int i = 0; i < map.items.size(); i++)
	    {
	    	if(frog.overlaps(map.items.get(i), 5, 4))
	    	{
	    		map.items.remove(i);
	    	}
	    }
	    
	    
	    // Collision handling for all traps (Spikes right now)
	    for(int i = 0; i < map.traps.size(); i++)
	    {
	    	if(frog.overlaps(map.traps.get(i), 8, 8))
	    	{
	    		reset();
	    	}
	    }
	    
	    // Collision handling for all the jump through platforms
	    for(int i = 0; i < map.platforms.size(); i++)
	    {
	    	if(frog.overlaps(map.platforms.get(i), 0, 0))
	    	{
	    		map.platforms.get(i).pushes(frog, true, 5, 0);
	    	}
	    }
	    
		// Collision handling for all static tiles (not traps)
	    frog.grounded = false;
	    for(int i = 0; i < map.tiles.size(); i++)
		{
			if(frog.overlaps(map.tiles.get(i), 5, 0) && frog.physics)
			{
				map.tiles.get(i).pushes(frog, false, 5, 0);
			
			}
			
		}
	    
	    
	}

	public void reset()
	{
		map.loadMap("level1.map");
		map.loadAnimated();
		frog.vx = 0;
		frog.vy = 0;
		frog.x = 50;
		frog.y = 350;
		frog.direction = NinjaFrog.RT;
	}
}