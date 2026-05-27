
public class Trampoline extends Sprite{
	
	
	
	public Trampoline(String name, int x, int y, int w, int h, int direction, int duration) {
		super(name, x, y, w, h, direction, duration);
		moving = false;
	}
	
	int frames = 10;
	boolean pushedS = false;
	
	public void bounce(Sprite s)
	{
		if(s.overlaps(this, 0, 30) && frames > 0)
		{
			moving = true;
			frames--;
			s.vy = -20;
			s.move();
			pushedS = true;
		} 
		else if(frames > 0 && pushedS)
		{
			moving = true;
			frames--;
		}
		else 
		{
			moving = false;
			pushedS = false;
			frames = 10;
		}
		
	}
}
