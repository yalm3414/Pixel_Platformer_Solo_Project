import java.awt.Graphics;

public class Item extends Sprite {
	
	public Item(String name, int x, int y, int w, int h, int direction, int duration) {
		
		super(name, x, y, w, h, direction, duration);
	}
	
	
	
	public void draw(Graphics g)
	{
		g.drawImage(animation[direction].nextImage(), (int)(x-Camera.x) , (int)(y - Camera.y), w, h, null);
	}
	
}
