package Game.Entities.Dynamic;

import Game.Entities.Static.*;

import Game.GameStates.GameState;

import Game.GameStates.State;

import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Player extends BaseDynamicEntity {
	Item item;

	public static float money;

	int speed = 6, selected;
	private Burger burger;

	private String direction = "right";
	private int interactionCounter = 0;
	private Animation playerAnim;
	public int customersServed = 0;
	public int customersLeft = 0;
//	
	
	public Player(BufferedImage sprite, int xPos, int yPos, Handler handler) {
		super(sprite, xPos, yPos, 82, 112, handler);
		createBurger();
		playerAnim = new Animation(120, Images.link);
	}

	public void createBurger() {
		burger = new Burger(handler.getWidth() - 110, 100, 100, 50);

	}

	public void tick() {
		playerAnim.tick();
		if (xPos + width >= handler.getWidth()) {
			direction = "left";

		} else if (xPos <= 0) {
			direction = "right";
		}
		if (direction.equals("right")) {
			xPos += speed;
		} else {
			xPos -= speed;
		}
//        attbut = key E
		if (interactionCounter > 15 && handler.getKeyManager().attbut) {
			interact();
			interactionCounter = 0;
		} else {
			interactionCounter++;
		}
		if (handler.getKeyManager().fattbut) {
			for (BaseCounter counter : handler.getWorld().Counters) {
				if (counter instanceof PlateCounter && counter.isInteractable()) {
					createBurger();

				}
			}
		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_SHIFT)) {
			if (this.speed == 6) {
				this.speed = 4;
			} else {
				this.speed = 6;
			}
		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_1)) {
					selected = 1;

		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_2)) {
					selected =2;


		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_3)) {
			        selected = 3;

		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_4)) {
			        selected = 4;

		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_5)) {
					selected = 5;
		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_R)) {
			for (BaseCounter counter : handler.getWorld().Counters) {
				if (counter instanceof PlateCounter && counter.isInteractable()) {
					ringCustomer(selected);
				}
			}
		}
		
		if ( money >= 50) {
			State.setState(handler.getGame().winState);
		}
		if (customersLeft >= 10) {
			State.setState(handler.getGame().gameOverState);
		}

	}


	private void ringCustomer(int position) {
		int loop= 0;
		for (Client client : handler.getWorld().clients) {
			loop++;
			boolean matched = ((Burger) client.order.food).equals(handler.getCurrentBurger());
			if (position == loop) {
				if (matched) {
					if (client.patience > (client.patience/2)) {
						money += (client.order.value*.15);
						customersServed += 1; 
					}
					if (Client.isInspector && client.patience >(client.patience/2)){
						for (Client clients : handler.getWorld().clients){
							clients.patience += (clients.patience*.12);

						}
					}
					money += client.order.value;
					client.isLeaving = true;
					for (Client clients : handler.getWorld().clients){
						clients.patience += clients.patience/4;

					}
					handler.getPlayer().createBurger();
					System.out.println("Total money earned is: " + money);
					return;
				}
			}

		}
	}

	public void render(Graphics g) {
		if (direction == "right") {
			g.drawImage(playerAnim.getCurrentFrame(), xPos, yPos, width, height, null);
		} else {
			g.drawImage(playerAnim.getCurrentFrame(), xPos + width, yPos, -width, height, null);

		}
		  g.setColor(Color.darkGray);
	        burger.render(g);
	        g.setColor(Color.darkGray);
	        g.fillRect(handler.getWidth()/2 -210, 3, 320, 32);;
	        g.setColor(Color.yellow);
		g.setFont(new Font("Arial", Font.BOLD, 32));
		g.drawString("Money Earned: " + money, handler.getWidth() / 2 - 200, 30);
	}

	public void interact() {
		for (BaseCounter counter : handler.getWorld().Counters) {
			if (counter.isInteractable()) {
				counter.interact();
			}
			if (counter.item == Item.power){
				if (AbilityCounter.isGreen){
					for(Client client : handler.getWorld().clients){
						client.patience = client.OGpatience; //max out all client patience
						System.out.println("Client " + client.position + " maxed out");

					}
				}
			}
		}

	}

	public Burger getBurger() {
		return this.burger;
	}
}
