import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

public class Animation
{
	ArrayList<Image> image = new ArrayList<>();
	int current = 0;
	
	int duration;
	int delay;
	
	public Animation(String name, int duration, String filetype)
	{
		
		this.duration = duration;
		
		delay = duration;
		
		int i = 0;
		String filename = name + "_" + i + "." + filetype;
		File imageFile = new File(filename);
		while(imageFile.exists()) 
		{
			image.add(getImage(filename));
			i++;
			
			filename = name + "_" + i + "." + filetype;
			imageFile = new File(filename);
		}
	}
	
	
	public Image stillImage()
	{
		return image.get(0);
	}
	
	
	//Cycles through all images 
	public Image nextImage()
	{
		delay--;
		
		if(delay == 0)
		{
			if( current == image.size()-1)   current = 0;
			else                             current++;
			
			delay = duration;
		}
				
		return image.get(current);
	}
	
	
	public Image getImage(String filename)
	{
		return Toolkit.getDefaultToolkit().getImage(filename);
	}


}