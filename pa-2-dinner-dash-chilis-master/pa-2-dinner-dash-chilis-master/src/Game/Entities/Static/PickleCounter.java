package Game.Entities.Static;

import Game.Entities.Static.BaseCounter;
import Main.Handler;
import Resources.Images;

public class PickleCounter extends BaseCounter {
    public PickleCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[8], xPos, yPos,96,108,handler);
        item = Item.pickle;
    }
}
