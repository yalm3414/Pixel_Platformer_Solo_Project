import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PixelPlatformer extends GameBase
{	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			PixelPlatformer game = new PixelPlatformer();

			JFrame window = new JFrame("Pixel Platformer");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setContentPane(game);
			window.pack();
			window.setLocationRelativeTo(null);

			window.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					game.stopGame();
				}
			});

			window.setVisible(true);
			game.startGame();

			SwingUtilities.invokeLater(
				() -> game.requestFocusInWindow()
			);
		});
	}
	
	//TileMap map = new TileMap("tilemap2.map", 16, 16);
	
	NinjaFrog frog = new NinjaFrog("Ninja_Frog", 50, 350, 32, 32, NinjaFrog.RT);
	
	
	public void initialize() 
	{
		Level.level[1] = new Level1(frog);
	    Level.level[2] = new Level2(frog);
	    
		Level.current = Level.level[1];
	}
	
	public void inGameLoop()
	{
		
		
		Level.current.handleInput(pressing);
		Level.current.handleCollisions();
		

		
		

	}
	
	
	@Override
	protected void drawGame(Graphics g) {
		Level.current.draw(g);
	}
	
	
}
