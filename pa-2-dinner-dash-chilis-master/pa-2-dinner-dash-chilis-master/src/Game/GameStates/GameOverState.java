package Game.GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Display.UI.UIImageButton;
import Display.UI.UIManager;
import Main.Handler;
import Resources.Images;

public class GameOverState extends State{

	private UIManager uiManager;
	
	public GameOverState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUimanager(uiManager);

		uiManager.addObjects(new UIImageButton(370, 400, 128, 64, Images.restart, () -> {
			handler.getMouseManager().setUimanager(null);
			State.setState(handler.getGame().menuState);
		}));
	
	}

	@Override
	public void tick() {

		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();
		
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
			 State.setState(handler.getGame().menuState);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Images.GameOver,0,0,900,800,null);
		g.setColor(Color.RED);
		g.setFont(new Font ("ComicSans", Font.BOLD, 28));
		g.drawString("Customers served: " + handler.getPlayer().customersServed, 300, 300);
		g.setColor(Color.blue);
		g.drawString("Customers that left: " + handler.getPlayer().customersLeft, 300, 350);
		g.setColor(Color.YELLOW);
		g.drawString("Amount of money made: " + handler.getPlayer().money, 270, 400);
		uiManager.Render(g);
	}

}
