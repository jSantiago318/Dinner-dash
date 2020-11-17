package Game.Entities.Dynamic;

import Game.Entities.Static.Burger;
import Game.Entities.Static.Item;
import Game.Entities.Static.Order;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Client extends BaseDynamicEntity {
	public boolean selected;
	int patience;
	int OGpatience;
	public static int inspectleft = 0, clinetLeft = 0, preInspectorPatience = 0;
	public double tip;
	public int position;
	public int timeFrom = 60, timeTo = 120;
	public static boolean isInspector = false, isAntiV = false;
	Order order;
	public boolean isLeaving = false;

	public Client(int xPos, int yPos, Handler handler, int position, int tip) {
		super(Images.people[new Random().nextInt(11)], xPos, yPos, 64, 72, handler);
		if (Client.super.sprite.equals(Images.people[10])){
			isInspector = true;
			System.out.println("INSPECTOR " +position);
		}
		if (Client.super.sprite.equals(Images.people[9])){
			isAntiV = true;
			System.out.println("AntiV " +position);

		}
		this.patience = new Random().nextInt(timeFrom * timeTo) + 60 * 60;
		this.position = position;
		int minus6 =  patience* (int) (inspectleft*.06);
		patience -= minus6;
		int plus10 =  patience* (int) (inspectleft*.1);
		patience += plus10;
		this.tip = tip;
		this.OGpatience = this.patience;
		this.preInspectorPatience = this.OGpatience;
		int numOfIngredients = new Random().nextInt(3) + 1;
		order = new Order();
		order.food = new Burger(xPos + 72, yPos, 52, 22);
		((Burger) order.food).addIngredient(Item.botBread);
		((Burger) order.food).addIngredient(Item.burger);
		order.value += 1.0;
		for (int i = 0; i < numOfIngredients; i++) {
//        	ingredients in burger changed from 4
			int ingredients = new Random().nextInt(5) + 1;
			order.value += 0.5;
			switch (ingredients) {
			case 1:
				((Burger) order.food).addIngredient(Item.tomato);

				break;
			case 2:
				((Burger) order.food).addIngredient(Item.pickle);

				break;

			case 3:
				((Burger) order.food).addIngredient(Item.pineapple);

				break;

			case 4:
				((Burger) order.food).addIngredient(Item.ketchup);

			break;


			}

		}

	((Burger) order.food).addIngredient(Item.topBread);
	}
	int antiVCounter = 0;

	public void tick() {
		patience--;
		if (Client.isAntiV && antiVCounter < (patience*.8)){
			antiVCounter++;
			if (antiVCounter >=(patience*.8)){
				int ran = new Random().nextInt(6);
				for (Client client : handler.getWorld().clients){
					if (client.position == ran){
						client.patience -= (client.patience *.4);
					}
				}
			}
		}
		if (patience <= 0) {
			isLeaving = true;
		}
		if (patience == 0) {
			handler.getPlayer().customersLeft = handler.getPlayer().customersLeft + 1;
		}
	}

	public void render(Graphics g) {
		if (this.patience%1000==0){
//			System.out.println("Position " + this.position + " Patience " + this.patience + " Tip " + this.tip);
		}
		if (!isLeaving) {
//			TODO 	use function bellow and add to the counter color
			g.drawImage(Images.tint(sprite, 1.0f, ((float) patience / (float) OGpatience),
					((float) patience / (float) OGpatience)), xPos, yPos, width, height, null);

			((Burger) order.food).render(g);
		}
	}

	public void move() {
		yPos += 102;
		((Burger) order.food).y += 102;
	}
	
}
