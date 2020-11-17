package Game.Entities.Static;

import Game.Entities.Static.BaseCounter;
import Main.Handler;
import Resources.Images;

public class ChickenCounter extends BaseCounter {
    public ChickenCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[0], xPos, yPos,96,108,handler);
        item = Item.pineapple;
    }
}
