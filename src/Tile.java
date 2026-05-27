import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Tile extends Rect {


	
	String name;
	Image image;
	public Tile(Image image,  int x, int y, int w, int h) {
		
		super(x, y, w, h);

		this.image = image;
		
	}
	
	public Image getImage(String filename)
	{
		return Toolkit.getDefaultToolkit().getImage(filename);
	}
	
	public void draw(Graphics g)
	{
		
		g.drawImage(image, (int) (x-Camera.x) , (int) (y - Camera.y), w, h, null);
	}
}
