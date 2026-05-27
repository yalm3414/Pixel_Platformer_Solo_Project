import java.awt.Graphics;

public class Saw extends Sprite {

	int direction = LT;
	public Saw(String name, int x, int y, int w, int h, int direction, int duration) {
		super(name, x, y, w, h, direction, duration);
	}
	
	int moves = 96;
	
	public void update() 
	{
		if(moves > 0 && direction == LT)
		{
			moveLT(1);
			moves -=1;
		} else if (moves > 0 && direction == RT)
		{
			moveRT(1);
			moves -=1;
		} else if (moves == 0 && direction == LT)
		{
			moves = 96;
			direction = RT;
		} else if (moves == 0 && direction == RT)
		{
			moves = 96;
			direction = LT;
		}
		
	}
	public void draw(Graphics g)
	{
		if(moving)
		{
			g.drawImage(animation[0].nextImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
		}
		else
		{
			g.drawImage(animation[0].stillImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
		}		
		
		moving = false;
	}
	
}
