import java.awt.Graphics;

public class NinjaFrog extends Sprite{
	
	static String[] pose = {"LT", "RT",  "Idle_LT", "Idle_RT", "Jump_LT", "Jump_RT", "DJ_LT", "DJ_RT", "Hit_LT", "Hit_RT"};

	public NinjaFrog(String name, int x, int y, int w, int h,  int direction)
	{
		super(name, x, y, w, h, direction, pose, 5);
	}
	
	public void draw(Graphics g)
	{
		if(moving && !jumping)
		{
			g.drawImage(animation[direction].nextImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
		} 
		else if(moving && jumping && direction == LT)
		{
			// Normal jump or flips if double jump
			if(jumps > 0)
			{
				g.drawImage(animation[UL].stillImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
			} else 
			{
				g.drawImage(animation[DOUBLEUL].nextImage(), (int)(x-Camera.x), (int)(y-Camera.y), (int) (w * 0.75), (int) (h * 0.75), null);
			}
			
		}
		else if(moving && jumping && direction == RT)
		{
			
			// Normal jump or flips if double jump
			if(jumps > 0)
			{
				g.drawImage(animation[UR].stillImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
			} else 
			{
				g.drawImage(animation[DOUBLEUR].nextImage(), (int)(x-Camera.x), (int)(y-Camera.y), (int) (w * 0.75), (int) (h * 0.75), null);
			}
		}
		else if (direction == LT)
		{
			g.drawImage(animation[IDLELT].nextImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
		}else if (direction == RT)
		{
			g.drawImage(animation[IDLERT].nextImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
		}			
		
		moving = false;
	}
}
