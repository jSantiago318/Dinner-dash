package Game.Entities.Static;

import Resources.Images;

import java.awt.image.BufferedImage;

public class Item {

    public BufferedImage sprite;
    private String name;
    public Item(BufferedImage sprite, String name){
        this.sprite = sprite;
        this.name = name;
    }

    public static Item cheese = new Item(Images.ingredients[2], "cheese");
    public static Item lettuce = new Item(Images.ingredients[4], "lettuce");
    public static Item tomato = new Item(Images.ingredients[3], "tomato");
    public static Item burger = new Item(Images.tint(Images.ingredients[1],0.5f,0.5f,0.5f), "patty");

    public static Item botBread = new Item(Images.ingredients[5], "bottomBun");
    public static Item topBread = new Item(Images.ingredients[0], "topBun");

    //    ADDED
    public static Item pickle = new Item(Images.ingredients[9], "pickle");
    public static Item plate = new Item(Images.ingredients[6], "topBun");
    public static Item ketchup = new Item(Images.ingredients[8], "onion");
    public static Item pineapple = new Item(Images.ingredients[7], "pineapple");

    public static Item friedChicken = new Item(Images.ingredients[10], "friedChicken");

    public static Item power;
    public boolean equals(Item i) {
        return i.name.equals(name);
    }
}



