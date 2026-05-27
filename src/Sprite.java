import java.awt.Graphics;
import java.awt.Toolkit;

public class Sprite extends Rect
{
	String name;
		
	boolean moving = false;
	public boolean grounded = false;
	public boolean jumping = false;
	int jumps = 2;
	boolean physics = true;
	
	double g = 0.8;
	
	
	int direction = RT;
	
	// Constant values that are used to index the
	// Animation array to select the correct
	// Animation for the direction the solder
	// is moving.
	static final int LT = 0;
	static final int RT = 1;
	static final int IDLELT = 2;
	static final int IDLERT = 3;
	static final int UL = 4;
	static final int UR = 5;
	static final int DOUBLEUL = 6;
	static final int DOUBLEUR = 7;
	static final int HITLT = 8;
	static final int HITRT = 9;
	
	Animation[] animation;
	
	//totalFrames is the total amount of frames a sprite will have including still frames, walking frames, jumping, dying, etc.
	public Sprite(String name, int x, int y, int w, int h, int direction, String[] pose, int duration)
	{
		super(x, y, w, h);
		
		this.name = name;
		animation = new Animation[pose.length];
		
		for(int i = 0; i < animation.length; i++)
		{
			animation[i] = new Animation(name + "_" + pose[i], duration, "png");
		}		
		
		
		this.direction = direction;
	}
	
	//Removed poses array for sprites that only have one pose
	public Sprite(String name, int x, int y, int w, int h, int direction, int duration)
	{
		super(x, y, w, h);
		
		this.name = name;
		animation = new Animation[1];
		
		for(int i = 0; i < animation.length; i++)
		{
			animation[i] = new Animation(name, duration, "png");
		}		
		
		
		this.direction = direction;
	}
	
	
	public void move()
	{
		x += vx;		
		y += vy;
		
		if(!grounded)
		{
			vy += g;
		}
		

		
		if (physics == false)
		{
			vx = 0;
			vy = 0;
		}
	}
	
	public void jump()
	{
		if(jumps > 0)
		{
			vy = -8;
			moving = true;
			jumping = true;
			grounded = false;
			
			jumps--;
		}
			
			
	}
	
	public void goUP(int dy)
	{
		vy = -dy;
	//	direction = UP;
		
		moving = true;
	}
	
	public void goDN(int dy)
	{
		vy = dy;

	//	direction = DN;

		moving = true;
	}
	
	public void goLT(int dx)
	{
		vx = -dx;

		direction = LT;
		
		moving = true;
	}
	
	public void goRT(int dx)
	{
		vx = dx;
		
		direction = RT;

		moving = true;

	}
		
	public void moveUP(int dy)
	{
		y -= dy;
		
	//	direction = UP;
		
		moving = true;
	}
	
	public void moveDN(int dy)
	{
		y += dy;

	//	direction = DN;

		moving = true;
	}
	
	public void moveLT(int dx)
	{
		x -= dx;

		direction = LT;
		
		moving = true;
	}
	
	public void moveRT(int dx)
	{
		x += dx;
		
		direction = RT;

		moving = true;

	}
	
	public void draw(Graphics g)
	{
		if(moving)
		{
			g.drawImage(animation[direction].nextImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
		}
		else
		{
			g.drawImage(animation[direction].stillImage(), (int)(x-Camera.x), (int)(y-Camera.y), w, h, null);
		}		
		
		moving = false;
	}
		
	
	
	

}