package Game.Entities.Static;

import Game.Entities.Dynamic.Client;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import static Resources.Images.tint;

public class AbilityCounter extends BaseCounter {

    int OGtimeTillReady, timeTillReady;
    boolean ready = false;
    public static boolean isGreen = false;

    int resetTime = 10;
    int tik = 0;
    public AbilityCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[10], xPos, yPos,96,108, handler);
        OGtimeTillReady = new Random().nextInt(10000);
        timeTillReady = OGtimeTillReady;
        item = Item.power;

    }


    @Override
    public void tick() {
        timeTillReady--;
        ready = timeTillReady < (OGtimeTillReady / 2);
        if (timeTillReady%100==0) System.out.println(timeTillReady+" time for ability" );

        if (timeTillReady<= OGtimeTillReady*.6) {
                isGreen = true;
                tik++;
                if (tik%20==0) System.out.println(tik+" ticks for ability" + timeTillReady);
        }
        if (tik >=90){ //time which power will be active
            timeTillReady = OGtimeTillReady;
            isGreen = false;
            tik = 0;
        }
    }
    
    @Override
    public void interact() {


    }
    boolean count = true;

    public void render(Graphics g) {

        if (timeTillReady < OGtimeTillReady){
            if (isGreen){//if ability is active turn green

                g.drawImage(Images.tint(Images.kitchenCounter[10], 0, 255,
                  0), xPos, yPos, 96   , 108, null);
            }
            else{
                g.drawImage(Images.kitchenCounter[10], xPos, yPos, 96   , 108, null);
            }
        }else{
            g.drawImage(Images.tint(Images.kitchenCounter[10], 1.0f, ((float) timeTillReady / (float) OGtimeTillReady),
                    ((float) timeTillReady / (float) OGtimeTillReady)), xPos, yPos, 96, 108, null);
        }
    }

}
