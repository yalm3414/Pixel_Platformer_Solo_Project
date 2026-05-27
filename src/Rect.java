import java.awt.*;

public class Rect
{
	double x;
	double y;
	
	int w;
	int h;
	
	Boolean pushed = false;
	double vx;
	double vy;
	
	
	boolean selected = false;
	
	public Rect(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected()
	{
		selected = true;
	}
	
	public void clearSelected()
	{
		selected = false;
	}
	
	public void toggle()
	{
		selected = ! selected;
	}
	

	public void pushes(Sprite s, boolean jumpThrough, int offsetLR, int offsetUD)
	{
	    // Calculate exactly how deep the sprite is overlapping the tile on all 4 sides
	    double overlapLeft   = ((s.x + s.w) -   x);     // Moving right into a wall
	    double overlapRight  = ((  x +   w) - s.x);       // Moving left into a wall
	    double overlapTop    = ((s.y + s.h) -   y);     // Landing on a floor
	    double overlapBottom = ((y   +   h) - s.y);     // Hitting your head on a ceiling

	    //Find the smallest overlap. The smallest overlap tells us which direction we hit from
	    double minOverlap = Math.min(Math.min(overlapLeft, overlapRight), Math.min(overlapTop, overlapBottom));

	    //Resolve the collision based only on the smallest overlap
	    if (minOverlap == overlapTop) {
	        // Landing on the floor
	        s.y -= overlapTop -offsetUD;
	        s.vy = 0;              // Stop falling velocity!
	        s.grounded = true;     // We are safely on the ground
	        s.jumping = false;
	        
	        s.jumps = 2;
	    } 
	    else if (minOverlap == overlapBottom && !jumpThrough) {
	        // Hitting your head on the ceiling
	        s.y += overlapBottom + 1;
	        s.vy = 0;              // Stop upward velocity so you fall back down immediately
	    } 
	    else if (minOverlap == overlapBottom && jumpThrough) {
	        // Hitting your head on the ceiling
	        s.y -= overlapBottom + 1;
	        //s.vy = 0;             
	    } 
	    else if (minOverlap == overlapLeft) {
	        // Running into a wall on the right side
	        s.x -= overlapLeft;
	    } 
	    else if (minOverlap == overlapRight) {
	        // Running into a wall on the left side
	        s.x += overlapRight;
	    }
	}

	
	public boolean overlaps(Rect r, int offsetLR, int offsetUD)
	{
		return (x <= (r.x + r.w) - offsetLR) &&
			   (y <= r.y + r.h) &&
			   
			   (r.x <= (x + w) - offsetLR)   &&
			   (r.y <= (y + h) - offsetUD);	
	}
	
	public boolean contains(int mx, int my)
	{
		return (mx > x)   && 
			   (mx < x+w) && 
			   (my > y)   && 
			   (my < y+h);
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	
	public void draw(Graphics g)
	{
		g.drawRect((int)x, (int)y, w, h);
	}
	
}	
	
