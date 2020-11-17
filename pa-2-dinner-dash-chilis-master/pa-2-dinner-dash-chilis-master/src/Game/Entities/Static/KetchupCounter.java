package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class KetchupCounter extends BaseCounter {
        public KetchupCounter(int xPos, int yPos, Handler handler) {
            super(Images.kitchenCounter[9], xPos, yPos,96,108,handler);
            item = Item.ketchup;
        }


}
