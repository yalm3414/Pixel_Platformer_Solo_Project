public class Level2 extends Level
{
	public Level2(NinjaFrog frog)
	{
		super("level2.map", frog);
	}
	
	public void handleCollisions()
	{
		// Move saws
		for(int i = 0; i < map.saws.size(); i++)
	    {
	   
			map.saws.get(i).update();
	    		
	    }
		
		// Collision handling for all animated tiles/items
	    for(int i = 0; i < map.items.size(); i++)
	    {
	    	if(frog.overlaps(map.items.get(i), 5, 4))
	    	{
	    		map.items.remove(i);
	    	}
	    }
	    
	    
	    // Collision handling for all Spikes
	    for(int i = 0; i < map.traps.size(); i++)
	    {
	    	if(frog.overlaps(map.traps.get(i), 8, 8))
	    	{
	    		reset();
	    	}
	    }
	    
	    // Collision handling for all Saws
	    for(int i = 0; i < map.saws.size(); i++)
	    {
	    	if(frog.overlaps(map.saws.get(i), 8, 8))
	    	{	
	    		reset();
	    	}
	    }
	    
	    // Collision handling for all Trampolines
	    for(int i = 0; i < map.trampolines.size(); i++)
	    {
	    	map.trampolines.get(i).bounce(frog);
	    	
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
		map.loadMap("level2.map");
		map.loadAnimated();
		frog.x = 750;
		frog.y = 250;
		frog.direction = NinjaFrog.LT;
	}
}